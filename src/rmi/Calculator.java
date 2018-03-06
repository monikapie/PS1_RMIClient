package rmi;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * rmi.Calculator interface used in remote server
 */
public interface Calculator extends Remote {
    BigDecimal add(BigDecimal x, BigDecimal y) throws RemoteException;
    BigDecimal subtract(BigDecimal x, BigDecimal y) throws RemoteException;
    BigDecimal multiply(BigDecimal x, BigDecimal y) throws RemoteException;
    BigDecimal divide(BigDecimal x, BigDecimal y) throws RemoteException;
}
