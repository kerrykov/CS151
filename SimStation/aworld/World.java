package aworld;

import java.util.ArrayList;
import framework.Utilities;
import simStation.Simulation;

public class World extends Simulation {

	public int SIZE = 500;
	private String worldName = "RandomWalk";
	private ArrayList<Agent> agentsList;

	public World() { //world constructor
		super(); //super
		agentsList = new ArrayList<Agent>(); //new agents array list
	}

	public void update() { //update method
		for (Agent agent: getAgentsList()) { //for each agent in the simulation
			agent.update();  //update
		}
	}

	public void setSimulation(String name) { //set simulation method
		agentsList.clear(); //clear the agents array list
		if (name == "RandomWalk") { //if the simulation is random walk
			int listSize = 0; //Agent list size
			for (int index = 0; index <= SIZE; index = index + 1) { //for 0 to less than or equal to the size of the model
				listSize = agentsList.size(); //set the list size
				agentsList.add(new Drunk(this)); //add a new drunk to the agents array list
			}
		} else if (name == "Flocking") { //if the simulation is flocking
			int listSize = 0; //agent list size
			for (int index = 0; index <= SIZE; index = index + 1) { //for 0 to less than or equal to the size of the model
				listSize = agentsList.size(); //set the list size
				agentsList.add(new Bird(this)); //add a new bird to the agents array list
			}
		} else { //else
			agentsList = null; //set the agent list to null
		}
	}

	public ArrayList<Agent> getAgentsList() { //get agents list method
		return agentsList; //return the agents array list
	}

	public synchronized Agent findNeighbor(Agent agent, int bounds) { //find neighbor method
		int beginPoint = Utilities.randInt(0, agentsList.size() - 1); //set the beginning point to a random int between 0 and the size of the agents list minus 1
		for (int index = beginPoint; index < agentsList.size(); index = index + 1) { //for the beginning for to less than the size of the agents list
			Agent randAgent = agentsList.get(index); //find a random agent from the list
			int newXAxis = (randAgent.getXAxis() - agent.getXAxis()); //find the x distance
			int newYAxis = (randAgent.getYAxis() - agent.getYAxis()); //find the y distance
			int totalDistance = (int) Math.sqrt(newXAxis^2 + newYAxis^2); //find the total distance
			if (totalDistance <= bounds) { //if the distance is less than the bounds
				return randAgent; //return the random agent
			} else { //else
				randAgent = null; //set the random agent to null
			}
		}
		return null; //else return a null agent
	}
}