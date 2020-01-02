package framework;

public abstract class CommandProcessor {
	
	public static void execute(Command command){ //execute method
		command.execute(); //execute the command
		}
}