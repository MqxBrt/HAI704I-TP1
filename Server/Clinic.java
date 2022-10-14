//Package imports
package Server;
import Vet.*;
//Java imports
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Clinic extends UnicastRemoteObject implements IClinic {
	
	//Attributes
	protected ArrayList<IAnimal> patients;
	protected ArrayList<IClient> clients;
	
	//Constructors
	public Clinic() throws RemoteException {
		this.patients = new ArrayList<IAnimal>();
		this.clients = new ArrayList<IClient>();
	}
	public Clinic(ArrayList<IAnimal> newPatients, ArrayList<IClient> newClients) throws RemoteException {
		this.patients = newPatients;
		this.clients = newClients;
	}
	
	//Getters and setters
	public ArrayList<IAnimal> getPatients() throws RemoteException {
		return this.patients;
	}
	public void setPatients(ArrayList<IAnimal> newPatients) throws RemoteException {
		this.patients = newPatients;
	}
	public ArrayList<IClient> getClients() throws RemoteException {
		return this.clients;
	}
	public void setClients(ArrayList<IClient> newClients) throws RemoteException {
		this.clients = newClients;
	}
	
	//Name search
	public IAnimal searchName(String name) throws RemoteException {
		for (IAnimal animal : this.patients) {
			if (animal.getName().equals(name)) {
				return animal;
			}
		}
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        System.out.println("[" + LocalDateTime.now() + "] Name research");
		return new Animal();
	}
	
	//Animal methods
	public void addAnimal(String name, String ownerName, String speciesName, String breedName, String status) throws RemoteException {
		IAnimal newAnimal = new Animal(name, ownerName, new Species(speciesName), breedName, new FollowUpFile(status));
		this.patients.add(newAnimal);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        System.out.println("[" + LocalDateTime.now() + "] Animal added");
		if (this.patients.size() == 100 || this.patients.size() == 500 || this.patients.size() == 1000) {
			this.alertClients(this.patients.size());
		}
	}
    	public void addAnimal(String name, String ownerName, Species newSpecies, String breedName, String status) throws RemoteException {
		IAnimal newAnimal = new Animal(name, ownerName, newSpecies, breedName, new FollowUpFile(status));
		this.patients.add(newAnimal);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        System.out.println("[" + LocalDateTime.now() + "] Animal added");
		if (this.patients.size() == 100 || this.patients.size() == 500 || this.patients.size() == 1000) {
			this.alertClients(this.patients.size());
		}
	}
	
	//Alert method
	public void alertClients(int level) throws RemoteException {
		for (IClient client : this.clients) {
			client.alert(level);
		}
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        System.out.println("[" + LocalDateTime.now() + "] Clients signaled");
	}
	
	//Browse animals
	public String browse() throws RemoteException {
		String resString = "";
        if (this.patients.size() == 0) {
            return "No animal registered.";
        } 
		for (IAnimal animal : this.patients) {
			resString = resString + animal.getCompleteName() + "\n";
		}
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        System.out.println("[" + LocalDateTime.now() + "] Browsing animals");
		return resString;
	}
	
	//Client methods
	public void addClient(IClient newClient) throws RemoteException {
		this.clients.add(newClient);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        System.out.println("[" + LocalDateTime.now() + "] Client added");
	}
	public void removeClient(IClient myClient) throws RemoteException {
		for (IClient client : this.clients) {
			if (client.equals(myClient)) {
				this.clients.remove(client);
				break;
			}
		}
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        System.out.println("[" + LocalDateTime.now() + "] Client removed");
	}
}
