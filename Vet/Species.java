//Package imports
package Vet;
//RMI imports
import java.rmi.RemoteException;
import java.io.Serializable;

public class Species implements Serializable {

	//Attributes
	protected String name;
	
	//Constructors
	public Species() throws RemoteException {
		this.name = null;
	}
	public Species(String newName) throws RemoteException {
		this.name = newName;
	}
	
	//Getters and setters
	public String getName() throws RemoteException {
		return this.name;
	}
	public void setName(String newName) throws RemoteException {
		this.name = newName;
	}
}