package aworld;

import framework.*;
import simStation.Simulation;

public class Stop extends Command {

	public Stop(Model model) { //stop constructor
		super(model); //super
	}

	@Override //Override from command
	public void execute() { //execute method
		Simulation simulation = (Simulation) model; //set the simulation
		simulation.stop(); //stop the simulation
	}
}