package org.teachingkidsprogramming.recipes.inDevelopment;

import java.util.Iterator;
import java.util.Scanner;

public class FunWithScanner
{
  private static Scanner scanner;
  public static void main(String[] args)
  {
    makeAString();
  }
  public static void makeAString()
  {
    String input = "1 fish 2 fish red fish blue fish, ";
    scanner = new Scanner(input);
    System.err.println("\nIt is said that there are: " + input);
    Scanner s = scanner.useDelimiter("\\s*fish\\s*");
    System.out.println("So:       " + s.nextInt() + " and " + s.nextInt());
    System.out.println("And:      " + s.next() + " and " + s.next() + '\n');
    for (String unit : new Iterable<String>()
    {
      private String units = "black fish,blue fish,old fish,new fish";
      @Override
      public Iterator<String> iterator()
      {
        Scanner scanner = new Scanner(units);
        scanner.useDelimiter(",");
        return scanner;
      }
    })
    {
      System.out.println("And also: " + unit);
    }
    s.close();
  }
}
