package fr.uca.poo.arithmetics.ast;

import static java.util.Objects.requireNonNull;

/**
 * A free variable in the expression.
 *
 * This node must be resolved in a {@link Context} in order to evaluate the expression.
 * It is a leaf in the expression tree.
 * A {@code Variable} is a value object, compared by value and immutable.
 */
public final class Variable extends Expression {

  private static final String NAME_REGEX = "^[a-z]\\w*$";
  private final String name;

  private Variable(String name) {
    this.name = name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double eval(Context c) {
    return c.resolve(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return this.name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (o == this) { return true; }
    if (o == null) { return false; }
    if (!(o instanceof Variable)) { return false; }
    Variable other = (Variable) o;
    return this.name.equals(other.name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return this.name.hashCode();
  }

  /**
   * Creates a variable.
   *
   * @param name the name of the variable.
   * @throws IllegalArgumentException if the name is not valid
   * @see #isValidName(String)
   */
  public static Variable of(String name) {
    if (!isValidName(name)) {
      throw new IllegalArgumentException(name);
    }
    return new Variable(name);
  }

  /**
   * Checks if the given name is a valid variable name.
   *
   * A valid name starts with a lowercase letter, optionally followed by letters, numbers or underscores.
   * For instance, {@code myVariable42} is valid, as well as {@code my_42nd_variable}, but {@code 42th_var} is not, nor
   * {@code my-variable}.
   */
  public static boolean isValidName(String name) {
    return name != null && name.matches(NAME_REGEX);
  }

}
