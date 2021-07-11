package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Washing machine.
 */
public class WashingMachine extends Device {

	public WashingMachine(int id) {
		super(id);
		type = "WashingMachine";
		documentation = new Documentation(type);
		documentation.text = "Water and electricity must be turned off before repair.";
		electricity = 70;
		water = 70;
	}
}
