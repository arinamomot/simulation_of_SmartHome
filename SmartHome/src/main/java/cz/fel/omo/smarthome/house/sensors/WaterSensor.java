package cz.fel.omo.smarthome.house.sensors;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.configurations.History;
import cz.fel.omo.smarthome.entity.devices.items.Device;

/**
 * If sensor active - turn off all devices with water
 */
public class WaterSensor extends Sensor {
	
	
	/**
	 * Instantiates a new Water sensor.
	 *
	 * @param id the id
	 */
	public WaterSensor(Integer id) {
		super(id);
		type = "waterSensor";
	}
	
	@Override
	public void react(Integer timestamp) throws Exception {
		SmartHome.getInstance().addHistory(new History(History.Type.SENSOR, this, "Water Sensor react"));
		for (Device dev : listeners) {
			if (dev.getState().toString().equals("turnOff") || dev.getState().toString().equals("broken")) continue;
			dev.setOff(null, timestamp);
		}
	}
	
	/**
	 * income
	 */
	public void signal() {
		// add to history
	}
	
}
