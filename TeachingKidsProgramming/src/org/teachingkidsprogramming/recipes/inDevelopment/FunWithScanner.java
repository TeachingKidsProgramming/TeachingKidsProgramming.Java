package org.teachingkidsprogramming.recipes.inDevelopment;

import java.util.Iterator;
import java.util.Scanner;
//
//**this recipe is being designed to show how to use the Java Scanner Object***********//
//

public class FunWithScanner
{
  private static Scanner scanner;
  public static void main(String[] args)
  {
    makeAString();
  }
  //
  public static void makeAString()
  {
    final String input = "1 fish 2 fish red fish blue fish,black fish,blue fish,old fish,new fish ";
    scanner = new Scanner(input);
    System.err.println("\nWe have:  " + input + '\n');
    Scanner s = scanner.useDelimiter("\\s*fish\\s*");
    System.out.println("So:       " + s.nextInt() + " and " + s.nextInt());
    System.out.println("And:      " + s.next() + " and " + s.next() + '\n');
    for (String fish : new Iterable<String>()
    {
      @Override
      public Iterator<String> iterator()
      {
        scanner = new Scanner(input);
        scanner.useDelimiter(",");
        return scanner;
      }
    })
    {
      System.out.println("And then: " + fish);
    }
    s.close();
  }
}
