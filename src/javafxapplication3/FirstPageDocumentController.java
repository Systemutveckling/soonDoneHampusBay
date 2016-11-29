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
import java.sql.PreparedStatement;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


 
 
public class FirstPageDocumentController implements Initializable {
    
  
     @FXML
    private ListView allInfo;
     @FXML
    private TextField sök;         
     @FXML
    private Button laddauppfil;
     @FXML
    private Button Minafiler;
     @FXML
     private Button loggaut;
     @FXML
     private Button register;
     @FXML
     private Button Login;
        ObservableList x = FXCollections.observableArrayList();

    @FXML
    private void loginPage(ActionEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));        
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        
    }
        @FXML
        private void minafiler(ActionEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("Minafiler.fxml"));        
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
       @FXML
    private void loggaut(ActionEvent event) throws IOException {
       if(LoginAuth.getInstance().isLoggedIn()){
        Minafiler.setVisible(false);
        laddauppfil.setVisible(false);
        loggaut.setVisible(false);
        register.setVisible(true);
        Login.setVisible(true);
        }
        
    }
    
      @FXML
        private void sök(ActionEvent event) {
            x.clear();
             try{
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hampusbay?useSSL=false","root","root");
        Statement myStmt = myConn.createStatement();
        ResultSet myRs = myStmt.executeQuery("select filer.Namn,kategori.Kategori,genre.Genre,filer.Storlek\n" +
"from användare,filer,kategori,genre\n" +
"where användare.Användarnamn like filer.Användare_Användarnamn and kategori.Kategori_id = filer.Kategori_Kategori_id and genre.idGenre = filer.Genre_idGenre;");
        //ResultSet genre = myStmt.executeQuery("Select * from genre");
        while(myRs.next()){
            
            if(myRs.getString("Namn").equalsIgnoreCase(sök.getText())){
            x.add(myRs.getString("Kategori") +"              " +  myRs.getString("Genre") + "            "  + myRs.getString("Namn") + "           " + myRs.getString("Storlek") + "MB");
            allInfo.setItems(x);
            }
            
           
        }
        
        if(sök.getText().isEmpty()){
        getDatabaseOriginal();
        }
        
       
        }catch(Exception exc){
            
        exc.printStackTrace();
        }
        
         
        
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(!LoginAuth.getInstance().isLoggedIn()){
        Minafiler.setVisible(false);
        laddauppfil.setVisible(false);
        loggaut.setVisible(false);
        }
        
        if(LoginAuth.getInstance().isLoggedIn()){
        register.setVisible(false);
        Login.setVisible(false);
        }
        
  getDatabaseOriginal();
  
    }    
    public void getDatabaseOriginal(){
              try{
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hampusbay?useSSL=false","root","root");
        Statement myStmt = myConn.createStatement();
        ResultSet myRs = myStmt.executeQuery("select filer.Namn,kategori.Kategori,genre.Genre,filer.Storlek\n" +
"from användare,filer,kategori,genre\n" +
"where användare.Användarnamn like filer.Användare_Användarnamn and kategori.Kategori_id = filer.Kategori_Kategori_id and genre.idGenre = filer.Genre_idGenre;");
        //ResultSet genre = myStmt.executeQuery("Select * from genre");
        while(myRs.next()){
            x.add(myRs.getString("Kategori") +"              " +  myRs.getString("Genre") + "            "  + myRs.getString("Namn") + "           " + myRs.getString("Storlek") + "MB");
        }
        
       
        }catch(Exception exc){
            
        exc.printStackTrace();
        }
        allInfo.setItems(x);
    }
}
