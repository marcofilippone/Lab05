package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	String parola = txtParola.getText();
    	if(parola==null) {
    		txtCorretti.setText("Inserire almeno una lettera");
    		txtErrati.setText("Inserire almeno una lettera");
    		return;
    	}
    	List<String> anagrammi = model.anagrammi(parola);
    	for(String s : anagrammi) {
    		if(model.getDizionario().contains(s)) {
    			txtCorretti.appendText(s+"\n");
    		}
    		else {
    			txtErrati.appendText(s+"\n");
    		}
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	txtParola.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model){
    	this.model=model;
    }
}
