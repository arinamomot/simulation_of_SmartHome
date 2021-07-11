package cz.fel.omo.smarthome.entity.inhabitants;

/**
 * The type Inhabitant.
 */
public abstract class Inhabitant {
	protected String type;

	public abstract String getName();

	public String getType() {
		return type;
	}
}
