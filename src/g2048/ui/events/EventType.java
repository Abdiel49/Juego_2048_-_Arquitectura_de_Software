package g2048.ui.events;

public enum EventType {
  WIN ("You Win"),
  LOST ("You Lost"),
  BOARD_CHANGE ("Board Changed"),
  END_GAME ("Bye Bye"),
  MOVEMENT ("");

  private String eventKey;
  EventType (String eventKey){
    this.eventKey = eventKey;
  }
  public void setName(String eventKey){
    this.eventKey = eventKey;
  }
  public String getName() {
    return this.eventKey;
  }
}