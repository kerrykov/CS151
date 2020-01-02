package aworld;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import framework.*;

public class AworldFrame extends AppFrame {
	
	public AworldFrame(AppFactory simulationFactory) { //aworld frame constructor
		super(simulationFactory); //super 
		JPanel simulationPanel = simulationFactory.makePanel(model, this); //create the panel for the model
		this.getContentPane().add(simulationPanel); //set the panel for the model
	}

	public Model getModel() { //get model method
		Model model = this.model; //get the model
		return model; //return the model
	}

	@Override
	public void actionPerformed(ActionEvent event) { //action performed method
		super.actionPerformed(event);		 //super
	}
}