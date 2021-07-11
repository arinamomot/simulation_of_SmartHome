package cz.fel.omo.smarthome.report;

import cz.fel.omo.smarthome.configurations.Gson;
import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.entity.inhabitants.person.Person;
import cz.fel.omo.smarthome.house.Floor;
import cz.fel.omo.smarthome.house.House;
import cz.fel.omo.smarthome.house.Room;

/**
 * The type House configuration report.
 */
public class HouseConfigurationReport {
	private House house;
	
	public HouseConfigurationReport(House house) {
		this.house = house;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(Gson.toJson(house));
		return string.toString();
	}
}
