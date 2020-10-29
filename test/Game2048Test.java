import g2048.gamerules.G2048;
import g2048.gamerules.Game2048;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * For run any test of this test class
 * you need commnet one line of code in g2048.gamerules.Game2048.java
 * comment the line where the value od the
 * 'FIRST_NIMBER' is assigned on the game board 2048
 */
public class Game2048Test {

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
    Game2048 initial = new Game2048(initialBoard);
    Game2048 expected = new Game2048(expectedBoard);

    initial.moveUp();
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
    Game2048 initial = new Game2048(initialBoard);
    Game2048 expected = new Game2048(expectedBoard);

    initial.moveUp();

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
    Game2048 initial = new Game2048(initialBoard);
    Game2048 expected = new Game2048(expectedBoard);

    initial.moveDown();

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
    Game2048 initial = new Game2048(initialBoard);
    Game2048 expected = new Game2048(expectedBoard);

    initial.moveDown();

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
    Game2048 initial = new Game2048(initialBoard);
    Game2048 expected = new Game2048(expectedBoard);

    initial.moveLeft();

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
    Game2048 initial = new Game2048(initialBoard);
    Game2048 expected = new Game2048(expectedBoard);

    initial.moveLeft();

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
    Game2048 initial = new Game2048(initialBoard);
    Game2048 expected = new Game2048(expectedBoard);

    initial.moveRight();

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
    Game2048 initial = new Game2048(initialBoard);
    Game2048 expected = new Game2048(expectedBoard);
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
    initial.moveRight();
    assertEquals(initial, expected);
  }/*

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
    g2048.gamerules.Game2048 expected = new g2048.gamerules.Game2048(topRight);
    g2048.gamerules.Game2048 board = new g2048.gamerules.Game2048();

    board.moveUp();
    board.moveRight();

    assertEquals(board, expected);

    expected = new g2048.gamerules.Game2048(topLeft);
    board.moveLeft();
    assertEquals(board, expected);

    expected = new g2048.gamerules.Game2048(downLeft);
    board.moveDown();
    board.moveRight();
    assertEquals(board, expected);
  }
*/

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

  @Test
  public void winGameState_test(){
    int[][] initialBoard = {
        {4,4,4,2},
        {0,4,0,32},
        {4,4,4,2},
        {0,0,4,0}
    };
     G2048 game = new Game2048(initialBoard);
     assertTrue(game.winGame());
  }

  @Test
  public void LostGameState(){
    int[][] initialBoard = {
        {4,4,4,2},
        {2,4,2,8},
       {4,2,4,2},
        {2,4,2,4}
    };
    G2048 game = new Game2048(initialBoard);
    assertTrue(game.lostGame());
  }

}