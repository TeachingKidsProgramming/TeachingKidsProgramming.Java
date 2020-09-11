package utils;

public class FormattedException extends RuntimeException {

  private static final long serialVersionUID = -4388436150197314047L;

  public FormattedException(String string, Object... params) {
    super(String.format(string, params));
    MySystem.variable(this.getMessage());
  }
}
