package control;

import java.awt.event.*;
import business.*;
import javax.swing.*;
import framework.*;

public class BrickController implements ActionListener {

	private Brick brick;

	public BrickController(Brick brick) {
		super();
		this.brick = brick;
	}

	public void actionPerformed(ActionEvent ae) {
		JTextField source = (JTextField)ae.getSource();
		String cmmd = ae.getActionCommand();
		try {
			double dim = Double.valueOf(source.getText());
			if (dim <= 0) {
				if (cmmd == "Set Height") source.setText("" + brick.getHeight());
				else if (cmmd == "Set Width") source.setText("" + brick.getWidth());
				else if (cmmd == "Set Length") source.setText("" + brick.getLength());
				Utilities.error("Dimensions must be positive");
			} else {
				if (cmmd == "Set Height") brick.setHeight(dim);
				else if (cmmd == "Set Width") brick.setWidth(dim);
				else if (cmmd == "Set Length") brick.setLength(dim);
			}
		} catch (NumberFormatException e) {
			if (cmmd == "Set Height") source.setText("" + brick.getHeight());
			else if (cmmd == "Set Width") source.setText("" + brick.getWidth());
			else if (cmmd == "Set Length") source.setText("" + brick.getLength());
			Utilities.error("Dimensions must be numeric");
		}

		//System.out.println("" + brick);
	}


}
