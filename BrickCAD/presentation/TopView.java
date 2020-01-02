package presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import business.Brick;

public class TopView extends BrickView {
	
	public TopView(Brick brick) {
		super(brick);
	}

	public void paintComponent(Graphics gc) {
		// update height & width of canvas:
		double height = brick.getHeight();
		double length = brick.getLength();
		Graphics2D gc2d = (Graphics2D)gc;
		Rectangle2D.Double b = new Rectangle2D.Double(20, 20, height, length);
		gc2d.setColor(Color.red);
		gc2d.fill(b);
		gc2d.setColor(Color.black);
		gc2d.drawString("Top View", 15, 15);
	}

}
