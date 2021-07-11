package cz.fel.omo.smarthome.entity.vehicles;

import cz.fel.omo.smarthome.entity.inhabitants.pet.Cat;
import cz.fel.omo.smarthome.entity.inhabitants.pet.Dog;
import cz.fel.omo.smarthome.entity.inhabitants.pet.Parrot;
import cz.fel.omo.smarthome.entity.inhabitants.pet.Pet;
import cz.fel.omo.smarthome.exception.CreationException;

/**
 * The type Vehicle factory.
 */
public class VehicleFactory {
	/**
	 * Make vehicle vehicle.
	 *
	 * @param type the type of vehicle
	 * @param id   the id
	 * @return the vehicle
	 * @throws CreationException the creation exception
	 */
	public static Vehicle makeVehicle(String type, Integer id) throws CreationException {
		switch (type){
			case "Ski":
				return new Ski(id);
			case "Car":
				return new Car(id);
			case "Bicycle":
				return new Bicycle(id);
			default:
				throw new CreationException("Vehicle creation error");
		}
	}
}
