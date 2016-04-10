package hu.unideb.inf.beadando;

import java.io.IOException;

import javafx.scene.image.Image;

/**
 * Arrow object that extends BowManGameObject
 * 
 * @author koviroli
 *
 */
public class Arrow extends BowManGameObject{

	private Image arrowImage;
	
	public void initalize() throws IOException {
		this.setArrowImage(new Image("pictures/arrow/arrow_v1.png"));
		this.setPositionXY(50, 320);
	}
	
	public void setArrowImage(Image image){
		this.arrowImage = image;
	}
	
	public Image getArrowImage(){
		return this.arrowImage;
	}

	
}
