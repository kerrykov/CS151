package framework;

import java.awt.event.*;
import java.io.*;
import java.util.Random;
import javax.swing.*;

public class Utilities {
	private static Random randomGenerator = new Random(System.currentTimeMillis());
	
	public static int nextInt(int highVal) { //next int method
		return randomGenerator.nextInt(highVal); //return the next random int
	}
	
	public static int randInt(int lowVal, int highVal) { //random int method
		return randomGenerator.nextInt(highVal - lowVal) + lowVal; //return a random int
	}
	
	public static boolean confirm(String q) { //confirm method
		int result = JOptionPane.showConfirmDialog(null, q, "choose one", JOptionPane.YES_NO_OPTION); //set the result
		return result == 1; //return the result
	}
	
	public static String ask(String q) { //ask method
		return JOptionPane.showInputDialog(null, q); //reutrn the pane
	}
	
	public static void inform(String message) { //inform method
		JOptionPane.showMessageDialog(null,message); //show the message
	}
	
	public static void inform(String[] information) { //inform method
		String informationString = ""; //make the string
		for(int i = 0; i < information.length; i++) { //for the length of the information
			informationString = informationString + "\n" + information[i]; //Set the information string
		}
		inform(informationString); //inform method with the information string
	}
	
	public static void error(Exception err) { //error method
		JOptionPane.showMessageDialog(null, err, "OOPS!", JOptionPane.ERROR_MESSAGE); //display the error message
	}
	
	public static void saveChanges(Model model) { //save changes method
		if (model.hasUnsavedChanges() && Utilities.confirm("Unsaved changes, do you want to continue?")) //if the model has unsaved changes and the user wants to save
			Utilities.save(model, false); //save the model
	}
	
	public static String getFileName(String fileName) { //get file name method
		JFileChooser fileChooser = new JFileChooser(); //make file chooser
		String nameResult = null; //set the result to null
		if (fileName != null) { //if there is a file name
           fileChooser.setCurrentDirectory(new File(fileName)); //set the directory
		}
		int returnValue = fileChooser.showOpenDialog(null); //set return value
		if(returnValue == JFileChooser.APPROVE_OPTION) { //if the return value
			nameResult= fileChooser.getSelectedFile().getPath(); //set the nameResult
		}
		return nameResult; //return the nameResult
	}
		
	public static void save(Model model, Boolean save) { //save method
		String fileName = model.getFileName(); //get the file name
		if (fileName == null || save) { //if the file name is null or save is true
			fileName = Utilities.getFileName(fileName); //set the file name
			model.setFileName(fileName); //est the file name
		}
		try { //try
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName)); //create a new output stream with the file
			model.setUnsavedChanges(false); //set unsaved changes
			outputStream.writeObject(model); //set the output stream
			outputStream.close(); //close the output stream
		} catch (Exception error) { //catch
			model.setUnsavedChanges(true); //set unsave changes true
			Utilities.error(error); //error
		}
	}
	
	public static Model open(Model model) { //open method
		saveChanges(model); //save changes to the model
		String fileName = Utilities.getFileName(model.getFileName()); //get the file name of the model
		Model modelNew = null; //set the new model to null
		try { //try
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName)); //make a new input stream with the file
			modelNew = (Model)inputStream.readObject(); //set the new model
			inputStream.close(); //close the input stream
		} catch (Exception error) { //catch
			Utilities.error(error); //error
		}
		return modelNew; //return the new model
	}
	
	public static JMenu makeMenu(String menuName, String[] menuItems, ActionListener listener) { //make menu method
		JMenu menu = new JMenu(menuName); //make a new menu
		for(int index = 0; index < menuItems.length; index = index + 1) { //for each item in the menu items
			JMenuItem menuItem = new JMenuItem(menuItems[index]); //make a new menu item
			menuItem.addActionListener(listener); //add an action listener
			menu.add(menuItem); //add the menu item to the menu
		}
		return menu; //return the menu
	}
}