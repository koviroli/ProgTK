package hu.unideb.inf.beadando;

import javafx.scene.image.Image;

/**
 * Arrow object that extends BowManGameObject
 * 
 * @author koviroli
 *
 */
public class Arrow extends BowManGameObject{

	private Image arrowImage;
	private double rotate;
	
	public void initalize(){
		this.setArrowImage(new Image("pictures/arrow_v1.png"));
		this.setPositionXY(50, 320);
	}
	
	public void setArrowImage(Image image){
		this.arrowImage = image;
	}
	
	public Image getArrowImage(){
		return this.arrowImage;
	}

	public double getRotate() {
		return rotate;
	}

	public void setRotate(double rotate) {
		this.rotate = rotate;
	}
	
	
	
}
