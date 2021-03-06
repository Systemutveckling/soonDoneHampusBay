/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

/**
 * FXML Controller class
 *
 * @author skate
 */

public class LoginFXMLController implements Initializable {
    
    @FXML
    private TextField username;
    
    @FXML
    private TextField password;
    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("FirstPageDocument.fxml"));        
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);

    }
    
        @FXML
    private void login(ActionEvent event) throws IOException {
        
             try{
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hampusbay?useSSL=false","root","root");
        Statement myStmt = myConn.createStatement();
        ResultSet myRs = myStmt.executeQuery("Select * from användare\n" +
"where Användarnamn = '"+username.getText()+ "' and lösenord =" + password.getText());
        //ResultSet genre = myStmt.executeQuery("Select * from genre");
        while(myRs.next()){
            if(username.getText().equalsIgnoreCase(myRs.getString("användarnamn")) && password.getText().equals(myRs.getString("lösenord"))){
            System.out.println(myRs.getString("Namn"));
            LoginAuth.getInstance().setUsername(myRs.getString("Användarnamn"));
            LoginAuth.getInstance().setPassword(myRs.getString("Lösenord"));
            }
             
        }
        LoginAuth.getInstance().setLoggedIn(true);
       
        }catch(Exception exc){
            
        exc.printStackTrace();
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    
    
}
