package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Tv.
 */
public class TV extends Device {

	public TV(int id) {
		super(id);
		type = "TV";
		documentation = new Documentation(type);
		documentation.text = "Electricity must be turned off before repair. It is better to contact a specialist.";
		electricity = 100;
	}
}
