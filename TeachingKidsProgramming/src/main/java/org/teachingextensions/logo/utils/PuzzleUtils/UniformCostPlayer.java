package org.teachingextensions.logo.utils.PuzzleUtils;

import java.util.PriorityQueue;

/**
 * Uniform cost player tries to pick the solution with the least number of steps.  The player treats every step as
 * if to costs the same as any other step.
 */
public class UniformCostPlayer extends PuzzlePlayer
{
  public UniformCostPlayer(Puzzle puzzle)
  {
    super(puzzle, new PriorityQueue<PuzzleState>());
  }
}
