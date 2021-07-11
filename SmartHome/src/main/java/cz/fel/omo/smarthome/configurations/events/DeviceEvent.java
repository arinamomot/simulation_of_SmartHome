package cz.fel.omo.smarthome.configurations.events;

/**
 * The type Device event.
 */
public class DeviceEvent extends Event {
	
	@Override
	public void execute() throws Exception {
		switch (action.status) {
			case "turnOn":
				device.setOn(inhabitant, timestamp);
				break;
			case "turnOff":
				device.setOff(inhabitant, timestamp);
				break;
			case "idle":
				device.inUse(inhabitant, timestamp);
				break;
			case "repair":
				device.repair(inhabitant);
				break;
			case "broken":
				device.broke(inhabitant, timestamp);
				break;
		}
	}
}
