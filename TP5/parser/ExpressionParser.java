package fr.uca.poo.arithmetics.parser;

import fr.uca.poo.arithmetics.ast.Constant;
import fr.uca.poo.arithmetics.ast.Expression;
import fr.uca.poo.arithmetics.ast.Expressions;
import fr.uca.poo.arithmetics.ast.Variable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.function.BiFunction;

/**
 * A Parser for arithmetic expressions represented as S-Expressions.
 *
 * For instance, {@code (3*7) + (22-1)} will be represented as {@code (+ (* 3 7) (- 22 1))} or  {@code + * 3 7 - 22 1}.
 */
public final class ExpressionParser {

  private int currentChar = 0;
  private String stringExpression;

  private static final HashMap<Character, BiFunction<Expression, Expression, Expression>> OPERATORS = new HashMap<>();
  private static final HashSet<Character> START_OF_NUMBER = new HashSet<>();
  private static final HashSet<Character> SEPARATORS = new HashSet<>();

  static {
    OPERATORS.put('+', Expressions::add);
    OPERATORS.put('-', Expressions::sub);
    OPERATORS.put('*', Expressions::mul);
    OPERATORS.put('/', Expressions::div);

    START_OF_NUMBER.add('.');
    START_OF_NUMBER.add('-');
    START_OF_NUMBER.add('0');
    START_OF_NUMBER.add('1');
    START_OF_NUMBER.add('2');
    START_OF_NUMBER.add('3');
    START_OF_NUMBER.add('4');
    START_OF_NUMBER.add('5');
    START_OF_NUMBER.add('6');
    START_OF_NUMBER.add('7');
    START_OF_NUMBER.add('8');
    START_OF_NUMBER.add('9');

    SEPARATORS.add(' ');
    SEPARATORS.add('(');
    SEPARATORS.add(')');
  }

  /**
   * Parse the given representation.
   */
  public Expression parse(String str) {
    this.currentChar = 0;
    this.stringExpression = str;
    return parseSubExpression();
  }

  /**
   * Check if the given string is a valid variable name.
   */
  public boolean isValidName(String name) {
    return Variable.isValidName(name);
  }

  private Expression parseSubExpression() {
    if (isEndOfString()) {
      throw new InvalidExpressionException(stringExpression, currentChar, "expression expected, got `EOF`");
    }
    if (currentChar() == ' ') {
      nextChar();
    }
    if (currentChar() == '(') {
      nextChar();
      Expression e = parseSubExpression();
      if (isEndOfString() || currentChar() != ')') {
        throw new InvalidExpressionException(stringExpression, currentChar,
            String.format("expected `)` and got `%s`", isEndOfString() ? "EOF" : currentChar()));
      }
      nextChar();
      return e;
    }
    if (isOperator()) {
      return parseOperator();
    }
    if (isNumber()) {
      return parseNumber(nextToken());
    }
    String next = nextToken();
    if ("".equals(next)) {
      throw new InvalidExpressionException(stringExpression, currentChar, "expected an expression");
    }
    return parseVariable(next);
  }

  public static Variable parseVariable(String name) {
    try {
      return Variable.of(name);
    } catch (IllegalArgumentException e) {
      throw new ParsingException(String.format("Invalid variable name: %s", e.getMessage()), e);
    }
  }

  private Expression parseOperator() {
    BiFunction<Expression, Expression, Expression> op = OPERATORS.get(currentChar());
    nextChar();
    Expression left = parseSubExpression();
    Expression right = parseSubExpression();
    return op.apply(left, right);
  }

  private boolean isOperator() {
    return OPERATORS.containsKey(currentChar())
      && (lookAhead() == null || lookAhead() == ' ');
  }

  public static Constant parseNumber(String value) {
    String val = value.trim().replace("_", "");
    try {
      return Constant.of(Double.parseDouble(val));
    } catch (NumberFormatException e) {
      throw new ParsingException(String.format("Invalid number: %s", val), e);
    }
  }

  private boolean isNumber() {
    return START_OF_NUMBER.contains(currentChar());
  }

  private boolean isEndOfString() {
    return this.currentChar >= this.stringExpression.length();
  }

  private boolean isSeparator() {
    return SEPARATORS.contains(currentChar());
  }

  private char currentChar() {
    return stringExpression.charAt(currentChar);
  }

  private Character lookAhead() {
    if (stringExpression.length() == (currentChar + 1)) {
      return null;
    }
    return stringExpression.charAt(currentChar + 1);
  }

  private void nextChar() {
    if (!isEndOfString()) {
      this.currentChar++;
    }
    while (!isEndOfString() && currentChar() == ' ') {
      this.currentChar++;
    }
  }

  private String nextToken() {
    int start = this.currentChar;
    while (!isEndOfString() && !isSeparator()) {
      this.currentChar++;
    }
    return stringExpression.substring(start, this.currentChar);
  }
}
