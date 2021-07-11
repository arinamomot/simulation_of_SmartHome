package cz.fel.omo.smarthome.house.sensors;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.configurations.Gson;
import cz.fel.omo.smarthome.configurations.History;
import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.house.Room;
import cz.fel.omo.smarthome.house.window.Window;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Sensor.
 * Observer and Listener design patters
 */
public class Sensor {
	private Integer id;
	
	public void setLocation(Room room) {
		this.room = room;
	}
	private transient Room room;
	public Room getLocation() {
		return room;
	}
	public String getType() {
		return type;
	}
	protected String type;
	protected Integer time;
	public Integer getId() {
		return id;
	}
	public Sensor(Integer id) {
		this.id = id;
	}
	
	public Sensor clone() {
		return Gson.fromJson(Gson.toJson(this), this);
	}
	
	/**
	 * The Listeners.
	 */
	transient List<Device> listeners = new ArrayList<>();
	
	/**
	 * Add device to listeners.
	 *
	 * @param device the device
	 */
	public void addDevice(Device device) {
		listeners.add(device);
	}
	transient Set<Window> windows = new HashSet<>();
	public void addWindow(Window window) {
		windows.add(window);
	}
	
	/**
	 * React on the event.
	 *
	 * @param timestamp the timestamp
	 * @throws Exception the exception
	 */
	public void react(Integer timestamp) throws Exception {}
	
	/**
	 * Signal.
	 *
	 * @param device     the device
	 * @param inhabitant the inhabitant
	 * @param message    the message
	 */
	public void signal(Device device, Inhabitant inhabitant, String message) {
		if(device.getType().equals("Fridge")) {
			SmartHome.getInstance().addHistory(new History(History.Type.FOOD, inhabitant, device, message ));
		}
	}
}
