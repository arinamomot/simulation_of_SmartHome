package cz.fel.omo.smarthome.house.window.windowState;

import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.exception.DeviceException;
import cz.fel.omo.smarthome.exception.WindowException;
import cz.fel.omo.smarthome.house.sensors.Sensor;

/**
 * The type Open state.
 */
public class OpenState extends WindowState{
	public OpenState() {
		state = "open";
	}
	
	@Override
	public WindowState open(Inhabitant living) throws WindowException {
		throw new WindowException("Window is already open");
	}
	
	@Override
	public WindowState close(Inhabitant living) throws WindowException {
		return new CloseState();
	}
	
	@Override
	public WindowState close(Sensor sensor) throws WindowException {
		return new CloseState();
	}
	
	@Override
	public WindowState halfOpen(Inhabitant living) throws WindowException {
		return new HalfOpenState();
	}
}
