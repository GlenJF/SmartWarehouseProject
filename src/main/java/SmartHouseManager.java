import javax.swing.JOptionPane;

public class SmartHouseManager {
    private LightSensorClient lightSensorClient;
    private MotionSensorClient motionSensorClient;
    private ThermostatServiceClient thermostatServiceClient;

    public SmartHouseManager() {
        String consulHost = "localhost"; // Consul host
        int consulPort = 8500; // Consul port
        lightSensorClient = new LightSensorClient(consulHost, consulPort, "lightsensor-service");
        motionSensorClient = new MotionSensorClient(consulHost, consulPort, "motionsensor-service");
        thermostatServiceClient = new ThermostatServiceClient(consulHost, consulPort, "thermostat-service");
    }

    public void startClients() {
        lightSensorClient.adjustBrightness();
        motionSensorClient.detectMotion();
        thermostatServiceClient.streamThermostatReadings();
    }

    public void stopClients() {
        lightSensorClient.shutdown();
        motionSensorClient.shutdown();
        thermostatServiceClient.shutdown();
    }

    public static void main(String[] args) {
        SmartHouseManager manager = new SmartHouseManager();

        while (true) {
            String input = JOptionPane.showInputDialog(null, "Enter command (1: start all, 2: stop all, 3: start light sensor, 4: start motion sensor, 5: start thermostat service, 6: exit):");
            if (input == null) { // If user clicks cancel or closes the dialog
                break;
            }
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
                continue;
            }
            switch (choice) {
                case 1:
                    manager.startClients();
                    break;
                case 2:
                    manager.stopClients();
                    break;
                case 3:
                    manager.lightSensorClient.adjustBrightness();
                    break;
                case 4:
                    manager.motionSensorClient.detectMotion();
                    break;
                case 5:
                    manager.thermostatServiceClient.streamThermostatReadings();
                    break;
                case 6:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid command!");
                    break;
            }
        }
    }
}
