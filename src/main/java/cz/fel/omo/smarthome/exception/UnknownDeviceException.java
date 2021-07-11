package cz.fel.omo.smarthome.exception;

/**
 * The type Unknown device exception.
 */
public class UnknownDeviceException extends Exception{
	public UnknownDeviceException(int id) {
		super("Device is unknown: " + id);
	}
}
