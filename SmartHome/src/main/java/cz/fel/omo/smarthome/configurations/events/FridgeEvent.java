package cz.fel.omo.smarthome.configurations.events;

/**
 * The type Fridge event.
 */
public class FridgeEvent extends Event {
	@Override
	public void execute() throws Exception {
		if(action.action.equalsIgnoreCase("take")) {
			action.fridge.removeFood(inhabitant, action.food);
		}else if(action.action.equalsIgnoreCase("put")) {
			action.fridge.addFood(inhabitant, action.food);
		} else {
			throw new Exception("Unknown command: " + action.action);
		}
		
	}
}
