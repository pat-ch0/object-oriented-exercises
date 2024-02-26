package fr.uca.poo.arithmetics;

import fr.uca.poo.arithmetics.ast.Expression;
import fr.uca.poo.arithmetics.ast.Evaluation;
import fr.uca.poo.arithmetics.ast.Expressions;
import fr.uca.poo.arithmetics.ast.Context;
import fr.uca.poo.arithmetics.parser.ExpressionParser;
import fr.uca.poo.arithmetics.parser.EvaluationParser;

import java.util.HashMap;
import java.util.regex.*;


final class Interpreter {

  private final ExpressionParser exprParser = new ExpressionParser();
  private final EvaluationParser evalParser = new EvaluationParser();
  private final Context globalContext = new Context();

  private static final String ASSIGNEMENT_OPERATOR = ":=";

  Expression parseExpressionDefinition(String str) {
    String[] tokens = str.split(ASSIGNEMENT_OPERATOR);
    Expression e = exprParser.parse(tokens[1].trim());
    globalContext.with(Expressions.v(tokens[0].trim()), e);
    return e;
  }

  void reset() {
    this.globalContext.clear();
  }

  private boolean isDefinition(String str) {
    return str != null && str.contains(ASSIGNEMENT_OPERATOR);
  }

  Context context() {
    return new Context().merge(this.globalContext);
  }

  Object interpret(String str) {
    if (str == null || "".equals(str)) { return null; }
    if (isDefinition(str)) { return parseExpressionDefinition(str); }
    if (exprParser.isValidName(str)) { return globalContext.get(Expressions.v(str)); }
    if (evalParser.isEvaluation(str)) { return evalParser.parse(str).eval(this.globalContext); }
    return exprParser.parse(str).eval(globalContext);
  }

}
