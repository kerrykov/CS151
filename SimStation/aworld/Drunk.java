package aworld;

import framework.*;

public class Drunk extends Agent {

	private int velocity = 5; 
	protected World world;

	public Drunk(World world) { //drunk constructor
		super(world); //super
	}

	@Override
	public void update() { //update method
		int stepCount = Utilities.randInt(1, velocity); //set the steps to a random int between 1 and the bird's velocity
		int headingValRand = Utilities.randInt(0, Heading.values().length); //get the random heading
		Heading newHeading = Heading.values()[headingValRand]; //set a new random heading
		turn(newHeading); //turn towards the new heading
		move(stepCount); //move the new number of steps
	}
}