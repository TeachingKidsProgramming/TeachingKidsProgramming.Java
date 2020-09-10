package org.teachingextensions.approvals.lite.util;

import java.util.List;

public class ParserCommons {
  public static ParserCommons INSTANCE = new ParserCommons();

  public static Class<?> getClass(String clazz) throws ClassNotFoundException {
    return Class.forName(clazz);
  }

  public static Object getNull() {
    return null;
  }

  public static int getArrayLength(Object[] array) {
    return array == null ? 0 : array.length;
  }

  public static Object get(Object[] array, int index) {
    return getArrayLength(array) > index ? array[index] : null;
  }

  public static Object get(List<?> list, int index) {
    return list == null ? null : list.get(index);
  }
}