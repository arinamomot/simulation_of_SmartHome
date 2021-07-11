package cz.fel.omo.smarthome.entity.inhabitants.pet;

import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;

/**
 * The type Pet.
 */
public abstract class Pet extends Inhabitant {
	protected int id;
	protected String name = "";

	Pet(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Pet{" +
			"id=" + id +
			", name='" + name + '\'' +
			'}';
	}
}
