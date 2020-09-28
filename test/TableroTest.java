import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class TableroTest {

  @Test
  public void actionKey() {
    Tablero t = new Tablero();

    boolean keyPressed = t.move('w');
    assertTrue(keyPressed);

    keyPressed = t.move('a');
    assertTrue(keyPressed);

    keyPressed = t.move('S');
    assertTrue(keyPressed);

    keyPressed = t.move('d');
    assertTrue(keyPressed);

    keyPressed = t.move('H');
    assertFalse(keyPressed);

    keyPressed = t.move(' ');
    assertFalse(keyPressed);

  }

  @Test
  public void moveUp_1() {
    int[][] initialBoard = {
        {4, 0, 5, 5},
        {4, 0, 0, 5},
        {2, 2, 0, 3},
        {0, 2, 2, 2}
    };
    int[][] expectedBoard = {
        {8, 4, 5, 10},
        {2, 0, 2, 3},
        {0, 0, 0, 2},
        {0, 0, 0, 0}
    };
    Tablero initial = new Tablero(initialBoard);
    Tablero expected = new Tablero(expectedBoard);

    initial.move('w');

    assertEquals(initial, expected);
  }

  @Test
  public void moveUp_2() {
    int[][] initialBoard = {
        {4,4,4,2},
        {0,4,0,3},
        {4,4,4,2},
        {0,0,4,0}
    };
    int[][] expectedBoard = {
        {8,8,8,2},
        {0,4,4,3},
        {0,0,0,2},
        {0,0,0,0}
    };
    Tablero initial = new Tablero(initialBoard);
    Tablero expected = new Tablero(expectedBoard);

    initial.move('w');

    assertEquals(initial, expected);
  }

  @Test
  public void moveDown_1() {
    int[][] initialBoard = {
        {4, 0, 5, 5},
        {4, 0, 0, 5},
        {2, 2, 0, 3},
        {0, 2, 2, 2}
    };
    int[][] expectedBoard = {
        {0, 0, 0, 0},
        {0, 0, 0, 10},
        {8, 0, 5, 3},
        {2, 4, 2, 2}
    };
    Tablero initial = new Tablero(initialBoard);
    Tablero expected = new Tablero(expectedBoard);

    initial.move('s');

    assertEquals(initial, expected);
  }

  @Test
  public void moveDown_2() {
    int[][] initialBoard = {
        {4,4,4,2},
        {0,4,0,3},
        {4,4,4,2},
        {0,0,4,0}
    };
    int[][] expectedBoard = {
        {0,0,0,0},
        {0,0,0,2},
        {0,4,4,3},
        {8,8,8,2}
    };
    Tablero initial = new Tablero(initialBoard);
    Tablero expected = new Tablero(expectedBoard);

    initial.move('s');

    assertEquals(initial, expected);
  }

  @Test
  public void moveLeft_1() {
    int[][] initialBoard = {
        {4, 0, 5, 5},
        {4, 0, 0, 5},
        {2, 2, 0, 3},
        {0, 2, 2, 2}
    };
    int[][] expectedBoard = {
        {4, 10, 0, 0},
        {4, 5,  0, 0},
        {4, 3,  0, 0},
        {4, 2,  0, 0}
    };
    Tablero initial = new Tablero(initialBoard);
    Tablero expected = new Tablero(expectedBoard);

    initial.move('a');

    assertEquals(initial, expected);
  }

  @Test
  public void moveLeft_2() {
    int[][] initialBoard = {
        {4,4,4,2},
        {0,4,0,3},
        {4,4,4,2},
        {0,0,4,0}
    };
    int[][] expectedBoard = {
        {8,4,2,0},
        {4,3,0,0},
        {8,4,2,0},
        {4,0,0,0}
    };
    Tablero initial = new Tablero(initialBoard);
    Tablero expected = new Tablero(expectedBoard);

    initial.move('a');

    assertEquals(initial, expected);
  }

  @Test
  public void moveRight_1() {
    int[][] initialBoard = {
        {4, 0, 5, 5},
        {4, 0, 0, 5},
        {2, 2, 0, 3},
        {0, 2, 2, 2}
    };
    int[][] expectedBoard = {
        {0, 0, 4, 10},
        {0, 0, 4, 5},
        {0, 0, 4, 3},
        {0, 0, 2, 4}
    };
    Tablero initial = new Tablero(initialBoard);
    Tablero expected = new Tablero(expectedBoard);

    initial.move('d');

    assertEquals(initial, expected);
  }

  @Test
  public void moveRight_2() {
    int[][] initialBoard = {
        {4,4,4,2},
        {0,4,0,3},
        {4,4,4,2},
        {0,0,4,0}
    };
    int[][] expectedBoard = {
        {0,4,8,2},
        {0,0,4,3},
        {0,4,8,2},
        {0,0,0,4}
    };
    Tablero initial = new Tablero(initialBoard);
    Tablero expected = new Tablero(expectedBoard);
    /*
    initial.printBoard("Initial");
    initial.turnMatrixControl("RIGHT",1);
    initial.printBoard("One Turn Right");
    initial.turnMatrixControl("RIGHT",1);
    initial.printBoard("One More Rurn Right 2");
    initial.solve();
    initial.printBoard("Solve");
    initial.displace();
    initial.printBoard("Displace");
    initial.turnMatrixControl("LEFT",1);
    initial.printBoard("Left Turn Board");
    initial.turnMatrixControl("LEFT",1);
    initial.printBoard("Left Turn Board One more time");
    */
    initial.move('d');
    assertEquals(initial, expected);
  }


  @Test
  public void justNumberTwo(){
    int[][] topRight  = {
        {0,0,0,2},
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0}
    };
    int[][] topLeft = {
        {2,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0}
    };
    int[][] downLeft = {
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,2}
    };
    Tablero expected = new Tablero(topRight);
    Tablero board = new Tablero();

    board.move('w');
    board.move('d');

    assertEquals(board, expected);

    expected = new Tablero(topLeft);
    board.move('a');
    assertEquals(board, expected);

    expected = new Tablero(downLeft);
    board.move('s');
    board.move('d');
    assertEquals(board, expected);
  }


  /**
 * Test Turn Matrix of the Board
 * First you need to make public turnMatrixControl(...)
 * method on the class
  @Test
  public void moveDown_solve_and_displace_1() {
    int[][] initialBoard = {
        {4,4,4,2},
        {0,4,0,3},
        {4,4,4,2},
        {0,0,4,0}
    };
    int[][] expectedBoard = {
        {0,4,0,4},
        {0,4,4,4},
        {4,4,0,4},
        {0,2,3,2}
    };
    int[][] twoTurn = {
        {0,4,0,0},
        {2,4,4,4},
        {3,0,4,0},
        {2,4,4,4}
    };
    Tablero initial = new Tablero(initialBoard);
    Tablero expected = new Tablero(expectedBoard);
    Tablero newInitial = new Tablero(initialBoard);
    Tablero twoTurnBoard = new Tablero(twoTurn);

    initial.turnMatrixControl("RIGHT", 1);
    assertEquals( initial, expected);

    initial.turnMatrixControl("LEFT", 1);
    assertEquals( initial, newInitial);

    initial.turnMatrixControl("RIGHT", 2);
    assertEquals( initial, twoTurnBoard);
  }*/

}