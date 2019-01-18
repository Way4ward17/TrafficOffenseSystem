/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSnackbar;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;
import trafficoffense.Javaconnect;

/**
 * FXML Controller class
 *
 * @author way4ward
 */

public class HomeController implements Initializable {
private String genda;
    @FXML
    private JFXComboBox<?> combo;
    @FXML
    private AnchorPane offencePpane;
    @FXML
    private TextField Firstname;
    @FXML
    private TextField Lastname;
    @FXML
    private TextField Vehicle;
    @FXML
    private TextField DriverNo;
    @FXML
    private ToggleGroup gender;
    @FXML
    private TextField offence;
    @FXML
    private TextField penalty;
    @FXML
    private TextField offenceCode;
    @FXML
    private TextField reporter;
    @FXML
    private JFXButton submitOffenceBTN;
    private ObservableList<LoadTables2> data;
Connection conn;
PreparedStatement pstmt;
ResultSet rs;
 final ObservableList babas =  FXCollections.observableArrayList();
    @FXML
    private JFXDatePicker date;
    private String genda1;
    @FXML
    private AnchorPane ViewOffencePane;
    @FXML
    private TableColumn<?, ?> Tfirstname;
    @FXML
    private TableColumn<?, ?> Tlastname;
    @FXML
    private TableColumn<?, ?> Tgender;
    @FXML
    private TableColumn<?, ?> Toffence;
    @FXML
    private TableColumn<?, ?> Treporter;
    @FXML
    private TableColumn<?, ?> Tpenalty;
    @FXML
    private TableView<LoadTables2> table;
    @FXML
    private JFXRadioButton male;
    @FXML
    private JFXRadioButton female;
    @FXML
    private JFXButton addOffenceBTN;
    @FXML
    private JFXButton viewOffenceBTN;
    @FXML
    private JFXButton bailOutBTN;
    @FXML
    private JFXButton exitBTN;
    @FXML
    private AnchorPane bailOutPane;
    @FXML
    private AnchorPane offencePpane1;
    @FXML
    private TextField Firstname1;
    @FXML
    private TextField Lastname1;
    @FXML
    private TextField Vehicle1;
    @FXML
    private TextField DriverNo1;
    @FXML
    private JFXRadioButton male1;
    @FXML
    private ToggleGroup gender1;
    @FXML
    private JFXRadioButton female1;
    @FXML
    private TextField offence1;
    @FXML
    private TextField penalty1;
    @FXML
    private TextField offenceCode1;
    @FXML
    private TextField reporter1;
    @FXML
    private JFXDatePicker date1;
    @FXML
    private JFXButton searchBailOut;
    @FXML
    private TextField editText;
    @FXML
    private AnchorPane addOffenceGanGan;
    @FXML
    private Text ID;
    @FXML
    private TableColumn<?, ?> offID;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      conn = Javaconnect.ConnecrDB();
       Random();
      searchBailOut.setOnAction(e->{
          String sql = "SELECT * FROM OFFENCE WHERE OFFENCE_ID = ?";
           try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,editText.getText());
            rs = pstmt.executeQuery();
         
            if(rs.next()){
                Firstname1.setText(rs.getString("Firstname"));
                Lastname1.setText(rs.getString("Lastname"));
                Vehicle1.setText(rs.getString("Vehicle"));
                DriverNo1.setText(rs.getString("Driver"));
                String babe = rs.getString("Gender");
                 if(babe.equals("Male")){
             male1.setSelected(true);
              female1.setSelected(false);
                 }
                if(babe.equals("Female")){     
             female1.setSelected(true);
              male1.setSelected(false);
         } 
                offence1.setText(rs.getString("OFFENCE"));
                penalty1.setText(rs.getString("PENALTY"));
                offenceCode1.setText(rs.getString("OFFENCECODE"));
                reporter1.setText(rs.getString("REPORTER"));       
            }else{
                Alert alert  = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("WARNING");
            alert.setHeaderText(null);
            alert.setContentText("INVALID ID");
            alert.showAndWait();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null , ex);
        }finally{
            try {
                rs.close();
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
      });
      
