
/*
 * Created a class to  represent thermostat readings.
 * It contains the temperature value and provides methods to access it.
 */
public class ThermostatReading {


    // Stores the temperature value
    private double temperature;


    // Constructor to initialize the temperature
    public ThermostatReading(double temperature) {
        this.temperature = temperature;
    }


    // Getter method to access the temperature
    public double getTemperature() {
        return temperature;
    }
}
