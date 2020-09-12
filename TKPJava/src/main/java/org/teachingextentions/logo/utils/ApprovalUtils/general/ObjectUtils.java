package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;


import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * A static class of convenience functions for Manipulating objects
 */
public class ObjectUtils {

  /**
   * A convenience function to check if two objects are equal.
   *
   * @param s1
   *          The first object
   * @param s2
   *          The second object
   * @return true if Equal.
   */
  public static boolean isEqual(Object s1, Object s2) {
    return s1 == s2 || (s1 != null) && s1.equals(s2);
  }

  public static boolean isThisInstanceOfThat(Class<?> type, Class<?> that) {
    return that.isAssignableFrom(type);
  }

  public static Error throwAsError(Throwable t) throws Error {
    if (t instanceof RuntimeException) {
      throw (RuntimeException) t;
    } else if (t instanceof Error) {
      throw (Error) t;
    } else {
      throw new Error(t);
    }
  }

  public static String getClassName(Object o) {
    return o == null ? "null" : o.getClass().getName();
  }

  public static Image loadImage(Class<?> type, String name) {
    URL resource = type.getResource(name);
    if (resource == null) {
      resource = type.getClassLoader().getResource(name);
    }
    if (resource == null) {
      throw new IllegalStateException("Could not find image: " + name);
    }
    return new ImageIcon(resource).getImage();
  }
}
