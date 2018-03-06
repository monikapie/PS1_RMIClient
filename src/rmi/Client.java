package rmi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * Created by pietyszukm on 06.03.2018.
 */
public class Client {
    public static void main(String[] args) throws IOException, NotBoundException {
        Properties prop = new Properties();
        InputStream input = null;
        input = new FileInputStream("config.properties");
        prop.load(input);
        Registry registry = LocateRegistry.getRegistry(prop.getProperty("host"));
//        Registry registry = LocateRegistry.getRegistry("192.168.75.128");

        Calculator calculator = (Calculator) registry.lookup("Calculator");
        BigDecimal x = BigDecimal.ONE;
        BigDecimal y = BigDecimal.TEN;
        System.out.println(MessageFormat.format("Dodawanie: {0}, Odejmowanie: {1}, Mnożenie: {2}, Dzielenie: {3}.",
                calculator.add(x,y), calculator.subtract(x,y), calculator.multiply(x,y), calculator.divide(x,y)));
    }
}
