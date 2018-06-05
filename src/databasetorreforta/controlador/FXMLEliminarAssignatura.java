/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta.controlador;

import databasetorreforta.dao.AlumneDAOImpl;
import databasetorreforta.dao.AssignaturaDAOImpl;
import databasetorreforta.domini.Alumne;
import databasetorreforta.domini.Assignatura;
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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author alumne
 */
public class FXMLEliminarAssignatura implements Initializable{

    AssignaturaDAOImpl aDao = new AssignaturaDAOImpl();
    @FXML
    private ComboBox cb_assignatura;
    @FXML
    private Text text_class, text_ass;
    @FXML
    private Label resposta;
    
    
     @FXML
     private void esborrar(ActionEvent event) throws IOException {
        cb_assignatura.setValue(null);
        resposta.setText("");
        text_class.setText("");
        text_ass.setText("");
    }

    @FXML
    private void eliminar(ActionEvent event) throws IOException {
        int indexAssignatura = cb_assignatura.getSelectionModel().getSelectedIndex();
        List<Assignatura> listAssignatura = aDao.getTots();
        List<Assignatura> listAss = new ArrayList<>();
        for (int i=0;i<listAssignatura.size();i++){
            if (!listAss.contains(listAssignatura.get(i))){
                listAss.add(listAssignatura.get(i));
            }
        }
        Assignatura a = listAss.get(indexAssignatura);
        aDao.eliminar(a);
        resposta.setText("Assignatura eliminada correctament");
        listAssignatura = aDao.getTots();
        listAss = new ArrayList<>();
        for (int i=0;i<listAssignatura.size();i++){
            if (!listAss.contains(listAssignatura.get(i))){
                listAss.add(listAssignatura.get(i));
            }
        }
        eliminar();
        cb_assignatura.setItems(FXCollections.observableArrayList(listAss));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Assignatura> listAssignatura = aDao.getTots();
        List<Assignatura> listAss = new ArrayList<>();
        for (int i=0;i<listAssignatura.size();i++){
            if (!listAss.contains(listAssignatura.get(i))){
                listAss.add(listAssignatura.get(i));
            }
        }
        cb_assignatura.setItems(FXCollections.observableArrayList(listAss));
    }
    public void eliminar(){
        text_class.setText("");
        text_ass.setText("");
        
    }
    
    @FXML
    private void combobox(ActionEvent event) {
        int indexAssignatura = cb_assignatura.getSelectionModel().getSelectedIndex();
        List<Assignatura> listAssignatura = aDao.getTots();
        List<Assignatura> listAss = new ArrayList<>();
        for (int i=0;i<listAssignatura.size();i++){
            if (!listAss.contains(listAssignatura.get(i))){
                listAss.add(listAssignatura.get(i));
            }
        }
        text_ass.setText(listAss.get(indexAssignatura).getNom());
        text_class.setText(listAss.get(indexAssignatura).getClasseList().toString());
    }
    
}
