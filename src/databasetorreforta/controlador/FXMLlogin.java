/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta.controlador;

import databasetorreforta.DATABASETORREFORTA;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author alumne
 */
public class FXMLlogin implements Initializable {

    //S'HA DE MIRAR COM FER A LES VISTES DE PROFESSORS EL COMBOBOX AMB CHECK O FER MULTIPLES CHECKS
    @FXML
    private Button b1;
    @FXML
    private TextField tf1;
    @FXML
    private PasswordField pf1;

    @FXML
    private void entrada(ActionEvent event) throws IOException {
        Stage stage = new Stage();

        if ((tf1.getText().equals("admin")) && (pf1.getText().equals("admin"))) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DATABASETORREFORTA.class.getResource("vista/FXMLadmin.fxml"));
            FXMLinicialAdmin contro = new FXMLinicialAdmin();
            loader.setController(contro);
            Parent root = (Parent) loader.load();
            // create a new scene with root and set the stage
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tf1.setText("admin");
        pf1.setText("admin");
    }

}
