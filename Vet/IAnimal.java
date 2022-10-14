//Package imports
package Vet;
//Java imports
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAnimal extends Remote {
	
	//Getters
	String getName() throws RemoteException;
	String getOwnerName() throws RemoteException;
	Species getSpecies() throws RemoteException;
	String getBreed() throws RemoteException;
	IFollowUpFile getFollowUpFile() throws RemoteException;
	
	//Setters
	void setName(String newName) throws RemoteException;
	void setOwnerName(String newOwnerName) throws RemoteException;
	void setSpecies(Species newSpecies) throws RemoteException;
	void setBreed(String newBreed) throws RemoteException;
	void setFollowUpFile(IFollowUpFile newFollowUpFile) throws RemoteException;
	
	//Complete name
	String getCompleteName() throws RemoteException;
	void displayCompleteName() throws RemoteException;
}
