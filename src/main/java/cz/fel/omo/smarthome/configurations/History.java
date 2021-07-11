package cz.fel.omo.smarthome.configurations;

import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.house.Room;
import cz.fel.omo.smarthome.house.sensors.Sensor;
import cz.fel.omo.smarthome.house.window.Window;

import java.util.Date;

/**
 * The History.
 */
public class History {
	public Type type;
	public Inhabitant inhabitant;
	public Sensor sensor;
	public Device device;
	public Window window;
	public Date when;
	public String room;
	public String state;
	public enum Type {
		FOOD,
		DEVICE,
		ACTIVITY,
		SENSOR,
		LIGHT,
		EVENT,
		VEHICLE,
		WINDOW
	}
	
	/**
	 * Instantiates a new History.
	 *
	 * @param type       the type of history
	 * @param inhabitant the inhabitant
	 * @param room       the room
	 */
	public History(Type type, Inhabitant inhabitant, Room room) {
		this.inhabitant = inhabitant;
		this.when = new Date();
		this.room = room.getRoom();
		this.type = type;
	}
	
	/**
	 * Instantiates a new History.
	 *
	 * @param type       the type  of history
	 * @param inhabitant the inhabitant
	 * @param device     the device
	 * @param message    the message
	 */
	public History(Type type, Inhabitant inhabitant, Device device, String message) {
		this.inhabitant = inhabitant;
		if (device != null) this.device = device.clone();
		this.when = new Date();
		this.state = message;
		this.type = type;
	}
	
	/**
	 * Instantiates a new History.
	 *
	 * @param type    the type  of history
	 * @param device  the device
	 * @param message the message
	 */
	public History(Type type, Device device, String message) {
		if (device != null) this.device = device.clone();
		this.when = new Date();
		this.state = message;
		this.type = type;
	}
	
	/**
	 * Instantiates a new History.
	 *
	 * @param type       the type  of history
	 * @param inhabitant the inhabitant
	 * @param device     the device
	 * @param room       the room
	 * @param state      the state
	 */
	public History(Type type, Inhabitant inhabitant, Device device, String room, String state) {
		this.inhabitant = inhabitant;
		if (device != null) this.device = device.clone();
		this.room = room;
		this.when = new Date();
		this.state = state;
		this.type = type;
	}
	
	/**
	 * Instantiates a new History.
	 *
	 * @param type       the type  of history
	 * @param inhabitant the inhabitant
	 * @param window     the window
	 * @param state      the state
	 */
	public History(Type type, Inhabitant inhabitant, Window window, String state) {
		this.inhabitant = inhabitant;
		if (window != null) {
			this.window = window.clone();
			this.room = window.getLocation().getRoom();
		}
		this.when = new Date();
		this.state = state;
		this.type = type;
	}
	
	/**
	 * Instantiates a new History.
	 *
	 * @param type   the type  of history
	 * @param sensor the sensor
	 * @param window the window
	 * @param state  the state
	 */
	public History(Type type, Sensor sensor, Window window, String state) {
		this.sensor = sensor;
		if (window != null) this.window = window.clone();
		this.room = sensor.getLocation().getRoom();
		this.when = new Date();
		this.state = state;
		this.type = type;
	}
	
	/**
	 * Instantiates a new History.
	 *
	 * @param type       the type  of history
	 * @param inhabitant the inhabitant
	 * @param device     the device
	 */
	public History(Type type, Inhabitant inhabitant, Device device) {
		this.inhabitant = inhabitant;
		this.device = device.clone();
		this.when = new Date();
		this.type = type;
	}
	
	/**
	 * Instantiates a new History.
	 *
	 * @param type    the type  of history
	 * @param sensor  the sensor
	 * @param message the message
	 */
	public History(Type type, Sensor sensor, String message) {
		this.sensor = sensor.clone();
		this.room = sensor.getLocation().getRoom();
		this.when = new Date();
		this.type = type;
		state = message;
	}
	
	public String toString() {
		return "Device{" +
			"inhabitant= " + inhabitant +
			", device= " + device +
			", when= " + when +
			", state= '" + state + '\'' +
			'}';
	}
	
	/**
	 * To string activity string.
	 *
	 * @return the string
	 */
	public String toStringActivity() {
		return "Activity{" +
			"inhabitant= " + inhabitant +
			", room= " + room +
			", when= " + when + '\'' +
			'}';
	}
	
	/**
	 * To string window string.
	 *
	 * @return the string
	 */
	public String toStringWindow() {
		return "Window{" +
			"inhabitant= " + inhabitant +
			", window= " + window +
			", when= " + when +
			", state= '" + state + '\'' +
			'}';
	}
	
	/**
	 * To string window 2 string.
	 *
	 * @return the string
	 */
	public String toStringWindow2() {
		return "History{" +
			"sensor= " + sensor +
			", window= " + window +
			", room= " + room +
			", when= " + when +
			", state= '" + state + '\'' +
			'}';
	}
	
	/**
	 * To string vehicle string.
	 *
	 * @return the string
	 */
	public String toStringVehicle() {
		return "Vehicle{" +
			"inhabitant= " + inhabitant +
			", vehicle= " + device +
			", when= " + when +
			", state= '" + state + '\'' +
			'}';
	}
	
	/**
	 * To string fridge string.
	 *
	 * @return the string
	 */
	public String toStringFridge() {
		return "Fridge{" +
			"inhabitant= " + inhabitant +
			", when= " + when +
			", state= '" + state + '\'' +
			'}';
	}
	
	/**
	 * To string event string.
	 *
	 * @return the string
	 */
	public String toStringEvent() {
		return "Event{" +
			"device= " + device +
			", when= " + when +
			", state= '" + state + '\'' +
			'}';
	}
	
	/**
	 * To string sensor string.
	 *
	 * @return the string
	 */
	public String toStringSensor() {
		return "Sensor{" +
			"sensor= " + sensor.getType() +
			", room= " + room +
			", when= " + when + '\'' +
			'}';
	}
	
	/**
	 * To string light string.
	 *
	 * @return the string
	 */
	public String toStringLight() {
		return "Light{" +
			"inhabitant= " + inhabitant +
			", light= " + device +
			", room= " + room +
			", when= " + when +
			", state= '" + device.getState() + '\'' +
			'}';
	}
}
