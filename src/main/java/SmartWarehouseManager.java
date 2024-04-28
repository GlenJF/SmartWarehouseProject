import javax.swing.*;
import java.awt.*;

public class SmartWarehouseManager {
    // Create instance variables  of all three clients
    private LightSensorClient lightSensorClient;
    private MotionSensorClient motionSensorClient;
    private ThermostatServiceClient thermostatServiceClient;

    private JFrame frame;//  JFrame for the main window
    private JPanel panel;//JPanel to hold GUI components
    private JTextField inputField;// JTextField for user input

    // Initialize clients with Consul details and service names
    public SmartWarehouseManager() {
        String consulHost = "localhost"; // Consul host
        int consulPort = 8500; // Consul port
        lightSensorClient = new LightSensorClient(consulHost, consulPort, "lightsensor-service");
        motionSensorClient = new MotionSensorClient(consulHost, consulPort, "motionsensor-service");
        thermostatServiceClient = new ThermostatServiceClient(consulHost, consulPort, "thermostat-service");
    }
    // Method to start all clients
    public void startClients() {
        lightSensorClient.adjustBrightness();
        motionSensorClient.detectMotion();
        thermostatServiceClient.streamThermostatReadings();
    }
    // Method to stop all clients
    public void stopClients() {
        lightSensorClient.shutdown();
        motionSensorClient.shutdown();
        thermostatServiceClient.shutdown();
    }

    // Methods to start and stop individual clients
    public void startLightSensorClient() {
        lightSensorClient.adjustBrightness();
    }

    public void stopLightSensorClient() {
        lightSensorClient.shutdown();
    }

    public void startMotionSensorClient() {
        motionSensorClient.detectMotion();
    }

    public void stopMotionSensorClient() {
        motionSensorClient.shutdown();
    }

    public void startThermostatServiceClient() {
        thermostatServiceClient.streamThermostatReadings();
    }

    public void stopThermostatServiceClient() {
        thermostatServiceClient.shutdown();
    }

    //Create and show the GUI
    public void createAndShowGUI() {
        frame = new JFrame("Smart Warehouse Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(500, 300));

        // Add logo
        ImageIcon icon = new ImageIcon("src/main/resources/image/icon.png");
        JLabel logoLabel = new JLabel(icon);
        JPanel logoPanel = new JPanel(new BorderLayout());
        logoPanel.add(logoLabel, BorderLayout.CENTER);
        panel.add(logoPanel, BorderLayout.BEFORE_FIRST_LINE);

        // Create options panel
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        optionsPanel.add(createTitleLabel("Smart Warehouse Manager"));
        optionsPanel.add(createOptionLabel("1: Start all Clients"));
        optionsPanel.add(createOptionLabel("2: Stop all Clients"));
        optionsPanel.add(createOptionLabel("3: Start Light Sensor Client"));
        optionsPanel.add(createOptionLabel("4: Stop Light Sensor Client"));
        optionsPanel.add(createOptionLabel("5: Start Motion Sensor Client"));
        optionsPanel.add(createOptionLabel("6: Stop Motion Sensor Client"));
        optionsPanel.add(createOptionLabel("7: Start Thermostat Service Client"));
        optionsPanel.add(createOptionLabel("8: Stop Thermostat Service Client"));
        optionsPanel.add(createOptionLabel("9: Exit"));

        // Add a label and text field for input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20)); // Add padding
        JLabel inputLabel = new JLabel("Enter option:");
        inputPanel.add(inputLabel);
        inputPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Add spacing
        inputField = new JTextField(2); // Text field for input with shorter length
        inputPanel.add(inputField);

        panel.add(optionsPanel, BorderLayout.CENTER);
        panel.add(inputPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        // Add action listener for input field
        inputField.addActionListener(e -> processInput());
    }

    private JLabel createTitleLabel(String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Align center
        label.setFont(new Font("Arial", Font.BOLD, 20)); // Larger font size
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); // Add padding
        return label;
    }

    private JLabel createOptionLabel(String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.LEFT_ALIGNMENT); // Align left
        label.setBorder(BorderFactory.createEmptyBorder(0, 20, 5, 0)); // Add padding between lines
        return label;
    }

    /*
     * Process the user input from the input field.
     * Retrieve  the input from the text field, convert to integer,
     *  execute action based on the input option.
     * If the input is invalid,  display an error message.
     */

    private void processInput() {
        int option;
        try {
            option = Integer.parseInt(inputField.getText().trim()); // Retrieve input from text field
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a number.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

            // Take the corresponding action based on the input option
        switch (option) {
            case 1:
                startClients();
                break;
            case 2:
                stopClients();
                break;
            case 3:
                startLightSensorClient();
                break;
            case 4:
                stopLightSensorClient();
                break;
            case 5:
                startMotionSensorClient();
                break;
            case 6:
                stopMotionSensorClient();
                break;
            case 7:
                startThermostatServiceClient();
                break;
            case 8:
                stopThermostatServiceClient();
                break;
            case 9:
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(frame, "Invalid command!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }

        // Clear the input field after processing
        inputField.setText("");
    }

    // Main method to launch the manager
    public static void main(String[] args) {
        SmartWarehouseManager manager = new SmartWarehouseManager();
        manager.createAndShowGUI();
    }
}
