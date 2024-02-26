package fr.uca.poo.arithmetics.ast;


/**
 * Describe an expression evaluation.
 *
 * The evaluation is identified by its name that must be resolved in a {@link Context} in order to be evaluated.
 * The evaluation can also bundle a local context to define the free variable of the expression.
 */
public final class Evaluation {

  private final Variable expressionName;
  private final Context localContext = new Context();

  public Evaluation(Variable name) {
    this.expressionName = name;
  }

  public Variable expressionName() { return this.expressionName; }
  public Context localContext() { return new Context().merge(this.localContext); }

  /**
   * Evaluate the referenced expression according to the given context.
   *
   * The context must contain an {@link Expression} bound to the name of the evaluation, and can contain bindings for
   * the expression free variables.
   * <p>The given context and the local one are merge before the evaluation.
   *
   * @param c the evaluation context
   * @return the value of the expression
   */
  public double eval(Context c) {
    return c.get(expressionName).eval(c.merge(localContext));
  }

  /**
   * Binds an expression to a variable in the context local to this evaluation.
   *
   * @param variable the variable to bind
   * @param expression the value of the variable
   */
  public Evaluation with(Variable variable, Expression expression) {
    this.localContext.with(variable, expression);
    return this;
  }
}
