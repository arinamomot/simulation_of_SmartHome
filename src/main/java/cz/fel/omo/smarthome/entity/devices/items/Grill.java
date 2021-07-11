package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Grill.
 */
public class Grill extends Device {

	public Grill(int id) {
		super(id);
		type = "Grill";
		documentation = new Documentation(type);
		documentation.text = "Gas must be turned off before repair. It is better to contact a specialist.";
		gas = 100;
	}
}
