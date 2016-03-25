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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
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
	 * The start of the application
	 */
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
		 * This event handle that when the user pushes the mouse button.
		 * It's the start of the shoot, after this part we measure the power if shoot, with
		 * dragging the mouse and when the mouse click released the shoot released too.
		 */
		gameScene.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {            
                if (e.getClickCount() > 0) {
                	
                	aimLine.setStartX(e.getX());
                	aimLine.setStartY(e.getY());
                	
                    System.out.println("mouse pressed x:" + e.getX() + " y:" +e.getY());
                }  
            }
        });
		
		/**
		 * Event for handling when mouse is clicked down, and dragging it.
		 * It helps the to draw assistantLine and the measure the power of shoot.
		 */
		gameScene.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
  
			public void handle(MouseEvent e) {
				aimLine.setEndX(e.getX());
       	     	aimLine.setEndY(e.getY());
       	     	
       	     	/**
       	     	 * Set that we could only aim to the right side of the screen.
       	     	 */
       	     	bow.setRotate( -(((360.0/WindowWidth)/2)*e.getY()-90.0) );
            	
       	     	Rotate r = new Rotate(bow.getRotate(), 102, 400);
       	     	bowGc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
       	     	
       	     	System.out.println("dragging mouse  " + e.getX() + " y:" +e.getY() );
            }
        });
		/**
		 * Event for handling when mouse is clicked, when the user shoots
		 * This part helps to manage assistantLine and the shoot the arrow from the bow.
		 */
		gameScene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {
            	aimLine.setStartX(0.0f);
            	aimLine.setStartY(0.0f);
            	aimLine.setEndX(0.0f);
            	aimLine.setEndY(0.0f);
                System.out.println("mouse clicked " + e.getX() + "|" + e.getY() );
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
		stackPaneRoot.getChildren().add(button);
		
		//theStage.setScene(scene);
		theStage.setScene(loginScene);
		theStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
