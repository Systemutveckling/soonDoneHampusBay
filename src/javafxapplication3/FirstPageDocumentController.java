/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


 
 
public class FirstPageDocumentController implements Initializable {
    
  
     @FXML
    private ListView allInfo;
     
     
        ObservableList x = FXCollections.observableArrayList(BankLogic.getInstance().getAllNames());
    @FXML
    private void loginPage(ActionEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));        
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        
    }
        @FXML
    private void registerPage(ActionEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("Register.fxml"));        
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        x.add("PC            " + "                      Action "     +    "                    Battlefield1     "      +          "           7GB");
        x.add("PC            " + "                      Action "     +    "                    Battlefield1     "      +          "           7GB");
        x.add("PC            " + "                      Action "     +    "                    Battlefield1     "      +          "           7GB");
        x.add("PC            " + "                      Action "     +    "                    Battlefield1     "      +          "           7GB");
        x.add("PC            " + "                      Action "     +    "                    Battlefield1     "      +          "           7GB");
        
        allInfo.setItems(x);
    }    
    
}
