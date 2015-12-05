package org.teachingkidsprogramming.recipes.inDevelopment;

import org.junit.Assert;
import org.junit.Test;
import org.teachingextensions.approvals.lite.util.FormattedException;

//**************ANSWER: This deepdive is in progress!*****************//
//
@SuppressWarnings("unused")
public class DeepDive09exceptions
{
  @Test
  public void exceptionsShouldProvideInformation() throws Exception
  {
    Chain c = createChain();
    int answer = c.get("a").get("b").get("c").get("d").get("e").value; /* Fix This Line */
    Assert.assertEquals(2048, answer);
  }
  @Test
  public void exceptionsShouldExplainPreconditions() throws Exception
  {
    Game game = new Game();
    /* Add needed line here */
    int fun = game.play();
    Assert.assertEquals(11, fun);
  }
  /**
   * Ignore the following, It's needed to run the homework
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
  private int call(int a, int b, int c)
  {
    if (((a + c) / 2) == b) { throw new FormattedException("%s is not a valid input for (%s, %s, %s)", b, a, b,
        c); }
    return a + b + c;
  }
  private static class Game
  {
    boolean on = false;
    public void turnOn()
    {
      on = true;
    }
    public int play()
    {
      if (!on) { throw new FormattedException(
          "Before you can play a game you need to turn it on.\n game.turnOn()"); }
      return 11;
    }
  }
  private static class Chain
  {
    private String label;
    private Chain  chain;
    public int     value;
    public Chain(String label, Chain chain)
    {
      this.label = label;
      this.chain = chain;
    }
    public Chain(int value)
    {
      this.value = value;
    }
    public Chain get(String string)
    {
      if (!label.equals(
          string)) { throw new FormattedException("There is no value for '%s', please use '%s'", string, label); }
      return chain;
    }
  }
  private Chain createChain()
  {
    return new Chain("a", new Chain("b", new Chain("surprise", new Chain("d", new Chain("e", new Chain(2048))))));
  }
  private static class _____ extends Exception
  {
    private static final long serialVersionUID = 7013264013388843231L;
    public _____(String message, Exception originalException)
    {
      super(message, originalException);
    }
  }
  public String  ___  = "You need to fill in the blank ___";
  public Integer ____ = -99;
}
