package framework;

import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import javax.swing.JPanel;

public class AppPanel extends JPanel implements Observer {
	protected Model model;
	protected ActionListener al;
	protected Set<View> panelViews;

	public AppPanel(Model model, ActionListener al) { //app panel constructor
		panelViews = new HashSet<View>(); //create the views
		setModel(model); //set the model
		this.al = al; //set the listener
	}
	
	public void update(Observable subject, Object message) { //update method
	}
	
	public void setModel(Model model) { //set model method
		if (this.model != null) {
			this.model.deleteObserver(this); //if the model is null then delete the observer
		}
		this.model = model; //set the model
		if (this.model != null) {
			this.model.addObserver(this); //if the model is not null then add the observer
		}
		for(View view: panelViews) {
			view.setModel(model); //for every view, set the model
		}
	}
	
	public void add(View newView) { //add method
		super.add(newView); //add the view
		panelViews.add(newView); //add the view to views
	}
}