package cz.fel.omo.smarthome.configurations.events;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.configurations.History;
import cz.fel.omo.smarthome.entity.inhabitants.PersonFactory;
import cz.fel.omo.smarthome.entity.inhabitants.person.Person;
import cz.fel.omo.smarthome.entity.inhabitants.pet.Pet;
import cz.fel.omo.smarthome.house.Room;


/**
 * The type Inhabitant event.
 */
public class InhabitantEvent extends Event {
	
	@Override
	public void execute() throws Exception {
		Room newRoom = SmartHome.getInstance().getRoom(room);
		if (newRoom == null) throw new Exception("Room does not exists");
		if (newRoom.getPersons().contains((Person) inhabitant)) {
			throw new Exception("Inhabitant already in this room");
		}
//		if(inhabitant.getClass() == Person.class) {
		
		newRoom.addPerson(PersonFactory.makePerson(inhabitant.getType(), 0, inhabitant.getName()));
		SmartHome.getInstance().removeInhabitant(inhabitant);
		SmartHome.getInstance().addHistory(new History(History.Type.ACTIVITY, inhabitant, newRoom));
//		}
	}
}
