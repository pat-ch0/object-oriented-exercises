package fr.uca.poo.arithmetics.parser;

public class ParsingException extends IllegalArgumentException {
  public ParsingException(String message) { super(message); }
  public ParsingException(String message, Throwable cause) { super(message, cause); }
}
