package aworld;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Observable;
import javax.swing.BorderFactory;
import framework.*;

public class SimView extends View {

	public SimView(Model model) { //sim view constructor
		super(model); //super
		World world = (World) model; //set the world
		setSize(new Dimension(world.SIZE,world.SIZE)); //set the size of the view
		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3, false)); //set the border of the view
	}

	@Override //OVerride from view
	public void update(Observable subject, Object message) { //update method
		SimView view = this; //set the view 
		view.repaint(); //repaint the view
	}

	@Override //Override from view
	public void paintComponent(Graphics graphics) { //paint component method
		Graphics2D graphics2dim = (Graphics2D)graphics; //set the graphics
		World simulation = (World)model; //set the world
		for (Agent agent: simulation.getAgentsList()) { //for each agent in the simulation
			AgentModel agentModel = new AgentModel((double)agent.getXAxis(), (double)agent.getYAxis(), 10.0, 10.0); //make a new agent
			agentModel.draw(graphics2dim); //draw the agent
		}
	}

	class AgentModel { //class for drawing the agents

		private Ellipse2D.Double agentModel;

		public AgentModel(Double xAxis, Double yAxis, Double width, Double height) { //agent model constructor
			agentModel = new Ellipse2D.Double(xAxis + .4 * width, yAxis + .4 * height, .4 * width, .4 * height); //make a new agent at the correct position
		}

		public void draw(Graphics2D graphics) { //draw method
			graphics.setColor(Color.red); //set the color to red
			graphics.fill(agentModel); //fill the agent with the red color
		}
	}
}