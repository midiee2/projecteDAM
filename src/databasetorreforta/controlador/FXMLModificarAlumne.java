/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta.controlador;

import databasetorreforta.dao.AlumneDAOImpl;
import databasetorreforta.dao.ClasseDAOImpl;
import databasetorreforta.domini.Alumne;
import databasetorreforta.domini.Classe;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author alumne
 */
public class FXMLModificarAlumne implements Initializable {

    
    AlumneDAOImpl aDao = new AlumneDAOImpl();
    ClasseDAOImpl cDao = new ClasseDAOImpl();
    @FXML
    private ComboBox cb_alumne;
    @FXML
    private TextField tf_nom, tf_classe;
    @FXML
    private Label resposta;
    
    public void netejar(){
        tf_nom.clear();
        tf_classe.clear();
        cb_alumne.setValue(null);
    }

    @FXML
    private void esborrar(ActionEvent event) throws IOException {
        tf_nom.clear();
        tf_classe.clear();
        resposta.setText("");
        cb_alumne.setValue(null);
    }

    @FXML
    private void combobox(ActionEvent event) {
        resposta.setText("");
        int indexAlumne = cb_alumne.getSelectionModel().getSelectedIndex();
        List<Alumne> listAlumne = aDao.getTots();
        tf_nom.setText(listAlumne.get(indexAlumne).getNom());
        tf_classe.setText(listAlumne.get(indexAlumne).getClasse().getNom());
    }
    
    @FXML
    private void modificar(ActionEvent event) throws IOException {
        int indexAlumne = cb_alumne.getSelectionModel().getSelectedIndex();
        List<Alumne> listAlumne = aDao.getTots();
        Alumne a = listAlumne.get(indexAlumne);
        a.setNom(tf_nom.getText());
        List<Classe> listClasse = cDao.getTots();
        boolean trobat = false;
        Classe cl = null;
        for (int i=0; i< listClasse.size();i++){
            if (listClasse.get(i).getNom().equals(tf_classe.getText())){
                cl = listClasse.get(i);
                trobat = true;
            }
        }
        if (trobat){
            a.setClasse(cl);
            aDao.modificar(a);
            resposta.setText(a.getNom()+" modificat correctament");
            netejar();
        }
        else {
            resposta.setText("La classe "+tf_classe.getText()+" no existeix");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        List<Alumne> listAlumne = aDao.getTots();
        
        cb_alumne.setItems(FXCollections.observableArrayList(listAlumne));
    }

}
