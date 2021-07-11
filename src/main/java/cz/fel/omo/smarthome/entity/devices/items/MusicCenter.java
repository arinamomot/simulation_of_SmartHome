package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Music center.
 */
public class MusicCenter extends Device {

	public MusicCenter(int id) {
		super(id);
		type = "MusicCenter";
		documentation = new Documentation(type);
		documentation.text = "Electricity must be turned off before repair.";
		electricity = 50;
	}
}
