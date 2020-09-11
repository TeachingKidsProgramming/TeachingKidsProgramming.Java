package logo.utils.PizzaUtils;

import java.util.ArrayList;

/**
 * <img src="https://cdn2.iconfinder.com/data/icons/fatcow/32x32/pizza.png" style="text-align: left" alt="A slice of pizza">
 * The Pizza allows you to make different sizes and kinds of pizza!
 */
public class Pizza
{
  private ArrayList<Topping> toppings = new ArrayList<Topping>();
  private boolean            cooked;
  private int                slices   = 2;
  /**
   * Adds a topping to a pizza
   * <div><b>Example:</b> {@code pizza.addTopping(Topping.Spam)} </div>
   *
   * @param topping A topping from the list
   */
  public void addTopping(Topping topping)
  {
    this.toppings.add(topping);
  }
  /**
   * Checks to see if a pizza has a particular kind of topping
   * <div><b>Example:</b> {@code pizza.hasTopping(topping)}</div>
   *
   * @param topping A topping from the list to check for
   * @return <b>true</b> when the pizza has the topping on it
   */
  public boolean hasTopping(Topping topping)
  {
    for (Topping toppingToday : toppings)
    {
      if (toppingToday == topping) { return true; }
    }
    return false;
  }
  /**
   * Cooks a pizza
   * <div><b>Example:</b> {@code pizza.cook()}</div>
   */
  public void cook()
  {
    this.cooked = true;
  }
  /**
   * Checks whether a pizza was cooked
   * <div><b>Example:</b> {@code pizza.wasCooked()}</div>
   *
   * @return whether or not the pizza has been cooked already
   */
  public boolean wasCooked()
  {
    return this.cooked;
  }
  public void ____()
  {
  }
  /**
   * Checks whether you can take a slice of pizza or not
   * <div><b>Example:</b> {@code pizza.takeSlice()}</div>
   *
   * @return whether or not the pizza has any more slices to take
   * If there are still slices, takes one slice
   */
  public boolean takeSlice()
  {
    if (0 < this.slices)
    {
      this.slices--;
      return true;
    }
    return false;
  }
  /**
   * Adds more slices to a pizza
   * <div><b>Example:</b> {@code pizza.superSizeIt()}</div>
   */
  public void superSizeIt()
  {
    this.slices = 8;
  }
}
