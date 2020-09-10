package org.teachingextensions.logo.utils.PuzzleUtils;

import java.util.ArrayDeque;

/**
 * A player who solves puzzles using breadth-first search.
 */
public class BreadthFirstPlayer extends PuzzlePlayer
{
  public BreadthFirstPlayer(Puzzle puzzle)
  {
    super(puzzle, new ArrayDeque<PuzzleState>());
  }
}
