interface G2048 {
  static G2048 create(){return null;};
  void moveUp();
  void moveDown();
  void moveLeft();
  void moveRight();
  boolean winGame();
  boolean lostGame();

}
