package fr.uca.poo.arithmetics.ast;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines an expression evaluation context.
 *
 * The context binds values to names.
 * A context is required to evaluate an expression having free variables.
 *
 * @see Expression#eval(Context)
 */
public final class Context {

  private final HashMap<Variable, Expression> values = new HashMap<>();

  /**
   * Adds a binding into the context.
   *
   * The context is returned, thus bindings can be chained as in
   * {@code c.with("answer", 42).with("elite", 1337)}.
   *
   * No {@code null} value can be bound, thus if such a value is provided, the name is removed from the context.
   *
   * @param variable the variable to bind
   * @param value the expression to be bound
   * @return the context itself
   */
  public Context with(Variable variable, Expression value) {
    if (value == null) {
      this.values.remove(variable);
    } else {
      this.values.put(variable, value);
    }
    return this;
  }

  /**
   * Returns the expression previously bound to the given variable.
   *
   * @param variable the variable to resolve
   * @return the expression bound to {@code name}.
   * @throws UndefinedVariableException if the name is not bound.
   */
  public Expression get(Variable variable) {
    if (!this.contains(variable)) {
      throw new UndefinedVariableException(variable.toString());
    }
    return this.values.get(variable);
  }

  /**
   * Remove all the bindings in this context.
   */
  public void clear() {
    this.values.clear();
  }


  /**
   * Returns the value previously bound to the given name.
   *
   * @param variable the name to resolve
   * @return the value bound to {@code name}.
   * @throws UndefinedVariableException if the name is not bound.
   */
  public double resolve(Variable variable) {
    return this.get(variable).eval(this);
  }

  /**
   * Checks if the context contains a binding for the given variable.
   */
  public boolean contains(Variable variable) {
    return this.values.containsKey(variable);
  }

  /**
   * Creates a new context by merging this one with an other.
   *
   * If the same value is bound in both contexts, the one in {@code other} is kept.
   *
   * @param other the context to merge with this one.
   * @return a new {@link Context}.
   */
  public Context merge(Context other) {
    Context newContext = new Context();
    newContext.values.putAll(this.values);
    if (other != null) {
      newContext.values.putAll(other.values);
    }
    return newContext;
  }

  /**
   * Returns the number of bound names.
   */
  public int size() {
    return this.values.size();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Variable, Expression> i : this.values.entrySet()) {
      sb.append(i.getKey()).append(" := ").append(i.getValue()).append(System.lineSeparator());
    }
    return sb.toString();
  }
}
