package cz.fel.omo.smarthome.house.window.windowState;

import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.exception.WindowException;
import cz.fel.omo.smarthome.house.sensors.Sensor;

/**
 * The type Half open state.
 */
public class HalfOpenState extends WindowState{
	public HalfOpenState() {
		state = "halfOpen";
	}
	
	@Override
	public WindowState open(Inhabitant living) throws WindowException {
		return new OpenState();
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
		throw new WindowException("Window is already half open");
	}
}
