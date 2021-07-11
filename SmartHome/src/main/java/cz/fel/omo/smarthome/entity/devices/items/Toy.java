package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.entity.devices.Documentation;
import cz.fel.omo.smarthome.entity.devices.deviceState.TurnOffState;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.entity.inhabitants.person.GrandMother;
import cz.fel.omo.smarthome.entity.inhabitants.person.Mother;
import cz.fel.omo.smarthome.entity.inhabitants.person.Person;
import cz.fel.omo.smarthome.exception.DeviceException;

/**
 * The type Toy.
 */
public class Toy extends Device {
	public Toy(int id) {
		super(id);
		type = "Toy";
		documentation = new Documentation(type);
		documentation.text = "Use a thread and needle to sew up the toy.";
	}
	
	@Override
	public void repair(Inhabitant person) throws DeviceException {
		if (person.getClass() == Mother.class || person.getClass() == GrandMother.class) {
			this.state = new TurnOffState();
		} else {
			throw new DeviceException("You cant repair device");
		}
	}
}

