package aworld;

import framework.*;
import simStation.Simulation;

public class Suspend extends Command {

	public Suspend(Model model) { //suspend constructor
		super(model); //super
	}

	@Override //Override from command
	public void execute() { //execute method
		Simulation simulation = (Simulation) model; //set the simulation
		simulation.suspend(); //suspend the simulation
	}
}