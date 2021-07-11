package cz.fel.omo.smarthome.entity.devices.deviceState;

import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.exception.DeviceException;

/**
 * The type Idle state.
 */
public class IdleState extends DeviceState {
	
	public IdleState() {
		state = "idle";
	}
	
	public DeviceState turnOff(Inhabitant living) throws DeviceException {
		return new TurnOffState();
	}
	
	@Override
	public DeviceState broken(Inhabitant living) throws DeviceException {
		return new BrokenState();
	}
	
	@Override
	public DeviceState idle(Inhabitant living) throws DeviceException {
		throw new DeviceException("Already in use");
	}
	
	@Override
	public DeviceState turnOn(Inhabitant living) throws DeviceException {
		throw new DeviceException("Already in use");
	}
}
