public class Game2048 implements G2048 {

  //pabloazero.a@fcyt.umss.edu.bo

  private int[][] Board;
  private final int SIZE = 4, FRIST_NUMBER = 2;
  private final String  RIGHT = "RIGHT",
                        LEFT = "LEFT";

  public Game2048(int[][] tablero ){
    this.Board = tablero;
  }

  public Game2048() {
    this.Board= new int[SIZE][SIZE];
    setNumberTwoInBoard();
  }

  public static G2048 create() {
    return new Game2048();
  }

  public boolean winGame(){
    return false;
  }
  public boolean lostGame() {
    return false;
  }
  private boolean setNumberTwoInBoard(){
    boolean hit = false;
    while ( !hit ){
      int[] position = getRandomPosition();
      if( this.Board[position[0]][position[1]] == 0 ){
        this.Board[position[0]][position[1]] = FRIST_NUMBER;
        hit = true;
      }
    }
    return hit;
  }

  public boolean move(String key){
    boolean resp = true;
    key = key.toUpperCase();
    switch (key){
      case "W" : moveUp();   break;
      case "S" : moveDown(); break;
      case "A" : moveLeft(); break;
      case "D" : moveRight();break;
      default : resp = false;
    }
    setNumberTwoInBoard();
    return resp;
  }
  public void moveUp(){
    turnMatrixControl(LEFT,1);
    solve();
    displace();
    turnMatrixControl(RIGHT,1);
  }
  public void moveDown(){
    turnMatrixControl(RIGHT,1);
    solve();
    displace();
    turnMatrixControl(LEFT,1);
  }
  public void moveLeft(){
    solve();
    displace();
  }
  public void moveRight(){
    turnMatrixControl(RIGHT,2);
    solve();
    displace();
    turnMatrixControl(LEFT,2);
  }


  private void displace(){
    int a, flag;
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        a = this.Board[i][j];
        flag = j;// = this.Board[j][i];
        if(a==0){
          flag = search(i, flag);
          if(flag < SIZE){   // SWAP
            Board[i][j] = Board[i][flag];
            Board[i][flag] = a;
          }
          //j = flag;
        }
      }
    }
  }

  private void solve(){
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE-1; j++) {
        int a = this.Board[i][j];
        int index = search( i, j+1 );
        int b = this.Board[i][index];
        if( a == b ){
          this.Board[i][j] = a * 2;
          this.Board[i][index] = 0;
        }
        //j = index;
      }
    }
  }

  private int search( int array, int flag ){
    for (int i = flag; i < SIZE; i++) {
      if(Board[ array ][ i ] != 0)
        return i;
    }
    return 3; // return 4 ??
  }

  private int[][] turnMatrixControl(String dir, int val){
    int resp[][] = new int [SIZE][SIZE];
    while(val-- > 0){
      resp= turnMatrix(dir);

      this.Board = resp;
    }
    return resp;
  }
  private int[][] turnMatrix( String direction){
    int[][] newMatrix = new int [SIZE][SIZE];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        int[] newLocation = getNewLocation(direction, i, j);
        int a = newLocation[0];
        int b = newLocation[1];
        newMatrix[a][b] = this.Board[i][j];
      }
    }
    return newMatrix;
  }
// pull out
  private int[] getNewLocation( String direction, int i, int j ){
    int [] a = new int [2];
    if(direction.equals("RIGHT")){
      a[0] = j;
      a[1] = SIZE-1-i;
    }else{
      a[0] = SIZE-1-j;
      a[1] = i;
    }
    return a;
  }
  // pull out
  private int[] getRandomPosition(){
    int a = (int) (Math.random()*SIZE);
    int b = (int) (Math.random()*SIZE);
    return new int[]{a,b};
  }

  @Override
  public boolean equals ( Object o ){
    boolean resp = true;
    if(o == this)
        resp = true;
    if(o instanceof Game2048){
      Game2048 anotherBoard = (Game2048) o;
      for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
          if(this.Board[i][j] != anotherBoard.Board[i][j])
            return false;
        }
      }
    }
    return resp;
  }


  public String toString() {
    String toString = "{\n";
    for (int i = 0; i < SIZE; i++) {
      toString += "[ ";
      for (int j = 0; j < SIZE; j++) {
        int val = this.Board[i][j];
        toString += val+",\t";
      }
      toString += "],\n";
    }
    toString += "}\n";
    return toString;
  }

}
