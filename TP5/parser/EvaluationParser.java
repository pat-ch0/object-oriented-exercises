package fr.uca.poo.arithmetics.parser;

import fr.uca.poo.arithmetics.ast.Evaluation;
import fr.uca.poo.arithmetics.ast.Variable;

import java.util.regex.*;

public final class EvaluationParser {
  private static final Pattern EVAL_PATTERN = Pattern.compile("^(\\w+)\\((.*)\\)$");
  private static final ExpressionParser PARSER = new ExpressionParser();
  
  /**
   * Creates an evaluation from a string representation.
   *
   * The representation has the for {@code exp(v1=e1, v2=e2, ...)} where {@code exp} is a variable bound to an
   * expression in the evaluation context, {@code v*} are free variables of the expression and {@code e*} are
   * expressions that will also be resolved in the given context.
   */
  public Evaluation parse(String str) {
    Matcher m = EVAL_PATTERN.matcher(str);
    if (!m.matches()) {
      throw new InvalidEvaluationException(String.format("Can't parse evaluation '%s'", str));
    }
    Evaluation e = new Evaluation(ExpressionParser.parseVariable(m.group(1)));
    String params = m.group(2);
    if (params != null && !"".equals(params)) {
      for (String v : m.group(2).split(",\\s*")) {
        String[] parts = v.split("\\s*=\\s*");
        if (parts.length != 2) {
          throw new InvalidEvaluationException(String.format("Can't parse evaluation '%s'", str));
        }
        e.with(Variable.of(parts[0].trim()), PARSER.parse(parts[1]));
      }
    }
    return e;
  }

  private void parseParams(Evaluation e, String params) {
    if (params == null || "".equals(params)) { return ; }
    for (String v : params.split(",\\s*")) {
      String[] parts = v.split("\\s*=\\s*");
      if (parts.length != 2) {
        throw new InvalidEvaluationException(String.format("Can't parse evaluation  parameters '%s'", params));
      }
      e.with(Variable.of(parts[0].trim()), PARSER.parse(parts[1]));
    }
  }

  /**
   * Checks if the given string looks like an evaluation.
   *
   * This is not a full syntax validation. The parsing may fail even if this method returned {@code true}.
   */
  public boolean isEvaluation(String str) {
    return EVAL_PATTERN.matcher(str).matches();
  }
}
