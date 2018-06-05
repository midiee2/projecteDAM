/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta.controlador;

import databasetorreforta.dao.AlumneDAOImpl;
import databasetorreforta.dao.ClasseDAOImpl;
import databasetorreforta.domini.Alumne;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author alumne
 */
public class FXMLEliminarAlumne implements Initializable {

    AlumneDAOImpl aDao = new AlumneDAOImpl();
    @FXML
    private ComboBox cb_alumne;
    @FXML
    private Text text_nom, text_classe;
    @FXML
    private Label resposta;

    @FXML
    private void combobox(ActionEvent event) {
        int indexAlumne = cb_alumne.getSelectionModel().getSelectedIndex();
        List<Alumne> listAlumne = aDao.getTots();
        text_nom.setText(listAlumne.get(indexAlumne).getNom());
        text_classe.setText(listAlumne.get(indexAlumne).getClasse().getNom());
    }

    @FXML
    private void esborrar(ActionEvent event) throws IOException {
        cb_alumne.setValue(null);
        text_nom.setText("");
        text_classe.setText("");
        resposta.setText("");
    }

    @FXML
    private void eliminar(ActionEvent event) throws IOException {
        int indexAlumne = cb_alumne.getSelectionModel().getSelectedIndex();
        List<Alumne> listAlumne = aDao.getTots();
        Alumne a = listAlumne.get(indexAlumne);
        aDao.eliminar(a);
        resposta.setText("Alumne eliminat correctament");
        listAlumne = aDao.getTots();
        cb_alumne.setItems(FXCollections.observableArrayList(listAlumne));
        esborrar();
    }
    public void esborrar(){       
        text_nom.setText("");
        text_classe.setText("");
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Alumne> listAlumne = aDao.getTots();
        cb_alumne.setItems(FXCollections.observableArrayList(listAlumne));
    }

}
