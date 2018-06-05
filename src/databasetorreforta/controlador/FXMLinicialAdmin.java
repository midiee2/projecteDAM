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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author alumne
 */
public class FXMLinicialAdmin implements Initializable{

    //S'HA DE MIRAR COM FER A LES VISTES DE PROFESSORS EL COMBOBOX AMB CHECK O FER MULTIPLES CHECKS


    @FXML
    private AnchorPane panel1;

    @FXML
    private void afegirAlumne(ActionEvent event) throws IOException {
        FXMLLoader fxmlAdmin = new FXMLLoader(DATABASETORREFORTA.class.getResource("vista/FXMLafegirAlumne.fxml"));
        FXMLAfegirAlumne controlador = new FXMLAfegirAlumne();     
        fxmlAdmin.setController(controlador);
        AnchorPane pNou = fxmlAdmin.load();
        panel1.getChildren().clear();
        panel1.getChildren().add(pNou);
    }

//    @FXML
//    private void afegirProfessor(ActionEvent event) throws IOException {
////        FXMLLoader fxmlAdmin = new FXMLLoader(TorrefortaDB.class.getResource("admin/FXMLafegirProfessor.fxml"));
////        FXMLAfegirProfessor controlador = new FXMLAfegirProfessor();
////        controlador.assignaModel(model);
////        fxmlAdmin.setController(controlador);
////        AnchorPane pNou = fxmlAdmin.load();
////        panel1.getChildren().clear();
////        panel1.getChildren().add(pNou);
//    }
//
//    @FXML
//    private void afegirAssignatura(ActionEvent event) throws IOException {
//        FXMLLoader fxmlAdmin = new FXMLLoader(TorrefortaDB.class.getResource("admin/FXMLafegirAssignatura.fxml"));
//        FXMLAfegirAssignatura controlador = new FXMLAfegirAssignatura();
//        controlador.assignaModel(model);
//        fxmlAdmin.setController(controlador);
//        AnchorPane pNou = fxmlAdmin.load();
//        panel1.getChildren().clear();
//        panel1.getChildren().add(pNou);
//    }
//
//    @FXML
//    private void modificarAlumne(ActionEvent event) throws IOException {
//        FXMLLoader fxmlAdmin = new FXMLLoader(TorrefortaDB.class.getResource("admin/FXMLmodificarAlumne.fxml"));
//        FXMLModificarAlumne controlador = new FXMLModificarAlumne();
//        controlador.assignaModel(model);
//        fxmlAdmin.setController(controlador);
//        AnchorPane pNou = fxmlAdmin.load();
//        panel1.getChildren().clear();
//        panel1.getChildren().add(pNou);
//    }
//
//    @FXML
//    private void modificarProfessor(ActionEvent event) throws IOException {
//        FXMLLoader fxmlAdmin = new FXMLLoader(TorrefortaDB.class.getResource("admin/FXMLmodificarProfessor.fxml"));
//        FXMLModificarProfessor controlador = new FXMLModificarProfessor();
//        controlador.assignaModel(model);
//        fxmlAdmin.setController(controlador);
//        AnchorPane pNou = fxmlAdmin.load();
//        panel1.getChildren().clear();
//        panel1.getChildren().add(pNou);
//    }
//
//    @FXML
//    private void modificarAssignatura(ActionEvent event) throws IOException {
//        FXMLLoader fxmlAdmin = new FXMLLoader(TorrefortaDB.class.getResource("admin/FXMLmodificarAssignatura.fxml"));
//        FXMLModificarAssignatura controlador = new FXMLModificarAssignatura();
//        controlador.assignaModel(model);
//        fxmlAdmin.setController(controlador);
//        AnchorPane pNou = fxmlAdmin.load();
//        panel1.getChildren().clear();
//        panel1.getChildren().add(pNou);
//    }
//
//    @FXML
//    private void eliminarAlumne(ActionEvent event) throws IOException {
//        FXMLLoader fxmlAdmin = new FXMLLoader(TorrefortaDB.class.getResource("admin/FXMLeliminarAlumne.fxml"));
//        FXMLEliminarAlumne controlador = new FXMLEliminarAlumne();
//        controlador.assignaModel(model);
//        fxmlAdmin.setController(controlador);
//        AnchorPane pNou = fxmlAdmin.load();
//        panel1.getChildren().clear();
//        panel1.getChildren().add(pNou);
//    }
//
//    @FXML
//    private void eliminarProfessor(ActionEvent event) throws IOException {
//        FXMLLoader fxmlAdmin = new FXMLLoader(TorrefortaDB.class.getResource("admin/FXMLeliminarProfessor.fxml"));
//        FXMLEliminarProfessor controlador = new FXMLEliminarProfessor();
//        controlador.assignaModel(model);
//        fxmlAdmin.setController(controlador);
//        AnchorPane pNou = fxmlAdmin.load();
//        panel1.getChildren().clear();
//        panel1.getChildren().add(pNou);
//    }
//     @FXML
//    private void eliminarAssignatura(ActionEvent event) throws IOException {
//        FXMLLoader fxmlAdmin = new FXMLLoader(TorrefortaDB.class.getResource("admin/FXMLeliminarAssignatura.fxml"));
//        FXMLEliminarAssignatura controlador = new FXMLEliminarAssignatura();
//        controlador.assignaModel(model);
//        fxmlAdmin.setController(controlador);
//        AnchorPane pNou = fxmlAdmin.load();
//        panel1.getChildren().clear();
//        panel1.getChildren().add(pNou);
//    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
 

}
