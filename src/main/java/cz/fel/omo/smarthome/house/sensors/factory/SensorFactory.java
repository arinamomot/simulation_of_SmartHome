package cz.fel.omo.smarthome.house.sensors.factory;

import cz.fel.omo.smarthome.exception.CreationException;
import cz.fel.omo.smarthome.house.sensors.FireSensor;
import cz.fel.omo.smarthome.house.sensors.Sensor;
import cz.fel.omo.smarthome.house.sensors.WaterSensor;
import cz.fel.omo.smarthome.house.sensors.WindSensor;

/**
 * The type Sensor factory.
 */
public class SensorFactory {
	/**
	 * Make sensor.
	 *
	 * @param type the type of the sensor
	 * @param id   the id
	 * @return the sensor
	 * @throws CreationException the creation exception
	 */
	public static Sensor makeSensor(String type, Integer id) throws CreationException {
		switch (type) {
			case "fireSensor":
				return new FireSensor(id);
			case "windSensor":
				return new WindSensor(id);
			case "waterSensor":
				return new WaterSensor(id);
			default:
				throw new CreationException("Sensor creation error");
		}
	}
}

