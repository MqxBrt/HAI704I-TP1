//Package imports
package Server;
import Vet.*;
//Java imports
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Animal extends UnicastRemoteObject implements IAnimal {

	//Attributes
	protected String name;
	protected String ownerName;
	protected Species species;
	protected String breed;
	protected FollowUpFile followupfile;
	
	//Constructors
	public Animal() throws RemoteException {
		this.name = null;
		this.ownerName = null;
		this.species = new Species();
		this.breed = null;
		this.followupfile = new FollowUpFile();
	}
	public Animal(String newName, String newOwnerName, Species newSpecies, String newBreed, FollowUpFile newFollowUpFile) throws RemoteException {
		this.name = newName;
		this.ownerName = newOwnerName;
		this.species = newSpecies;
		this.breed = newBreed;
		this.followupfile = newFollowUpFile;
	}
	
	//Getters
	public String getName() throws RemoteException {
		return this.name;
	}
	public String getOwnerName() throws RemoteException {
		return this.ownerName;
	}
	public Species getSpecies() throws RemoteException {
		return (Species) this.species;
	}
	public String getBreed() throws RemoteException {
		return this.breed;
	}
	public IFollowUpFile getFollowUpFile() throws RemoteException {
		return (IFollowUpFile) this.followupfile;
	}
	//Setters
	public void setName(String newName) throws RemoteException {
		this.name = newName;
	}
	public void setOwnerName(String newOwnerName) throws RemoteException {
		this.ownerName = newOwnerName;
	}
	public void setSpecies(Species newSpecies) throws RemoteException {
		this.species = (Species) newSpecies;
	}
	public void setBreed(String newBreed) throws RemoteException {
		this.breed = newBreed;
	}
	public void setFollowUpFile(IFollowUpFile newFollowUpFile) throws RemoteException {
		this.followupfile = (FollowUpFile) newFollowUpFile;
	}
	
	//Complete name
	public String getCompleteName() throws RemoteException {
		return "Name: " + this.name + ", Owner: " + this.ownerName + ", Species: " + this.species.getName() + ", Breed: " + this.breed + ", Follow up file status: " + this.followupfile.getStatus();
	}
	public void displayCompleteName() throws RemoteException {
		System.out.println("Name: " + this.name + ", Owner: " + this.ownerName + ", Species: " + this.species.getName() + ", Breed: " + this.breed + ", Follow up file status: " + this.followupfile.getStatus());
	}
}
