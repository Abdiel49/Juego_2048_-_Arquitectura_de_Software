package g2048.ui.console;

import g2048.gamerules.G2048;

import java.util.Scanner;

public class Console2048 implements UI2048 {

  private final G2048 game;

  public Console2048(G2048 game ) {
    this.game = game;
  }
  public void play(){
    String movement;
    print( game.toString() );
    while(true) {
      print("Usa: 'w', 'a', 's', 'd' para mover, _o_ 'q' para salir");
      //print( game.toString() );
      movement = readMovement().toUpperCase();
      if( movement.equals("Q") ){
        print("Bueno, tu te lo pierdes :)\n-:el juego toxico xD");
        break;
      }
      if( validate(movement) ) {
        move(movement);
        print( game.toString() );
        if(game.winGame()) {
          print("Felicidades Reto cumplido.");
          break;
        }
        else if(game.lostGame()) {
          print("F bro ya valiste");
          break;
        }
      }else print("Momiviento no valido");
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

  public boolean validate(String str){
    return str.equals("W") || str.equals("A") ||
           str.equals("S") || str.equals("D");
  }
  private void print(String str){
    System.out.println(str);
  }

}
