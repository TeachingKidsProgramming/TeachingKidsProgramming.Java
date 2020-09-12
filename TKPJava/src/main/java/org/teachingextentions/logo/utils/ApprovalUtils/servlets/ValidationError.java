package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.servlets;

import java.util.HashMap;
import java.util.HashSet;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.StringUtils;

public class ValidationError extends RuntimeException {
  private static final long       serialVersionUID = 7940285202708976073L;
  private HashMap<String, String> errors           = new HashMap<>();
  private HashSet<String>         assertions       = null;

  public ValidationError(Enum<?> enumerations[]) {
    this.assertions = new HashSet<>();
    for (Enum<?> e : enumerations) {
      this.assertions.add(e.toString());
    }
  }

  @Override
  public String getMessage() {
    return toString();
  }

  @Override
  public String toString() {
    return "Validation(s) failed " + errors.keySet().toString() + " - "
        + errors.values().toString();
  }

  public void set(Enum<?> assertion, boolean isOk, String errorDescription) {
    setError(assertion.toString(), !isOk, errorDescription);
  }

  public void setError(String assertion, boolean isError,
      String errorDescription) {
    if (isError && !StringUtils.isNonZero(errorDescription)) {
      throw new Error("You can not use empty error descriptions");
    }
    assertValidAssertion(assertion);
    if (isError) {
      errors.put(assertion, errorDescription);
    } else {
      errors.remove(assertion);
    }
  }

  public boolean isOk() {
    return errors.size() == 0;
  }

  private void assertValidAssertion(String assertion) {
    if (!this.assertions.contains(assertion)) {
      throw new Error("Assertion '" + assertion + "' not found from "
          + assertions.toString());
    }
  }

  public int size() {
    return errors.size();
  }

}
