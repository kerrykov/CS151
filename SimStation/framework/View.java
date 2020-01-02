package framework;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JComponent;

public abstract class View extends JComponent implements Observer{
	protected Model model;

	public View(Model model) { //view constructor
		setModel(model); //set the model
	}
	
	public View() {  //null view constructor
		this(null); // set the model
	}
	
	public void update(Observable subject, Object message) { //update method
		repaint(); //repaint the method
	}
	
	public void setModel(Model model) { //set model method
		if (this.model != null) this.model.deleteObserver(this); //if the model is not null, delete the observer
			this.model = model; //set the model
		if (this.model != null) { //if the model is not null
			this.model.addObserver(this); //add observer
			this.update(model, null); // update the model
		}
	}
}