import org.junit.Test;

import static org.junit.Assert.*;

public class TableroTest {

  @Test
  public void actionKey() {
    Tablero t = new Tablero();
    boolean keyPressed = t.move('w');
    assertTrue(keyPressed);

    keyPressed = t.move('a');
    assertFalse(keyPressed);

    keyPressed = t.move('s');
    assertFalse(keyPressed);

    keyPressed = t.move('d');
    assertFalse(keyPressed);
  }

  @Test
  public void solve_scrollUp_1() {
    int[][] initialBoard = {
        {4, 0, 5, 5},
        {4, 0, 0, 5},
        {2, 2, 0, 3},
        {0, 2, 2, 2}
    };
    int[][] expectedBoard = {
        {8, 0, 5, 10},
        {0, 0, 0, 0},
        {2, 4, 0, 3},
        {0, 0, 2, 2}
    };
    Tablero initial = new Tablero(initialBoard);
/*
    System.out.println("\n *** Initial State *** \n");
    initial.printBoard();

    System.out.println("\n *** ScrollUp And Final State *** \n");
    */
    initial.solve();
    /*initial.printBoard();

    System.out.println("\n *** Spected State *** \n");
    */
    Tablero expected = new Tablero(expectedBoard);
    //expected.printBoard();

    //expected.printBoard();
    assertTrue(initial.equals(expected));
  }

  @Test
  public void solve_scrollUp_2() {
    int[][] initialBoard = {
        {4, 0, 5, 7},
        {4, 0, 0, 5},
        {2, 0, 6, 3},
        {2, 2, 6, 2}
    };
    int[][] expectedBoard = {
        {8, 0, 5, 7},
        {0, 0, 0, 5},
        {4, 0, 12, 3},
        {0, 2, 0, 2}
    };
    Tablero initial = new Tablero(initialBoard);
    Tablero expected = new Tablero(expectedBoard);
    initial.solve();
    assertTrue(initial.equals(expected));
  }


  @Test
  public void displace_scrollUp_1() {
    int[][] initialBoard = {
        {8, 0, 5, 10},
        {0, 0, 0, 0},
        {2, 4, 0, 3},
        {1, 0, 2, 2}
    };
    int[][] expectedBoard = {
        {8, 4, 5, 10},
        {2, 0, 2, 3},
        {1, 0, 0, 2},
        {0, 0, 0, 0}
    };
    Tablero initial = new Tablero(initialBoard);
    Tablero expected = new Tablero(expectedBoard);

    initial.displace();

    assertTrue(initial.equals(expected));
  }
}