package com.jkuat.cat.q5;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            TemperatureConverterImpl service = new TemperatureConverterImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("TempConverter", service);
            System.out.println("Server ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}