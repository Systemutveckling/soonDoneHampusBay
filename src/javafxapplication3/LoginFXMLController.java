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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author skate
 */

public class LoginFXMLController implements Initializable {
    
    
    

    
    
    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("FirstPageDocument.fxml"));        
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);

    }
    
        @FXML
    private void login(ActionEvent event) throws IOException {
     
//             try{
//        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thehampusdatabase?useSSL=false","root","root");
//        Statement myStmt = myConn.createStatement();
//        ResultSet myRs = myStmt.executeQuery("Select * from användare\n" +
//"where användare.Email = 'abovepants@gmail.com' and användare.Användarnamn = 'abovepants' and Användare.lösenord = 123");
//        //ResultSet genre = myStmt.executeQuery("Select * from genre");
//        while(myRs.next()){
//            
//            System.out.println(myRs.getString("Namn"));
//             
//           
//            
//            
//           
//        }
//
//        
//       
//        }catch(Exception exc){
//            
//        exc.printStackTrace();
//        }
        

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    
    
}
