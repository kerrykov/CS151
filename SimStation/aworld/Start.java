package aworld;

import framework.*;
import simStation.Simulation;

public class Start extends Command {

	public Start(Model model) { //start constructor
		super(model); //super
	}

	@Override //OVerride from command
	public void execute() { //execute method
		Simulation simulation = (Simulation) model; //set the simulation
		simulation.start(); //start the simulation
	}
}