package it.polito.tdp.poweroutages;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.poweroutages.model.Model;
import it.polito.tdp.poweroutages.model.Nerc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PowerOutagesController {

	private Model model;
	private List<Nerc> allNerc;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    private ComboBox<Nerc> cmbNerc;

    @FXML
    private TextField txtYears;

    @FXML
    private TextField txtHours;
    
    public void setModel(Model model) {
    	this.model = model;
    	setComboItems();
	}
    
    private void setComboItems() {

		allNerc = model.getNercList();
		cmbNerc.getItems().addAll(allNerc);
	}

    @FXML
    void doRun(ActionEvent event) {
    	
    	Nerc nerc = cmbNerc.getValue();
    	try {
    		int anni = Integer.parseInt(txtYears.getText());
    		int ore = Integer.parseInt(txtHours.getText());
    		
		} catch (NumberFormatException e) {
			txtResult.appendText("Devi inserire dei numeri interi");
		}
    	

    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'PowerOutages.fxml'.";
        assert cmbNerc != null : "fx:id=\"cmbNerc\" was not injected: check your FXML file 'PowerOutages.fxml'.";
        assert txtYears != null : "fx:id=\"txtYears\" was not injected: check your FXML file 'PowerOutages.fxml'.";
        assert txtHours != null : "fx:id=\"txtHours\" was not injected: check your FXML file 'PowerOutages.fxml'.";

    }
    
    
}
