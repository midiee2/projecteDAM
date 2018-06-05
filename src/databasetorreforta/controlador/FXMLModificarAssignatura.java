/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta.controlador;

import databasetorreforta.dao.AssignaturaDAOImpl;
import databasetorreforta.dao.ClasseDAOImpl;
import databasetorreforta.domini.Alumne;
import databasetorreforta.domini.Assignatura;
import databasetorreforta.domini.Classe;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

/**
 *
 * @author alumne
 */
public class FXMLModificarAssignatura implements Initializable{

    ClasseDAOImpl cDao = new ClasseDAOImpl();
    AssignaturaDAOImpl aDao = new AssignaturaDAOImpl();
    
    @FXML
    private ComboBox cb_assignatura;
    @FXML
    private TextField tf_nom;
    @FXML
    private ListView<Classe> listC1, listC2;
    @FXML
    private Label resposta;

    @FXML
    private void esborrar(ActionEvent event) throws IOException {
        tf_nom.clear();
        resposta.setText("");
        cb_assignatura.setValue(null);
    }

    @FXML
    private void modificar(ActionEvent event) throws IOException {
        Assignatura a = (Assignatura)cb_assignatura.getSelectionModel().getSelectedItem();
        a.setNom(tf_nom.getText());
        List<Classe> listCla = listC2.getItems();
        a.setClasseList(listCla);
        aDao.modificar(a);
        resposta.setText("Assignatura modicicada correctament: "+listCla.get(0).toString()+", "+listCla.get(1).toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        List<Classe> listClasse = cDao.getTots();
        listC1.setItems(FXCollections.observableArrayList(listClasse));
        listC1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        List<Assignatura> listAssi = new AssignaturaDAOImpl().getTots();
        List<Assignatura> listAss = new ArrayList<>();
        for (int i=0;i<listAssi.size();i++){
            if (!listAss.contains(listAssi.get(i))){
                listAss.add(listAssi.get(i));
            }
        }
        cb_assignatura.setItems(FXCollections.observableArrayList(listAss));
    }
    
    @FXML
    private void combobox(ActionEvent event) {
        resposta.setText("");
        int indexAlumne = cb_assignatura.getSelectionModel().getSelectedIndex();
        List<Assignatura> listAssignatura = aDao.getTots();
        tf_nom.setText(listAssignatura.get(indexAlumne).getNom());
        List<Classe> listClasse = listAssignatura.get(indexAlumne).getClasseList();
        listC2.setItems(FXCollections.observableArrayList(listClasse));
        listC2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    
    @FXML
    private void afegir(ActionEvent event) {
        List<Classe> obCla = listC1.getSelectionModel().getSelectedItems();
        for (int i=0; i<obCla.size();i++){
            listC2.getItems().add(obCla.get(i));
        }
    }
    
    @FXML
    private void eliminar(ActionEvent event) {
        List<Classe> obCla = listC2.getSelectionModel().getSelectedItems();
        for (int i=0; i<obCla.size();i++){
            listC2.getItems().remove(obCla.get(i));
        }
    }

}
