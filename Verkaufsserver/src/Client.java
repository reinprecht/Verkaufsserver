

import java.io.Console;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Client extends UnicastRemoteObject implements ClientInterface{
	private static final long serialVersionUID = 1L;

	public Client() throws java.rmi.RemoteException {
		super();
	}
	
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("localhost",1099);
        ServerInterface server = (ServerInterface)reg.lookup("DemoServer");
        
        Client client = new Client();
        server.login(client);
        
        Scanner s = new Scanner(System.in);
        System.out.println("Bisher wurden Stück verkauft:"+ " " + server.getAnzahl());
        System.out.println("Wie viele Stück haben Sie verkauft?");
        String msg;
        while ((msg = s.nextLine()) != null) {
            server.setGesamtanzahl(Integer.parseInt(msg));        	
        }
    }

	@Override
	public void receiveMsg(int msg){
		System.out.println("Bisher wurden Stück verkauft:"+ " " + msg);
        System.out.println("Wie viele Stück haben Sie verkauft?");
	}
   
}
