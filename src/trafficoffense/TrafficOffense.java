/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficoffense;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 * @author way4ward
 */

public class TrafficOffense extends Application {
Connection conn;
PreparedStatement pstmt;
ResultSet rs;    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
         
        Scene scene = new Scene(root);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
       
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
        one();
        two();
        three();
        four();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   private void one(){
    String sql = "CREATE TABLE IF NOT EXISTS `SIGNUP` (ID VARCHAR (50), FULLNAME VARCHAR (50),  USERNAME VARCHAR (50) , PASSWORD VARCHAR(30))";
    try{
        Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/fxdiag","sa","");
        
        pstmt = conn.prepareStatement(sql);
        pstmt.execute();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null , e);
    }
   
} 
  
 
   
    private void two(){
    String sql = "CREATE TABLE IF NOT EXISTS `OFFENCE` (FIRSTNAME VARCHAR(100) , LASTNAME VARCHAR(100) , VEHICLE VARCHAR(100)  , " +
"DRIVER VARCHAR(100) , GENDER VARCHAR(100) , OFFENCE VARCHAR(100),PENALTY VARCHAR(100) ,OFFENCECODE VARCHAR(100) , "
            + "REPORTER VARCHAR(100) , DATE VARCHAR(20) ,OFFENCE_ID VARCHAR(20))";
    try{
        Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/fxdiag","sa","");
        
        pstmt = conn.prepareStatement(sql);
        pstmt.execute();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null , e);
    }
    }  
    
        private void three(){
    String sql = "CREATE TABLE IF NOT EXISTS `off_code_fine` (`off_id` int(20) NOT NULL AUTO_INCREMENT,`off_name` varchar(255) NOT NULL,"
            + "`off_code` varchar(50) NOT NULL,`penalty` int(100) NOT NULL, PRIMARY KEY (`off_id`))";
    try{
        Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/fxdiag","sa","");
        
        pstmt = conn.prepareStatement(sql);
        pstmt.execute();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null , e);
    }
    }
         private void four(){
    String sql = "CREATE TABLE IF NOT EXISTS `BAILOUT` (FIRSTNAME VARCHAR(100) , LASTNAME VARCHAR(100) , VEHICLE VARCHAR(100)  , DRIVER VARCHAR(100) , "
            + "GENDER VARCHAR(100) , OFFENCE VARCHAR(100),PENALTY VARCHAR(100) ,OFFENCECODE VARCHAR(100) , REPORTER VARCHAR(100) ,"
            + " DATE VARCHAR(20) ,OFFENCE_ID VARCHAR(20))";
    try{
        Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/fxdiag","sa","");
        
        pstmt = conn.prepareStatement(sql);
        pstmt.execute();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null , e);
    }
    }  
}
