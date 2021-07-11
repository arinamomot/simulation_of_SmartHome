package cz.fel.omo.smarthome.configurations.events;

/**
 * The type Vehicle event.
 */
public class VehicleEvent extends Event {
	@Override
	public void execute() throws Exception{
		switch (action.status) {
			case "turnOff":
				vehicle.setOff(inhabitant, timestamp);
				break;
			case "idle":
				vehicle.setOn(inhabitant, timestamp);
				vehicle.inUse(inhabitant, timestamp);
				break;
			case "broken":
				vehicle.broke(inhabitant, timestamp);
				break;
		}
	}
}
