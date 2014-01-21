

import java.rmi.RemoteException;

public interface ServerInterface extends java.rmi.Remote {
    public int getAnzahl() throws RemoteException;
    public void setGesamtanzahl(int anzahl) throws RemoteException;
    public void anzahlVerteilen() throws RemoteException;
    public void login(ClientInterface client) throws RemoteException;
}
