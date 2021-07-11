package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Oven.
 */
public class Oven extends Device {

	public Oven(int id) {
		super(id);
		type = "Oven";
		documentation = new Documentation(type);
		documentation.text = "Gas must be turned off before repair. It is better to contact a specialist.";
		gas = 100;
	}
}
