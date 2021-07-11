package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Kettle.
 */
public class Kettle extends Device {

	public Kettle(int id) {
		super(id);
		type = "Kettle";
		documentation = new Documentation(type);
		documentation.text = "Water and electricity must be turned off before repair.";
		electricity = 30;
		water = 40;
	}
}
