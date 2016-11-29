/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
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
    private PasswordField confirmpassword;
    @FXML
    private TextField email;
    @FXML
    private Label check;
    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("FirstPageDocument.fxml"));        
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
    
    
    @FXML
    private void registerAccount(ActionEvent event) throws IOException {
        
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        Connection myConn = null;
        
               try{
      if(name.getText().isEmpty() || surname.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty()){
          check.setTextFill(Color.web("RED"));
        check.setText("You need to fill all the fields");
      } else if(!password.getText().equals(confirmpassword.getText())){
         check.setTextFill(Color.web("RED"));
        check.setText("You need to have the same passwords"); 
      } else{
          check.setTextFill(Color.web("GREEN"));
      check.setText("added to database");
 //        myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hampusbay?useSSL=false","root","root");
//        myStmt = myConn.prepareStatement("INSERT INTO `thehampusdatabase`.`användare` (`Användarnamn`, `Email`, `Lösenord`, `Namn`, `Efternamn`) VALUES (?, ?, ?, ?, ?);");
//        myStmt.setString(1, username.getText());
//        myStmt.setString(2, email.getText());
//        myStmt.setString(3, password.getText());
//        myStmt.setString(4, name.getText());
//        myStmt.setString(5, surname.getText());
//        myStmt.executeUpdate();
//        System.out.println("update");
        
      }
   
                   
                  
    
        }catch(Exception exc){
            
        exc.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
