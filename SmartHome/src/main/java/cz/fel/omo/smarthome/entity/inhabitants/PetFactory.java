package cz.fel.omo.smarthome.entity.inhabitants;

import cz.fel.omo.smarthome.entity.inhabitants.pet.Cat;
import cz.fel.omo.smarthome.entity.inhabitants.pet.Dog;
import cz.fel.omo.smarthome.entity.inhabitants.pet.Parrot;
import cz.fel.omo.smarthome.entity.inhabitants.pet.Pet;
import cz.fel.omo.smarthome.exception.CreationException;

/**
 * The type Pet factory.
 * Factory design pattern
 */
public class PetFactory {
	/**
	 * Make pet.
	 *
	 * @param type the type of pet
	 * @param id   the id
	 * @param name the name
	 * @return the pet
	 * @throws CreationException the creation exception
	 */
	public static Pet makePet(String type, Integer id, String name) throws CreationException {
		switch (type){
			case "Cat":
				return new Cat(id, name);
			case "Dog":
				return new Dog(id, name);
			case "Parrot":
				return new Parrot(id, name);
			default:
				throw new CreationException("Pet creation error");
		}
	}
}
