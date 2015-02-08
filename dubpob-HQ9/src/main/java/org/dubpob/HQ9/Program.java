package org.dubpob.HQ9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Program extends Application {
	private static Program INSTANCE = null;
	
	public static Program INSTANCE() {
		if(INSTANCE == null) {
			INSTANCE = new Program();
		}
		return INSTANCE;
	}
	
	private Stage currentStage = null;

	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(this.getClass().getResource("EditorDesign.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Editor");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
			if(INSTANCE == null)
				INSTANCE = this;
			
			currentStage = primaryStage;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() {
		currentStage.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
