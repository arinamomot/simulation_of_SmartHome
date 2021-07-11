package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Telephone.
 */
public class Telephone extends Device {

	public Telephone(int id) {
		super(id);
		type = "Telephone";
		documentation = new Documentation(type);
		documentation.text = "Electricity must be turned off before repair.";
		electricity = 30;
	}

}
