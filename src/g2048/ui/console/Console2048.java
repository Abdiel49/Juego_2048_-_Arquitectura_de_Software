package g2048.ui.console;

import g2048.gamerules.G2048;

import java.util.Scanner;

public class Console2048 implements UI2048 {

  private final G2048 game;

  public Console2048(G2048 game ) {
    this.game = game;
  }

  @Override
  public void play(){
    String movement;
    printGameBoard();
    while(true) {
      print("Usa: 'w', 'a', 's', 'd' para mover, _o_ 'q' para salir\n");
      //print( game.toString() );
      movement = readMovement().toUpperCase();
      if( movement.equals("Q") ){
        print("Bueno, tu te lo pierdes :)\n-:el juego toxico xD\n");
        break;
      }
      if( validate(movement) ) {
        print(movement + " was pressed!");
        move(movement);
        printGameBoard();
        if(game.winGame()) {
          print("Felicidades Reto cumplido.\n");
          break;
        }
        else if(game.lostGame()) {
          print("F bro ya valiste\n");
          break;
        }
      }else print("Momiviento no valido\n");
    }
  }
  private String readMovement(){
    Scanner in = new Scanner(System.in);
    return in.next();
  }

  private void move(String key){
    switch (key){
      case "W" : game.moveUp();   break;
      case "S" : game.moveDown(); break;
      case "A" : game.moveLeft(); break;
      case "D" : game.moveRight();break;
      default : break;
    }
  }

  private void printGameBoard(){
    for( Iterable<Integer> row : game){
      for(int value : row){
        print(value + "\t");
      }
      print("\n");
    }
  }

  private boolean validate(String str){
    return str.equals("W") || str.equals("A") ||
           str.equals("S") || str.equals("D");
  }
  private void print(String str){
    System.out.print(str);
  }

}
