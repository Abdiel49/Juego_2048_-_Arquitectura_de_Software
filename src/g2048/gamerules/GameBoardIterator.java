package g2048.gamerules;

import java.util.Iterator;

public class GameBoardIterator implements Iterator {

  private int indexRow;
  private int indexCol;
  private int[][] Board;

  public GameBoardIterator(int[][]board){
    this.Board = board;
    indexRow = 0;
    indexCol = 0;
  }
  @Override
  public boolean hasNext() {
    return (indexRow < this.Board.length) && (indexCol < this.Board[1].length);
  }

  /**             indexCol - >
   * indexRow   {8, 4, 5, 10},
   *    |       {2, 0, 2, 3},
   *    v       {0, 0, 0, 2},
   *            {0, 0, 0, 0}
   */

  @Override
  public Integer next() {
    Integer value = this.Board[indexRow][indexCol];
    if (indexCol+1 < Board[indexRow].length ){
      indexCol++;
    } else if (indexRow+1 < Board.length) {
      indexCol = 0;
      indexRow++;
    }
    return value;
  }
}
