package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.configurations.History;
import cz.fel.omo.smarthome.entity.devices.Documentation;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;

/**
 * The type Cooker.
 */
public class Cooker extends Device {
	public Cooker(int id) {
		super(id);
		type = "Cooker";
		documentation = new Documentation(type);
		documentation.text = "Gas must be turned off before repair. It is better to contact a specialist.";
		gas = 100;
	}
}
