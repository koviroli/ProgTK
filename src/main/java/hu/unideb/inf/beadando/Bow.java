package hu.unideb.inf.beadando;

import javafx.scene.image.Image;

/**
 * Bow object that extends BowManGameObject
 * 
 * 
 * @author koviroli
 *
 */
public class Bow extends BowManGameObject{

	private double Rotate;
	private Image bowImage;
	
	public void initalize(){
		setBowImage(new Image("pictures/bow_r_70pers.png"));
		this.setPositionXY(50, 300);
	}

	public double getRotate() {
		return Rotate;
	}

	public void setRotate(double rotate) {
		Rotate = rotate;
	}

	public Image getBowImage() {
		return bowImage;
	}

	public void setBowImage(Image bowImage) {
		this.bowImage = bowImage;
	}
	
	
	
	
}
