/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficoffense;

import Home.HomeController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 *
 * @author way4ward
 */
public class LoginController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private AnchorPane signUpPane;
    @FXML
    private TextField signUpID;
    @FXML
    private TextField Fullname;
    @FXML
    private TextField UsernameID;
    @FXML
    private PasswordField PasswordID;
    @FXML
    private JFXButton lgBtn;
    @FXML
    private JFXButton newStaff;
    @FXML
    private JFXButton signUpBtn;
    
Connection conn;
PreparedStatement pstmt;
ResultSet rs;
    @FXML
    private StackPane stick;
    @FXML
    private AnchorPane splashAnchorPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = Javaconnect.ConnecrDB();
        signUpPane.setVisible(false);
        stick.setVisible(false);
         newStaff.setOnAction(e->{
         signUpPane.setVisible(true); 
      });
    }    

    @FXML
    private void signUp(ActionEvent event) {
         String sql = "INSERT INTO SIGNUP (ID , FULLNAME , USERNAME , PASSWORD ) VALUES (?,?,?,?)";
    try{
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1,signUpID.getText());
      pstmt.setString(2,Fullname.getText());
      pstmt.setString(3,UsernameID.getText());
      pstmt.setString(4,PasswordID.getText());
      pstmt.execute();
               stick.setVisible(true);
      JFXDialogLayout content =  new JFXDialogLayout();
  content.setHeading(new Text("Success")); // Header of the Dialog
  content.setBody(new Text("Account Created")); // Text in the dialog
  JFXDialog dialog = new JFXDialog(stick, content,JFXDialog.DialogTransition.CENTER);
  JFXButton btn = new JFXButton("Close"); // Button to close Dialog

  btn.setOnAction(new EventHandler <ActionEvent>(){
      @Override
      public void handle(ActionEvent event) {
          dialog.close();
          stick.setVisible(false);
      }
      
  });
  content.setActions(btn);
     
     dialog.show();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null , e);
    }   
   } 

    @FXML
    private void login(ActionEvent event) {
      String sqll = "SELECT * FROM SIGNUP WHERE Username=? AND Password=?";
       try{
           pstmt = conn.prepareStatement(sqll);
           pstmt.setString(1 , username.getText());
           pstmt.setString(2 , password.getText());
           rs = pstmt.executeQuery();
           if(rs.next()){ 
           Stage stage = new Stage();
                FXMLLoader Loader = new FXMLLoader();
                 Loader.setLocation(getClass().getResource("/Home/Home.fxml"));
                 Parent root = Loader.load();  
                  HomeController drawer = (HomeController)Loader.getController();
              drawer.GetMat(username.getText());
        Scene scene = new Scene(root);
//stage = (Stage) lgbtn.getScene().getWindow();
 
              stage.setScene(scene);
              stage.setResizable(false);
              stage.centerOnScreen();
              stage.show(); 
               splashAnchorPane.getScene().getWindow().hide();
                     Image img = new Image("/images/owk.png");
               Notifications notificationBuilder = Notifications.create()
               .title("LOGIN")
               .text("LOGIN SUCCESFULL")
               .graphic(new ImageView(img))
               .hideAfter(Duration.seconds(3))
               .position(Pos.BOTTOM_RIGHT);
               notificationBuilder.show();
           
           }else{
              Alert alert  = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("WARNING");
            alert.setHeaderText(null);
            alert.setContentText("INVALID DETAILS");
            alert.showAndWait();
           }
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(null , e);
       }
              
}
    }
    