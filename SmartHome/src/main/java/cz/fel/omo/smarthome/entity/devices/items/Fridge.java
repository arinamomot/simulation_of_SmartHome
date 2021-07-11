package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.configurations.History;
import cz.fel.omo.smarthome.entity.devices.Documentation;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.house.sensors.Sensor;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Fridge.
 */
public class Fridge extends Device {
	int capacity = 5;

	List<Sensor> sensors = new ArrayList<>();

	List<String> foods = new ArrayList<>();
	

	public Fridge(int id) {
		super(id);
		type = "Fridge";
		documentation = new Documentation(type);
		documentation.text = "Disconnect the fridge from the power supply, clear the ice, fix what is broken, and reconnect the appliance to the power supply.";
		electricity = 40; // Per hour
	}
	
	/**
	 * Add food to the fridge.
	 *
	 * @param inhabitant the inhabitant
	 * @param food       the food
	 */
	public void addFood(Inhabitant inhabitant, String food) {
		if (foods.size() < capacity) {
			foods.add(food);
			SmartHome.getInstance().addHistory(new History(History.Type.FOOD, inhabitant, this, food + " was added from fridge"));
		}
		if (capacity == foods.size()) {
			sensors.forEach(sensor -> sensor.signal(this, inhabitant, "Full fridge"));
		}
	}
	
	/**
	 * Remove food from fridge.
	 *
	 * @param inhabitant the inhabitant
	 * @param food       the food
	 * @throws Exception the exception
	 */
	public void removeFood(Inhabitant inhabitant, String food) throws Exception {
		if (!foods.contains(food)) throw new Exception("Food is not in fridge: " + food);
		foods.remove(food);
		SmartHome.getInstance().addHistory(new History(History.Type.FOOD, inhabitant, this, food + " was taken from fridge"));
	}
}
