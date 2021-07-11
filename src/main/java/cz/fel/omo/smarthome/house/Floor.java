package cz.fel.omo.smarthome.house;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Floor.
 */
public class Floor {
    private int floor;
    private List<Room> rooms = new ArrayList<Room>();
    
	public Floor(int floor) {
        this.floor = floor;
    }
	public int getFloor() {
        return floor;
    }
	public List<Room> getRooms() {
        return rooms;
    }
	public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
	public void addRoom(Room room){
        this.rooms.add(room);
    }
}
