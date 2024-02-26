package fr.uca.poo.arithmetics.ast;

import static java.util.Objects.requireNonNull;

/**
 * Expression for binary operators.
 *
 * The behaviour of the operator is specified by defining the {@link #op(double, double)} method.
 */
public abstract class Operator extends Expression {
  private final Expression left;
  private final Expression right;

  Operator(Expression left, Expression right) {
    this.left = requireNonNull(left);
    this.right = requireNonNull(right);
  }

  /**
   * Returns the symbol to use when displaying the expression.
   */
  protected abstract String symbol();

  /**
   * Defines the behaviour of the operator.
   *
   * @param left the evaluated value of the left subexpression.
   * @param right the evaluated value of the right subexpression.
   * @return the application of the operator as a raw value.
   */
  protected abstract double op(double left, double right);

  /**
   * Returns the left hand side subexpression.
   */
  public Expression left() {
    return this.left;
  }

  /**
   * Returns the right hand side subexpression.
   */
  public Expression right() {
    return this.right;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double eval(Context c) {
    return op(this.left.eval(c), this.right.eval(c));
  }
  
  private void appendChild(StringBuilder sb, Expression e) {
    if (e instanceof Operator) {
      sb.append("(").append(e.toString()).append(")");
    } else {
      sb.append(e.toString());
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final String toString() {
    StringBuilder sb = new StringBuilder();
    appendChild(sb, this.left);
    sb.append(" ").append(this.symbol()).append(" ");
    appendChild(sb, this.right);
    return sb.toString();
  }

}
