package cz.fel.omo.smarthome.entity.devices.items;

import cz.fel.omo.smarthome.SmartHome;
import cz.fel.omo.smarthome.configurations.History;
import cz.fel.omo.smarthome.entity.devices.Documentation;
import cz.fel.omo.smarthome.entity.devices.deviceState.DeviceState;
import cz.fel.omo.smarthome.entity.devices.deviceState.TurnOffState;
import cz.fel.omo.smarthome.configurations.Gson;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.entity.inhabitants.person.Father;
import cz.fel.omo.smarthome.entity.inhabitants.person.GrandFather;
import cz.fel.omo.smarthome.entity.inhabitants.person.Person;
import cz.fel.omo.smarthome.exception.DeviceException;
import cz.fel.omo.smarthome.exception.VehicleException;
import cz.fel.omo.smarthome.house.lights.Light;
import cz.fel.omo.smarthome.house.sensors.Sensor;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The type Device.
 */
public abstract class Device {
    protected DeviceState state;
    protected int id;
    protected String type;
    protected Documentation documentation;
    protected Integer functionality= 100;
    protected Integer electricity = 0;
    protected Integer gas = 0;
    protected Integer water = 0;
    int totalTime = 0;
    int start = 0;
    protected transient Set<Sensor> sensorList = new HashSet<>();
    
    /**
     * Connect sensor with devices.
     *
     * @param sensor the sensor
     */
    public void connectSensor(Sensor sensor) {
        sensorList.add(sensor);
    }
    
    public Integer getFunctionality() {
        return functionality;
    }
    public Integer getElectricity() {
        return electricity;
    }
    public Integer getGas() {
        return gas;
    }
    public Integer getWater() {
        return water;
    }
    public int getTotalTime() {
        return totalTime;
    }
    public String getType() {
        return type;
    }
    public int getId() {
        return id;
    }
    
    public Device(int id) {
        this.id = id;
        state = new TurnOffState();
    }
    
    /**
     * Copy the element.
     *
     *@return device
     */
    public Device clone() {
        return Gson.fromJson(Gson.toJson(this), this);
    }
    
    /**
     * Repair the device/vehicle.
     *
     * @param person the person
     * @throws DeviceException  the device exception
     * @throws VehicleException the vehicle exception
     */
    public void repair(Inhabitant person) throws DeviceException, VehicleException {
        if(!this.state.getState().equalsIgnoreCase("broken")) throw new DeviceException("device is not broken");
        if (person.getClass() == Father.class || person.getClass() == GrandFather.class) {
            this.state = new TurnOffState();
            functionality = 100;
            addHistory(person);
        } else {
            throw new DeviceException("You cant repair device");
        }
    }

    public DeviceState getState() {
        return state;
    }
    
    /**
     * Add to history.
     *
     * @param inhabitant the inhabitant
     */
    private void addHistory(Inhabitant inhabitant) {
        if (this.getType().equals("Light")) SmartHome.getInstance().addHistory( new History(History.Type.LIGHT, inhabitant, this, ((Light) this).getRoom(), state.getState()));
        else if (inhabitant == null) SmartHome.getInstance().addHistory( new History(History.Type.EVENT, this, state.getState()));
        else if (this.getType().equals("Vehicle")) SmartHome.getInstance().addHistory( new History(History.Type.VEHICLE, inhabitant, this,  state.getState()));
        else SmartHome.getInstance().addHistory( new History(History.Type.DEVICE, inhabitant, this, state.getState()));
    }
    
    /**
     * Turn on the device.
     *
     * @param inhabitant the inhabitant
     * @param when       the start time of device use
     * @throws Exception the exception
     */
    public void setOn(Inhabitant inhabitant , int when) throws Exception {
        state = state.turnOn(inhabitant);
        start = when;
        functionality -= 10;
        addHistory(inhabitant);
    }
    
    /**
     * Turn off the device.
     *
     * @param inhabitant the inhabitant
     * @param when       the end time of device use
     * @throws Exception the exception
     */
    public void setOff(Inhabitant inhabitant , int when) throws Exception {
        state = state.turnOff(inhabitant);
        totalTime += (when-start);
        functionality -= 20;
        addHistory(inhabitant);
    }
    
    /**
     * Using the device.
     *
     * @param inhabitant the inhabitant
     * @param when       time
     * @throws Exception the exception
     */
    public void inUse(Inhabitant inhabitant, int when) throws Exception {
        state = state.idle(inhabitant);
        functionality -= 10;
        addHistory(inhabitant);
    }
    
    /**
     * Broke the device.
     *
     * @param inhabitant the inhabitant
     * @param when       the time when the device broke down
     * @throws Exception the exception
     */
    public void broke(Inhabitant inhabitant, int when) throws Exception {
        state = state.broken(inhabitant);
        totalTime += (when-start);
        functionality = 0;
        addHistory(inhabitant);
        for(Sensor sensor : sensorList) sensor.react( when);
    }
    
    @Override
    public String toString() {
        return "Device{" +
          "id=" + id +
          ", type='" + type + '\'' +
          '}';
    }
}
