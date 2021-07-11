package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Bath.
 */
public class Bath extends Device {
	public Bath(int id) {
		super(id);
		type = "Bath";
		documentation = new Documentation(type);
		documentation.text = "Before repairing, you must turn off the water, unscrew the faucet and shower.";
		water = 150;
	}
}
