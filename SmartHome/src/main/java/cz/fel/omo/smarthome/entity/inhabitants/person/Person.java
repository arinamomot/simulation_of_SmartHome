package cz.fel.omo.smarthome.entity.inhabitants.person;

import cz.fel.omo.smarthome.entity.inhabitants.Inhabitant;

/**
 * The type Person.
 */
public abstract class Person extends Inhabitant {
	protected int id;
	protected String name = "";

	Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Person{" +
          "id=" + id +
          ", name='" + name + '\'' +
          '}';
    }
}
