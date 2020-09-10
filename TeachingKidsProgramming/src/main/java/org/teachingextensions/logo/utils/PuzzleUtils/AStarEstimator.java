package org.teachingextensions.logo.utils.PuzzleUtils;

import java.util.Comparator;

public class AStarEstimator implements Comparator<PuzzleState>
{
  @Override
  public int compare(PuzzleState left, PuzzleState right)
  {
    return costOf(left) - costOf(right);
  }
  private int costOf(PuzzleState state)
  {
    return state.getActualCost() + state.getEstimatedCost();
  }
}
