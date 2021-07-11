package cz.fel.omo.smarthome.house;

import cz.fel.omo.smarthome.house.sensors.Sensor;

/**
 * Builder design pattern
 */
public class HouseBuilder {
	protected House house = new House();
	public House getHouse() {
        return house;
    }
	public void addFloor(Floor floor) {
        house.addFloor(floor);
    }
	public void addSensors(Sensor sensor) { house.addSensor(sensor);}
}
