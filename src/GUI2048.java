import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI2048 extends JFrame implements ActionListener {

  private G2048 Game;

  private JPanel BoardPanelContainer;
  private JPanel FunctionalPanel;
  private JPanel ControlPanel;


  private JButton Restartbutton;
  private Label[][] Board;

  public GUI2048 (G2048 game){
    this.Game = game;
    initAllComponents();
  }

  private void initAllComponents(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500, 500);
    this.setVisible(true);
    this.setTitle("Game 2048 - Arquitectura de Software");
    this.setLayout( new BorderLayout(2,2));
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
    this.FunctionalPanel.setPreferredSize( new Dimension(100,50));
    this.FunctionalPanel.setBackground(Color.CYAN);
    this.Restartbutton = new JButton("Restart");


    this.FunctionalPanel.add(this.Restartbutton);
  }

  private void initBoardPanel(){
    this.BoardPanelContainer = new JPanel();
    this.BoardPanelContainer.setLayout( new GridLayout(4,4,3,3) );
    this.BoardPanelContainer.setPreferredSize( new Dimension(400,400) );
    this.BoardPanelContainer.setBackground(Color.GREEN);

    fillBoard(0);
  }

  private void initControlPanel(){
    this.ControlPanel = new JPanel();
    this.ControlPanel.setPreferredSize( new Dimension(100,50) );
    this.ControlPanel.setBackground(Color.blue);

    //this.ControlPanel.add(this.Restartbutton);
  }

  private void fillBoard(int value){
    for (int i = 0; i < Board.length; i++) {
      for(Label button : Board[i]){
        button = new Label(value+"");
        //button.setEnabled(false);
        button.setAlignment(Label.CENTER);
        this.BoardPanelContainer.add(button);
      }
    }
  }

  public void play(){


  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
