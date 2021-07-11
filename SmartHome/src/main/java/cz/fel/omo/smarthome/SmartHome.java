package cz.fel.omo.smarthome;

import cz.fel.omo.smarthome.configurations.*;
import cz.fel.omo.smarthome.configurations.events.*;
import cz.fel.omo.smarthome.entity.devices.DeviceFactory;
import cz.fel.omo.smarthome.entity.devices.items.Device;
import cz.fel.omo.smarthome.entity.devices.items.Fridge;
import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;
import cz.fel.omo.smarthome.entity.inhabitants.PersonFactory;
import cz.fel.omo.smarthome.entity.inhabitants.PetFactory;
import cz.fel.omo.smarthome.entity.inhabitants.person.Person;
import cz.fel.omo.smarthome.entity.inhabitants.pet.Pet;
import cz.fel.omo.smarthome.entity.vehicles.Vehicle;
import cz.fel.omo.smarthome.entity.vehicles.VehicleFactory;
import cz.fel.omo.smarthome.exception.DeviceException;
import cz.fel.omo.smarthome.exception.SensorException;
import cz.fel.omo.smarthome.exception.UnknownDeviceException;
import cz.fel.omo.smarthome.house.*;
import cz.fel.omo.smarthome.house.lights.Light;
import cz.fel.omo.smarthome.house.sensors.*;
import cz.fel.omo.smarthome.house.sensors.factory.SensorFactory;
import cz.fel.omo.smarthome.house.window.Window;
import cz.fel.omo.smarthome.report.ActivityAndUsageReport;
import cz.fel.omo.smarthome.report.ConsumptionReport;
import cz.fel.omo.smarthome.report.EventReport;
import cz.fel.omo.smarthome.report.HouseConfigurationReport;

import java.io.*;
import java.util.*;

/**
 * Singleton design pattern
 */
public class SmartHome {
	private static SmartHome smartHome;
	private Configuration conf;
	
	public List<History> getHistoryList() {
		return historyList;
	}
	
	private List<History> historyList = new ArrayList<>();
	private List<House> houses = new ArrayList<>();
	private List<Device> devices = new ArrayList<>();
	private List<Vehicle> vehicles = new ArrayList<>();
	private List<Room> rooms = new ArrayList<>();
	private List<Window> windows = new ArrayList<>();
	private List<Light> lights = new ArrayList<>();
	private List<Inhabitant> inhabitantList = new ArrayList<>();
	private List<Sensor> sensors = new ArrayList<>();
	private List<Event> events = new ArrayList<>();
	private static int ids = 0;
	
	public static int getId() {
		ids++;
		return ids;
	}
	
	private SmartHome() {
	}
	
	/**
	 * Generate house configuration report house configuration report.
	 *
	 * @return the house configuration report
	 */
	public HouseConfigurationReport generateHouseConfigurationReport() {
		int count = 0;
		HouseConfigurationReport report = null;
		for (House house : houses) {
			report = new HouseConfigurationReport(houses.get(count));
			count++;
		}
		return report;
	}
	
	
	/**
	 * Generate consumption report.
	 */
	public void generateConsumptionReport() {
		int count = 0;
		ConsumptionReport report = null;
		for (House house : houses) {
			report = new ConsumptionReport(houses.get(count));
			String electricityReport = report.toStringElectricity();
			String gasReport = report.toStringGas();
			String waterReport = report.toStringWater();
			String functionalityReport = report.toStringFunctionality();
			writeToFileConsumption("reports/ConsumptionReport.json", electricityReport, "electricity");
			writeToFileConsumption("reports/ConsumptionReport.json", gasReport, "gas");
			writeToFileConsumption("reports/ConsumptionReport.json", waterReport, "water");
			writeToFileConsumption("reports/ConsumptionReport.json", functionalityReport, "functionality");
			count++;
		}
	}
	
