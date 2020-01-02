package presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import business.*;
import framework.Utilities;
import framework.*;

public class BrickFrame extends JFrame {

	private Brick model;
	private BrickPanel brickPanel;
	private FileController controller;

	public BrickFrame() {
		model = new Brick();
		brickPanel = new BrickPanel(model);
		Container cp = getContentPane();
		cp.add(brickPanel);
		controller = new FileController();
		
		//setJMenuBar(createMenuBar());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Brick CAD");  
		setSize(300, 150);
		pack();
	}
	
	protected JMenuBar createMenuBar() {
		   // create a menu bar containing File, Edit, View, and Help menus
			JMenuBar result = new JMenuBar();
			result.add(Utilities.makeMenu("F&ile", new String[] {"New", "Open", "Save", "SaveAs", "Quit"}, controller));
/*
			cmmds.add("Undo");
			cmmds.add("Redo");
			result.add(Utilities.makeMenu("E&dit", cmmds.toArray(new String[0]), new EditHandler()));
			java.util.List<String> views = factory.getViews();
			result.add(Utilities.makeMenu("V&iew", views.toArray(new String[0]), new ViewHandler()));
			result.add(Utilities.makeMenu("H&elp", new String[] {"Help", "About"}, this));
			*/
			return result;
		}

	public static void main(String[] args) {
		BrickFrame brickFrame = new BrickFrame();
		brickFrame.setVisible(true);
	}

	class FileController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			String cmmd = ae.getActionCommand();
			if (cmmd == "Save") {
				Utilities.save(model, false);
			} else if (cmmd == "SaveAs") {
				Utilities.save(model, true);
			} else if (cmmd == "Open") {
				model = (Brick)Utilities.open(model);
				brickPanel.setBrick(model);
			} else if (cmmd == "New") {
				Utilities.saveChanges(model);
				model = new Brick();
				brickPanel.setBrick(model);
			} else if (cmmd == "Quit") {
				Utilities.saveChanges(model);
				System.exit(1);
			} else if (cmmd == "Help") {
				//Utilities.informUser(factory.getHelp());
			} else if (cmmd == "About") {
				//Utilities.informUser(factory.about());
			} else {
				Utilities.error("Unrecognized command: " + cmmd);
			}

		}

	}


}
