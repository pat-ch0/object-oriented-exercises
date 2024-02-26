package fr.uca.poo.arithmetics;

import fr.uca.poo.arithmetics.parser.ParsingException;
import fr.uca.poo.arithmetics.ast.UndefinedVariableException;

/**
 * REPL for the arithmetic expressions
 */
public final class Main {
  private static final String CONTEXT = "$";
  private final Interpreter interpreter = new Interpreter();
  private boolean run = true;

  private String read() {
    String input = System.console().readLine("> ");
    if (input == null) { return null; }
    return input.trim();
  }

  private void println(Object v) {
    if (v != null) {
      System.console().format("%s%n", v);
    }
  }

  private boolean isQuit(String str) {
    return str == null
      || "!q".equals(str)
      || "!quit".equals(str)
      || "!exit".equals(str);
  }

  private boolean isEmpty(String str) {
    return str != null && "".equals(str);
  }

  private boolean isContext(String str) {
    return CONTEXT.equals(str);
  }

  private boolean isHelp(String str) {
    return "!help".equals(str) || "?".equals(str);
  }

  private boolean isClear(String str) {
    return "!clear".equals(str);
  }

  private void printBanner() {
    println("Welcome to Expressions 2000!");
    println("");
    printHelp();
  }

  private void printHelp() {
    println("Commands:");
    println("  `!quit` or `!exit` to quit");
    println("  `!clear` to reset internal state");
    println("  `!help` or `?` to print this help");
    println("  `$` prints the currently defined variables.");
    println("");
    println("Definitions: name := expression");
    println("Evaluation: name(variable=value, variable=value, ...)");
    println("Entering a name prints its non-evaluated expression.");
    println("");
  }

  private Object eval(String str) {
    if (isEmpty(str)) { return null; }
    if (isQuit(str)) { 
      this.run = false;
      return null;
    }
    if (isClear(str)) {
      interpreter.reset();
      return "Internal state cleared";
    }
    if (isHelp(str)) {
      printHelp();
      return null;
    }
    if (isContext(str)) {
      return interpreter.context();
    }
    try {
      return interpreter.interpret(str);
    } catch (UndefinedVariableException|ParsingException e) {
      return e.getMessage();
    }
  }

  private void run() {
    printBanner();
    while (run) {
      println(eval(read()));
    }
    println("Goodbye!");
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
