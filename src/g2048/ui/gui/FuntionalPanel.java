package g2048.ui.gui;

import g2048.gamerules.G2048;
import g2048.ui.events.ChangeEvent;
import g2048.ui.events.ChangeEventListener;
import g2048.ui.events.EventType;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuntionalPanel extends JPanel implements ChangeEventListener, ActionListener {

  private final G2048 game;
  private JButton quitButton;
  private JLabel title;

  public FuntionalPanel ( G2048 game){
    this.game = game;
    game.addEventListener(this);
    initFuntionalPanel();
  }
  private void initFuntionalPanel(){
    this.setLayout(new FlowLayout());
    this.setPreferredSize( new Dimension(100,40));
    this.setBackground(Colors.background());
    this.quitButton = new GameButtons("QUIT", "ALERT");
    this.title = new GameLabel("GAME 2048");

    this.quitButton.addActionListener(this);

    this.add(title);
    this.add(quitButton);
  }

  private void finalEventGame(String text){
    this.title.setText(text);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (quitButton.equals(source)) {
      this.game.triggerEvent(EventType.END_GAME);
    }
  }

  @Override
  public void onChange(ChangeEvent changeEvent) {
    EventType type = changeEvent.getEvent();
    switch ( type ) {
      case WIN -> finalEventGame(type.getName());
      case LOST -> finalEventGame(type.getName());
    }
  }
}
