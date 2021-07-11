package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Vacuum cleaner.
 */
public class VacuumCleaner extends Device {

	public VacuumCleaner(int id) {
		super(id);
		type = "VacuumCleaner";
		documentation = new Documentation(type);
		documentation.text = "Electricity must be turned off before repair. It is better to contact a specialist.";
		electricity = 80;
	}
}
