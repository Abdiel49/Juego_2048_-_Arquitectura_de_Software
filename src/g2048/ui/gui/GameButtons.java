package g2048.ui.gui;

import javax.swing.JButton;
import java.awt.*;

public class GameButtons extends JButton {

  private boolean wasPressed;

  public GameButtons (String text, String type){
    setDafaultConfig(text);
    switch ( type){
      case "CONTROL" -> this.setBackground(Colors.repose());
      case "ALERT" -> {
        this.setBackground(Colors.alert());
        this.setForeground(Color.black);
      }
    }
  }

  private void setDafaultConfig(String text){
    this.setText(text);
    this.wasPressed = false;
    this.setFocusable(false);
    this.setForeground(Colors.textPrimary());
  }

  public void pressed(){
    if (wasPressed) {
      this.setBackground(Colors.repose());
    } else {
      this.setBackground(Colors.action());
    }
    this.wasPressed = !this.wasPressed;
  }

}
