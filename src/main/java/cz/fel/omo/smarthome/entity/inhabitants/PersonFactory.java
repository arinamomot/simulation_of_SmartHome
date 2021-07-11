package cz.fel.omo.smarthome.entity.inhabitants;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.entity.inhabitants.person.*;
import cz.fel.omo.smarthome.exception.CreationException;

/**
 * The type Person factory.
 * Factory design pattern
 */
public class PersonFactory {
	/**
	 * Make person.
	 *
	 * @param type the type of person
	 * @param id   the id
	 * @param name the name
	 * @return the person
	 * @throws CreationException the creation exception
	 */
	public static Person makePerson(String type, Integer id, String name) throws CreationException {
		id = SmartHome.getId();
		switch (type){
			case "Father":
				return new Father(id, name);
			case "Mother":
				return new Mother(id, name);
			case "GrandFather":
				return new GrandFather(id, name);
			case "GrandMother":
				return new GrandMother(id, name);
			case "Son":
				return new Son(id, name);
			case "Daughter":
				return new Daughter(id, name);
			case "Baby":
				return new Baby(id, name);
			default:
				throw new CreationException("Person creation error");
		}
	}
}
