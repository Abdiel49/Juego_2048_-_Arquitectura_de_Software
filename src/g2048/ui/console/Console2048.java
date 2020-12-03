package g2048.ui.console;

import g2048.gamerules.G2048;
import g2048.ui.events.ChangeEvent;
import g2048.ui.events.EventType;

import java.util.Scanner;

public class Console2048 implements UI2048 {

  private final G2048 game;
  private Scanner in;

  public Console2048(G2048 game ) {
    this.game = game;
    game.addEventListener(this);
    in = new Scanner(System.in);
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
        exitGame("");
        break;
      }
      if( validate(movement) ) {
        print(movement + " was pressed!\n");
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

  private void exitGame(String text){
    print("Console says: " + text + "\n");
    System.exit(0);
  }

  private void movementHappened(String movement) {
    print( movement +"\n");
  }

  @Override
  public void onChange(ChangeEvent changeEvent){
    EventType type = changeEvent.getEvent();
    switch( type ) {
      case BOARD_CHANGE -> printGameBoard();
      case WIN -> print(type.getName()+"\n");
      case LOST -> print(type.getName()+"\n");
      case END_GAME -> exitGame(EventType.END_GAME.getName());
      //case MOVEMENT -> movementHappened(type.getName());
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
