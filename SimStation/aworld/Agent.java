package aworld;

import java.io.Serializable;
import framework.Utilities;

abstract public class Agent implements Serializable {

	protected int xAxis; //x position
	protected int yAxis; //y position
	protected World world; //the world
	protected Heading heading; //the heading

	public Agent(World world) { //agent constructor
		this.world = world; //set the world
		xAxis = Utilities.randInt(0, world.SIZE); //set the x position to a random int in the world
		yAxis = Utilities.randInt(0, world.SIZE); //set the y position to a random int in the world
	}

	public void move(int numSteps) { //move method
		if (heading == Heading.NORTH) { //if the bird is going North
			yAxis = yAxis + numSteps; //add the number of steps to the y position
			if (yAxis >= world.SIZE) { //Check if the bird has gone off the screen
				yAxis = 0; //if so, wrap around
			}
			else { //else
				heading = Heading.NORTH; //keep the heading North
			}
		}
		else if (heading == Heading.SOUTH) { // if the bird is going South
			yAxis = yAxis - numSteps; //subtract the number of steps from the y position
			if (yAxis < 0) { //Check if the bird has gone off the screen
				yAxis = world.SIZE; //if so, wrap around
			} else { //else
				heading = Heading.SOUTH; //keep the heading South
			}
		}
		else if (heading == Heading.EAST) { // if the bird is going East
			xAxis = xAxis + numSteps; //add the number of steps to the x position
			if (xAxis >= world.SIZE) { //Check if the bird has gone off the screen
				xAxis = 0; //if so, wrap around
			} else { //else
				heading = Heading.EAST; //keep the heading East
			}
		}
		else if (heading == Heading.WEST) { //if the bird is going West
			xAxis = xAxis - numSteps; //subtract the number of steps from the x position
			if (xAxis < 0) { //Check if the bird has gone off the screen
				xAxis = world.SIZE; //if so, wrap around
			} else { //else
				heading = Heading.WEST; //keep the heading West
			}
		}
	}

	public void turn(Heading heading) { //turn method
		Heading currentHeading = this.heading; //get the current heading
		if (currentHeading != heading) { //if the headings are not the same
			currentHeading = heading; //set the heading to the new heading
		}
		this.heading = currentHeading; //set the heading to the correct heading
	}

	public int getXAxis() { //get the x axis position
		return this.xAxis; //return the position
	}

	public int getYAxis() { //get the y axis position
		return this.yAxis; //return the position
	}

	abstract public void update(); //abstract update method
}