/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import databasetorreforta.dao.AlumneDAOImpl;
import databasetorreforta.dao.ClasseDAO;
import databasetorreforta.dao.ClasseDAOImpl;
import databasetorreforta.domini.Alumne;
import databasetorreforta.domini.Classe;
import java.util.List;
import javafx.scene.control.Label;

/**
 *
 * @author alumne
 */
public class FXMLAfegirAlumne implements Initializable {

    AlumneDAOImpl aDao = new AlumneDAOImpl();
    ClasseDAOImpl cDao = new ClasseDAOImpl();

    @FXML
    private Label resultat;
    
    @FXML
    private TextField tf_dni, tf_nom;

    @FXML
    private ComboBox cb_classe;

    @FXML
    private Button b_afegir, b_esborrar;

    @FXML
    private void esborrar(ActionEvent event) throws IOException {
        esborrador();
    }

    @FXML
    private void afegir(ActionEvent event) throws IOException {
        if (!tf_dni.getText().equals("") && !tf_nom.getText().equals("")) {
            Alumne a = new Alumne(tf_dni.getText());
            a.setNom(tf_nom.getText());
            a.setClasse((Classe)cb_classe.getSelectionModel().getSelectedItem());
            aDao.inserir(a);
            /*Classe c = cDao.getTots().get(cb_classe.getSelectionModel().getSelectedIndex());
            List<Alumne> lAlu = c.getAlumneList();
            lAlu.add(a);
            c.setAlumneList(lAlu);
            cDao.modificar(c);*/
            resultat.setText(a.getNom()+" s'ha afegit CORRECTAMENT");
            esborrador();
        }
    }
    
    public void esborrador(){
        tf_dni.clear();
        tf_nom.clear();
        cb_classe.setValue(null);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        /*String noms[] = {"1A", "1B", "2A", "2B", "3A", "3B", "4A", "4B"};
        for (int i = 0; i < noms.length; i++) {
            Classe c = new Classe(String.valueOf(i));
            c.setNom(noms[i]);
            cDao.inserir(c);
        }*/

        List<Classe> listClasse = cDao.getTots();
        cb_classe.setItems(FXCollections.observableArrayList(listClasse));
    }

}
