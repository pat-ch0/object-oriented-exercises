package fr.uca.poo.arithmetics.ast;

/**
 * An arithmetic expression.
 */
public abstract class Expression {

  /**
   * Evaluates the expression according to the given context.
   *
   * @param c the context defining values for free variables in the expression.
   * @return the result of the expression evaluation.
   */
  public abstract double eval(Context c);
}
