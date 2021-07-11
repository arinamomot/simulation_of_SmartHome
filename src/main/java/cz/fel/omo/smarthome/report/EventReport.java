package cz.fel.omo.smarthome.report;

import cz.fel.omo.smarthome.configurations.History;
import cz.fel.omo.smarthome.house.House;

import java.util.List;

/**
 * The type Event report.
 */
public class EventReport {
	
	
	/**
	 * To string string.
	 *
	 * @param historyList the history list
	 * @return the string
	 */
	public String toString(List<History> historyList) {
		StringBuilder out = new StringBuilder();
		for (History history : historyList) {
			if (history.type == History.Type.SENSOR) {
				out.append(history.toStringSensor());
				out.append("\n");
			}
			if (history.type == History.Type.EVENT) {
				out.append(history.toStringEvent());
				out.append("\n");
			}
			if (history.type == History.Type.DEVICE && history.inhabitant == null) {
				out.append(history);
				out.append("\n");
			}
//			if (history.type == History.Type.FOOD) out.append(history.toStringFridge());
			if (history.type == History.Type.VEHICLE && history.inhabitant == null) {
				out.append(history.toStringVehicle());
				out.append("\n");
			}
//			if (history.type == History.Type.LIGHT) out.append(history.toStringLight());
			if (history.type == History.Type.WINDOW && history.inhabitant == null) {
				out.append(history.toStringWindow());
				out.append("\n");
			}
		}
		return out.toString();
	}
}
