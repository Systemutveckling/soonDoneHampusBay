/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author skate
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField password;
    @FXML
    private TextField username;
    @FXML
    private TextField confirmpassword;
    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("FirstPageDocument.fxml"));        
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        System.out.println(BankLogic.getInstance().getAllAccounts());
    }
    
    
    @FXML
    private void registerAccount(ActionEvent event) throws IOException {
        BankLogic.getInstance().setAccounts(name.getText(), password.getText(), username.getText());

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
