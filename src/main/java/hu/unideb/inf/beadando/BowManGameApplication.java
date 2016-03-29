package hu.unideb.inf.beadando;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/**
 * BowManGameApplication that responsible for the application.
 * In this class we manage the graphical user interface and the whole game.
 * 
 * 
 * @author koviroli
 *
 */
public class BowManGameApplication extends Application {

	//////////////////////////////////////////
	//
	// This is the game declaration section
	//
	//////////////////////////////////////////
	private final String WindowTitle = "BowManGame (created by Kovács Roland))";
	private final double WindowWidth = 800;
	private final double WindowHeigth = 600;
	
	private final Archer archer = new Archer();
	private final Bow bow = new Bow();
	private final Background background = new Background();
	
	private final Canvas backgroundCanvas = new Canvas(WindowWidth, WindowHeigth);
	private final Canvas bowCanvas = new Canvas(WindowWidth, WindowHeigth);
	private final Canvas archerCanvas = new Canvas(WindowWidth, WindowHeigth);

	private final GraphicsContext backgroundGc = backgroundCanvas.getGraphicsContext2D();
	private final GraphicsContext bowGc = bowCanvas.getGraphicsContext2D();
	private final GraphicsContext archerGc = archerCanvas.getGraphicsContext2D();
	
	private Line aimLine;
	private Text strengthText = new Text();
	private Text angleText = new Text();
	private double strengthStartX, strengthStartY;
	private double angleX2, angleY2;
	
	//////////////////////////////////////////
	//
	// This is the login screen declaration section
	//
	//////////////////////////////////////////
	Button button = new Button();
	StackPane stackPaneRoot = new StackPane();
	
	
	/* This method refresh the scene, by redraw everything*/
	public void refreshScene(){
		
		backgroundGc.clearRect(0, 0, WindowWidth, WindowHeigth);
		bowGc.clearRect(0, 0, WindowWidth, WindowHeigth);
		archerGc.clearRect(0, 0, WindowWidth, WindowHeigth);
	}
	
	private void drawObjects() {
		backgroundGc.drawImage(background.getBackgroundImage(), background.getPositionX(), background.getPositionY());
		bowGc.drawImage(bow.getBowImage(), bow.getPositionX() , bow.getPositionY());
		archerGc.drawImage(archer.getArcherImage(), archer.getPositionX(), archer.getPositionY());
	}
	
	/**
	 * Calculating the gaussian distance of two vectors A and B.
	 * @param Ax is the A vector's x coordinate
	 * @param Ay is the A vector's y coordinate
	 * @param Bx is the B vector's x coordinate
	 * @param By is the B vector's y coordinate
	 * @return the gaussian distance of A and B vector
	 */
	private double calculateDistance(double Ax, double Ay, double Bx, double By){
		return  Math.sqrt( Math.pow(Ax-Bx, 2) + Math.pow(Ay-By, 2)) ;
	}
	
	/**
	 * @param x1 A vector's x coordinate
	 * @param y1 A vector's Y coordinate
	 * @param x2 B vector's x coordinate
	 * @param y2 B vector's y coordinate
	 * @return the angle of two vectors
	 */
	
	public float getAngle(double x1, double y1, double x2, double y2) {
	    float angle = -(float) Math.toDegrees(Math.atan2(y2 - y1 , x2 - x1   ));

	    return angle;
	}
	
	private void setStrenghTextNull(){
		strengthText.setText("");
	}
	
	private void setAngleTextNull(){
		angleText.setText("");
	}
	
	//Start of the application
	@Override
	public void start(final Stage theStage) throws Exception {
		Group root = new Group();
		final Scene gameScene = new Scene(root);
		aimLine = new Line();
		
		////////////////////////////////////////
		//		Initalize the game objects
		////////////////////////////////////////
		archer.initalize();
		bow.initalize();
		background.initalize();
    	aimLine.setStrokeWidth(0.2f);
    	
    	Scene loginScene = new Scene(stackPaneRoot, 480, 240);
    	button.setText("START");
    	
		new AnimationTimer() {	
			@Override
			public void handle(long now) {
		
				refreshScene();
				
				drawObjects();			
			}

		}.start();
		
		/**
		 * This event handle that when the user keeps pushing the mouse button.
		 * It's the start of the shot, after this part we measure the power of shot, with
		 * dragging the mouse and when the mouse click released the shot released too.
		 */
		gameScene.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {            
                if (e.getClickCount() > 0) {
                	
                	aimLine.setStartX(e.getX());
                	aimLine.setStartY(e.getY());
                	
                	strengthStartX = angleX2 = e.getX();
                	strengthStartY = angleY2 = e.getY();
                	
                	angleText.setX(e.getX());
                	angleText.setY(e.getY());
                	
                    System.out.println("mouse pressed x:" + e.getX() + " y:" +e.getY());
                }  
            }
        });
		
		/**
		 * Event for handling when mouse is clicked, and dragging it.
		 * It helps the to draw assistantLine and the measure the power of shot.
		 */
		gameScene.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
  
			public void handle(MouseEvent e) {
				
				aimLine.setEndX(e.getX());
       	     	aimLine.setEndY(e.getY());
       	     	
       	     	strengthText.setX(e.getX());
       	     	strengthText.setY(e.getY());
       	     	
       	     	strengthText.setText( String.format("%.2f", calculateDistance(strengthStartX, strengthStartY, e.getX(), e.getY())));
       	     	
       	     	angleText.setText(String.format("%.2f", getAngle(e.getX(), e.getY(), angleX2, angleY2 )) + " °");
       	     	
       	     	//set the angle of rotation of the bow
       	     	bow.setRotate(  -getAngle(e.getX(), e.getY(), angleX2, angleY2 ) );
       	     	Rotate r = new Rotate(bow.getRotate(), 102, 400);
       	     	bowGc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
       	     	
       	     	System.out.println("dragging mouse  " + e.getX() + " y:" +e.getY() );
            }
        });
		/**
		 * Event for handling when mouse is clicked, when the user shoots
		 * This part helps to manage assistantLine and the shot.
		 */
		gameScene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {
            	
            	aimLine.setStartX(0.0f);
            	aimLine.setStartY(0.0f);
            	aimLine.setEndX(0.0f);
            	aimLine.setEndY(0.0f);
            	
            	setStrenghTextNull();
                setAngleTextNull();
            	
            	System.out.println("mouse clicked " + e.getX() + "|" + e.getY() );
            }
        });
		
		//Exit when escape pressed
		gameScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			public void handle(KeyEvent k){		
				if (k.getCode() == KeyCode.ESCAPE){
					theStage.close();
				}
			}
		});
		
		button.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				theStage.setScene(gameScene);
			}
		});
		
		theStage.setTitle(WindowTitle);
		
		root.getChildren().add(backgroundCanvas);
		root.getChildren().add(archerCanvas);
		root.getChildren().add(bowCanvas);
		root.getChildren().add(aimLine);
		root.getChildren().add(archer.getLeftArm());
		root.getChildren().add(archer.getRightArm());
		root.getChildren().add(strengthText);
		root.getChildren().add(angleText);
		stackPaneRoot.getChildren().add(button);
		
		//theStage.setScene(scene);
		theStage.setScene(loginScene);
		theStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
