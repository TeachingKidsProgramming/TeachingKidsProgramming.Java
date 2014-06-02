package org.teachingkidsprogramming.section05recursion;

public class TurtleTree
{
  public static void main(String[] args)
  {
    //    Make the tortoise go as fast as possible --#10
    //    Turn the background black --#21
    //    The current branch length = 60 --#1.2
    //    drawBranch(recipe below) --#2
    //    ------------- Recipe for drawBranch --#2
    //        If the current branch length is greater than zero, do the rest of this recipe --#5
    //        adjustColor --#15
    //        ------------- Recipe for adjustColor --#15
    //            A 10 pixel long branch is lime --#20
    //            A 20 pixel long branch is forest green --#19
    //            A 30 pixel long branch is dark green --#18
    //            A 40 pixel long branch is olive --#17
    //            A 50 pixel long branch is sienna --#14
    //            A 60 pixel long branch is saddle brown --#13
    //        ------------- End of adjustColor --#15
    //        Move the tortoise the length of the current branch --#1.1
    //        drawLowerBranches (recipe below) --#6
    //        ------------- Recipe for drawLowerBranches --#6
    //            Turn the Tortoise 30 degrees to the right --#3
    //            drawShorterBranch (recipe below) --#8
    //            ------------- Recipe for drawShorterBranch --#8
    //                drawBranch (10 pixels shorter) --#4
    //            ------------- End of drawShorterBranch recipe --#8
    //            Turn the Tortoise 60 degrees to the left --#7
    //            drawShorterBranch --#9
    //            Turn the Tortoise 30 degrees to the right --#12
    //            adjustColor --#16
    //            Move the tortoise backward the length of the current branch --#11
    //        ------------- End of drawLowerBranches recipe --#6
    //    ------------- End of drawBranch recipe --#2
  }
}