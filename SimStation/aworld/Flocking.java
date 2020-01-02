package aworld;

import java.awt.Dimension;

public class Flocking {

	public static void main(String[] args) { //main for the flocking simulation
		AworldFactory factory = new AworldFactory(); //make a new factory
		AworldFrame frame = new AworldFrame(factory); //make a new frame
		frame.setMinimumSize(new Dimension(1000,500)); //set the size to the correct dimension
		frame.display(); //display the frame
		World world = (World) frame.getModel(); //make the new world
		world.setSimulation("Flocking"); //set the simulation to type flocking
	}
}