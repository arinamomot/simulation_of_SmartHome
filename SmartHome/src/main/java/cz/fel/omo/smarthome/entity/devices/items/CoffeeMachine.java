package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.entity.devices.Documentation;

/**
 * The type Coffee machine.
 */
public class CoffeeMachine extends Device {
	public CoffeeMachine(int id) {
		super(id);
		type = "CoffeeMachine";
		documentation = new Documentation(type);
		documentation.text = "Water and electricity must be turned off before repair.";
		electricity = 30;
		water = 10;
	}
}
