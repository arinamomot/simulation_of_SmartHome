package cz.fel.omo.smarthome.entity.vehicles;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Bicycle.
 */
public class Bicycle extends Vehicle{
	public Bicycle(int id) {
		super(id);
		type = "Bicycle";
		documentation = new Documentation(type);
	}
}
