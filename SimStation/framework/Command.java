package framework;

public abstract class Command {
	protected Model model;

	abstract public void execute(); //execute method
	
	public Command(Model model) { //command method
		this.model = model; //set the model
	}
}