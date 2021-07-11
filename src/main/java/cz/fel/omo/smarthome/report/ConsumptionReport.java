package cz.fel.omo.smarthome.report;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.configurations.Gson;
import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.entity.devices.iterator.DeviceIterator;
import cz.fel.omo.smarthome.house.House;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Consumption report.
 */
public class ConsumptionReport {
	private House house;

	public ConsumptionReport(House house) {
		this.house = house;
	}
	
	/**
	 * To string electricity string.
	 *
	 * @return the string
	 */
	public String toStringElectricity() {
		Map<String, Integer> electricity = new HashMap<>();
		DeviceIterator iter = house.getDevicesIterator();
		while (iter.hasNext()){
			Device device = null;
			try {
				device = iter.next();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			if (device == null) continue;
			electricity.put(device.getType(), device.getElectricity()*device.getTotalTime());
		}
		return Gson.toJson(electricity);
	}
	
	/**
	 * To string gas string.
	 *
	 * @return the string
	 */
	public String toStringGas() {
		Map<String, Integer> gas = new HashMap<>();
		DeviceIterator iter = house.getDevicesIterator();
		while (iter.hasNext()){
			Device device = null;
			try {
				device = iter.next();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			if (device == null) continue;
			gas.put(device.getType(), device.getGas()*device.getTotalTime());
		}
		return Gson.toJson(gas);
	}
	
	/**
	 * To string water string.
	 *
	 * @return the string
	 */
	public String toStringWater() {
		Map<String, Integer> water = new HashMap<>();
		DeviceIterator iter = house.getDevicesIterator();
		while (iter.hasNext()){
			Device device = null;
			try {
				device = iter.next();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			if (device == null) continue;
			water.put(device.getType(), device.getWater()*device.getTotalTime());
		}
		return Gson.toJson(water);
	}
	
	/**
	 * To string functionality string.
	 *
	 * @return the string
	 */
	public String toStringFunctionality() {
		Map<String, Integer> functionality = new HashMap<>();
		DeviceIterator iter = house.getDevicesIterator();
		while (iter.hasNext()){
			Device device = null;
			try {
				device = iter.next();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			if (device == null) continue;
			functionality.put(device.getType(), device.getFunctionality());
		}
		return Gson.toJson(functionality);
	}
}
