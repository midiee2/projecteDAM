/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta.controlador;

import databasetorreforta.DATABASETORREFORTA;
import databasetorreforta.dao.ProfessorDAO;
import databasetorreforta.dao.ProfessorDAOImpl;
import databasetorreforta.domini.Professor;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author alumne
 */
public class FXMLlogin implements Initializable {

    //Part del administrador
    @FXML
    private Button b1;
    @FXML
    private TextField tf1;
    @FXML
    private PasswordField pf1;
    
    //Part del professor
    @FXML
    private Button b_entrar_prof;
    @FXML
    private TextField t_usuari_prof;
    @FXML
    private PasswordField p_pass_prof;

    @FXML
    private void entrada_admin(ActionEvent event) throws IOException {
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
    @FXML
    private void entrada_prof(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        //Recuperar tots els usuaris dels professors
        ProfessorDAOImpl pDAO= new ProfessorDAOImpl();
        List<Professor> llistaProfessors = pDAO.getTots();
        String usuari =t_usuari_prof.getText();
        String contra= p_pass_prof.getText();      
         String contraEncript= DigestUtils.sha1Hex(contra); //Encripta la contra
         //Recuperar la contrasenya del profe i compararla
         String contraProfe="";
         Professor p; //Professor que haurem d'agafar les relacions en els controladors seguents
         boolean trobat=false;
        for (Professor llistaProfessor : llistaProfessors) {
            if(llistaProfessor.getUsuari().equals(usuari)){
                p=llistaProfessor;
                contraProfe=llistaProfessor.getContrasenya();
                trobat=true;
            }
        }

        if ((trobat==true) && (contraProfe.equals(contraEncript))) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DATABASETORREFORTA.class.getResource("vista/FXMLentrada.fxml"));
            FXMLinicialAdmin contro = new FXMLinicialAdmin();
            loader.setController(contro);
            Parent root = (Parent) loader.load();
            // create a new scene with root and set the stage
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
            
            //LI HEM DE PASSAR EL PROFESSOR PER A QUE PUGUI AGAFAR LES DADES CORRESPONENTS
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tf1.setText("admin");
        pf1.setText("admin");
    }

}
