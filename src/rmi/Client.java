package rmi;

import rmi.animal.AnimalRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * Created by pietyszukm on 06.03.2018.
 */
public class Client {
    public static void main(String[] args) throws IOException, NotBoundException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Properties prop = new Properties();
        InputStream input = null;
        input = new FileInputStream("config.properties");
        prop.load(input);
        Registry registry = LocateRegistry.getRegistry(prop.getProperty("host"));
        if(prop.getProperty("which").equalsIgnoreCase("calculator")){
            runCalculator(registry);
        } else if (prop.getProperty("which").equalsIgnoreCase("animal")){
            runAnimal(registry);
        } else{
            System.out.println("No such option");
        }
    }

    private static void runCalculator(Registry registry) throws RemoteException, NotBoundException {
        Calculator calculator = (Calculator) registry.lookup("Calculator");
        BigDecimal x = BigDecimal.ONE;
        BigDecimal y = BigDecimal.TEN;
        System.out.println(MessageFormat.format("Addition: {0}, Subtraction: {1}, Multiplication: {2}, Division: {3}.",
                calculator.add(x,y), calculator.subtract(x,y), calculator.multiply(x,y), calculator.divide(x,y)));
    }

    private static void runAnimal(Registry registry) throws RemoteException, NotBoundException{
        AnimalRepository repository = (AnimalRepository) registry.lookup("Animal");
        System.out.println(repository.findAll());
    }
}
