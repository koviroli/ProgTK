package hu.unideb.inf.beadando;

public class BowManGameObject {

	private double positionX, positionY;
	
	public BowManGameObject() {
		this(0.0, 0.0);
	}
	
	public BowManGameObject(double positionX, double positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	
	public void setPositionXY(double positionX, double positionY){
		this.positionX = positionX;
		this.positionY = positionY;
	}
}
