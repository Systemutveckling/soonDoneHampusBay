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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hampus
 */
public class MinafilerController implements Initializable {
    
    @FXML
    ListView minafiler;
            
    
        ObservableList x = FXCollections.observableArrayList();
            @FXML
            
            
    private void back(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("FirstPageDocument.fxml"));        
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);

    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                     try{
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hampusbay?useSSL=false","root","root");
        Statement myStmt = myConn.createStatement();
        ResultSet myRs = myStmt.executeQuery(query());
        //ResultSet genre = myStmt.executeQuery("Select * from genre");
        while(myRs.next()){
            x.add(myRs.getString("namn")+ "                 " +  myRs.getString("Genre") + "             " +myRs.getString("Kategori") + "        " + myRs.getString("Storlek") + "MB");
        }
        
       
        }catch(Exception exc){
            
        exc.printStackTrace();
        }
        minafiler.setItems(x);
    }
        
        
public String query(){
    return ("Select filer.Namn,genre.Genre,filer.Storlek,kategori.Kategori from användare,filer,genre,kategori\n" +
"where användare.Användarnamn = '"+LoginAuth.getInstance().getUsername()+"' and genre.idGenre = filer.Genre_idGenre and Användare.Email = filer.Användare_Email and kategori.Kategori_id = filer.Kategori_Kategori_id and användare.lösenord = 123;");
}
            
    }
    
    

