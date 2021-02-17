package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class utils {
	public static Stage currentStage(ActionEvent event) {
		//Acessar o Stage onde o controle evento esta.
		return (Stage)((Node)event.getSource()).getScene().getWindow();
	}
	
	public static Integer tryParseToInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return null;
		}
		
		
	}
}
