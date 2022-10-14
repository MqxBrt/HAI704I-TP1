//Package imports
package Vet;
//Java imports
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {
	//Methods
	void start() throws RemoteException;
	void stop() throws RemoteException;
	void addAnimal(String newName, String newOwnerName, String newSpecies, String newBreed, String Status) throws RemoteException;
    void addMonkey() throws RemoteException;
	void browse() throws RemoteException;
	void alert(int level) throws RemoteException;
	void searchName(String myName) throws RemoteException;
}
