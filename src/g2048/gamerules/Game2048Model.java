package g2048.gamerules;

import g2048.ui.events.ChangeEventListener;
import g2048.ui.events.EventType;

public interface Game2048Model {

  void addEventListener(ChangeEventListener listenerUI2048);

  void triggerEvent(EventType eventType);
}
