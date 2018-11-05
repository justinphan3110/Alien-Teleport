//Long Phan 					lnp26
// Long Phan 								lnp26
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.Group;

import java.io.File;
import java.io.FileInputStream;
import java.util.Random;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class AlienGames extends Application {
	 private Region tele1 = new Region(0, 0, 120, 120);
	 private Region tele2 = new Region(0, 580, 120, 120);
	 private Region alien = new Region(350, 350, 100, 100);
	 
	 Image alienpic = new Image("file:C:\\Users\\HOANG LONG\\Desktop\\Class Material\\EECS 132\\HW06\\alien.png");
	 
	 
	 ImageView alienView = new ImageView(alienpic);
	 Rectangle rec1 = new Rectangle();
	 Rectangle rec2 = new Rectangle();
	private final int SHIFT = 10;
	public void start(Stage primaryStage) {
	 final int WIDTH = 700;		/// the Scene dimension
	 final int HEIGHT = 700;
	 start();
	
	
	
	 Group root = new Group(rec1, rec2, alienView);
	
	 Scene scene = new Scene(root, WIDTH, HEIGHT, Color.WHITE);
	 scene.setOnKeyPressed(this::processKeyPress);
	 primaryStage.setTitle("Alien Games");
	 primaryStage.setScene(scene);
	 primaryStage.show();
	 }
	
	public static void main(String args[]) {
	 launch(args);
	}

	public void start() {
		rec1 = new Rectangle(tele1.getX(), tele1.getY(), tele1.getWith(),tele1.getHeight());
		rec2 = new Rectangle(tele2.getX(), tele2.getY(), tele2.getWith(),tele2.getHeight());
		rec1.setFill(Color.BLACK);
		rec2.setFill(Color.BLACK);
		alienView.setX(alien.getX());
		alienView.setY(alien.getY());
		 
		
	}

	public void processKeyPress(KeyEvent event) {
		switch(event.getCode()) {
		case UP:
			alienView.setY(alienView.getY() - SHIFT);
			alien.move(0, -SHIFT);
			break;
		case DOWN:
			alienView.setY(alienView.getY() + SHIFT);
			alien.move(0, SHIFT);
			break;
		case LEFT:
			alienView.setX(alienView.getX() - SHIFT);
			alien.move(-SHIFT, 0);
			break;
		case RIGHT:
			alienView.setX(alienView.getX() + SHIFT);
			alien.move(SHIFT, 0);
			break;
		default:
			break;
		}
		
		//boolean inside = alien.inRegion(tele1) || alien.inRegion(tele2);
		//if (alien.inRegion(tele1) == true) {
			//alien.moveImageViewToRegion(alienView, tele1);
		//}
		
		if(alien.inRegion1(tele1) == true) {
		alien.moveImageViewToRegion(alienView, tele2);
		}
		else {
		if(alien.inRegion2(tele2) == true) {
			alien.moveImageViewToRegion(alienView, tele1);
		}
	
	}
	}
}
