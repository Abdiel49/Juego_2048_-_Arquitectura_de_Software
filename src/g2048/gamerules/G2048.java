package g2048.gamerules;

public interface G2048
    extends Iterable<Iterable<Integer>>,
            Game2048Model {
  void moveUp();
  void moveDown();
  void moveLeft();
  void moveRight();
  boolean winGame();
  boolean lostGame();
}
