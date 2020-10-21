public class Main {
  public static void main(String[] args) {
	
    G2048 game = new Game2048();
    //Console2048 console = new Console2048(game);
    //console.play();
    GUI2048 gui = new GUI2048( game );
    gui.play();
  }
}
