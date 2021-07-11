package cz.fel.omo.smarthome.house.window.windowState;

import cz.fel.omo.smarthome.entity.devices.deviceState.IdleState;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.exception.DeviceException;
import cz.fel.omo.smarthome.exception.WindowException;
import cz.fel.omo.smarthome.house.sensors.Sensor;

/**
 * The type Window state.
 */
public class WindowState {
	protected String state;
	public String getState() {
		return state;
	}
	public WindowState() {
	}
	
	/**
	 * Open the window.
	 *
	 * @param living the living
	 * @return the window state
	 * @throws WindowException the window exception
	 */
	public WindowState open(Inhabitant living) throws WindowException {
		return new OpenState();
	}
	
	/**
	 * Close the window.
	 *
	 * @param living the living
	 * @return the window state
	 * @throws WindowException the window exception
	 */
	public WindowState close(Inhabitant living) throws WindowException {
		return new CloseState();
	}
	
	/**
	 * Close the window because of the sensor reaction.
	 *
	 * @param sensor the sensor
	 * @return the window state
	 * @throws WindowException the window exception
	 */
	public WindowState close(Sensor sensor) throws WindowException {
		return new CloseState();
	}
	
	/**
	 * Half open the window.
	 *
	 * @param living the living
	 * @return the window state
	 * @throws WindowException the window exception
	 */
	public WindowState halfOpen(Inhabitant living) throws WindowException{
		return new HalfOpenState();
	}
	
	@Override
	public String toString() {
		return "WindowState{" +
			"state='" + state + '\'' +
			'}';
	}
}
