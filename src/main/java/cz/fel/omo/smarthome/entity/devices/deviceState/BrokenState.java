package cz.fel.omo.smarthome.entity.devices.deviceState;

import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.configurations.History;
import cz.fel.omo.smarthome.exception.DeviceException;

/**
 * The type Broken state.
 */
public class BrokenState extends DeviceState {
    
    public BrokenState() {
        state = "broken";
    }
    
    @Override
    public DeviceState idle(Inhabitant living) throws DeviceException {
        throw new DeviceException("Device is broken");
    }
    
    public DeviceState turnOn(Inhabitant living) throws DeviceException {
        throw new DeviceException("Device is broken");
    }
    
    @Override
    public DeviceState turnOff(Inhabitant living) throws DeviceException {
        throw new DeviceException("Device is broken");
    }
    
    public DeviceState broken(Inhabitant living) throws DeviceException {
        throw new DeviceException("Device is broken");
    }
}
