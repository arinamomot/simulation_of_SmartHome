package cz.fel.omo.smarthome.house.sensors;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.configurations.History;
import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.house.window.Window;

/**
 * if sensor active - close all windows
 */
public class WindSensor extends Sensor {
	public WindSensor(Integer id) {
		super(id);
		type = "windSensor";
	}
	
	@Override
	public void react(Integer timestamp) throws Exception {
		SmartHome.getInstance().addHistory(new History(History.Type.SENSOR, this, "Wind Sensor react"));
		for (Window window : windows) {
			if (window.getWindowState().getState().equals("close")) continue;
			window.close(this);
		}
	}
}
