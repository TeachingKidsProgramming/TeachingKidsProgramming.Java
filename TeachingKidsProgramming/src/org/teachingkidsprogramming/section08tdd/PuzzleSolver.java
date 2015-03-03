package org.teachingkidsprogramming.section08tdd;

import org.teachingextensions.windows.ProgramWindow;

public class PuzzleSolver
{
  //this problem is an ArraySort w/ custom rules 
  //the ArraySort (square) controls which positions can be swapped with each other 
  //must determine 'where is the blank (square)?'
  //must determine 'where to move the blank to get the array more sorted than it is?'
  //this is a type A* problem (AI) - 
  //generate all permutations and check to see which ones are valid (evaluate costs)
  //throw away all non-valid choices (highest costs)
  //keep track of the history of cost
  //develop a heuristic for estimated cost of possible actions
  //
  //NOTE: this is a kata (higher level instructions)
  //part of the exercise is to translate into line-by-line English, THEN Java
  //
  //for more complete directions see this page
  //https://www.penflip.com/lynnlangit/tkp-lesson-plans/blob/master/course09.txt
  //complex example -- http://www.brian-borowski.com/software/puzzle/
  //http://en.wikipedia.org/wiki/File:Batgirl.gif
  //
  public ProgramWindow programWindow;
  public PuzzleSolver()
  {
    programWindow = new ProgramWindow("Puzzle");
    PuzzleBoard jboard = new PuzzleBoard();
    jboard.addTo(programWindow);
    programWindow.setVisible(true);
  }
  public static void main(String[] args)
  {
    new PuzzleSolver();
  }
}
