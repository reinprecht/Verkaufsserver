

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server  extends UnicastRemoteObject implements ServerInterface{
    public static final long serialVersionUID=12;
    private int gesamtanzahl = 0;
    private ArrayList<ClientInterface> clients = new ArrayList<ClientInterface>();
    
    public Server() throws java.rmi.RemoteException {
        super(); //very important
        System.out.println("Server ist angelegt");
    }

    public static void main(String[] args) throws java.rmi.RemoteException {
        Registry reg = LocateRegistry.createRegistry(1099);
        Server s = new Server();
        reg.rebind("DemoServer",s);
    }

	@Override
	public int getAnzahl() throws RemoteException {
		// TODO Auto-generated method stub
		return this.gesamtanzahl;
	}

	@Override
	public void setGesamtanzahl(int anzahl) throws RemoteException {
		// TODO Auto-generated method stub
		this.gesamtanzahl += anzahl;
		anzahlVerteilen();
		
	}

	@Override
	public void anzahlVerteilen() throws RemoteException {
		// TODO Auto-generated method stub
		for (ClientInterface c : this.clients) {
			c.receiveMsg(this.gesamtanzahl);
		}
	}

	@Override
	public void login(ClientInterface client) {
		// TODO Auto-generated method stub
		this.clients.add(client);
	}
}
