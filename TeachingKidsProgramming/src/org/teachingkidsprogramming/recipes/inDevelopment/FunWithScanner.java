package org.teachingkidsprogramming.recipes.inDevelopment;

import java.util.Scanner;

public class FunWithScanner
{
  private static Scanner scanner;
  private static Scanner scanner2;
  public static void main(String[] args)
  {
    scanner = new Scanner(System.in);
    scanner.useDelimiter("\\n");
    System.out.print("Enter an index: ");
    int index = scanner.nextInt();
    System.out.print("Enter a sentence: ");
    String sentence = scanner.next();
    System.out.println("\nYour sentence: " + sentence);
    System.out.println("Your index: " + index);
  }
  public static void makeAString()
  {
    String input = "1 fish 2 fish red fish blue fish";
    scanner2 = new Scanner(input);
    Scanner s = scanner2.useDelimiter("\\s*fish\\s*");
    System.out.println(s.nextInt());
    System.out.println(s.nextInt());
    System.out.println(s.next());
    System.out.println(s.next());
    s.close();
  }
}
