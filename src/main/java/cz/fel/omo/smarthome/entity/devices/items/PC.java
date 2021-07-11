package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Pc.
 */
public class PC extends Device {

	public PC(int id) {
        super(id);
        type = "PC";
        documentation = new Documentation(type);
        documentation.text = "Electricity must be turned off before repair. It is better to contact a specialist.";
        electricity = 70;
    }
}
