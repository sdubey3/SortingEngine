/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author nevehall and jothamdailly
 */
public class SortingsController implements Initializable {
    
    @FXML
    private Pane view;
    @FXML
    private ComboBox algoBox;
    @FXML
    private Slider arraySizeSlider;
    @FXML
    private Label arraySizeLabel;
    
    final ObservableList<String> data = FXCollections.observableArrayList();
    
    private final Model model = new Model();
    private SortingsStrategy sortingMethod;
    private int[] array;
    
    private int[] getArray() {
        model.setArraySize((int)arraySizeSlider.getValue());
        array = model.getUnsortedList();
        return array;
    }
    
    private ArrayList<Rectangle> getList() {
        ArrayList<Rectangle> recList = new ArrayList<>();
        for(int i=0;i<(int)arraySizeSlider.getValue();i++) {
            double width = (view.widthProperty().getValue()/(arraySizeSlider.getValue()));
            double height = (array[i]/arraySizeSlider.getValue())*view.heightProperty().getValue();
            
            double x = width*i;
            double y = view.heightProperty().getValue() - height;
            
            Rectangle r = new Rectangle();
            
            r.setX(x);
            r.setY(y);
            r.setWidth(width);
            r.setHeight(height);
            r.setFill(Color.RED);
            recList.add(r);
        }
        return recList;
    }
    
    private void setSortStrategy() {
        if (algoBox.getSelectionModel().isEmpty()){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please select a sorting algorithm.");

            alert.showAndWait();
        }
        else {
            if ("Selection Sort".equals(algoBox.getSelectionModel().getSelectedItem().toString())) {
                sortingMethod = new SelectionSort();
            }

            if ("Merge Sort".equals(algoBox.getSelectionModel().getSelectedItem().toString())) {
                sortingMethod = new MergeSort();
            }
            if ("Bubble Sort".equals(algoBox.getSelectionModel().getSelectedItem().toString())) {
                sortingMethod = new BubbleSort();
            }
            if ("Insertion Sort".equals(algoBox.getSelectionModel().getSelectedItem().toString())) {
                sortingMethod = new InsertionSort();
            }
            if ("Quick Sort".equals(algoBox.getSelectionModel().getSelectedItem().toString())) {
                sortingMethod = new QuickSort();
            }
        }
    }
        
    public void draw() {
        view.getChildren().clear();
        view.getChildren().addAll(getList());
    }
    
    @FXML
    public void sortBtn_Click() {
        setSortStrategy();
        new Thread(() -> {
            sortingMethod.sort(array, this);
        }).start();
    }
    
    public void arraySizeBar_ValueChanged() {
        arraySizeSlider.valueProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                arraySizeLabel.textProperty().setValue(
                        String.valueOf((int) arraySizeSlider.getValue()));
                array = getArray();
                draw();
            }
        });
    }
    
    @FXML
    public void resetBtn_Click() {
        view.getChildren().clear();
        array = getArray();
        draw();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        arraySizeSlider.setMin(50);
        arraySizeSlider.setMax(150);
        arraySizeSlider.setShowTickLabels(true);
        arraySizeSlider.setShowTickMarks(true);
        arraySizeSlider.setMajorTickUnit(50);
        arraySizeSlider.setMinorTickCount(10);
        
        arraySizeBar_ValueChanged();
        
        data.add("Selection Sort");
        data.add("Merge Sort");
        data.add("Bubble Sort");
        data.add("Insertion Sort");
        data.add("Quick Sort");
        
        algoBox.setItems(data);
        
        view.setVisible(true);
        
    }    
    
}