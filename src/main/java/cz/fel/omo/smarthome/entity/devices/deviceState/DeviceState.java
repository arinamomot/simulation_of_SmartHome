package cz.fel.omo.smarthome.entity.devices.deviceState;

import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.configurations.History;
import cz.fel.omo.smarthome.exception.DeviceException;

import java.util.LinkedList;
import java.util.List;

/**
 * The type Device state.
 */
public class DeviceState {
    protected String state;

    public DeviceState() {}
    
    /**
     * Idle device state.
     *
     * @param living the living
     * @return the device state
     * @throws DeviceException the device exception
     */
    public DeviceState idle(Inhabitant living) throws DeviceException {
        return new IdleState();
    }
    
    /**
     * Turn on device state.
     *
     * @param living the living
     * @return the device state
     * @throws DeviceException the device exception
     */
    public DeviceState turnOn(Inhabitant living) throws DeviceException {
        return new TurnOnState();
    }
    
    /**
     * Turn off device state.
     *
     * @param living the living
     * @return the device state
     * @throws DeviceException the device exception
     */
    public DeviceState turnOff(Inhabitant living) throws DeviceException {
        return new TurnOffState();
    }
    
    /**
     * Broken device state.
     *
     * @param living the living
     * @return the device state
     * @throws DeviceException the device exception
     */
    public DeviceState broken(Inhabitant living) throws DeviceException {
        return new BrokenState();
    }
    
    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }
    
    @Override
    public String toString() {
        return state;
    }
}
