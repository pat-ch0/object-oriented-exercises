package fr.uca.poo.arithmetics.ast;

/**
 * The multiplication of two expressions.
 */
public final class Multiplication extends Operator {

  Multiplication(Expression left, Expression right) {
    super(left, right);
  }

  protected double op(double l, double r) { return l * r; }
  protected String symbol() { return "*"; }
}
