package framework;
import java.awt.event.ActionListener;

public interface AppFactory {
	
	public Model makeModel(); //make model method
	
	public AppPanel makePanel(Model model, ActionListener listener); //make panel method
	
	public String[] getEditCommands(); //get commands method
	
	public Command makeEditCommand(Model model, String type); //make command method
	
	public String getTitle(); //get title method
	
	public String getHelp(); //get help method
	
	public String about(); //about method
}