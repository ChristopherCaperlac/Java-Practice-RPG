package Main;

import java.util.ArrayList;
import java.util.HashMap;

import Rooms.Room;

public class Location {
  private HashMap<Room, ArrayList<Room>> adjRoom;
  private Room entranceRoom;
  private Room currRoom;
  private Room exitRoom;
  private String dialogue;

  public Location() {
    adjRoom = new HashMap<Room, ArrayList<Room>>();
    entranceRoom = null;
    currRoom = null;
    exitRoom = null;
  }

  public void start() {
    printDialogue();
    currRoom = entranceRoom;
    while (currRoom != exitRoom) {
      Main.sleep();
      currRoom.start();
      getMovementInput();
    }
    System.out.println("You exit and go out");
    System.out.println("");
    Main.sleep();
    // TODO implement overworld traversal
    // throw new UnsupportedOperationException("overworld traversal is not
    // implemented yet");
  }

  private void getMovementInput() {
    System.out.println("Where should you go next?");
    int input = 0;
    for (int i = 1; i < getAdjRooms(currRoom).size() + 1; i++) {
      System.out.println("[" + i + "] " + getAdjRooms(currRoom).get(i - 1));
    }
    while (input < 1 || input > getAdjRooms(currRoom).size()) {
      input = Main.getScnr().nextInt();
      Main.getScnr().nextLine();
    }
    currRoom = getAdjRooms(currRoom).get(input - 1);
    System.out.println("");
  }

  public void addRoom(Room room) {
    adjRoom.putIfAbsent(room, new ArrayList<Room>());
  }

  public void removeRoom(Room room) {
    adjRoom.remove(room);
  }

  public void addHall(Room room1, Room room2) {
    adjRoom.get(room1).add(room2);
    adjRoom.get(room2).add(room1);
  }

  public void removeHall(Room room1, Room room2) {
    adjRoom.get(room1).remove(room2);
    adjRoom.get(room2).remove(room1);
  }

  public void addHall(Room room1, Room room2, boolean Isbidirection) {
    adjRoom.get(room1).add(room2);
    if (Isbidirection) {
      adjRoom.get(room2).add(room1);
    }
  }

  public void removeHall(Room room1, Room room2, boolean Isbidirection) {
    adjRoom.get(room1).remove(room2);
    if (Isbidirection) {
      adjRoom.get(room2).remove(room1);
    }
  }

  public ArrayList<Room> getAdjRooms(Room room) {
    return adjRoom.get(room);
  }

  public void setEntrance(Room entranceRoom) {
    this.entranceRoom = entranceRoom;
  }

  /**
   * @param room
   *             makes room points to a dummy exitRoom
   */
  public void setExit(Room room) {
    Room exitRoom = new Room();
    this.exitRoom = exitRoom;
    adjRoom.get(room).add(0, exitRoom);
  }

  private void printDialogue() {
    System.out.println(this.dialogue);
    System.out.println("");
    Main.sleep();
  }

  public void setDialogue(String dialogue) {
    this.dialogue = dialogue;
  }
}
