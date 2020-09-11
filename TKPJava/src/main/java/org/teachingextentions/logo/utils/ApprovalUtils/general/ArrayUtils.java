package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.Function1;

/**
 * A static class of convenience methods for arrays and collections.
 */
public class ArrayUtils {
  public static <T> java.util.Collection<T> addArray(java.util.Collection<T> v, T array[]) {
    if ((array == null) || (v == null)) {
      return v;
    }
    Collections.addAll(v, array);
    return v;
  }

  public static <T> String toString(T[] values, Function1<T, String> formatter) {
    return toString(Arrays.asList(values), formatter);
  }

  public static <T> String toString(Iterable<T> values, Function1<T, String> formatter) {
    StringBuilder b = new StringBuilder();
    for (T t : values) {
      b.append(formatter.call(t)).append("\r\n");
    }
    return b.toString();
  }

  public static <T> T[] toReverseArray(T[] array) {
    for (int i = 0; i < array.length / 2; i++) {
      T o1 = array[i];
      int end = array.length - i - 1;
      T o2 = array[end];
      array[i] = o2;
      array[end] = o1;
    }
    return array;
  }

  public static boolean isEmpty(Object[] array) {
    return ((array == null) || (array.length == 0));
  }

  public static <H, T extends H> T getFirst(T[] array, Comparator<H> comparator) {
    return get(array, comparator, true);
  }

  private static <H, T extends H> T get(T[] array, Comparator<H> sorter, boolean wantFirst) {
    if (isEmpty(array)) {
      return null;
    }
    T last = array[0];
    for (int i = 1; i < array.length; i++) {
      int compare = sorter.compare(last, array[i]);
      if ((wantFirst && compare > 0) || (!wantFirst && compare < 0)) {
        last = array[i];
      }
    }
    return last;
  }

  public static <T> T getLast(List<T> list) {
    return list.get(list.size() - 1);
  }

  public static <T> List<T> combine(List<T> list1, List<T> list2) {
    List<T> all = new ArrayList<>();
    all.addAll(list1);
    all.addAll(list2);
    return all;
  }

}
