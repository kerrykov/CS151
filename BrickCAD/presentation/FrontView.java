package presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import business.Brick;

public class FrontView extends BrickView {
	
	public FrontView(Brick brick) {
		super(brick);
	}

	public void paintComponent(Graphics gc) {
		// update height & width of canvas:
		double length = brick.getLength();
		double width = brick.getWidth();
		Graphics2D gc2d = (Graphics2D)gc;
		Rectangle2D.Double b = new Rectangle2D.Double(20, 20, length, width);
		gc2d.setColor(Color.red);
		gc2d.fill(b);
		gc2d.setColor(Color.black);
		gc2d.drawString("Front View", 15, 15);
	}

}
