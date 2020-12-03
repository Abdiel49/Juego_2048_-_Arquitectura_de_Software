package g2048.ui.gui;

import g2048.gamerules.G2048;
import g2048.ui.events.ChangeEvent;
import g2048.ui.events.EventType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI2048  extends JFrame
    implements KeyListener, UI2048, ActionListener {

  private G2048 game;
  private final int ROW_SIZE = 4,
      COLUMN_SIZE = 4,
      LEFT_ARROW = 37,
      UP_ARROW = 38,
      RIGHT_ARROW = 39,
      DOWN_ARROW = 40;

  private Label title;
  private Label notice;
  private JPanel BoardPanelContainer;
  private JPanel FunctionalPanel;
  private JPanel ControlPanel;

  private Label[] Board;
  private JButton upButton;
  private JButton downButton;
  private JButton leftButton;
  private JButton rightButton;
  private JButton quitBbutton;

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

    initFunctionalPanel();
    initBoardPanel();
    initControlPanel();

    this.add(this.FunctionalPanel, BorderLayout.NORTH);
    this.add(this.ControlPanel, BorderLayout.SOUTH);
    this.add(this.BoardPanelContainer, BorderLayout.CENTER);

    this.pack();
  }

  private void initFunctionalPanel(){
    this.FunctionalPanel = new JPanel();
    this.FunctionalPanel.setLayout(new FlowLayout());
    this.FunctionalPanel.setPreferredSize( new Dimension(100,40));
    //this.FunctionalPanel.setBackground(new Color(87,230,156));

    title = new Label("Game 2048");
    notice = new Label();
    title.setFont( new Font("Sans Bold", Font.PLAIN, 24));
    title.setForeground(Colors.textPrimary());
    this.FunctionalPanel.setBackground(Colors.background());

    quitBbutton = new JButton("QUIT");
    quitBbutton.setBackground(Colors.alert());
    quitBbutton.setFocusable(false);
    quitBbutton.addActionListener(this);
    quitBbutton.setForeground(Colors.background());

    FunctionalPanel.add(title);
    FunctionalPanel.add(notice);
    FunctionalPanel.add(quitBbutton);
  }
  @Override
  public void play(){
    if( game.winGame() ){
      this.notice.setText(EventType.WIN.getName());
    }
    if( game.lostGame() ) {
      this.notice.setText(EventType.LOST.getName());
    }

  }

  private void initBoardPanel(){
    this.BoardPanelContainer = new JPanel();
    this.BoardPanelContainer.setLayout( new GridLayout(4,4,3,3) );
    this.BoardPanelContainer.setPreferredSize( new Dimension(400,400) );
    this.BoardPanelContainer.setBackground(Colors.background());
    //this.BoardPanelContainer.setBackground(new Color(238, 226, 209) );
    fillBoard();
    repaintBoard();
  }

  private void initControlPanel(){
    this.ControlPanel = new JPanel();
    this.ControlPanel.setLayout(new FlowLayout());
    this.ControlPanel.setPreferredSize( new Dimension(100,65) );
    this.ControlPanel.setBackground(Colors.background());
    //this.ControlPanel.setBackground(new Color(91, 112,240));

    this.upButton = new JButton("Move UP");
    this.downButton = new JButton("Move Down");
    this.leftButton = new JButton("Move Left");
    this.rightButton = new JButton("Move Right");

    this.upButton.addActionListener(this);
    this.downButton.addActionListener(this);
    this.leftButton.addActionListener(this);
    this.rightButton.addActionListener(this);

    this.leftButton.setFocusable(false);
    this.rightButton.setFocusable(false);
    this.upButton.setFocusable(false);
    this.downButton.setFocusable(false);

    this.ControlPanel.add(leftButton);
    this.ControlPanel.add(upButton);
    this.ControlPanel.add(rightButton);
    this.ControlPanel.add(downButton);
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
  public void keyTyped(KeyEvent e) {
    //System.out.println("key presed is: "+e.getKeyChar()+", and key code is: "+e.getKeyCode());
  }

  @Override
  public void keyPressed(KeyEvent e) {
    //System.out.println("key presed is: "+e.getKeyChar()+", and key code is: "+e.getKeyCode());
  }

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
  private void winGame(String message){
    //this.title.setText(message);
  }

  private void lostGame(String message){
    this.title.setText(message);
  }

  private void movementHappened(String movement) {
    switch( movement ) {
      case "UP" -> upButton.setBackground(Colors.action());
      case "DOWN" -> downButton.setBackground(Colors.action());
      case "LEFT" -> leftButton.setBackground(Colors.action());
      case "RIGHT" -> rightButton.setBackground(Colors.action());
    }
  }

  @Override
  public void onChange(ChangeEvent changeEvent) {
    EventType type = changeEvent.getEvent();
    switch ( type ) {
      case BOARD_CHANGE -> repaintBoard();
      case WIN -> winGame( type.getName() );
      case LOST -> lostGame( type.getName() );
      case END_GAME -> this.dispose();
      case MOVEMENT -> movementHappened( type.getName() );
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    //if(e.getSource() == upButton)
    Object source = e.getSource();
    if (quitBbutton.equals(source)) {
      this.game.triggerEvent(EventType.END_GAME);
    } else if (upButton.equals(source)) {
      this.game.moveUp();
    } else if (downButton.equals(source)) {
      this.game.moveDown();
    } else if (leftButton.equals(source)) {
      this.game.moveLeft();
    } else if (rightButton.equals(source)) {
      this.game.moveRight();
    }
  }
}
