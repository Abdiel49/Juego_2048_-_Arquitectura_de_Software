import java.util.Scanner;

public class BoardMain {
  public static void main ( String[] args ){
    Game2048 t = new Game2048();
    Scanner in = new Scanner(System.in);
    print("Ya valiste  - 2048");
    while ( true ) {
      print(t.toString());
      print("Mueve:");
      String move = in.next();
      t.move(move);
    }
  }
  private static void print(String str){
    System.out.println(str);
  }
}
