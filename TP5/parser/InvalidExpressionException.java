package fr.uca.poo.arithmetics.parser;

public final class InvalidExpressionException extends ParsingException {
  private String expression;
  private int position;

  InvalidExpressionException(String e, int p) {
    this(e, p, null);
  }

  InvalidExpressionException(String e, int p, String reason) {
    super(reason);
    this.expression = e;
    this.position = p;
  }

  @Override
  public String getMessage() {
    StringBuilder message = new StringBuilder();
    String prefix = "Invalid character in ";
    message.append(prefix);
    message.append(String.format("`%s`", this.expression, this.position));
    if (super.getMessage() != null && !super.getMessage().equals("")) {
      message.append(": ").append(super.getMessage());
    }
    message.append(System.lineSeparator());
    for (int i = 0; i < prefix.length() + this.position + 1; i++) {
      message.append(" ");
    }
    message.append("^");
    return message.toString();
  }
}


