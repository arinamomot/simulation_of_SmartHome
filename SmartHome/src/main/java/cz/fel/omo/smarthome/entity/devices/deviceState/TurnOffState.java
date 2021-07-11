package cz.fel.omo.smarthome.entity.devices.deviceState;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.configurations.History;
import cz.fel.omo.smarthome.exception.DeviceException;

/**
 * The type Turn off state.
 */
public class TurnOffState extends DeviceState {

	public TurnOffState() {
		state = "turnOff";
	}
	
	@Override
	public DeviceState turnOn(Inhabitant living) throws DeviceException {
		if (!state.equals("turnOff")) throw new DeviceException("Device is not turned off");
		return new TurnOnState();
	}
	
	@Override
	public DeviceState turnOff(Inhabitant living) throws DeviceException {
		throw new DeviceException("Device is already turned off");
	}
	
	@Override
	public DeviceState broken(Inhabitant living) throws DeviceException {
		return new BrokenState();
	}
	
	
	@Override
	public DeviceState idle(Inhabitant living) throws DeviceException {
		throw new DeviceException("Device is not turned on");
	}

	
}
//
//	@Override
//	public void turnOn(Inhabitant living) throws Exception {
//
//	}
//
//	@Override
//	public void turnOff(Inhabitant living) throws Exception {
//		switch (state) {
//			case "idle":
//				throw new DeviceException(device.getName() + " is currently in use");
//			case "broken":
//				throw new DeviceException(device.getName() + "is broken");
//			case "turnOff":
//				throw new DeviceException(device.getName() + "is already off");
//		}
//
//		this.state = "turnOff";
//		this.history.add(new History(living, device, state));
//	}
//
//	@Override
//	public void broken(Inhabitant living) {
//
//	}
//}
