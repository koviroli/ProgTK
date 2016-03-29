package hu.unideb.inf.beadando;

import javafx.scene.image.Image;


import java.io.IOException;

/**
 * Archer object that extends BowManGameObject
 * 
 * 
 * @author koviroli
 *
 */
public class Archer extends BowManGameObject {

	/* pullStrenhth is the what stregth with the archer pulls the bow to shoot. */
	private int pullStrength;

	/* The image of archer object */
	private Image archerBodyImage;
	private Image archerLeftArmImage;
	private Image archerRightArmImage;
	private double leftArmRotate, rightArmRotate;
	
	public void initalize() throws IOException {
		setArcherBodyImage( new Image("pictures/archer_image_v2.png") );
		setArcherLeftArmImage(new Image("pictures/left_arm.png"));
		setArcherRightArmImage(new Image("pictures/right_arm.png"));
		this.MoveTo(0, 250);
	}
	
	public int getPullStrength() {
		return pullStrength;
	}

	public void setPullStrength(int pullStrength) {
		this.pullStrength = pullStrength;
	}

	public Image getArcherBodyImage() {
		return archerBodyImage;
	}

	public void setArcherBodyImage(Image image) {
		this.archerBodyImage = image;
	}
	
	public Image getArcherLeftArmImage() {
		return archerLeftArmImage;
	}

	public void setArcherLeftArmImage(Image archerLeftArmImage) {
		this.archerLeftArmImage = archerLeftArmImage;
	}

	public Image getArcherRightArmImage() {
		return archerRightArmImage;
	}

	public void setArcherRightArmImage(Image archerRightArmImage) {
		this.archerRightArmImage = archerRightArmImage;
	}
	
	public void MoveTo(double x, double y){
		this.setPositionXY(x, y);
	}
	
	public void setLeftArmRotate(double rotate){
		this.leftArmRotate = rotate;
	}
	
	public void setRightArmRotate(double rotate){
		this.rightArmRotate = rotate;
	}
	
	public double getLeftArmRotate(){ 
		return this.leftArmRotate; 
	}
	
	public double getRightArmRotate(){ 
		return this.rightArmRotate; 
	}
	
}
