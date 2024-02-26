package fr.uca.poo.arithmetics.ast;

/**
 * A constant value.
 *
 * This node encapsulate a numeric value. It is a leaf in the expression tree.
 * A {@code Constant} is a value object, compared by value and immutable.
 */
public final class Constant extends Expression {
  private final double value;

  private Constant(double v) {
    this.value = v;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double eval(Context c) {
    return this.value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return Double.toString(this.value);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (o == this) { return true; }
    if (o == null) { return false; }
    if (!(o instanceof Constant)) { return false; }
    Constant other = (Constant) o;
    return this.value == other.value;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Double.hashCode(this.value);
  }

  /**
   * Creates a new constant.
   */
  public static Constant of(double value) {
    return new Constant(value);
  }

  /**
   * Creates a new constant.
   */
  public static Constant of(int value) {
    return new Constant((double) value);
  }
}
