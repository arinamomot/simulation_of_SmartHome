package cz.fel.omo.smarthome.entity.devices;

import cz.fel.omo.smarthome.entity.devices.items.*;
import cz.fel.omo.smarthome.exception.CreationException;

/**
 * Factory design pattern.
 */
public class DeviceFactory {
	/**
	 * Make device device.
	 *
	 * @param type the type of device
	 * @param id   the id of device
	 * @return the device
	 * @throws CreationException the creation exception
	 */
	public static Device makeDevice(String type, Integer id) throws CreationException {
		switch (type){
			case "Bath":
				return new Bath(id);
			case "PC":
				return new PC(id);
			case "Cooker":
				return new Cooker(id);
			case "CoffeeMachine":
				return new CoffeeMachine(id);
			case "Dishwasher":
				return new Dishwasher(id);
			case "Fridge":
				return new Fridge(id);
			case "Kettle":
				return new Kettle(id);
			case "Microwave":
				return new Microwave(id);
			case "MusicCenter":
				return new MusicCenter(id);
			case "Oven":
				return new Oven(id);
			case "Telephone":
				return new Telephone(id);
			case "Toy":
				return new Toy(id);
			case "TV":
				return new TV(id);
			case "VacuumCleaner":
				return new VacuumCleaner(id);
			case "WashingMachine":
				return new WashingMachine(id);
			case "Boller":
				return new Boller(id);
			case "Grill":
				return new Grill(id);
			default:
				throw new CreationException("Device creation error: " + type);
		}
	}
}
