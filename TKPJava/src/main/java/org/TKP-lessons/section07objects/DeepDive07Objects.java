package org.teachingkidsprogramming.section07objects;

import java.awt.Cursor;

import org.junit.Assert;
import org.junit.Test;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.Turtle.Animals;
import org.teachingextensions.logo.utils.PizzaUtils.Pizza;
import org.teachingextensions.logo.utils.PizzaUtils.Topping;

@SuppressWarnings("unused")
public class DeepDive07Objects
{
  //  Step 1: SELECT the method name (twoTortoises on line 26), then click the Run Button
  //            Keyboard shortcut to run ->  PC: Ctrl+F11 or Mac: Command+fn+F11
  //  Step 2: READ the name of the method that failed
  //  Step 3: FILL IN the blank (___) to make that method pass
  //  Step 4: SAY at least one thing you just learned
  //  Step 5: GO to the next method
  //  IMPORTANT - Do NOT change anything except the blank (___)//
  //
  @Test
  public void twoTortoises() throws Exception
  {
    Tortoise rafael = new Tortoise();
    Tortoise michealangelo = new Tortoise();
    boolean result = rafael.equals(michealangelo);
    Assert.assertEquals(______, result);
  }
  @Test
  public void twoTortoisesAgain() throws Exception
  {
    Tortoise rafael = new Tortoise();
    Tortoise anonymousNinja = rafael;
    boolean result = rafael.equals(anonymousNinja);
    Assert.assertEquals(_____, result);
  }
  @Test
  public void twoTortoisesYetAgain() throws Exception
  {
    Tortoise rafael = new Tortoise();
    Tortoise michelangelo = new Tortoise();
    Tortoise anonymousNinja = ________;
    boolean result = michelangelo.equals(anonymousNinja);
    Assert.assertEquals(true, result);
  }
  //Turtle Leonardo belongs to "this"
  private Turtle leonardo;
  @Test
  public void fatTrailTurtle() throws Exception
  {
    Turtle ninja = new Turtle();
    this.leonardo = _______;
    ninja.setPenWidth(30);
    Assert.assertEquals(30, this.leonardo.getPenWidth());
  }
  //Turtle Donatello belongs to "this"
  private Turtle donatello;
  @Test
  public void explodingTurtle() throws Exception
  {
    Turtle ninja = new Turtle();
    this._______ = ninja;
    this.donatello.setAnimal(Animals.ExplodedTurtle);
    Assert.assertTrue("The ninja is still alive!", ninja.isDead());
  }
  @Test
  public void feedTheNinja() throws Exception
  {
    Tortoise michelangelo = new Tortoise();
    michelangelo.likesTopping(Topping.Pepperoni);
    Pizza pizza = new Pizza();
    pizza.addTopping(_________);
    boolean likedIt = michelangelo.eatPizza(pizza);
    Assert.assertTrue("Michelangelo barfs! Wrong pizza!", likedIt);
  }
  @Test
  public void feedTheNinjaTwo() throws Exception
  {
    Tortoise karai = new Tortoise();
    karai.likesTopping(Topping.Anchovy);
    Pizza pizza = new Pizza();
    pizza.addTopping(Topping.Anchovy);
    boolean likedIt = karai.eatPizza(pizza);
    Assert.assertTrue("Karai turns greener! Wrong pizza!", _____);
  }
  @Test
  public void checkOutThePizza() throws Exception
  {
    Tortoise cecil = new Tortoise();
    cecil.likesTopping(Topping.Cheese);
    Pizza pizza = new Pizza();
    pizza.addTopping(Topping.Cheese);
    pizza.____();
    boolean likedIt = cecil.eatPizza(pizza);
    Assert.assertTrue("Cecil sends it back, raw pizza!", likedIt);
  }
  @Test
  public void feedAllTheNinjas() throws Exception
  {
    Tortoise[] tortoises = throwPizzaParty();
    Pizza pizza = new Pizza();
    pizza.____();
    for (Tortoise tortoise : tortoises)
    {
      gotASlice = tortoise.eatPizza(pizza);
      if (!gotASlice)
      {
        break;
      }
    }
    Assert.assertTrue("The ninja flips out - not enough pizza!", gotASlice);
  }
  @Test
  public void feedAllTheNinjasAgain() throws Exception
  {
    Tortoise[] tortoises = throwPizzaParty();
    Pizza pizza = new Pizza();
    pizza.superSizeIt();
    for (Tortoise tortoise : tortoises)
    {
      _____ = tortoise.eatPizza(pizza);
      if (!this.gotASlice)
      {
        break;
      }
    }
    Assert.assertTrue("The ninja flips out - not enough pizza!", this.gotASlice);
  }
  /**
   * Ignore the following, It's needed to run the deep dive
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   */
  private Tortoise[] throwPizzaParty()
  {
    Tortoise karai = new Tortoise();
    Tortoise cecil = new Tortoise();
    Tortoise michealangelo = new Tortoise();
    Tortoise fred = new Tortoise();
    return new Tortoise[]{karai, cecil, michealangelo, fred};
  }
  private boolean gotASlice;
  public boolean  _____     = false;
  public boolean  ______    = true;
  public String   ___       = "You need to fill in the blank ___";
  public int      ____      = 0;
  public Turtle   _______   = new Turtle();
  public Tortoise ________;
  public Topping  _________ = Topping.NoTopping;
  public String ___()
  {
    return ___;
  }
  private Cursor getCursor()
  {
    return Tortoise.getBackgroundWindow().getCanvas().getCursor();
  }
  public DeepDive07Objects()
  {
    this.leonardo = new Turtle();
    this.donatello = new Turtle();
  }
}
