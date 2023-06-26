/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrojogo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Felipe
 */
public class FXMLTelaInicialController implements Initializable {

    @FXML
    private MenuItem menuItemCadastroArbitro;
    
    @FXML
    private MenuItem menuItemProcessosCartoes;
    
    @FXML
    private MenuItem menuItemGraficosCartoes;
    
    @FXML
    private MenuItem menuItemRelatoriosCartoes;
    
    @FXML
    private AnchorPane anchorPane;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

   
    
    @FXML
    public void handleMenuItemCadastroArbitro() throws IOException {
        /*
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/cadastrojogo/view/FXMLCadastroArbitro.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stageCadastroArbitro = new Stage();     
        stageCadastroArbitro.setScene(scene);
        stageCadastroArbitro.show();*/
        
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/cadastrojogo/view/FXMLCadastroArbitro.fxml"));
        anchorPane.getChildren().setAll(a);
        
        
    }
    
    /*
    @FXML
    public void handleMenuItemProcessosCartoes() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/cadastrojogo/view/FXMLProcessoCartao.fxml"));
        anchorPane.getChildren().setAll(a);
    } */
    
}
