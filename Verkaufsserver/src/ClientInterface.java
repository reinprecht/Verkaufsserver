

import java.rmi.RemoteException;

public interface ClientInterface extends java.rmi.Remote {
    public void receiveMsg(int msg) throws RemoteException;
}