package fr.uca.poo.arithmetics.ast;

/**
 * DSL to construct complexes expressions.
 *
 * This DSL consists in static methods to ease the creation of nested expressions.
 * For instance, the expression {@code (3*7) + (22-1)} can be written
 * {@code add(mul(c(3), c(7)), sub(c(22), c(1)))}.
 */
public final class Expressions {

  private Expressions() {
    throw new UnsupportedOperationException("Do not instantiate a utility class");
  }

  /**
   * Creates the addition of two expressions.
   */
  public static Operator add(Expression l, Expression r) {
    return new Addition(l, r);
  }

  /**
   * Creates the subtraction of two expressions.
   */
  public static Operator sub(Expression l, Expression r) {
    return new Subtraction(l, r);
  }

  /**
   * Creates the multiplication of two expressions.
   */
  public static Operator mul(Expression l, Expression r) {
    return new Multiplication(l, r);
  }

  /**
   * Creates the division of two expressions.
   */
  public static Operator div(Expression l, Expression r) {
    return new Division(l, r);
  }

  /**
   * Creates a free variable.
   *
   * @param name the name of the free variable.
   */
  public static Variable v(String name) {
    return Variable.of(name);
  }

  /**
   * Creates a constant value.
   *
   * @param val the value.
   */
  public static Constant c(double val) {
    return Constant.of(val);
  }
  /**
   * Creates a constant value.
   *
   * @param val the value.
   */
  public static Constant c(int val) {
    return Constant.of(val);
  }

  /**
   * Creates a new context with the given binding.
   *
   * @param n the name of the variable.
   * @param v the value to bind.
   */
  public static Context with(String n, double v) {
    return with(Variable.of(n), Constant.of(v));
  }

  /**
   * Creates a new context with the given binding.
   *
   * @param n the variable.
   * @param v the expression to bind.
   */
  public static Context with(Variable n, Expression v) {
    return new Context().with(n, v);
  }
}
