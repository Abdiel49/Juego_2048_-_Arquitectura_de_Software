import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI2048  extends JFrame
                      implements ActionListener, KeyListener {

  private G2048 game;

  private JPanel BoardPanelContainer;
  private JPanel FunctionalPanel;
  private JPanel ControlPanel;

  private Label[][] Board;
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
    this.Board = new Label[4][4];

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
    this.FunctionalPanel.setBackground(Color.CYAN);

    Label Title = new Label("Game 2048");

    JButton Restartbutton = new JButton("Restart");
    Restartbutton.setFocusable(false);
    Restartbutton.addActionListener(e -> {
      this.game = new Game2048();
      System.out.println("Boton de reinicio");
    });

    FunctionalPanel.add(Title);
    this.FunctionalPanel.add(Restartbutton);
  }

  private void initBoardPanel(){
    this.BoardPanelContainer = new JPanel();
    this.BoardPanelContainer.setLayout( new GridLayout(4,4,3,3) );
    this.BoardPanelContainer.setPreferredSize( new Dimension(400,400) );
    this.BoardPanelContainer.setBackground(Color.GREEN);
    this.Board = new Label[4][4];

    fillBoard();
    repaintBoard();
  }

  private void initControlPanel(){
    this.ControlPanel = new JPanel();
    this.ControlPanel.setLayout(new FlowLayout());
    this.ControlPanel.setPreferredSize( new Dimension(100,65) );
    this.ControlPanel.setBackground(Color.blue);

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
    int[][] board = game.getBoard();
    for (int i = 0; i < board.length; i++) {
      for(int j = 0; j < board.length; j++) {
        int value = board[i][j];
        this.Board[i][j].setText(value+"");
      }
    }
  }

  private void fillBoard(){
    for (int i = 0; i < this.Board.length; i++) {
      for (int j = 0; j < this.Board.length; j++) {
        Label labelContend = new Label("0");
        labelContend.setFont( new Font("Sans Bold", Font.PLAIN, 50));
        labelContend.setAlignment(Label.CENTER);
        this.BoardPanelContainer.add(labelContend);
        this.Board[i][j] = labelContend;
      }
    }
  }

  public void play(){


  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals("w")){
      System.out.println("Se presiono W");
    }
    if(e.getSource() == "w" ){
      System.out.println("Se presiono W");
    }
    if(e.getSource() == upButton){
      System.out.println("Se presiono el boton de arriba");
    }
    if(e.getSource() == leftButton){
      System.out.println("Se presiono el boton de Izq");
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
    String key = (Character.toUpperCase(e.getKeyChar()))+"";
    switch (key){
      case "W" : game.moveUp();   repaintBoard(); break;
      case "S" : game.moveDown(); repaintBoard(); break;
      case "A" : game.moveLeft(); repaintBoard(); break;
      case "D" : game.moveRight();repaintBoard(); break;
      default : break;
    }
    switch (e.getKeyCode()){
      case 37 : game.moveLeft(); repaintBoard(); break;
      case 38 : game.moveUp();   repaintBoard(); break;
      case 39 : game.moveRight();repaintBoard(); break;
      case 40 : game.moveDown(); repaintBoard(); break;
      default : break;
    }
  }
}
