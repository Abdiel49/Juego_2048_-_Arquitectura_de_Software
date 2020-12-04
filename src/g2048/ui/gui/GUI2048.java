package g2048.ui.gui;

import g2048.gamerules.G2048;
import g2048.ui.events.ChangeEvent;
import g2048.ui.events.EventType;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Label;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI2048  extends JFrame
    implements KeyListener, UI2048 {

  private final G2048 game;
  private final int ROW_SIZE = 4,
      COLUMN_SIZE = 4,
      LEFT_ARROW = 37,
      UP_ARROW = 38,
      RIGHT_ARROW = 39,
      DOWN_ARROW = 40;

  private JPanel BoardPanelContainer;
  private JPanel FunctionalPanel;
  private JPanel ControlPanel;

  private Label[] Board;

  public GUI2048 (G2048 game){
    this.game = game;
    game.addEventListener(this);
    initAllComponents();
  }

  private void initAllComponents(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(600, 600);
    this.setVisible(true);
    this.setTitle("Game 2048 - Arquitectura de Software");
    this.setLayout( new BorderLayout(2,2));
    this.addKeyListener(this);
    this.Board = new Label[ROW_SIZE*COLUMN_SIZE];
    this.setBackground(Colors.background());

    this.FunctionalPanel = new FuntionalPanel(game);
    this.ControlPanel = new ControlPanel(game);
    this.BoardPanelContainer = new BoardPanel();

    fillBoard();
    repaintBoard();

  }

  @Override
  public void play(){
    this.add(this.FunctionalPanel, BorderLayout.NORTH);
    this.add(this.ControlPanel, BorderLayout.SOUTH);
    this.add(this.BoardPanelContainer, BorderLayout.CENTER);

    this.pack();
  }

  private void repaintBoard(){
    int i = 0;
    for( Iterable<Integer> row : game){
      for(int value : row){
        this.Board[i].setText( value+"" );
        i++;
      }
    }
  }

  private void fillBoard(){
    for(int i = 0; i < this.Board.length; i++){
      Label labelContend = new Label("0");
      labelContend.setFont( new Font("Sans Bold", Font.PLAIN, 50));
      labelContend.setAlignment(Label.CENTER);
      labelContend.setForeground(Colors.text());
      this.BoardPanelContainer.add(labelContend);
      this.Board[i] = labelContend;
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {  }

  @Override
  public void keyPressed(KeyEvent e) {  }

  @Override
  public void keyReleased(KeyEvent e) {
    char key = Character.toUpperCase(e.getKeyChar());
    switch (key){
      case 'W' : game.moveUp();   repaintBoard(); play(); break;
      case 'S' : game.moveDown(); repaintBoard(); play(); break;
      case 'A' : game.moveLeft(); repaintBoard(); play(); break;
      case 'D' : game.moveRight();repaintBoard(); play(); break;
      default : break;
    }
    switch (e.getKeyCode()){
      case UP_ARROW : game.moveUp();   repaintBoard(); play(); break;
      case DOWN_ARROW : game.moveDown(); repaintBoard(); play(); break;
      case LEFT_ARROW : game.moveLeft(); repaintBoard(); play(); break;
      case RIGHT_ARROW : game.moveRight();repaintBoard(); play(); break;
      default : break;
    }
  }

  @Override
  public void onChange(ChangeEvent changeEvent) {
    EventType type = changeEvent.getEvent();
    switch ( type ) {
      case BOARD_CHANGE -> repaintBoard();
      case END_GAME -> this.dispose();
    }
  }

}
