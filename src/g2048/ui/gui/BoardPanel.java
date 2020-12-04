package g2048.ui.gui;

import javax.swing.JPanel;
import java.awt.*;

public class BoardPanel extends JPanel {

  public BoardPanel () {
    this.setLayout( new GridLayout(4,4,3,3) );
    this.setPreferredSize( new Dimension(400,400) );
    this.setBackground(Colors.background());
  }
}
