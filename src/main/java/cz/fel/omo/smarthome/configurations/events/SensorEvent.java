package cz.fel.omo.smarthome.configurations.events;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.house.sensors.WaterSensor;
import cz.fel.omo.smarthome.house.sensors.WindSensor;

/**
 * The type Sensor event.
 */
public class SensorEvent extends Event {
	@Override
	public void execute() throws Exception {
		switch (sensorType) {
			case "waterSensor":
				sensor = new WaterSensor(sensorId);
				sensor.react(timestamp);
				break;
			case "fireSensor":
				break;
			case "windSensor":
				sensor = SmartHome.getInstance().getSensor(sensorId).get();
				sensor.react(timestamp);
				break;
		}
	}
}