  combo.setOnAction(e->{
  String sql = "SELECT * FROM OFF_CODE_FINE WHERE OFF_NAME = ?";
  try{
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, (String) combo.getSelectionModel().getSelectedItem());
      rs = pstmt.executeQuery();
      if(rs.next()){
          penalty.setText(rs.getString("PENALTY"));
          offenceCode.setText(rs.getString("OFF_CODE"));
      }
  }catch(Exception ex){
      JOptionPane.showMessageDialog(null , ex);
  }
      
      
      
      
     String baba = (String)combo.getSelectionModel().getSelectedItem();
     offence.setText(baba);
      offencePpane.setVisible(true); 
  });
  
  
  
           offencePpane.setVisible(false); 
           ViewOffencePane.setVisible(false); 
           bailOutPane.setVisible(false); 
      addOffenceBTN.setOnAction(e->{
         addOffenceGanGan.setVisible(true);
          ViewOffencePane.setVisible(false);
         bailOutPane.setVisible(false); 
      });
        bailOutBTN.setOnAction(e->{
         bailOutPane.setVisible(true); 
          addOffenceGanGan.setVisible(false);
           ViewOffencePane.setVisible(false);
      });
       viewOffenceBTN.setOnAction(e->{
         ViewOffencePane.setVisible(true);
         bailOutPane.setVisible(false); 
          addOffenceGanGan.setVisible(false);
          LoadData();
      });
         exitBTN.setOnAction(e->{
         System.exit(0);
      });
      combo.setItems(babas);
        male.setOnAction(e->{
          genda = male.getText();
      });
       female.setOnAction(e->{
          genda = female.getText();
      });
       
              male1.setOnAction(e->{
          genda1 = male1.getText();
      });
       female1.setOnAction(e->{
          genda1 = female1.getText();
      });
       
       data = FXCollections.observableArrayList();
       setCellTable();
       fetchonline1();
       LoadData();
    }    
    
    private void setCellTable(){
        Tfirstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
      Tlastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        Tgender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        Toffence.setCellValueFactory(new PropertyValueFactory<>("offence"));
        Treporter.setCellValueFactory(new PropertyValueFactory<>("reporter")); 
        Tpenalty.setCellValueFactory(new PropertyValueFactory<>("penalty")); 
        offID.setCellValueFactory(new PropertyValueFactory<>("id")); 
    }
  
     public void fetchonline1(){
         babas.clear();
        String sql = "select OFF_NAME from OFF_CODE_FINE";
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                babas.add(rs.getString("OFF_NAME"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
    } 
     
        public void GetMat(String name){
        reporter.setText(name);
      
    }
    private void LoadData(){
        data.clear();
    try {
        pstmt = conn.prepareStatement("SELECT * FROM OFFENCE");
        rs = pstmt.executeQuery();
        while(rs.next()){
          data.add(new LoadTables2(rs.getString(1),rs.getString(2),rs.getString(5),rs.getString(6),rs.getString(9),rs.getString(7) ,rs.getString(11)));
        }
    } catch (SQLException ex) {
        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
    }
         table.setItems(data);
    }
      public void Random(){
          Random rd = new Random();
    ID.setText("OFF"+rd.nextInt(8899988+1));        
    } 
    @FXML
    private void SubmitOffence(ActionEvent event) {
        if(Firstname.getText().isEmpty() || Vehicle.getText().isEmpty() || reporter.getText().isEmpty()){
              Alert alert  = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("WARNING");
            alert.setHeaderText(null);
            alert.setContentText("ONE OR MORE FIELD IS EMPTY");
            alert.showAndWait();
        }else{
        String sql = "INSERT INTO OFFENCE (FIRSTNAME , LASTNAME , VEHICLE , DRIVER , GENDER , OFFENCE,"
                + "PENALTY , OFFENCECODE , REPORTER , DATE ,OFFENCE_ID ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1 , Firstname.getText());
            pstmt.setString(2 , Lastname.getText());
            pstmt.setString(3 , Vehicle.getText());
            pstmt.setString(4 , DriverNo.getText());
            pstmt.setString(5 , genda);
            pstmt.setString(6 , offence.getText());
            pstmt.setString(7 , penalty.getText());
            pstmt.setString(8 , offenceCode.getText());
             pstmt.setString(9 , reporter.getText()); 
             pstmt.setString(10,((TextField)date.getEditor()).getText());
   pstmt.setString(11 , ID.getText()); 
   pstmt.execute();
   Random();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
        }
    }

    @FXML
    private void BailOut(ActionEvent event) { 
        String sqll = "DELETE FROM OFFENCE WHERE OFFENCE_ID = ?";
        try{
            pstmt = conn.prepareStatement(sqll);
            pstmt.setString(1 , editText.getText());
            pstmt.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
        
   
        String sql = "INSERT INTO BAILOUT (FIRSTNAME , LASTNAME , VEHICLE , DRIVER , GENDER , OFFENCE,"
                + "PENALTY , OFFENCECODE, REPORTER, DATE , OFFENCE_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1 , Firstname1.getText());
            pstmt.setString(2 , Lastname1.getText());
            pstmt.setString(3 , Vehicle1.getText());
            pstmt.setString(4 , DriverNo1.getText());
            pstmt.setString(5 , genda);
            pstmt.setString(6 , offence1.getText());
            pstmt.setString(7 , penalty1.getText());
            pstmt.setString(8 , offenceCode1.getText());
        
   pstmt.setString(9 , reporter.getText());  
        pstmt.setString(10,((TextField)date1.getEditor()).getText());
        pstmt.setString(11 , ID.getText()); 
   pstmt.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
        
    }
    
}
