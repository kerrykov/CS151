package aworld;

import java.awt.Dimension;

public class RandomWalk {

	public static void main(String[] args) { //main for random walk simulation
		AworldFactory factory = new AworldFactory(); //make the factory
		AworldFrame frame = new AworldFrame(factory); //make the frame
		frame.setMinimumSize(new Dimension(1000,500));  //set the frame size
		frame.display(); //display the frame
		World world = (World) frame.getModel(); //set the world
		world.setSimulation("RandomWalk"); //set the simulation type to random walk
	}
}