/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasetorreforta;

import databasetorreforta.controlador.FXMLlogin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sergi
 */
public class DATABASETORREFORTA extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("vista/FXMLlogin.fxml"));
        FXMLlogin controlador = new FXMLlogin();

        fxml.setController(controlador);
        Parent root=fxml.load();
        
        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Aplicació TorrefortaDB");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
