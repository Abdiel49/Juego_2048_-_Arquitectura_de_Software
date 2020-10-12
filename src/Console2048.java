import java.util.Scanner;

public class Console2048 {

  private final G2048 game;

  public Console2048(G2048 game ) {
    this.game = game;
  }
  public void play(){
    String movement;
    while(true) {
      print("Usa: 'w', 'a', 's', 'd' para mover, _o_ 'q' para salir");
      print( game.toString() );
      movement = readMovement().toUpperCase();
      if( movement.equals("Q") ){
        print("Bueno, tu te lo pierdes :)\n-:el juego toxico xD");
        break;
      }
      if( move(movement) ) {
        if(game.winGame()) {
          print("Felicidades Reto cumplido.");
          break;
        }
        if(game.lostGame()) {
          print("F bro ya valiste");
          break;
        }
      }else
        print("Momiviento no valido");
    }
  }
  private String readMovement(){
    Scanner in = new Scanner(System.in);
    String resp = in.next();
    return resp;
  }

  public boolean move(String key){
    boolean resp = true;
    switch (key){
      case "W" : game.moveUp();   break;
      case "S" : game.moveDown(); break;
      case "A" : game.moveLeft(); break;
      case "D" : game.moveRight();break;
      default : resp = false;
    }
    return resp;
  }

  private boolean validate(String str){
    return str.length() < 2 ? true : false;
  }
  public void print(String str){
    System.out.println(str);
  }
}
