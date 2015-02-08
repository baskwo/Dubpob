package org.dubpob.HQ9.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.dubpob.HQ9.Program;

import bsh.EvalError;
import bsh.Interpreter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class SceneController {
	@FXML
	private TextArea txtCode;
	
	@FXML
	private TextArea txtOutput;
	
	@FXML
	private void handleCloseMenuAction(ActionEvent event) {
		try {
			Program.INSTANCE().stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	@FXML
	private void handleExecuteButtonAction(ActionEvent event) throws Exception {
		txtOutput.setText("");
		String code = txtCode.getText().toLowerCase();
		
		Interpreter interpret = new Interpreter();
		try {
			interpret.set("txtCode", txtCode);
			interpret.set("txtOutput", txtOutput);
		} catch (EvalError e) {
			e.printStackTrace();
		}
		
		txtOutput.setText(txtOutput.getText() + "\n");
		
		for(char c : code.toCharArray()) {
			String filename = "commands\\" + c + ".dpb";
			if(!Files.exists(Paths.get(filename))) {
				txtOutput.setText(txtOutput.getText() + "\nImpossible to continue the interpretation.");
				throw new Exception("File does not exist : " + filename);
			}
			
			interpret.source(filename);
		}
	}
}
