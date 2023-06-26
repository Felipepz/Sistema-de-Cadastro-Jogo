/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrojogo.controller;

import cadastrojogo.model.Arbitro;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Felipe
 */
public class FXMLCadastroArbitroInserirController implements Initializable {
    
    @FXML
    private DatePicker datePickerCadastroArbitro;   
    @FXML
    private TextField textFieldNomeCadastroArbitro;  
    @FXML
    private TextField textFieldCPFCadastroArbitro;   
    @FXML
    private TextField textFieldNacionalidadeCadastroArbitro;  
    @FXML
    private TextField textFieldFormacaoCadastroArbitro; 
    @FXML
    private Label labelNomeCadastroArbitro;
    @FXML
    private Label labelCPFCadastroArbitro;
    @FXML
    private Label labelDataDeNascimentoCadastroArbitro;
    @FXML
    private Label labelNacionalidadeCadastroArbitro;
    @FXML
    private Label labelFormacaoCadastroArbitro;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;
    
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false; 
    
    private Arbitro arbitro;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public Arbitro getArbitro() {
        return this.arbitro;
    }
    
    public void setArbitro(Arbitro arbitro){
        this.arbitro = arbitro;
        this.textFieldNomeCadastroArbitro.setText(arbitro.getNome());
        this.textFieldCPFCadastroArbitro.setText(arbitro.getCpf());
        this.textFieldNacionalidadeCadastroArbitro.setText(arbitro.getNacionalidade());
        this.textFieldFormacaoCadastroArbitro.setText(arbitro.getFormacao());
        arbitro.setDataDeNascimento(datePickerCadastroArbitro.getValue());
        
    }
    
    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }
    
    @FXML
    public void handleButtonConfirmar() {
        if (validarEntradaDeDados()) {
            arbitro.setNome(textFieldNomeCadastroArbitro.getText());
            arbitro.setCpf(textFieldCPFCadastroArbitro.getText());
            arbitro.setDataDeNascimento(datePickerCadastroArbitro.getValue());
            arbitro.setNacionalidade(textFieldNacionalidadeCadastroArbitro.getText());
            arbitro.setFormacao(textFieldFormacaoCadastroArbitro.getText());

            buttonConfirmarClicked = true;
            dialogStage.close();
        }
    } 
    
    @FXML
    public void handleButtonCancelar() {
        getDialogStage().close();
    } 
    
    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (textFieldNomeCadastroArbitro.getText() == null || textFieldNomeCadastroArbitro.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        if (textFieldCPFCadastroArbitro.getText() == null || textFieldCPFCadastroArbitro.getText().length() == 0) {
            errorMessage += "CPF inválido!\n";
        }
        if (textFieldNacionalidadeCadastroArbitro.getText() == null || textFieldNacionalidadeCadastroArbitro.getText().length() == 0) {
            errorMessage += "Nacionalidade inválido!\n";
        }
        if (textFieldFormacaoCadastroArbitro.getText() == null || textFieldFormacaoCadastroArbitro.getText().length() == 0) {
            errorMessage += "Formação inválido!\n";
        }
    
        // Implementar a validação do Date Picker
        

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }
    
}
