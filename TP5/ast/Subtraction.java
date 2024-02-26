package fr.uca.poo.arithmetics.ast;

/**
 * The subtraction of two expressions.
 */
public final class Subtraction extends Operator {

  Subtraction(Expression left, Expression right) {
    super(left, right);
  }

  protected double op(double l, double r) { return l - r; }
  protected String symbol() { return "-"; }
}
