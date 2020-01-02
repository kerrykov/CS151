package presentation;

import javax.swing.*;
import business.*;
import java.awt.*;
import control.*;

public class BrickPanel extends JPanel {
	private Brick brick;
	private JTextField heightField, widthField, lengthField;
	private BrickView sideView, topView, frontView;
	private BrickController controller;
	
	public BrickPanel(Brick brick) {
		super();
		this.brick = brick;
		controller = new BrickController(brick);
		
		heightField = new JTextField("" + brick.getHeight(), 10);
		heightField.setActionCommand("Set Height");
		heightField.addActionListener(controller);
		widthField = new JTextField("" + brick.getWidth(), 10);
		widthField.setActionCommand("Set Width");
		widthField.addActionListener(controller);
		lengthField = new JTextField("" + brick.getLength(), 10);
		lengthField.setActionCommand("Set Length");
		lengthField.addActionListener(controller);
		
		this.setLayout(new GridLayout(2, 2));
		
		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(3, 2));
		
		JPanel p = new JPanel();
		p.add(new JLabel("Set Height"));
		fields.add(p);
		
		p = new JPanel();
		p.add(heightField);
		fields.add(p);
		
		p = new JPanel();
		p.add(new JLabel("Set Width"));
		fields.add(p);
		
		p = new JPanel();
		p.add(widthField);
		fields.add(p);
		
		p = new JPanel();
		p.add(new JLabel("Set Length"));
		fields.add(p);
		
		p = new JPanel();
		p.add(lengthField);
		fields.add(p);
		
		this.add(fields);
		
		sideView = new SideView(brick);
		topView = new TopView(brick);
		frontView = new FrontView(brick);
		
		this.add(sideView);
		this.add(topView);
		this.add(frontView);
	}
	
	public void setBrick(Brick brick) {
		widthField.setText("" + brick.getWidth());
		lengthField.setText("" + brick.getLength());
		heightField.setText("" + brick.getHeight());
		sideView.setBrick(brick);
		frontView.setBrick(brick);
		topView.setBrick(brick);
	}
}
