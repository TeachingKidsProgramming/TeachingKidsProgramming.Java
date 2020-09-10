package org.teachingextensions.logo.utils.PuzzleUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * A player solves puzzles using a certain style.
 */
public abstract class PuzzlePlayer
{
  private final Puzzle             puzzle;
  private final Set<PuzzleState>   visited = new HashSet<>();
  private final Queue<PuzzleState> frontier;
  public PuzzlePlayer(Puzzle puzzle, Queue<PuzzleState> frontier)
  {
    this.puzzle = puzzle;
    this.frontier = frontier;
  }
  protected Set<PuzzleState> getVisited()
  {
    return visited;
  }
  protected Queue<PuzzleState> getFrontier()
  {
    return frontier;
  }
  protected Puzzle getPuzzle()
  {
    return puzzle;
  }
  public PuzzleState solve()
  {
    PuzzleState state = new PuzzleState(this.getPuzzle());
    do
    {
      getVisited().add(state);
      if (!state.isSolution())
      {
        this.search(state);
        if (getFrontier().isEmpty()) { throw new IllegalStateException("Cannot solve puzzle."); }
        state = getFrontier().remove();
      }
    }
    while (!state.isSolution());
    return state;
  }
  protected void search(PuzzleState state)
  {
    List<PuzzleState> branches = state.getBranches();
    for (PuzzleState b : branches)
    {
      if (!getVisited().contains(b))
      {
        getFrontier().add(b);
      }
    }
  }
}
