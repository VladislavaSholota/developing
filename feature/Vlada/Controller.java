package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

public class Controller {

    private ObservableList<TableElements> usersData = FXCollections.observableArrayList();
    @FXML
    AreaChart area;

    @FXML TableView <TableElements> table;
    @FXML TableColumn <TableElements, Integer> column1;
    @FXML TableColumn <TableElements, Integer> column2;
    @FXML TableColumn <TableElements, Integer> column3;
    @FXML TableColumn <TableElements, Integer> column4;
    @FXML TableColumn <TableElements, Integer> column5;
    @FXML TableColumn <TableElements, Integer> column6;
    @FXML TableColumn <TableElements, Integer> column7;
    @FXML TableColumn <TableElements, Integer> column8;
    @FXML TableColumn <TableElements, Integer> column9;
    @FXML TableColumn <TableElements, Integer> column10;

    @FXML public void pressBubble(ActionEvent actionEvent){
        indent(1);

    }
    @FXML public void pressCoctail(ActionEvent actionEvent){
        indent(2);

    }
    @FXML public void pressExtrem(ActionEvent actionEvent){
        indent(3);

    }
    @FXML public void pressInsert(ActionEvent actionEvent){
        indent(4);

    }
    @FXML public void pressQuick(ActionEvent actionEvent){

    }
    @FXML public void press1(ActionEvent actionEvent){

    }
    @FXML public void press2(ActionEvent actionEvent){

    }
    @FXML public void press3(ActionEvent actionEvent){

    }

    public void indent(Integer idn){
        Integer n = 10;
        Random random = new Random();
        Integer [] a = new Integer[n];
        for (int i = 0; i < n; i ++){
            a[i] = random.nextInt(n);
        }
        ArrayList <ArrayList<Integer>> arrayLists = null;
        switch (idn){
            case (1): {
                arrayLists = TableSortings.bubble(a, n);
                break;
            }
            case (2): {
                arrayLists = TableSortings.coctail(a, n);
                break;
            }
            case (3): {
                arrayLists = TableSortings.extrem(a, n);
                break;
            }
            case (4): {
                arrayLists = TableSortings.insert(a, n);
                break;
            }
            default: break;
        }

        for (int i = 0; i < arrayLists.size(); i ++){
            ArrayList <Integer> arrayList = arrayLists.get(i);
            usersData.add(new TableElements(arrayList.get(0), arrayList.get(1), arrayList.get(2),
                    arrayList.get(3), arrayList.get(4), arrayList.get(5), arrayList.get(6), arrayList.get(7),
                    arrayList.get(8), arrayList.get(9)));
        }
        column1.setCellValueFactory(new PropertyValueFactory<TableElements, Integer>("c1"));
        column2.setCellValueFactory(new PropertyValueFactory<TableElements, Integer>("c2"));
        column3.setCellValueFactory(new PropertyValueFactory<TableElements, Integer>("c3"));
        column4.setCellValueFactory(new PropertyValueFactory<TableElements, Integer>("c4"));
        column5.setCellValueFactory(new PropertyValueFactory<TableElements, Integer>("c5"));
        column6.setCellValueFactory(new PropertyValueFactory<TableElements, Integer>("c6"));
        column7.setCellValueFactory(new PropertyValueFactory<TableElements, Integer>("c7"));
        column8.setCellValueFactory(new PropertyValueFactory<TableElements, Integer>("c8"));
        column9.setCellValueFactory(new PropertyValueFactory<TableElements, Integer>("c9"));
        column10.setCellValueFactory(new PropertyValueFactory<TableElements, Integer>("c10"));
        table.setItems(usersData);

        ArrayList <TimeForTable> timeForTables = new ArrayList<>();

        for (int i = 1; i <= 20; i ++){
            long time = 0;
            for (int k = 0; k < 5; k ++) {
                n = 50 * i;
                a = new Integer[n];
                for (int j = 0; j < n; j++) {
                    a[j] = random.nextInt(n);
                }
                long time1 = System.nanoTime();
                Integer c = 0;
                switch (idn){
                    case (1): {
                        c = Sortings.bubble(a, n);
                        break;
                    }
                    case (2): {
                        c = Sortings.coctail(a, n);
                        break;
                    }
                    case (3): {
                        c = Sortings.extrem(a, n);
                        break;
                    }
                    case (4): {
                        c = Sortings.insert(a, n);
                        break;
                    }
                    default: break;
                }
                time = time + System.nanoTime() - time1;
            }
            timeForTables.add(new TimeForTable(n, time/5));
        }
        XYChart.Series series = new XYChart.Series();
        switch (idn){
            case (1): {
                series.setName("Р‘СѓР»СЊР±Р°С€РєРѕРІРµ СЃРѕСЂС‚СѓРІР°РЅРЅСЏ");
                break;
            }
            case (2): {
                series.setName("РЎРѕСЂС‚СѓРІР°РЅРЅСЏ Р·РјС–С€СѓРІР°РЅРЅСЏРј");
                break;
            }
            case (3): {
                series.setName("РЎРѕСЂС‚СѓРІР°РЅРЅСЏ С€Р»СЏС…РѕРј РїРѕС€СѓРєСѓ РµРєСЃС‚СЂРµРјР°Р»СЊРЅРѕРіРѕ Р·РЅР°С‡РµРЅРЅСЏ");
                break;
            }
            case (4): {
                series.setName("РЎРѕСЂС‚СѓРІР°РЅРЅСЏ РІСЃС‚Р°РІРєРѕСЋ");
                break;
            }
            default: break;
        }
        for (int i = 0; i < timeForTables.size(); i ++){
            series.getData().add(new XYChart.Data(timeForTables.get(i).n.toString(), timeForTables.get(i).time));
        }
        area.getData().add(series);
        area.setVisible(true);
        table.setVisible(true);
    }
}
