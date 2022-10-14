//Package imports
package Vet;
//Java imports
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFollowUpFile extends Remote {

	//Getters and setters
	String getStatus() throws RemoteException;
	void setStatus(String newStatus) throws RemoteException;
}