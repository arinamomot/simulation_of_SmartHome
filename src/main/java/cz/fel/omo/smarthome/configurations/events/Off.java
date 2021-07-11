package cz.fel.omo.smarthome.configurations.events;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.entity.devices.iterator.DeviceIterator;

/**
 * The type Off.
 */
public class Off extends Event {
	@Override
	public void execute() throws Exception {
		DeviceIterator iter = SmartHome.getInstance().getHouses().get(0).getDevicesIterator();
		while (iter.hasNext()) {
			Device device = iter.next();
			if (device.getState().toString().equalsIgnoreCase("turnOn") || device.getState().toString().equalsIgnoreCase("idle")) device.setOff(null, timestamp);
		}
	}
}
