package hu.unideb.inf.beadando;

import java.io.IOException;

import javafx.scene.image.Image;

/**
 * Bow object that extends BowManGameObject
 * 
 * 
 * @author koviroli
 *
 */
public class Bow extends BowManGameObject{

	private Image bowImage;
	
	public void initalize() throws IOException {
		setBowImage(new Image("pictures/bow/bow_r_70pers.png"));
		this.setPositionXY(50, 300);
	}

	public Image getBowImage() {
		return bowImage;
	}

	public void setBowImage(Image bowImage) {
		this.bowImage = bowImage;
	}
	
	
	
	
}
