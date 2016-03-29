package hu.unideb.inf.beadando;

import javafx.scene.image.Image;
import javafx.scene.shape.Line;

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
	
	private Line leftArm, rightArm;
	
	public void initalize() throws IOException {
		setArcherBodyImage( new Image("pictures/archer_image_v2.png") );
		setArcherLeftArmImage(new Image("pictures/left_arm.png"));
		setArcherRightArmImage(new Image("pictures/right_arm.png"));
		this.MoveTo(0, 250);
		//leftArm = new Line(); 
		//rightArm = new Line();
		//leftArm.setStrokeWidth(1.5);
		//rightArm.setStrokeWidth(1.5);
		//setDefaultLeftArm();
		//setDefaultRightArm();
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
	
	public double getLeftArmRotate(){ return this.leftArmRotate; }
	
	public double getRightArmRotate(){ return this.rightArmRotate; }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * setDefaultLeftArm function is set the default values of the archer's left arm.
	 */	
	public void setDefaultLeftArm(){
		this.leftArm.setStartX(102);
		this.leftArm.setStartY(400);
		this.leftArm.setEndX(180);
		this.leftArm.setEndY(340);
	}
	
	public void setLeftArmX(double value){
		this.leftArm.setEndX(value);
	}
	
	public void setLeftArmY(double value){
		this.leftArm.setEndY(value);
	}
	
	public double getLeftArmX(){
		return this.leftArm.getEndX();
	}
	
	public double getLeftArmY(){
		return this.leftArm.getEndY();
	}
	
	
	/**
	 * function is set the default values of the archer's right arm. 
	 */
	public void setDefaultRightArm(){
		this.rightArm.setStartX(102);
		this.rightArm.setStartY(400);
		this.rightArm.setEndX(180);
		this.rightArm.setEndY(450);
	}
	
	public void setRightArmX(double value){
		this.rightArm.setEndX(value);
	}
	
	public void setRightArmY(double value){
		this.rightArm.setEndY(value);
	}
	
	
	public double getRightArmX(){
		return this.rightArm.getEndX();
	}
	
	public double getRightArmY(){
		return this.rightArm.getEndY();
	}
	
	
	/**
	 * Gives back the left arm of the archer
	 * @return Line with archer's left arm's parameters
	 */
	public Line getLeftArm(){ return this.leftArm; }
	
	/**
	 * Gives back the right arm of the archer.
	 * 
	 * @return Line with archer's left arm's parameters
	 */
	public Line getRightArm(){ return this.rightArm; }

}
