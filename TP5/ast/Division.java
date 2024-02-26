package fr.uca.poo.arithmetics.ast;

/**
 * The division of two expressions.
 */
public final class Division extends Operator {

  Division(Expression left, Expression right) {
    super(left, right);
  }

  protected double op(double l, double r) { return l / r; }
  protected String symbol() { return "/"; }
}
