package g2048.ui.console;

import g2048.gamerules.G2048;
import g2048.ui.events.ChangeEvent;
import g2048.ui.events.EventType;

import java.util.Scanner;

public class Console2048 implements UI2048 {

  private final G2048 game;
  private final Scanner in;

  public Console2048(G2048 game ) {
    this.game = game;
    game.addEventListener(this);
    in = new Scanner(System.in);
  }

  @Override
  public void play(){
    String movement;
    printGameBoard();
    print("Usa: 'w', 'a', 's', 'd' para mover, _o_ 'q' para salir\n");
    while( true ) {
      movement = readMovement().toUpperCase();
      if( validate(movement) ) {
        move(movement);
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
      case "Q" : quitGame(EventType.END_GAME.getName());
      default : break;
    }
  }

  private void quitGame(String text){
    print("Console says: " + text + "\n");
//    in.close();
    System.exit(0);
  }

  private void movementHappened(String movement) {
    print( movement +"\n");
  }
  private void onChangeBoard(){
    printGameBoard();
  }
  private void winGame(String text){
    print(text+"\n");
  }

  private void lostGame(String text){
    print(text+"\n");
  }

  @Override
  public void onChange(ChangeEvent changeEvent){
    EventType type = changeEvent.getEvent();
    switch( type ) {
      case BOARD_CHANGE -> onChangeBoard();
      case WIN -> winGame(type.getName());
      case LOST -> lostGame(type.getName());
      case END_GAME -> quitGame(EventType.END_GAME.getName());
      case MOVEMENT -> movementHappened(type.getName());
    }

  }

  private void printGameBoard(){
    for( Iterable<Integer> row : game){
      for(int value : row){
        print(value + "\t");
      }
      print("\n");
    }
    print("\n");
  }

  private boolean validate(String str){
    return str.equals("W") || str.equals("A") ||
           str.equals("S") || str.equals("D") || str.equals("Q");
  }
  private void print(String str){
    System.out.print(str);
  }

}
