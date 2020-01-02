package framework;
import java.awt.event.*;
import javax.swing.*;

public class AppFrame extends JFrame implements ActionListener {
	protected AppFactory factory;
	protected Model model;
	protected AppPanel panel;
	
	public AppFrame(AppFactory appFactory) { //app frame constructor
		this.factory = appFactory; //set the factory
		model = factory.makeModel(); //make the model
		setJMenuBar(createMenuBar()); //make the menu bar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set the exit
		setTitle(factory.getTitle());  //set the title
		setSize(500, 500); //set the size of the frame
	}
	
	public void display() {  //display method
		this.setVisible(true);  //set the visibility to true
		}
	
	public void setModel(Model model) { //set model method
		this.model.copy(model); //make a copy and set the model
	}
	
	protected JMenuBar createMenuBar() { //create menu bar method
		JMenuBar menuBar = new JMenuBar(); //new menu bar
		JMenu fileMenuBar = Utilities.makeMenu("File", new String[] {"New", "Save", "SaveAs", "Open", "Quit"}, this); //Set the commands in file
		menuBar.add(fileMenuBar); //add the file
		JMenu editMenuBar = Utilities.makeMenu("Edit", factory.getEditCommands(), this); //set the commands in edit
		menuBar.add(editMenuBar); //add the edit
		JMenu helpMenuBar = Utilities.makeMenu("Help", new String[] {"Help", "About"}, this); //set the commands in help
		menuBar.add(helpMenuBar); //add the help
		add(menuBar); //add the bar
		return menuBar; //return the bar
	}
	
	public void actionPerformed(ActionEvent ae) { //action performed method
		String command = ae.getActionCommand(); //get the command
		String thisCommand;
		if (command == "Save") { //if the command is save
			thisCommand = "Save"; //set the command 
			Utilities.save(model, false); //save the model
		} else if (command == "SaveAs") { //if the command is save as
			thisCommand = "SaveAs"; //set the command
			Utilities.save(model, true); //save the model
	     } else if (command == "Open") { //if the command is open
	    	 thisCommand = "Open"; //set the command
	        Model newModel = Utilities.open(model); //open the model
	        setModel(newModel); //set the model
	     } else if (command == "New") { //if he command is new
	    	 thisCommand = "New"; //set the command
	        Utilities.saveChanges(model); //save the model
	        setModel(factory.makeModel()); //make a new model
	        model.setUnsavedChanges(false); //unsaved changes
	     } else if (command == "Quit") { //if the command is quit
	    	 thisCommand = "Quit"; //set the command
	        Utilities.saveChanges(model); //save the changes
	        System.exit(1); //exit
	     } else if (command == "About") { //if the command is about
	    	 thisCommand = "About"; //set the command
	        Utilities.inform(factory.about()); //show the about
	     } else if (command == "Help") { //if the command is help
	    	 thisCommand = "Help"; //set the command
	        Utilities.inform(factory.getHelp()); //show the help
	     } else {
	        Command newCommand = factory.makeEditCommand(model, command); //make a new command
	        try {
	        	CommandProcessor.execute(newCommand); //try to execute the command
	        } catch(Exception e) {
	        	JOptionPane.showMessageDialog(this, e.getMessage(), "SimStation", JOptionPane.WARNING_MESSAGE); //give a warning
	        }
	     }
	}
}