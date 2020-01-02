package aworld;

import framework.*;
import simStation.Simulation;

public class Resume extends Command {

	public Resume(Model model) { //resume constructor
		super(model); //super
	}

	@Override //Override from command
	public void execute() { //execute method
		Simulation simulation = (Simulation) model; //set the simulation
		simulation.resume(); //resume the simulation
	}
}