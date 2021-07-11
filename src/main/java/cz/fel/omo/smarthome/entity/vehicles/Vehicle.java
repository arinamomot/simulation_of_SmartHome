package cz.fel.omo.smarthome.entity.vehicles;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.configurations.History;
import cz.fel.omo.smarthome.entity.devices.deviceState.DeviceState;
import cz.fel.omo.smarthome.entity.devices.deviceState.TurnOffState;
import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.entity.inhabitants.person.Father;
import cz.fel.omo.smarthome.entity.inhabitants.person.GrandFather;
import cz.fel.omo.smarthome.entity.inhabitants.person.Person;
import cz.fel.omo.smarthome.exception.VehicleException;

/**
 * The type Vehicle.
 */
public abstract class Vehicle extends Device {
	public Vehicle(int id) {
		super(id);
		this.state = new TurnOffState();
	}
	
	@Override
	public void repair(Inhabitant person) throws VehicleException {
		if(!this.state.getState().equalsIgnoreCase("broken")) throw new VehicleException("Vehicle is not broken");
		if (person.getClass() == Father.class || person.getClass() == GrandFather.class) {
			this.state = new TurnOffState();
		} else {
			throw new VehicleException("You cant repair this vehicle");
		}
	}
	
	@Override
	public void setOff(Inhabitant inhabitant, int when) throws Exception {
		state = state.turnOff(inhabitant);
		SmartHome.getInstance().addHistory(new History(History.Type.VEHICLE,inhabitant, this, state.getState()));
	}
	
	@Override
	public void inUse(Inhabitant inhabitant, int when) throws Exception {
		state = state.idle(inhabitant);
		SmartHome.getInstance().addHistory( new History(History.Type.VEHICLE, inhabitant, this, state.getState()));
	}
	
	@Override
	public void broke(Inhabitant inhabitant, int when) throws Exception {
		state = state.broken(inhabitant);
		SmartHome.getInstance().addHistory( new History(History.Type.VEHICLE, inhabitant, this, state.getState()));
	}
	
}
