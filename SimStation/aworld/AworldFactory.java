package aworld;

import java.awt.event.ActionListener;
import framework.*;

public class AworldFactory implements AppFactory {
	
	private String appCommand;
	
	@Override //Override app factory
	public Model makeModel() { //make model method
		World world = new World(); //create a new world 
		return world; //return the new world
	}

	@Override //Override app factory
	public AppPanel makePanel(Model model, ActionListener al) { //make panel method
		AworldPanel aworldPanel = new AworldPanel(model, al); //make a new aworld panel
		return aworldPanel; //return the new aworld panel
	}

	@Override //Override app factory
	public String[] getEditCommands() { //edit commands method
		String[] editCommands = {"Start", "Suspend", "Resume", "Stop"}; //Set the edit commands
		return editCommands; //return the edit commands
	}

	@Override //OVerride app factory
	public Command makeEditCommand(Model model, String command) { //make edit commands method
		if(command == "Start") { //if the command is a start command
			appCommand = "Start"; //Set the app command
			return new Start(model); //start the model
		}else if(command == "Resume") { //if the command is a resume command
			appCommand = "Resume"; //set the app command
			return new Resume(model); //resume the model
		}else if(command == "Suspend") { //if the command is a suspend command
			appCommand = "Suspend"; //set the app command
			return new Suspend(model); //suspend the model
		}else if(command == "Stop") { //if the command is a stop command
			appCommand = "Stop"; //set the app command
			return new Stop(model); //stop the model
		}
		return null; //return null if none
	}

	@Override //Override app factory
	public String getTitle() { //get title method
		String titleString = "SimStation"; //set the title return string
		return titleString; //return the title
	}

	@Override //Override app factory
	public String getHelp() { //get help method
		String helpString = "Select Start to begin."; //set the help return string
		return helpString; //return message
	}
	
	@Override //Override app factory
	public String about() { //about method
		String aboutString = "SimStation"; //Set the about return string
		return aboutString; //return simstation (project title)
	}
}