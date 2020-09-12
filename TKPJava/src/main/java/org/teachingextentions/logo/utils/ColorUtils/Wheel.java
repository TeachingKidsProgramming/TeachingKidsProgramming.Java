package src.main.java.org.teachingextentions.logo.utils.ColorUtils;

import java.util.ArrayList;
import java.util.List;

import org.teachingextensions.approvals.lite.util.NumberUtils;

/**
 * A Wheel is a List with no ending on beginning <p>
 * <b>Example:</b><pre>{@code
 *    Wheel<String> names = new Wheel<String>();
 *    names.add("Chocolate");
 *    names.add("Peanut Butter");
 *    for(int i = 0; i < 6; i++){
 *      String name = names.next();
 *      System.out.print(name + " ");
 *    }
 * }</pre>
 * Would result in:<p>
 * Chocolate Peanut Butter Chocolate Peanut Butter Chocolate Peanut Butter
 *
 * @param <T> The kind of things that are in the wheel
 */
public class Wheel<T>
{
  private List<T> list  = new ArrayList<>();
  private int     index = 0;
  @SafeVarargs
  public Wheel(T... loadWith)
  {
    for (T t : loadWith)
    {
      add(t);
    }
  }
  public Wheel()
  {
  }
  public void add(T i)
  {
    list.add(i);
  }
  public T next()
  {
    assertNonEmpty();
    if (index >= list.size())
    {
      index = 0;
    }
    return list.get(index++);
  }
  protected void assertNonEmpty()
  {
    if (list.isEmpty())
    {
      String message = "I call shenanigans!!!\nThis Wheel is empty\nYou can NOT get an object from the Wheel before you've added anything to it.";
      throw new RuntimeException(message);
    }
  }
  public T getRandomFrom()
  {
    assertNonEmpty();
    int index = NumberUtils.getRandomInt(0, list.size());
    return list.get(index);
  }
  public void empty()
  {
    list.clear();
    index = 0;
  }
  public boolean isEmpty()
  {
    return list.isEmpty();
  }
}
