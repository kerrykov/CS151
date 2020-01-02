package framework;
import java.util.*;
import java.io.*;

public abstract class Model extends Observable implements Serializable {
	private String name;
	private boolean unsavedChanges;
	private static final long serialVersionUID = 1L;

	public Model(String name) { //Model constructor
		this.name = name; //set the file name
		unsavedChanges = false; //set unsaved changes
	}
	
	public Model() { //blank model constructor 
		this(""); 
		}
	
	public void copy(Model model) { //copy method
		name = model.getFileName(); //get the file name
		changed(); //set changed
		unsavedChanges = false; //set unsaved changes
	}
	
	public void changed() { //changed method
		this.setUnsavedChanges(true); //set unsavedchanges
		this.setChanged(); //set changed
		this.notifyObservers(); //notify observers
	}
	
	public boolean hasUnsavedChanges() { //unsaved changes method
		boolean returnUnsavedChanges = unsavedChanges;
		return returnUnsavedChanges; //return unsaved changes
	}
	
	public void setUnsavedChanges(boolean unsavedChanges) { //set unsaved changes method
		this.unsavedChanges = unsavedChanges; //set unsavedChanges
	}
	
	public String getFileName() { //get file name method
		String returnName = this.name;
		return returnName; //return the file name
	}
	
	public void setFileName(String name) { //set the file name
		this.name = name; //set file name
	}
}