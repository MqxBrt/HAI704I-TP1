//Package imports
package Vet;
//Java imports
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IClinic extends Remote {
	
	//Getters and setters
	ArrayList<IAnimal> getPatients() throws RemoteException;
	void setPatients(ArrayList<IAnimal> newPatients) throws RemoteException;
	ArrayList<IClient> getClients() throws RemoteException;
	void setClients(ArrayList<IClient> newClients) throws RemoteException;
	
	//Name search
	IAnimal searchName(String name) throws RemoteException;
	
	//Add animal
	void addAnimal(String name, String ownerName, String speciesName, String breedName, String status) throws RemoteException;
    void addAnimal(String name, String ownerName, Species newSpecies, String breedName, String status) throws RemoteException;
	
	//Alert method
	void alertClients(int level) throws RemoteException;
	
	//Browse animals
	String browse() throws RemoteException;
	
	//Client methods
	void addClient(IClient newClient) throws RemoteException;
	void removeClient(IClient myClient) throws RemoteException;
}
