package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Microwave.
 */
public class Microwave extends Device{

	public Microwave(int id) {
		super(id);
		type = "Microwave";
		documentation = new Documentation(type);
		documentation.text = "Electricity must be turned off before repair. It is better to contact a specialist.";
		electricity = 50;
	}
}
