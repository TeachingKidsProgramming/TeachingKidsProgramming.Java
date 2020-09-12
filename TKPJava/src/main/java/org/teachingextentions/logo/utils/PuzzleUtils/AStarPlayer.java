package src.main.java.org.teachingextentions.logo.utils.PuzzleUtils;

import java.util.PriorityQueue;

/**
 * A player who solves puzzles using the A* strategy will not only take into account the known cost of a reaching
 * a puzzle state, but also estimates the remaining cost to the goal.
 */
public class AStarPlayer extends PuzzlePlayer
{
  public AStarPlayer(Puzzle puzzle)
  {
    super(puzzle, new PriorityQueue<>(1, new AStarEstimator()));
  }
}
