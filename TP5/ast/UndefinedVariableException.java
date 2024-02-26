package fr.uca.poo.arithmetics.ast;

public final class UndefinedVariableException extends RuntimeException {
  UndefinedVariableException(String variableName) {
    super(String.format("Variable `%s` is not defined", variableName));
  }
}

