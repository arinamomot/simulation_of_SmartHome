package cz.fel.omo.smarthome.entity.vehicles;

import cz.fel.omo.smarthome.entity.devices.Documentation;
import cz.fel.omo.smarthome.entity.devices.deviceState.BrokenState;
import cz.fel.omo.smarthome.entity.devices.deviceState.IdleState;
import cz.fel.omo.smarthome.entity.devices.deviceState.TurnOffState;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.entity.inhabitants.person.Father;
import cz.fel.omo.smarthome.entity.inhabitants.person.GrandFather;
import cz.fel.omo.smarthome.entity.inhabitants.person.Mother;
import cz.fel.omo.smarthome.exception.VehicleException;

/**
 * The type Car.
 */
public class Car extends Vehicle {
	
	public Car(int id) {
		super(id);
		type = "Car";
		documentation = new Documentation(type);
	}
	
	@Override
	public void setOff(Inhabitant inhabitant, int when) throws Exception {
		if(!this.state.getState().equalsIgnoreCase("turnOff")) throw new VehicleException("Vehicle is already not used");
		if (inhabitant.getClass() == Father.class || inhabitant.getClass() == GrandFather.class || inhabitant.getClass() == Mother.class ) {
			this.state = new TurnOffState();
		} else {
			throw new VehicleException("You cant drive the car");
		}
	}
	
	@Override
	public void inUse(Inhabitant inhabitant, int when) throws Exception {
		if(!this.state.getState().equalsIgnoreCase("idle")) throw new VehicleException("Vehicle is already used");
		if (inhabitant.getClass() == Father.class || inhabitant.getClass() == GrandFather.class || inhabitant.getClass() == Mother.class ) {
			this.state = new IdleState();
		} else {
			throw new VehicleException("You cant drive the car");
		}
	}
	
	@Override
	public void broke(Inhabitant inhabitant, int when) throws Exception {
		if(!this.state.getState().equalsIgnoreCase("broken")) throw new VehicleException("Vehicle is already broken");
		if (inhabitant.getClass() == Father.class || inhabitant.getClass() == GrandFather.class || inhabitant.getClass() == Mother.class ) {
			this.state = new BrokenState();
		} else {
			throw new VehicleException("You cant broke the car");
		}
	}
	
	
}
