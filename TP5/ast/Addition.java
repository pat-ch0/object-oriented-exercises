package fr.uca.poo.arithmetics.ast;

/**
 * The addition of two expressions.
 */
public final class Addition extends Operator {

  Addition(Expression left, Expression right) {
    super(left, right);
  }

  protected double op(double l, double r) { return l + r; }
  protected String symbol() { return "+"; }
}
