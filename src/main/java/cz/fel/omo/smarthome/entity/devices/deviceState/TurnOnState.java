package cz.fel.omo.smarthome.entity.devices.deviceState;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.configurations.History;
import cz.fel.omo.smarthome.exception.DeviceException;

/**
 * The type Turn on state.
 */
public class TurnOnState extends DeviceState {
    
    public TurnOnState() {
        state = "turnOn";
    }
    
    @Override
    public DeviceState idle(Inhabitant living) throws DeviceException {
        return new IdleState();
    }
    
    @Override
    public DeviceState turnOn(Inhabitant living) throws DeviceException {
        throw new DeviceException("Device is already turned on");
    }
    
    @Override
    public DeviceState turnOff(Inhabitant living) throws DeviceException {
        return new TurnOffState();
    }
    
    @Override
    public DeviceState broken(Inhabitant living) throws DeviceException {
        return new BrokenState();
    }
    
}
