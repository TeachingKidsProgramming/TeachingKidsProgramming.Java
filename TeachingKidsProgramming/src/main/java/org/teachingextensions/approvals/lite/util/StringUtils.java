package org.teachingextensions.approvals.lite.util;

/**
 * A static class of convenience functions for database access
 */
public final class StringUtils {
  public static final String NEW_LINE = System.getProperty("line.separator");

  private StringUtils() {
  }

  public static String stripNonNumeric(String number, boolean allowDecimal, boolean allowNegative) {
    boolean allowExponential = allowDecimal;
    boolean afterE = false;
    if (number == null) {
      return "";
    }
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < number.length(); i++) {
      char c = number.charAt(i);
      switch (c) {
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
          result.append(c);
          afterE = false;
          break;
        case '-':
          if (allowNegative || afterE) {
            result.append(c);
            allowNegative = false;
          }
          break;
        case '.':
          if (allowDecimal) {
            result.append(c);
            allowDecimal = false;
          }
          afterE = false;
          break;
        case 'e':
        case 'E':
          if (allowExponential) {
            result.append(c);
            allowExponential = false;
          }
          afterE = true;
          break;
        default:
          break;
      }
    }
    return result.toString();
  }

  /**
   * A convenience function to check that a String has at least 1 character.
   *
   * @param string
   *     The string in question
   * @return true if Non Zero.
   */
  public static boolean isNonZero(String string) {
    return string != null && 0 < string.trim().length();
  }

  public static boolean isEmpty(String string) {
    return !isNonZero(string);
  }
}
