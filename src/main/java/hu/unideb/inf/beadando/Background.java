package hu.unideb.inf.beadando;

import javafx.scene.image.Image;

public class Background extends BowManGameObject {
	private Image background;
	
	public void initalize(){
		setBackgroundImage(new Image("pictures/background/bg_castles_800_600.png"));
		setPositionXY(0, -50);
	}

	public Image getBackgroundImage() {
		return background;
	}

	public void setBackgroundImage(Image background) {
		this.background = background;
	}
}
