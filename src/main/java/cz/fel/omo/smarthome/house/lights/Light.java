package cz.fel.omo.smarthome.house.lights;

import cz.fel.omo.smarthome.entity.devices.Documentation;
import cz.fel.omo.smarthome.entity.devices.deviceState.DeviceState;
import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.house.Room;

import java.util.Date;

/**
 * The type Light.
 */
public class Light extends Device {
	public String getRoom() {
		return room;
	}
	private String room;
	protected DeviceState deviceState;
	
	public Light(String room, int id) {
		super(id);
		this.room = room;
		type = "Light";
		documentation = new Documentation(type);
		electricity = 30; // Per hour
	}
	
	@Override
	public String toString() {
		return "Light{" +
			"id=" + id +
			", type='" + type + '\'' +
			'}';
	}
}
