package cz.fel.omo.smarthome.configurations.events;

/**
 * The type Light event.
 */
public class LightEvent extends Event {
	@Override
	public void execute() throws Exception{
		switch (action.status) {
			case "turnOn":
				device.setOn(inhabitant, timestamp);
				break;
			case "turnOff":
				device.setOff(inhabitant, timestamp);
				break;
			case "broken":
				device.broke(inhabitant, timestamp);
				break;
		}
	}
}
