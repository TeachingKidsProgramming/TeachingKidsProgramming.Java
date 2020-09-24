package src.main.java.org.teachingextentions.logo.utils.MazeUtils;

import java.awt.Color;

public class CoolMaze
{
  public static void main(String[] args)
  {
    int mazeComplexityScale = 10;
    CoolMaze maze = new CoolMaze(mazeComplexityScale);
    StdDraw.show(0);
    maze.drawWallsAndEndPoint();
    maze.solveThisMaze();
  }
  public CoolMaze(int mazeComplexity)
  {
    this.mazeComplexity = mazeComplexity;
    StdDraw.setXscale(0, mazeComplexity + 2);
    StdDraw.setYscale(0, mazeComplexity + 2);
    createMazeStructure();
    generateStartLocation(1, 1);
  }
  public void drawWallsAndEndPoint()
  {
    StdDraw.setPenColor(StdDrawColors.GREEN);
    // createAndSizeStartPoint();
    createAndSizeEndPoint();
    drawAndColorMazeWalls();
    StdDraw.show(1000);
  }
  private void createMazeStructure()
  {
    visited = new boolean[mazeComplexity + 2][mazeComplexity + 2];
    for (int x = 0; x < mazeComplexity + 2; x++)
    {
      visited[x][0] = true;
      visited[x][mazeComplexity + 1] = true;
    }
    for (int y = 0; y < mazeComplexity + 2; y++)
    {
      visited[0][y] = true;
      visited[mazeComplexity + 1][y] = true;
    }
    north = new boolean[mazeComplexity + 2][mazeComplexity + 2];
    east = new boolean[mazeComplexity + 2][mazeComplexity + 2];
    south = new boolean[mazeComplexity + 2][mazeComplexity + 2];
    west = new boolean[mazeComplexity + 2][mazeComplexity + 2];
    for (int x = 0; x < mazeComplexity + 2; x++)
    {
      for (int y = 0; y < mazeComplexity + 2; y++)
      {
        north[x][y] = true;
        east[x][y] = true;
        south[x][y] = true;
        west[x][y] = true;
      }
    }
  }
  private void generateStartLocation(int x, int y)
  {
    visited[x][y] = true;
    while (!visited[x][y + 1] || !visited[x + 1][y] || !visited[x][y - 1] || !visited[x - 1][y])
    {
      while (true)
      {
        double r = StdRandom.uniform(4);
        if (r == 0 && !visited[x][y + 1])
        {
          north[x][y] = false;
          south[x][y + 1] = false;
          generateStartLocation(x, y + 1);
          break;
        }
        else if (r == 1 && !visited[x + 1][y])
        {
          east[x][y] = false;
          west[x + 1][y] = false;
          generateStartLocation(x + 1, y);
          break;
        }
        else if (r == 2 && !visited[x][y - 1])
        {
          south[x][y] = false;
          north[x][y - 1] = false;
          generateStartLocation(x, y - 1);
          break;
        }
        else if (r == 3 && !visited[x - 1][y])
        {
          west[x][y] = false;
          east[x - 1][y] = false;
          generateStartLocation(x - 1, y);
          break;
        }
      }
    }
  }
  private void renderCorrectSolveDots(int x, int y)
  {
    Color colorOfCorrectSolvePath = StdDrawColors.BOOK_BLUE;
    StdDraw.setPenColor(colorOfCorrectSolvePath);
    drawAndSizeSolvePathPoints(x, y);
    StdDraw.show(30);
  }
  private void renderIncorrectSolveDots(int x, int y)
  {
    Color colorOfIncorrectSolvePath = StdDrawColors.LIGHT_GRAY;
    StdDraw.setPenColor(colorOfIncorrectSolvePath);
    drawAndSizeSolvePathPoints(x, y);
    StdDraw.show(30);
  }
  private void drawAndSizeSolvePathPoints(int x, int y)
  {
    StdDraw.filledCircle(x + 0.5, y + 0.5, 0.225);
  }
  private void createAndSizeEndPoint()
  {
    StdDraw.filledCircle(mazeComplexity / 2.0 + 0.5, mazeComplexity / 2.0 + 0.5, 0.35);
  }
  @SuppressWarnings("unused")
  private void createAndSizeStartPoint()
  {
    StdDraw.filledCircle(1.5, 1.5, 0.35);
  }
  private void drawAndColorMazeWalls()
  {
    Color colorOfMazeWalls = StdDrawColors.DARK_GRAY;
    StdDraw.setPenColor(colorOfMazeWalls);
    drawMazeWalls();
  }
  private void drawMazeWalls()
  {
    for (int x = 1; x <= mazeComplexity; x++)
    {
      for (int y = 1; y <= mazeComplexity; y++)
      {
        if (south[x][y])
          StdDraw.line(x, y, x + 1, y);
        if (north[x][y])
          StdDraw.line(x, y + 1, x + 1, y + 1);
        if (west[x][y])
          StdDraw.line(x, y, x, y + 1);
        if (east[x][y])
          StdDraw.line(x + 1, y, x + 1, y + 1);
      }
    }
  }
  public void solveThisMaze()
  {
    int startingX = 1;
    int startingY = 1;
    for (int x = startingX; x <= mazeComplexity; x++)
      for (int y = startingY; y <= mazeComplexity; y++)
        visited[x][y] = false;
    done = false;
    solve(startingX, startingY);
  }
  private void solve(int x, int y)
  {
    if (x == 0 || y == 0 || x == mazeComplexity + 1 || y == mazeComplexity + 1)
      return;
    if (done || visited[x][y])
      return;
    visited[x][y] = true;
    renderCorrectSolveDots(x, y);
    if (x == mazeComplexity / 2 && y == mazeComplexity / 2)
      done = true;
    if (!north[x][y])
      solve(x, y + 1);
    if (!east[x][y])
      solve(x + 1, y);
    if (!south[x][y])
      solve(x, y - 1);
    if (!west[x][y])
      solve(x - 1, y);
    if (done)
      return;
    renderIncorrectSolveDots(x, y);
  }
  private int         mazeComplexity;
  private boolean[][] north;
  private boolean[][] east;
  private boolean[][] south;
  private boolean[][] west;
  private boolean[][] visited;
  private boolean     done = false;
}
