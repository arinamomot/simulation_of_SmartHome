package cz.fel.omo.smarthome.house.window;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.configurations.Gson;
import cz.fel.omo.smarthome.configurations.History;
import cz.fel.omo.smarthome.entity.devices.deviceState.DeviceState;
import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.house.Room;
import cz.fel.omo.smarthome.house.lights.Light;
import cz.fel.omo.smarthome.house.sensors.Sensor;
import cz.fel.omo.smarthome.house.window.windowState.CloseState;
import cz.fel.omo.smarthome.house.window.windowState.WindowState;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Window.
 */
public class Window {
	protected WindowState windowState;
	protected Integer id;
	
	public Window(Room room, Integer id) {
		windowState = new CloseState();
		this.room = room;
		this.id = id;
	}
	
	
	public void setLocation(Room room) {
		this.room = room;
	}
	
	private transient Room room;
	
	public Room getLocation() {
		return room;
	}
	
	public WindowState getWindowState() {
		return windowState;
	}
	
	public Window clone() {
		return Gson.fromJson(Gson.toJson(this), this);
	}
	
	/**
	 * The Sensor list.
	 */
	protected transient Set<Sensor> sensorList = new HashSet<>();
	
	/**
	 * Connect sensor with windows.
	 *
	 * @param sensor the sensor
	 */
	public void connectSensor(Sensor sensor) {
		sensorList.add(sensor);
	}
	
	/**
	 * Open the window.
	 *
	 * @param inhabitant the inhabitant
	 * @throws Exception the exception
	 */
	public void open(Inhabitant inhabitant) throws Exception {
		windowState = windowState.open(inhabitant);
		SmartHome.getInstance().addHistory(new History(History.Type.WINDOW, inhabitant, this, windowState.toString()));
	}
	
	/**
	 * Close the window.
	 *
	 * @param sensor the sensor
	 * @throws Exception the exception
	 */
	public void close(Sensor sensor) throws Exception {
		windowState = windowState.close(sensor);
		SmartHome.getInstance().addHistory(new History(History.Type.WINDOW, sensor, this, windowState.toString()));
	}
	
	/**
	 * Close window because of sensor reaction.
	 *
	 * @param inhabitant the inhabitant
	 * @throws Exception the exception
	 */
	public void close(Inhabitant inhabitant) throws Exception {
		windowState = windowState.close(inhabitant);
		SmartHome.getInstance().addHistory(new History(History.Type.WINDOW, inhabitant, this, windowState.toString()));
	}
	
	/**
	 * Half open the window.
	 *
	 * @param inhabitant the inhabitant
	 * @throws Exception the exception
	 */
	public void halfOpen(Inhabitant inhabitant) throws Exception {
		windowState = windowState.halfOpen(inhabitant);
		SmartHome.getInstance().addHistory(new History(History.Type.WINDOW, inhabitant, this, windowState.toString()));
	}
	
	@Override
	public String toString() {
		return "Window{" +
			"id=" + id +
			'}';
	}
}
