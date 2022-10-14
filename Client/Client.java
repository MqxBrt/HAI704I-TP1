//Package imports
package Client;
import Vet.*;
//Java imports
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Client extends UnicastRemoteObject implements IClient {
	
	protected Registry registry;
	protected IClinic clinic;
	
	//Constructor
	public Client() throws RemoteException {
		this.registry = null;
		this.clinic = null;
	};
	
	//Start method
	public void start() throws RemoteException {
		System.setProperty("java.security.policy", "./security.policy");
		SecurityManager securityManager = new SecurityManager();
		System.setSecurityManager(securityManager);
		try {
			this.registry = LocateRegistry.getRegistry(null);
			this.clinic = (IClinic) this.registry.lookup("myClinic");
			this.clinic.addClient(this);
			System.out.println("[CLIENT] Connected to the clinic");
		}
		catch (Exception e) {
			System.err.println("[CLIENT] Error - Failed to start client, exception: " + e.toString());
			e.printStackTrace();
		}
	}
	
	//Stop method
	public void stop() throws RemoteException {
		this.clinic.removeClient(this);
	}
	
	//Add animal
	public void addAnimal(String newName, String newOwnerName, String newSpecies, String newBreed, String Status) throws RemoteException {
		this.clinic.addAnimal(newName, newOwnerName, newSpecies, newBreed, Status);
		System.out.println("[SERVER] Animal added successfully");
	}
    public void addMonkey() throws RemoteException{
		Species monki = new Monkey();
		this.clinic.addAnimal("Beignet", "Maxime", monki, "Orangutan", "Chill");
	}
	
	//Browse
	public void browse() throws RemoteException {
		System.out.println(this.clinic.browse());
	}
	
	//Alert
	public void alert(int level) throws RemoteException {
		System.out.println("\n[SERVER] " + Integer.toString(level) + " patients were registered !\n");
	}
	
	//Search by name
	public void searchName(String myName) throws RemoteException {
		IAnimal myAnimal = this.clinic.searchName(myName);
		if (myAnimal.getName() == null) {
			System.out.println("[SERVER] Unknown animal");
		}
		else {
			System.out.println("[SERVER] " + myAnimal.getCompleteName());
		}
	}
}
