/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrojogo.controller;

import cadastrojogo.model.dao.CartaoDAO;
import cadastrojogo.model.database.Database;
import cadastrojogo.model.database.DatabaseFactory;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Felipe
 */
public class FXMLGraficoCartaoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis categoryAxis;

    @FXML
    private NumberAxis numberAxis;
    
    private ObservableList<String> observableListMeses = FXCollections.observableArrayList();

    //Atributos para manipulação de Banco de Dados
    private final Database database = DatabaseFactory.getDatabase("postgresql");
    private final Connection connection = database.conectar();
    private final CartaoDAO cartaoDAO = new CartaoDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Obtém an array com nomes dos meses em Inglês.
        String[] arrayMeses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
        // Converte o array em uma lista e adiciona em nossa ObservableList de meses.
        observableListMeses.addAll(Arrays.asList(arrayMeses));

        // Associa os nomes de mês como categorias para o eixo horizontal.
        categoryAxis.setCategories(observableListMeses);
        
        cartaoDAO.setConnection(connection);
        Map<Integer, ArrayList> dados = cartaoDAO.listarQuantidadeCartaoPorMes();

        for (Map.Entry<Integer, ArrayList> dadosItem : dados.entrySet()) {
            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.setName(dadosItem.getKey().toString());

            for (int i = 0; i < dadosItem.getValue().size(); i = i + 2) {
                String mes;
                Integer quantidade;

                mes = retornaNomeMes((int) dadosItem.getValue().get(i));
                quantidade = (Integer) dadosItem.getValue().get(i + 1);

                series.getData().add(new XYChart.Data<>(mes, quantidade));
            }
            barChart.getData().add(series);
        }
        //barChart.getData().sorted();
        
        //ObservableList<String> list = categoryAxis.getCategories();
        //Comparator<String> byValue = (e1, e2) -> Integer.compare(Integer.parseInt(e1), Integer.parseInt(e2));
        //list.sort(byValue);
        //categoryAxis.setCategories(list);
    }

    public String retornaNomeMes(int mes) {
        switch (mes) {
            case 1:
                return "Jan";
            case 2:
                return "Fev";
            case 3:
                return "Mar";
            case 4:
                return "Abr";
            case 5:
                return "Mai";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Ago";
            case 9:
                return "Set";
            case 10:
                return "Out";
            case 11:
                return "Nov";
            case 12:
                return "Dez";
            default:
                return "";
        } 
    }
}
