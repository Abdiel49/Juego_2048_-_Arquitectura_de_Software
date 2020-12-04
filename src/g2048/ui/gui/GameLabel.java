package g2048.ui.gui;

import javax.swing.JLabel;
import java.awt.*;

public class GameLabel extends JLabel {

  public GameLabel (String text) {
    this.setText(text);
    setDefaultConfig();
  }

  private void setDefaultConfig(){
    this.setFont( new Font("Sans Bold", Font.PLAIN, 24));
    this.setForeground(Colors.textPrimary());
  }
}
