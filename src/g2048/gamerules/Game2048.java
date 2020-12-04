package g2048.gamerules;

import g2048.ui.events.ChangeEvent;
import g2048.ui.events.ChangeEventListener;
import g2048.ui.events.EventType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game2048 implements G2048 {

  //pabloazero.a@fcyt.umss.edu.bo

  private int[][] Board;
  private final int SIZE = 4,
                    FIRST_NUMBER = 2;
  private int Goal;
  private final String  RIGHT = "RIGHT",
                        LEFT = "LEFT";
  private List<ChangeEventListener> ListenersUIs2048;

  public Game2048(int[][] tablero ){
    this.Board = tablero;
  }

  public Game2048() {
    this.Board = new int[SIZE][SIZE];
    this.Goal = 16;
    this.ListenersUIs2048 = new ArrayList<>();
    setNumberTwoInBoard();
  }

  @Override
  public boolean winGame(){
    boolean victory = searchValue(Goal);
    if(victory) {
      //this.Goal *= 2;
      triggerEvent(EventType.WIN);
    }
    return victory;
  }

  @Override
  public boolean lostGame() {
    boolean lost = searchValue(0);
    if( !lost ){
      triggerEvent(EventType.LOST);
    }
    return !lost;
  }

  private boolean searchValue(int value){
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        int elemmt = this.Board[i][j];
        if(elemmt == value)
          return true;
      }
    }
    return false;
  }

  private void setNumberTwoInBoard(){
    boolean hit = false;
    while ( !hit && !lostGame() ){
      int[] position = getRandomPosition();
      if( this.Board[position[0]][position[1]] == 0 ){
        this.Board[position[0]][position[1]] = FIRST_NUMBER;
        hit = true;
      }
    }
    //return hit;
  }
  @Override
  public void moveUp(){
    if( !winGame() && !lostGame() ) {
      turnMatrixControl(LEFT, 1);
      solve();
      displace();
      turnMatrixControl(RIGHT, 1);
      setNumberTwoInBoard();
      movementHappened("UP");
    }
  }

  @Override
  public void moveDown(){
    if( !winGame() && !lostGame() ) {
      turnMatrixControl(RIGHT,1);
      solve();
      displace();
      turnMatrixControl(LEFT,1);
      setNumberTwoInBoard();
      movementHappened("DOWN");
    }
  }

  @Override
  public void moveLeft(){
    if( !winGame() && !lostGame() ) {
      solve();
      displace();
      setNumberTwoInBoard();
      movementHappened("LEFT");
    }
  }

  @Override
  public void moveRight(){
    if( !winGame() && !lostGame() ) {
      turnMatrixControl(RIGHT, 2);
      solve();
      displace();
      turnMatrixControl(LEFT, 2);
      setNumberTwoInBoard();
      movementHappened("RIGHT");
    }
  }

  private void movementHappened (String movementSuccessful){
    EventType movement = EventType.MOVEMENT;
    movement.setName(movementSuccessful);
    triggerEvent(movement);
    triggerEvent(EventType.BOARD_CHANGE);
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
        if( index < SIZE ) {
          int b = this.Board[i][index];
          if( a == b ){
            this.Board[i][j] = a * 2;
            this.Board[i][index] = 0;
          }
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
    return 4; // return 4 ??
  }

  private void turnMatrixControl(String dir, int val){
    int resp[][];
    while(val-- > 0){
      resp= turnMatrix(dir);
      this.Board = resp;
    }

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

  @Override
  public Iterator<Iterable<Integer>> iterator() {
    return new GameBoardIterator(this.Board);
  }

  @Override
  public void addEventListener(ChangeEventListener listenerUI2048) {
    this.ListenersUIs2048.add(listenerUI2048);
  }

  @Override
  public void triggerEvent(EventType evenType) {
    ChangeEvent event  = new ChangeEvent(this);
    event.setEvent(evenType);
    for(ChangeEventListener ListenerUI : ListenersUIs2048 ){
      ListenerUI.onChange(event);
    }
  }

}
