public class Tablero {

  //pabloazero.a@fcyt.umss.edu.bo

  private int[][] Board;
  private final int SIZE = 4, FRIST_NUMBER = 2;
  private final String  RIGHT = "RIGHT",
                        LEFT = "LEFT";

  public Tablero ( int[][] tablero ){
    this.Board = tablero;
  }

  public Tablero () {
    this.Board= new int[SIZE][SIZE];
    setInitialState();
  }

  private void setInitialState(){
    int[] position = getRandomPosition();
    this.Board[position[0]][position[1]] = FRIST_NUMBER;
  }

  public boolean move(char key){
    boolean resp = true;
    key = Character.toUpperCase(key);
    switch (key){
      case 'W' : playUp();   break;
      case 'S' : playDown(); break;
      case 'A' : playLeft(); break;
      case 'D' : playRight();break;
      default : resp = false;
    }
    return resp;
  }
  private void playUp(){
    turnMatrixControl(LEFT,1);
    solve();
    displace();
    turnMatrixControl(RIGHT,1);
  }
  private void playDown(){
    turnMatrixControl(RIGHT,1);
    solve();
    displace();
    turnMatrixControl(LEFT,1);
  }
  private void playLeft(){
    solve();
    displace();
  }
  private void playRight(){
    turnMatrixControl(RIGHT,2);
    solve();
    displace();
    turnMatrixControl(LEFT,2);
  }

  public void displace(){
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

  public void solve(){
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

  public int[][] turnMatrixControl(String dir, int val){
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

  private int[] getRandomPosition(){
    int a = (int) Math.random()*SIZE;
    int b = (int) Math.random()*SIZE;
    return new int[]{a,b};
  }

  @Override
  public boolean equals ( Object o ){
    if(o == this)
        return true;
    if(o instanceof Tablero){
      Tablero anotherBoard = (Tablero) o;
      for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
          if(this.Board[i][j] != anotherBoard.Board[i][j])
            return false;
        }
      }
    }
    return true;
  }

  public String printBoard(String title) {
    String toString = "{ ";
    System.out.println("\t***\t"+title+"\t***\t");
    for (int i = 0; i < SIZE; i++) {
      toString += "[ ";
      for (int j = 0; j < SIZE; j++) {
        int val = this.Board[i][j];
        toString += val+", ";
        System.out.print(val+"\t");
      }
      toString += "],\n";
      System.out.println();
    }
    toString += "}";
    return toString;
  }/*
  public String toString(){
    return printBoard("");
  }*/
}
