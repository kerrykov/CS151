package aworld;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import framework.AppPanel;
import framework.Model;
import simStation.Simulation;

public class AworldPanel extends AppPanel {

	JLabel simClockField; //label for the clock

	public AworldPanel(Model model, ActionListener al) { //aworld panel constructor
		super(model, al); //super
		World simulation = (World) model; //set the model
		setLayout(new GridLayout(1, 2)); //set the grid layout, one row, two columns
		JPanel simControlPanel = new JPanel(); //make a sim control panel
		simControlPanel.setLayout(new GridLayout(5, 1)); //simcontrol grid layout, five rows, one column
		JPanel simPanelClock = new JPanel(new FlowLayout(FlowLayout.CENTER)); //CLOCK
		JLabel simClockLabel = new JLabel("Clock: "); //make the label
		simClockField = new JLabel(Long.toString(simulation.getSimulationClock())); //set the label
		simPanelClock.add(simClockLabel); //add the label
		simPanelClock.add(simClockField); //add the field
		simControlPanel.add(simPanelClock); //add the clock
		JPanel simPanelStart = new JPanel(new FlowLayout(FlowLayout.CENTER)); // START BUTTON
		JButton simButtonStart = new JButton("Start"); //make the start button
		simButtonStart.addActionListener(al); //add the action listener
		simPanelStart.add(simButtonStart); //add the button to the panel
		simControlPanel.add(simPanelStart); //add the panel to the control panel
		JPanel simPanelSuspend = new JPanel(new FlowLayout(FlowLayout.CENTER)); //SUSPEND BUTTON
		JButton simButtonSuspend = new JButton("Suspend"); //make the suspend button
		simButtonSuspend.addActionListener(al); //add the action listener
		simPanelSuspend.add(simButtonSuspend); //add the button to the panel
		simControlPanel.add(simPanelSuspend); //add the panel to the control panel
		JPanel simPanelResume = new JPanel(new FlowLayout(FlowLayout.CENTER)); //RESUME BUTTON
		JButton simButtonResume = new JButton("Resume"); //make the resume button
		simButtonResume.addActionListener(al); //add the actionlistener
		simPanelResume.add(simButtonResume); //add the button to the panel
		simControlPanel.add(simPanelResume); //add the panel to the contro panel
		JPanel simPanelStop = new JPanel(new FlowLayout(FlowLayout.CENTER)); //STOP BUTTON
		JButton simButtonStop = new JButton("Stop"); //make the stop button
		simButtonStop.addActionListener(al); //add the action listener
		simPanelStop.add(simButtonStop); //add the button to thepanel
		simControlPanel.add(simPanelStop); //add the panel to the control panel
		JPanel simViewPanel = new JPanel(); //make the view panel
		simViewPanel.setLayout(new GridLayout()); //set to a grid layout
		simViewPanel.add(new SimView(model)); //add the sim view to the panel
		this.add(simControlPanel); //add the control panel to the world panel
		this.add(simViewPanel); //add the view panel to the world panel
	}

	@Override //Override app panel
	public void update(Observable subject, Object message) { //update method
		super.update(subject, message); //super
		Simulation  simulation = (Simulation) model; //set the simulation
		simClockField.setText(Long.toString(simulation.getSimulationClock())); //set the clock text
	}
}