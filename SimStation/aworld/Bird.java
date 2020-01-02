package aworld;

import framework.*;

public class Bird extends Agent {

	private int velocity;

	public Bird(World world) { //bird constructor
		super(world); //super
		velocity = Utilities.randInt(1, 10); //set the velocity to a random int between 1 and 10
		int newRandHeadingVal = Utilities.randInt(0,Heading.values().length); //get the new random heading
		turn(Heading.values()[newRandHeadingVal]); //turn in the random Heading direction
	}

	@Override //Override from agent
	public void update() { //update method
		int neighborDist = 1; //set the allowed neighbor distance
		move(velocity); //move at the correct velocity
		Bird bird = (Bird) world.findNeighbor(this, neighborDist); //Find a neighboring bird
		while (bird == null) { //while the bird is null
			bird = (Bird)world.findNeighbor(this, neighborDist); //find a new neighboring bird
		}
		this.velocity = bird.getVelocity(); //set this bird's velocity to the velocity of the neighbor
		this.heading = bird.heading; //set this bird's heading to the heading of the neighbor
	}

	public int getVelocity() { //get velocity method
		return this.velocity; //return the velocity
	}
}