	/**
	 * Write to file.
	 *
	 * @param path    the path
	 * @param content the content
	 */
	public void writeToFile(String path, String content) {
		try {
			FileWriter writer = new FileWriter(path);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Write to file consumption.
	 *
	 * @param path    the path
	 * @param content the content
	 * @param type    the type
	 */
	public void writeToFileConsumption(String path, String content, String type) {
		try {
			FileWriter writer = new FileWriter(path, true);
			if ("electricity".equals(type)) {
				writer.write("Electricity: " + "\n");
			} else if ("gas".equals(type)) {
				writer.write("Gas: " + "\n");
			} else if ("water".equals(type)) {
				writer.write("Water: " + "\n");
			} else if ("functionality".equals(type)) {
				writer.write("Functionality: " + "\n");
			}
			writer.write(content);
			writer.write("\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Generate reports.
	 */
	public void generateReports() {
		File f = new File("reports/ConsumptionReport.json");
		f.delete();
		HouseConfigurationReport houseConfigurationReport = this.generateHouseConfigurationReport();
		this.generateConsumptionReport();
		EventReport eventReport = new EventReport();
		writeToFile("reports/EventReport.json", eventReport.toString(historyList));
		ActivityAndUsageReport activityAndUsageReport = new ActivityAndUsageReport();
		writeToFile("reports/ActivityAndUsageReport.json", activityAndUsageReport.toString(historyList));
		String report1 = houseConfigurationReport.toString();
		//or
		writeToFile("reports/HouseConfigurationReport.json", report1);
	}
	
	/**
	 * Add history.
	 *
	 * @param history the history
	 */
	public void addHistory(History history) {
		this.historyList.add(history);
	}
	
	public static SmartHome getInstance() {
		if (smartHome != null) {
			return smartHome;
		}
		smartHome = new SmartHome();
		return smartHome;
	}
	
	/**
	 * Configure.
	 * Converting json configuration to the code.
	 *
	 * @param path the path
	 * @throws Exception the exception
	 */
	public void configure(String path) throws Exception {
		File file = new File(path);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		String json = "";
		while ((line = reader.readLine()) != null) {
			json += line;
		}
		reader.close();
		conf = Gson.fromJson(json, new Configuration());
		for (Configuration.HouseConfiguration houseConfiguration : conf.houses) {
			HouseBuilder houseBuilder = new HouseBuilder();
			int index = 1;
			for (Configuration.FloorConfiguration floorConfiguration : houseConfiguration.floors) {
				Floor floor = new Floor(index);
				for (Configuration.RoomConfiguration roomConfiguration : floorConfiguration.rooms) {
					Room room = new Room(roomConfiguration.name);
					if (!room.getRoom().equals("outside")) {
						Window window = new Window(room, getId());
						room.addWindow(window);
						window.setLocation(room);
						windows.add(window);
						Light light = new Light(room.getRoom(), getId());
						room.addLight(light);
						lights.add(light);
					}
					for (Configuration.DeviceConfiguration deviceConfiguration : roomConfiguration.getDevices()) {
						final Device device = DeviceFactory.makeDevice(deviceConfiguration.type, deviceConfiguration.id);
						room.addDevice(device);
						devices.add(device);
					}
					for (Configuration.PersonConfiguration personConfiguration : roomConfiguration.getPersons()) {
						final Person person = PersonFactory.makePerson(personConfiguration.type, personConfiguration.id, personConfiguration.name);
						room.addPerson(person);
						inhabitantList.add(person);
					}
					for (Configuration.PetConfiguration petConfiguration : roomConfiguration.getPets()) {
						final Pet pet = PetFactory.makePet(petConfiguration.type, petConfiguration.id, petConfiguration.name);
						room.addPet(pet);
						inhabitantList.add(pet);
					}
					for (Configuration.VehicleConfiguration vehicleConfiguration : roomConfiguration.getVehicles()) {
						final Vehicle vehicle = VehicleFactory.makeVehicle(vehicleConfiguration.type, vehicleConfiguration.id);
						room.addVehicle(vehicle);
						vehicles.add(vehicle);
					}
					for (Configuration.SensorConfiguration sensorConfiguration : roomConfiguration.getSensors()) {
						final Sensor sensor = SensorFactory.makeSensor(sensorConfiguration.type, sensorConfiguration.id);
						sensor.setLocation(room);
						sensors.add(sensor);
						
					}
					floor.addRoom(room);
					rooms.add(room);
				}
				houseBuilder.addFloor(floor);
				index++;
			}
			// CONNECT SENSORS AND DEVICES
			for (Sensor sensor : sensors) {
				String type = sensor.getType();
				for (Device device : devices) {
					switch (type) {
						case "fireSensor":
							if (device.getElectricity() == 0) continue;
							sensor.addDevice(device);
							device.connectSensor(sensor);
							break;
						case "windSensor":
							for (Window window : windows) {
								sensor.addWindow(window);
								window.connectSensor(sensor);
							}
							break;
						case "waterSensor":
							if (device.getWater() == 0) continue;
							sensor.addDevice(device);
							device.connectSensor(sensor);
							break;
						default:
							throw new SensorException("Connection error of the sensor and device");
					}
				}
			}
			House house = houseBuilder.getHouse();
			houses.add(house);
			//Events configuration - Converting json configuration to the code
			for (Configuration.EventConfiguration eventConfiguration : conf.events) {
				// 'device-state', 'inhabitatnt_location', 'sensor', 'fridge' , 'light', 'vehicle', 'window-state', 'off'
				Event event = null;
				if (eventConfiguration.action.type.equalsIgnoreCase("device-state")) {
					event = new DeviceEvent();
					event.action = new Event.Action();
					event.order = eventConfiguration.order;
					event.action.type = eventConfiguration.action.type;
					event.action.status = eventConfiguration.action.status;
					if (getDevice(eventConfiguration.subject.device).isPresent()) {
						event.device = getDevice(eventConfiguration.subject.device).get();
					}
					Optional<Inhabitant> inhabitant = getInhabitant(eventConfiguration.inhabitant);
					if (inhabitant.isPresent()) event.inhabitant = inhabitant.get();
					event.timestamp = eventConfiguration.timestamp;
				}
				if (eventConfiguration.action.type.equalsIgnoreCase("vehicle")) {
					event = new VehicleEvent();
					event.action = new Event.Action();
					event.order = eventConfiguration.order;
					event.action.type = eventConfiguration.action.type;
					event.action.status = eventConfiguration.action.status;
					if (getVehicle(eventConfiguration.subject.vehicle).isPresent()) {
						event.vehicle = getVehicle(eventConfiguration.subject.vehicle).get();
					}
					Optional<Inhabitant> inhabitant = getInhabitant(eventConfiguration.inhabitant);
					if (inhabitant.isPresent()) event.inhabitant = inhabitant.get();
					event.timestamp = eventConfiguration.timestamp;
				}
				if (eventConfiguration.action.type.equalsIgnoreCase("light")) {
					event = new LightEvent();
					event.action = new Event.Action();
					event.order = eventConfiguration.order;
					event.action.type = eventConfiguration.action.type;
					event.action.status = eventConfiguration.action.status;
					event.room = eventConfiguration.room;
					for (Light light : lights) {
						if (light.getRoom().equals(event.room)) event.device = light;
					}
					Optional<Inhabitant> inhabitant = getInhabitant(eventConfiguration.inhabitant);
					if (inhabitant.isPresent()) event.inhabitant = inhabitant.get();
					event.timestamp = eventConfiguration.timestamp;
				}
				if (eventConfiguration.action.type.equalsIgnoreCase("window-state")) {
					event = new WindowEvent();
					event.action = new Event.Action();
					event.order = eventConfiguration.order;
					event.action.type = eventConfiguration.action.type;
					event.action.status = eventConfiguration.action.status;
					event.room = eventConfiguration.room;
					for (Window window : windows) {
						if (window.getLocation().getRoom().equals(event.room)) event.window = window;
					}
					Optional<Inhabitant> inhabitant = getInhabitant(eventConfiguration.inhabitant);
					if (inhabitant.isPresent()) event.inhabitant = inhabitant.get();
					event.timestamp = eventConfiguration.timestamp;
				}
				if (eventConfiguration.action.type.equalsIgnoreCase("fridge")) {
					event = new FridgeEvent();
					event.action = new Event.Action();
					event.order = eventConfiguration.order;
					event.action.type = eventConfiguration.action.type;
					event.action.food = eventConfiguration.action.food;
					event.action.action = eventConfiguration.action.action;
					Optional<Device> device = getDevice(eventConfiguration.fridge);
					if (device.isEmpty()) throw new UnknownDeviceException(eventConfiguration.fridge);
					if (device.get().getClass() != Fridge.class) throw new DeviceException("This is not a fridge");
					event.action.fridge = (Fridge) device.get();
					event.inhabitant = getInhabitant(eventConfiguration.inhabitant).get();
				}
				if (eventConfiguration.action.type.equalsIgnoreCase("inhabitant_location")) {
					event = new InhabitantEvent();
					event.action = new Event.Action();
					event.order = eventConfiguration.order;
					event.action.type = eventConfiguration.action.type;
					event.room = eventConfiguration.room;
					Optional<Inhabitant> inhabitant = getInhabitant(eventConfiguration.inhabitant);
					if (inhabitant.isPresent()) event.inhabitant = inhabitant.get();
					event.timestamp = eventConfiguration.timestamp;
				}
				if (eventConfiguration.action.type.equalsIgnoreCase("sensor")) {
					event = new SensorEvent();
					event.action = new Event.Action();
					event.order = eventConfiguration.order;
					event.action.type = eventConfiguration.action.type;
					event.sensorId = eventConfiguration.sensorId;
					event.sensorType = eventConfiguration.sensorType;
					event.room = eventConfiguration.room;
					Optional<Sensor> sensor = getSensor(eventConfiguration.sensorId);
					if (sensor.isPresent()) event.sensor = sensor.get();
					event.timestamp = eventConfiguration.timestamp;
				}
				if (eventConfiguration.action.type.equalsIgnoreCase("off")) {
					event = new Off();
					event.action = new Event.Action();
					event.order = eventConfiguration.order;
					event.action.type = eventConfiguration.action.type;
					event.timestamp = eventConfiguration.timestamp;
				}
				if (event == null) continue;
				events.add(event);
				
			}
		}
	}
	
	public Room getRoom(String title) {
		for (Room room : rooms) {
			if (room.getRoom().equalsIgnoreCase(title)) return room;
		}
		return null;
	}
	
	/**
	 * Execute.
	 *
	 * @param random the random
	 * @throws Exception the exception
	 */
	void execute(boolean random) throws Exception {
		for (Event event : events) {
			try {
				event.execute();
			} catch (Exception exception) {
				History.Type type = null;
				if (event.getClass() == FridgeEvent.class) {
					type = History.Type.FOOD;
					historyList.add(new History(type, event.inhabitant, event.device, exception.getMessage()));
				}
				if (event.getClass() == VehicleEvent.class) {
					type = History.Type.VEHICLE;
					historyList.add(new History(type, event.vehicle, exception.getMessage()));
				}
				if (event.getClass() == SensorEvent.class) {
					type = History.Type.SENSOR;
					historyList.add(new History(type, event.sensor, exception.getMessage()));
				}
				if (event.getClass() == LightEvent.class) {
					type = History.Type.LIGHT;
					historyList.add(new History(type, event.inhabitant, event.device, event.room, event.device.getState().toString()));
				}
				if (event.getClass() == DeviceEvent.class) {
					type = History.Type.DEVICE;
					historyList.add(new History(type, event.inhabitant, event.device, exception.getMessage()));
				}
			}
//			Thread.sleep(1000);
		}
	}
	
	/**
	 * Write to the history(to the console).
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	public void writeHistory() throws InterruptedException {
		for (History history : historyList) {
			if (history.type == History.Type.SENSOR) System.out.println(history.toStringSensor());
			if (history.type == History.Type.EVENT) System.out.println(history.toStringEvent());
			if (history.type == History.Type.DEVICE) System.out.println(history);
			if (history.type == History.Type.FOOD) System.out.println(history.toStringFridge());
			if (history.type == History.Type.VEHICLE) System.out.println(history.toStringVehicle());
			if (history.type == History.Type.LIGHT) System.out.println(history.toStringLight());
			if (history.type == History.Type.WINDOW) System.out.println(history.toStringWindow());
			if (history.type == History.Type.ACTIVITY) System.out.println(history.toStringActivity());
		}
	}
	
	/**
	 * Gets inhabitant by id.
	 *
	 * @param name the name
	 * @return the inhabitant
	 */
	public Optional<Inhabitant> getInhabitant(String name) {
		for (Inhabitant inhabitant : inhabitantList) {
			if (inhabitant.getName().equalsIgnoreCase(name)) return Optional.of(inhabitant);
		}
		return Optional.empty();
	}
	
	/**
	 * Gets sensor by id.
	 *
	 * @param id the id
	 * @return the sensor
	 */
	public Optional<Sensor> getSensor(Integer id) {
		for (Sensor sensor : sensors) {
			if (sensor.getId().equals(id)) return Optional.of(sensor);
		}
		return Optional.empty();
	}
	
	/**
	 * Gets device by id.
	 *
	 * @param id the id
	 * @return the device
	 */
	public Optional<Device> getDevice(Integer id) {
		for (Device device : devices) {
			if (device.getId() == id) return Optional.of(device);
		}
		return Optional.empty();
	}
	
	/**
	 * Gets vehicle by id.
	 *
	 * @param id the id
	 * @return the vehicle
	 */
	public Optional<Vehicle> getVehicle(Integer id) {
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getId() == id) return Optional.of(vehicle);
		}
		return Optional.empty();
	}
	
	/**
	 * Remove inhabitant.
	 *
	 * @param inhabitant the inhabitant
	 */
	public void removeInhabitant(Inhabitant inhabitant) {
		for (Room room : rooms) {
			room.removePerson(inhabitant.getType(), inhabitant.getName());
		}
	}
	
	public List<House> getHouses() {
		return houses;
	}
}
