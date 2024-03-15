package Main;

import java.util.ArrayList;

import Characters.Skeleton;
import Characters.SkeletonMage;
import Characters.Slime;
import Rooms.Room;

public class Overworld {
  private static ArrayList<Location> locations;

  public static void loadLocations() {
    locations = new ArrayList<Location>();
    locations.add(loadStarterCave());
    locations.add(loadElswood());
    locations.add(loadForest());
  }

  private static Location loadStarterCave() {
    Location cave = new Location();
    cave.setDialogue("You wake up inside a cave, and you try to find a way out.");
    Room caveRoom_1 = new Room(1);
    caveRoom_1.addOccupants(new Skeleton(1));
    Room caveRoom_2 = new Room(1);
    caveRoom_2.addOccupants(new Skeleton(1));
    Room caveRoom_3 = new Room(1);
    caveRoom_3.addOccupants(new Skeleton(2));
    cave.addRoom(caveRoom_1);
    cave.addRoom(caveRoom_2);
    cave.addRoom(caveRoom_3);
    cave.addHall(caveRoom_1, caveRoom_2, false);
    cave.addHall(caveRoom_2, caveRoom_3, false);
    cave.setEntrance(caveRoom_1);
    cave.setExit(caveRoom_3);
    return cave;
  }

  private static Location loadElswood() {
    Location village = new Location();
    village.setDialogue("You arrive at the village of Elswood");
    Room shopRoom = new Room(0);
    village.addRoom(shopRoom);
    village.setEntrance(shopRoom);
    village.setExit(shopRoom);
    return village;
  }

  private static Location loadForest() {
    Location forest = new Location();
    forest.setDialogue("You find yourself at the forest of Elswood");
    Room forestRoom_1 = new Room(1);
    forestRoom_1.addOccupants(new Slime(1));
    forestRoom_1.addOccupants(new Slime(2));
    Room forestRoom_2 = new Room(1);
    forestRoom_2.addOccupants(new Skeleton(2));
    Room forestRoom_3 = new Room(1);
    forestRoom_3.addOccupants(new Slime(2));
    Room forestRoom_4 = new Room(1);
    forestRoom_4.addOccupants(new SkeletonMage(2));
    forest.addRoom(forestRoom_1);
    forest.addRoom(forestRoom_2);
    forest.addRoom(forestRoom_3);
    forest.addRoom(forestRoom_4);
    forest.addHall(forestRoom_1, forestRoom_2, false);
    forest.addHall(forestRoom_1, forestRoom_3, false);
    forest.addHall(forestRoom_2, forestRoom_4, false);
    forest.addHall(forestRoom_3, forestRoom_4, false);
    forest.setEntrance(forestRoom_1);
    forest.setExit(forestRoom_4);
    return forest;
  }

  public static Location getLocation(int index) {
    return locations.get(index);
  }
}
