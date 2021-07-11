package cz.fel.omo.smarthome.configurations.events;

import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.entity.devices.items.Fridge;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.entity.vehicles.Vehicle;
import cz.fel.omo.smarthome.house.sensors.Sensor;
import cz.fel.omo.smarthome.house.window.Window;


/**
 * Strategy design pattern.
 */
public abstract class Event {
	public Action action;
	public Integer order;
	public Inhabitant inhabitant;
	public Device device;
	public Window window;
	public String room;
	public Integer timestamp;
	public Integer sensorId;
	public Sensor sensor;
	public String sensorType;
	public Vehicle vehicle;
	
	public abstract void execute() throws Exception;
	
	public static class Action {
		public String type;
		public String status;
		public String food;
		public Fridge fridge;
		public String action;
	}
}
