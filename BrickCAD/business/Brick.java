package business;

import framework.*;

public class Brick extends Model {
	private double height, width, length;

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
		changed();
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
		changed();
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
		changed();
	}

	public Brick(double height, double width, double length) {
		super();
		this.height = height;
		this.width = width;
		this.length = length;
	}
	
	public Brick() {
		this(50.0, 60.0, 100.0);
	}

	@Override
	public String toString() {
		return "Brick [height=" + height + ", width=" + width + ", length=" + length + "]";
	}
	
	

}
