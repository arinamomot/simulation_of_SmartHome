package cz.fel.omo.smarthome.house;

import cz.fel.omo.smarthome.entity.devices.iterator.DeviceIterator;
import cz.fel.omo.smarthome.house.sensors.Sensor;

import java.util.ArrayList;
import java.util.List;

/**
 * The type House.
 */
public class House {
	private List<Floor> floors = new ArrayList<Floor>();
	private List<Sensor> sensors = new ArrayList<Sensor>();
	private Integer floorCount;
	
	public DeviceIterator getDevicesIterator() {
		return new DeviceIterator(this);
	}
	
	public List<Floor> getFloors() {
		return floors;
	}
	
	public void addFloor(Floor floor) {
		this.floors.add(floor);
		floorCount = floors.size();
	}
	
	public void addSensor(Sensor sensor) {
		this.sensors.add(sensor);
	}

	public Integer getFloorCount() {
		return floorCount;
	}
}
