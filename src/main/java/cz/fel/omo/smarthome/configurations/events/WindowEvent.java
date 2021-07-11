package cz.fel.omo.smarthome.configurations.events;

/**
 * The type Window event.
 */
public class WindowEvent extends Event {
	@Override
	public void execute() throws Exception {
		switch (action.status) {
			case "open":
				window.open(inhabitant);
				break;
			case "close":
				window.close(inhabitant);
				break;
			case "halfOpen":
				window.halfOpen(inhabitant);
				break;
		}
	}
}
