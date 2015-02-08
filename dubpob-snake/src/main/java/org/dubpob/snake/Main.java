package org.dubpob.snake;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private static Main INSTANCE = null;
	
	public static Main getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Main();
		}
		return INSTANCE;
	}
	
	private Stage currentStage = null;
	
	public Main() {
		INSTANCE = this;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(this.getClass().getResource("MainMenu.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Menu");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			currentStage = primaryStage;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void changeScene(URL url) {
		try {
			closeStage(currentStage);
			
			Stage nextStage = new Stage();
			Parent child = FXMLLoader.load(url);
			Scene scene = new Scene(child);
			
			nextStage.setScene(scene);
			nextStage.setResizable(false);
			nextStage.show();
			currentStage = nextStage;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void closeStage(Stage stage) {
		if(stage != null && stage.isShowing()) {
			stage.close();
		}
	}
	
	//In case I have multiple stage
	public void closeStages() {
		try {
			for(Field field : this.getClass().getDeclaredFields()) {
				if(!Stage.class.isAssignableFrom(field.getType())) {
					continue;
				}
				
				Stage stage = (Stage)field.get(this);
				closeStage(stage);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(String resource) {
		changeScene(this.getClass().getResource(resource));
	}
	
	@Override
	public void stop() {
		currentStage.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
