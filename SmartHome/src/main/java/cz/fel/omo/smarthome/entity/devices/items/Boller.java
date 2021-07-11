package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Boller.
 */
public class Boller extends Device {
	
	public Boller(int id) {
		super(id);
		type = "Boller";
		documentation = new Documentation(type);
		documentation.text = "Water and electricity must be turned off before repair. It is better to contact a specialist.";
		electricity = 100;
		water = 60;
	}
}
