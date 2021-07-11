package cz.fel.omo.smarthome;

/**
 * The type Main.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        SmartHome smartHome = SmartHome.getInstance();
        smartHome.configure(args[0]);
        if(args.length ==2) {
            smartHome.execute(true);
        } else {
            smartHome.execute(false);
        }
        smartHome.generateReports();
        smartHome.writeHistory();
    }
}
