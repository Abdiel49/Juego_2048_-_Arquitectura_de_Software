package g2048.ui.gui;

import g2048.gamerules.G2048;
import g2048.gamerules.Game2048;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI2048  extends JFrame
    implements KeyListener, UI2048 {

  private G2048 game;
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
  private JButton upButton;
  private JButton downButton;
  private JButton leftButton;
  private JButton rightButton;


  public GUI2048 (G2048 game){
    this.game = game;
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

    Label title = new Label("Game 2048");
    title.setFont( new Font("Sans Bold", Font.PLAIN, 20));

    JButton restartbutton = new JButton("Restart");
    restartbutton.setFocusable(false);
    restartbutton.addActionListener(e -> {
      //this.game = new g2048.gamerules.Game2048();
      System.out.println("restart button was presset");
    });

    FunctionalPanel.add(title);
    this.FunctionalPanel.add(restartbutton);
  }
  @Override
  public void play(){
    if( game.winGame() ){
      int YES = 0, NO = 1;
      int yesNoMessageDialog = JOptionPane.showConfirmDialog(
          null, "You Win!!\n Play Again?",
          "Game 2040 says:", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
      if ( yesNoMessageDialog == YES){
        JOptionPane.showMessageDialog(null, "Les't Go!");
      }
      if ( yesNoMessageDialog == NO){
        JOptionPane.showMessageDialog(null, "Bye");
        this.dispose();
      }
    }
    if( game.lostGame() ) {
      JOptionPane.showMessageDialog(null, "Bye");
    }

  }

  private void initBoardPanel(){
    this.BoardPanelContainer = new JPanel();
    this.BoardPanelContainer.setLayout( new GridLayout(4,4,3,3) );
    this.BoardPanelContainer.setPreferredSize( new Dimension(400,400) );
    //this.BoardPanelContainer.setBackground(new Color(238, 226, 209) );


    fillBoard();
    repaintBoard();
  }

  private void initControlPanel(){
    this.ControlPanel = new JPanel();
    this.ControlPanel.setLayout(new FlowLayout());
    this.ControlPanel.setPreferredSize( new Dimension(100,65) );
    //this.ControlPanel.setBackground(new Color(91, 112,240));

    this.upButton = new JButton("Move UP");
    this.downButton = new JButton("Move Down");
    this.leftButton = new JButton("Move Left");
    this.rightButton = new JButton("Move Right");

    this.upButton.addActionListener(e -> {
      this.game.moveUp();
      repaintBoard();
    });
    this.downButton.addActionListener(e -> {
      this.game.moveDown();
      repaintBoard();
    });
    this.leftButton.addActionListener(e -> {
      this.game.moveLeft();
      repaintBoard();
    });
    this.rightButton.addActionListener(e -> {
      this.game.moveRight();
      repaintBoard();
    });

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
    //System.out.println("key presed is: "+e.getKeyChar()+", and key code is: "+e.getKeyCode());
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
}
