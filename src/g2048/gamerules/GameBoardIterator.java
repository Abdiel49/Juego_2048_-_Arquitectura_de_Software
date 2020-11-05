package g2048.gamerules;

import java.util.Arrays;
import java.util.Iterator;

public class GameBoardIterator implements Iterator {

  private int index;
  private int[][] Board;

  public GameBoardIterator(int[][]board){
    this.Board = board;
    index = 0;
  }
  @Override
  public boolean hasNext() {
    return index < Board.length;
  }

  @Override
  public Iterable<Integer> next() {
    index++;
    return () -> Arrays.stream(Board[index - 1]).iterator();
  }
}
