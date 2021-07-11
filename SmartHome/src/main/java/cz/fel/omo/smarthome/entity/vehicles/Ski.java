package cz.fel.omo.smarthome.entity.vehicles;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Ski.
 */
public class Ski extends Vehicle {
	public Ski(int id) {
		super(id);
		type = "Ski";
		documentation = new Documentation(type);
	}
}
