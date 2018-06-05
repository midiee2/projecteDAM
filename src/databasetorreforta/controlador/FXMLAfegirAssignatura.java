/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta.controlador;

import databasetorreforta.dao.AssignaturaDAOImpl;
import databasetorreforta.dao.ClasseDAOImpl;
import databasetorreforta.domini.Assignatura;
import databasetorreforta.domini.Classe;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

/**
 *
 * @author alumne
 */
public class FXMLAfegirAssignatura implements Initializable {

    ClasseDAOImpl cDao = new ClasseDAOImpl();
    AssignaturaDAOImpl aDao = new AssignaturaDAOImpl();
    
    @FXML
    private TextField tf_nom;
    @FXML
    private ComboBox cb_classe;
    @FXML
    private Button b_afegir, b_esborrar;
    @FXML
    private ListView<Classe> listC;
    @FXML
    private Label resposta;

    @FXML
    private void esborrar(ActionEvent event) throws IOException {
        tf_nom.clear();
        cb_classe.setValue(null);
        resposta.setText("");
    }

    @FXML
    private void afegir(ActionEvent event) throws IOException {
        if (!tf_nom.getText().equals("")) {
            List<Classe> obCla = listC.getSelectionModel().getSelectedItems();
            int n = aDao.getTots().size();
            Assignatura a = new Assignatura(String.valueOf(n));
            a.setNom(tf_nom.getText());
            a.setClasseList(obCla);
            aDao.inserir(a);
            resposta.setText(tf_nom.getText()+" afegida correctament a: "+obCla.get(0).toString()+", "+obCla.get(1).toString());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        List<Classe> listClasse = cDao.getTots();
        listC.setItems(FXCollections.observableArrayList(listClasse));
        listC.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

}
