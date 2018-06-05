/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta.controlador;

import databasetorreforta.domini.Professor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author alumne
 */
public class FXMLAfegirProfessor implements Initializable{

    @FXML
    private TextField tf_usuari, tf_nom;
    @FXML
    private ChoiceBox cb_classe, cb_assignatura;
    @FXML
    private Button b_afegir, b_esborrar;
    @FXML
    private PasswordField p_prof;

    @FXML
    private void esborrar(ActionEvent event) throws IOException {
        tf_usuari.clear();
        tf_nom.clear();
        p_prof.clear();
        cb_classe.setValue(null);
        cb_assignatura.setValue(null);
    }

    @FXML
    private void afegir(ActionEvent event) throws IOException {
        if (!tf_nom.getText().equals("") && !tf_usuari.getText().equals("")&& !p_prof.getText().equals("")) {
            Professor p = new Professor(tf_usuari.getText());
            p.setNom(tf_nom.getText());
            //Encriptar contrassenya:
            String contra= p_prof.getText();
            String contraEncript= DigestUtils.sha1Hex(contra); //Aixo es lo que s'ha de guardar a la bbdd
            
//            a.setClasse((Classe)cb_classe.getSelectionModel().getSelectedItem());
//            aDao.inserir(a);
//            /*Classe c = cDao.getTots().get(cb_classe.getSelectionModel().getSelectedIndex());
//            List<Alumne> lAlu = c.getAlumneList();
//            lAlu.add(a);
//            c.setAlumneList(lAlu);
//            cDao.modificar(c);*/
//            resultat.setText(a.getNom()+" s'ha afegit CORRECTAMENT");
//            esborrador();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

}
