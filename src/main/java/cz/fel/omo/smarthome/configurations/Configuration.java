package cz.fel.omo.smarthome.configurations;

import cz.fel.omo.smarthome.house.sensors.Sensor;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Сonfigurations.
 */
public class Configuration {
	public List<HouseConfiguration> houses;
	public List<EventConfiguration> events;
	
	public class EventConfiguration {
		public Integer order;
		public Integer sensorId;
		public Sensor sensor;
		public String sensorType;
		public String inhabitant;
		public String room;
		public Integer fridge;
		public ActionConfiguration action;
		public SubjectConfiguration subject;
		public Integer timestamp;
	}
	
	public class SubjectConfiguration {
		public Integer device;
		public Integer vehicle;
		public PersonConfiguration person = null;
	}
	
	public class ActionConfiguration {
		public String status; // turnOn, turnOff, broken, idle, repair
		public String food;
		public String action; // take, put
		public String type; // 'device-state', 'inhabitatnt_location', 'sensor', 'fridge' , 'light', 'window-state'
	}
	public class HouseConfiguration {
		public List<FloorConfiguration> floors;
	}
	public class FloorConfiguration {
    public List<RoomConfiguration> rooms;
  }
	public class RoomConfiguration {
		public String name;
		
    private List<DeviceConfiguration> devices = new ArrayList<>();
    public List<DeviceConfiguration> getDevices() {
			if(devices == null) return new ArrayList<>();
			return devices;
		}
		
		private List<PersonConfiguration> persons = new ArrayList<>();
		public List<PersonConfiguration> getPersons() {
			if (persons == null) return new ArrayList<>();
			return persons;
		}
		
		private List<PetConfiguration> pets = new ArrayList<>();
		public List<PetConfiguration> getPets() {
			if (pets == null) return new ArrayList<>();
			return pets;
		}
		
		private List<VehicleConfiguration> vehicles = new ArrayList<>();
		public List<VehicleConfiguration> getVehicles() {
			if (vehicles == null) return new ArrayList<>();
			return vehicles;
		}
		
		private List<SensorConfiguration> sensors = new ArrayList<>();
		public List<SensorConfiguration> getSensors() {
			if (sensors == null) return new ArrayList<>();
			return sensors;
		}
	}
  
  public class PersonConfiguration {
		public String type;
		public Integer id;
		public String name;
		
	  @Override
	  public String toString() {
		  return "PersonConfiguration{" +
			  "type='" + type + '\'' +
			  ", id=" + id +
			  ", name='" + name + '\'' +
			  '}';
	  }
  }
  
  public class PetConfiguration {
		public String type;
		public Integer id;
		public String name;
	
	  @Override
	  public String toString() {
		  return "PetConfiguration{" +
			  "type='" + type + '\'' +
			  ", id=" + id +
			  ", name='" + name + '\'' +
			  '}';
	  }
  }
  
  public class VehicleConfiguration {
	  public String type;
	  public Integer id;
	
	  @Override
	  public String toString() {
		  return "VehicleConfiguration{" +
			  "type='" + type + '\'' +
			  ", id=" + id +
			  '}';
	  }
  }
  
	public class DeviceConfiguration {
	  public String type;
		public Integer id;
		
		@Override
		public String toString() {
			return "DeviceConfiguration{" +
				"type='" + type + '\'' +
				", id=" + id +
				'}';
		}
	}
	
	public class SensorConfiguration {
		public String type;
		public Integer id;
		
		@Override
		public String toString() {
			return "SensorConfiguration{" +
				"type='" + type + '\'' +
				", id=" + id +
				'}';
		}
	}
}
