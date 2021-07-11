package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Dishwasher.
 */
public class Dishwasher extends Device {

	public Dishwasher(int id) {
		super(id);
		type = "Dishwasher";
		documentation = new Documentation(type);
		documentation.text = "Water and electricity must be turned off before repair.";
		electricity = 60;
		water = 60;
	}
}
