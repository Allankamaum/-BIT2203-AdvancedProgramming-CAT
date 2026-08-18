import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            TemperatureConverter stub = (TemperatureConverter) registry.lookup("TempConverter");
            double fahrenheit = stub.celsiusToFahrenheit(25);
            System.out.println("25°C = " + fahrenheit + "°F");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}