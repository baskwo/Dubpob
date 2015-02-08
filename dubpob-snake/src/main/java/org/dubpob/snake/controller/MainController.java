package org.dubpob.snake.controller;

import org.dubpob.snake.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {
	
	@FXML
	private void handleCloseButtonAction(ActionEvent event) {
		try {
			Main.getInstance().stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	@FXML
	private void handleSinglePlayerButtonAction(ActionEvent event) {
		Main.getInstance().changeScene("SnakeGame.fxml");
	}
}
