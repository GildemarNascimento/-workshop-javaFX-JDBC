package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem About;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}
	@FXML
	public void onMenuItemDepartmentAction() {
		System.out.println("onMenuItemDepartmentAction");
	}
	@FXML
	public void onMenuItemAbountAction() {
		loadView("/gui/About.fxml");
	}
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	private synchronized  void loadView(String absoluteName) {
		//synchronized garante que processo multi theader não seja interrompido.
		//Abria a About.
		//Objeto carrega a tela.
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVbox = loader.load();
			//Pegar a referencia da cena do método da classe Main.
			Scene  mainScene = Main.getMainScene();
			//Pega ScrolPane\Content\VBox.
			VBox mainVBox = (VBox)((ScrollPane)mainScene.getRoot()).getContent();
			//Guardar uma referencia para o Menus.
			Node mainMenu = mainVBox.getChildren().get(0); //pega o primeiro filho/posição.
			//Limpa todos os filhos do VBox
			mainVBox.getChildren().clear();
			//Adcionar Menu do VBox
			mainVBox.getChildren().add(mainMenu);
			//Adicionar a Coleção menus About
			mainVBox.getChildren().addAll(newVbox.getChildren());
			
		} catch (IOException e) {
			//Exibir o Alert.
			Alerts.showAlert("IO Exception","Error loandig view", e.getMessage(), AlertType.ERROR);
			
		}
	}

}
