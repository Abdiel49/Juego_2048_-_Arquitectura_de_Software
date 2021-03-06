package g2048.ui.gui;

import g2048.gamerules.G2048;
import g2048.ui.events.ChangeEvent;
import g2048.ui.events.ChangeEventListener;
import g2048.ui.events.EventType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements ChangeEventListener, ActionListener{

  private final G2048 game;

  private GameButton upButton;
  private GameButton downButton;
  private GameButton leftButton;
  private GameButton rightButton;

  private GameButton lastActionPressed;

  public ControlPanel (G2048 game){
    this.game = game;
    this.game.addEventListener(this);
    this.setLayout(new FlowLayout());
    this.setPreferredSize( new Dimension(100,65) );
    this.setBackground(Colors.background());

    initControlButtons();

    this.add(leftButton);
    this.add(upButton);
    this.add(rightButton);
    this.add(downButton);
  }

  private void initControlButtons(){
    this.upButton = new GameButton("Move Up", "CONTROL");
    this.downButton = new GameButton("Move Down", "CONTROL");
    this.leftButton = new GameButton("Move Left", "CONTROL");
    this.rightButton = new GameButton("Move Right", "CONTROL");

    this.lastActionPressed = new GameButton("","");

    this.upButton.addActionListener(this);
    this.downButton.addActionListener(this);
    this.leftButton.addActionListener(this);
    this.rightButton.addActionListener(this);
  }

  private void showButtonThatItWasPressed(String movement){
    lastActionPressed.pressed();
    switch (movement) {
      case "UP" -> lastActionPressed = upButton;
      case "DOWN" -> lastActionPressed = downButton;
      case "LEFT" -> lastActionPressed = leftButton;
      case "RIGHT" -> lastActionPressed = rightButton;
    }
    lastActionPressed.pressed();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (upButton.equals(source)) {
      this.game.moveUp();
    } else if (downButton.equals(source)) {
      this.game.moveDown();
    } else if (leftButton.equals(source)) {
      this.game.moveLeft();
    } else if (rightButton.equals(source)) {
      this.game.moveRight();
    }
  }

  @Override
  public void onChange(ChangeEvent changeEvent) {
    EventType type = changeEvent.getEvent();
    if ( type == EventType.MOVEMENT ){
      showButtonThatItWasPressed(type.getName());
    }
  }
}
