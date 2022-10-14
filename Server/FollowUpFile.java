//Package imports
package Server;
import Vet.IFollowUpFile;
//Java imports
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FollowUpFile extends UnicastRemoteObject implements IFollowUpFile {

	//Attributes
	protected String status;
	
	//Constructors
	public FollowUpFile() throws RemoteException {
		this.status = null;
	}
	public FollowUpFile(String newStatus) throws RemoteException {
		this.status = newStatus;
	}
	
	//Getters and setters
	public String getStatus() throws RemoteException {
		return this.status;
	}
	public void setStatus(String newStatus) throws RemoteException {
		this.status = newStatus;
	}
}