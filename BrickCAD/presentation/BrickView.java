package presentation;

import javax.swing.*;
import business.*;

import java.awt.Color;
import java.awt.Dimension;
import java.util.*;


public class BrickView extends JComponent implements Observer {
	protected Brick brick;

	public BrickView(Brick brick) {
		super();
		this.brick = brick;
		brick.addObserver(this);
		setPreferredSize(new Dimension(200, 200));
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public void setBrick(Brick brick) {
		if (this.brick != null) this.brick.deleteObserver(this);
		this.brick = brick;
		this.brick.addObserver(this);
		repaint();
	}
	
	public void update(Observable subject, Object msg) {
		repaint(); // triggers call to paintComponent
	}

}
