package cz.fel.omo.smarthome.house;

import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.entity.inhabitants.person.Person;
import cz.fel.omo.smarthome.entity.inhabitants.pet.Pet;
import cz.fel.omo.smarthome.entity.vehicles.Vehicle;
import cz.fel.omo.smarthome.house.lights.Light;
import cz.fel.omo.smarthome.house.sensors.Sensor;
import cz.fel.omo.smarthome.house.window.Window;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Room.
 */
public class Room {
	private String room;
	
	private final List<Person> persons = new ArrayList<Person>();
	private final List<Pet> pets = new ArrayList<Pet>();
	private final List<Window> windows = new ArrayList<Window>();
	private final List<Light> lights = new ArrayList<Light>();
	private final List<Device> devices = new ArrayList<Device>();
	private final List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public List<Sensor> getSensors() {
		return sensors;
	}
	
	public void addSensor(Sensor sensor) {
		sensors.add(sensor);
	}
	
	private final List<Sensor> sensors = new ArrayList<Sensor>();

	public List<Person> getPersons() {
		return persons;
	}
	

	public void addPerson(Person person) {
		persons.add(person);
	}
	

	public List<Pet> getPets() {
		return pets;
	}
	
	public void addPet(Pet pet) {
		pets.add(pet);
	}
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	

	public Room(String room) {
		this.room = room;
	}
	

	public void addWindow(Window window) {
		windows.add(window);
	}
	
	public void addLight(Light light) {
		lights.add(light);
	}
	
	
	public void addDevice(Device device) {
		devices.add(device);
	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	public String getRoom() {
		return room;
	}
	

	public void setRoom(String room) {
		this.room = room;
	}
	

	public List<Window> getWindows() {
		return windows;
	}
	

	public List<Device> getDevices() {
		return devices;
	}
	
	/**
	 * Remove person from the room.
	 *
	 * @param type the type
	 * @param name the name
	 */
	public void removePerson(String type, String name) {
		for (Person person : persons) {
			if (person.getName().equalsIgnoreCase(name) && person.getType().equalsIgnoreCase(type)) {
				persons.remove(person);
				break;
			}
		}
	}
}
