package g2048.ui.events;

import java.util.EventListener;

public interface ChangeEventListener extends  EventListener {
  void onChange( ChangeEvent event );
}
