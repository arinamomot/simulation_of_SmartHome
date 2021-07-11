package cz.fel.omo.smarthome.house.sensors;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.configurations.History;
import cz.fel.omo.smarthome.entity.devices.items.Device;

/**
 * if sensor active - all electronic devices will turn off
 */
public class FireSensor extends Sensor {
	public FireSensor(Integer id) {
		super(id);
		type = "fireSensor";
	}
	
	@Override
	public void react(Integer timestamp) throws Exception {
		SmartHome.getInstance().addHistory(new History(History.Type.SENSOR, this, "Fire Sensor react"));
		for (Device dev : listeners) {
			if (dev.getState().toString().equals("turnOff") || dev.getState().toString().equals("broken")) continue;
			dev.setOff(null, timestamp);
		}
	}
}
