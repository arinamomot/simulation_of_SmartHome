package cz.fel.omo.smarthome.entity.devices.iterator;

import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.house.Floor;
import cz.fel.omo.smarthome.house.House;
import cz.fel.omo.smarthome.house.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Device iterator.
 *  Iterator design pattern
 */
public class DeviceIterator {

	List<Device> list = new ArrayList<>();
	Integer current = 0;

	public DeviceIterator(House house) {
		for (Floor floor : house.getFloors()){
			for (Room room : floor.getRooms()) {
				list.addAll(room.getDevices());
			}
		}
	}
	
	/**
	 * Next device.
	 *
	 * @return the device
	 * @throws Exception the exception
	 */
	public Device next() throws Exception {
		if (current >= list.size()) throw new Exception("Device not found");
		Device device = list.get(current);
		current++;
		return device;
	}
	
	/**
	 * Has next boolean.
	 *
	 * @return the boolean
	 */
	public boolean hasNext() {
		return current != list.size() - 1;
	}
}
