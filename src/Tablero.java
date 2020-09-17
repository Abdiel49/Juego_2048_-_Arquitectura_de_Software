public class Tablero {

  private int[][] Board;

  public Tablero ( int[][] tablero ){
    this.Board = tablero;
  }
  public Tablero () {
    this.Board= new int[4][4];/*[]{
        {0, 1, 2, 3},
        {0, 1, 2, 3},
        {0, 1, 2, 3},
        {0, 1, 2, 3}
    };*/
  }

  public boolean move(char key){
    boolean resp = true;
    switch (key){
      case 'w' :
        scrollUp();
        break;
      default : resp = false;
    }
    return resp;
  }

  public void scrollUp (){

  }
  public void solve(){
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        if(this.Board[j][i]==this.Board[j+1][i] && this.Board[j][i] != 0){
          this.Board[j][i]=this.Board[j][i]+this.Board[j+1][i];
          this.Board[j+1][i]=0;
        }
      }
    }
  }
  public void displace(){
    int a, flag;
    for (int i = 0; i < this.Board.length; i++) {
      for (int j = 0; j < this.Board.length; j++) {
        a = this.Board[j][i];
        flag = j;// = this.Board[j][i];
        if(a==0){
          flag = search(flag, i);
          if(flag < 4){   // SWAP
            Board[j][i] = Board[flag][i];
            Board[flag][i] = a;
          }
        }
      }
    }
  }
  private int search(int flag, int colum){
    int resp=4;
    for (int i = flag; i < Board.length; i++) {
      if(Board[i][colum] != 0){
        resp = i;
        break;
      }
    }
    return resp;
  }

  public boolean equals ( Tablero t){
    //int [][] board = t.getBoard();
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if(this.Board[i][j] != t.Board[i][j])
          return false;
      }
    }
    return true;
  }

  /*
  public void printBoard(){
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(this.Board[i][j]+"\t");
      }
      System.out.println();
    }
  }

   */
}
