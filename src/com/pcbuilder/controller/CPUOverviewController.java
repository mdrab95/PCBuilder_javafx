package com.pcbuilder.controller;

import com.pcbuilder.MainApp;
import com.pcbuilder.model.ModelCPU;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ace on 2017-05-14.
 */
public class CPUOverviewController implements Initializable {

    @FXML
    private ListView<ModelCPU> cpuListView;
    private final ObservableList<ModelCPU> cpuData = FXCollections.observableArrayList();
    private final ObservableList<ModelCPU> finalData = FXCollections.observableArrayList();
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void filterButton (ObservableList<ModelCPU> cpuDataList){

    }


    @FXML
    public void initialize (URL location, ResourceBundle resources) {
        cpuData.clear();
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "7700k", "core i7", 14, 4, 8,
                4.2, 4.5, 1, 8, 91, 140, false, 1700, "images/cpuImages/i7-7700k.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "7700", "core i7", 14, 4, 8,
                3.6, 4.2, 1, 8, 65, 95, true, 1500, "images/cpuImages/i7-7700.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "7600k", "core i5", 14, 4, 4,
                3.8, 4.2, 1, 6, 91, 115, false, 1200, "images/cpuImages/i5-7600k.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "7600", "core i5", 14, 4, 4,
                3.5, 4.1, 1, 6, 65, 85, true,  1000, "images/cpuImages/i5-7600.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "7500", "core i5", 14, 4, 4,
                3.4, 3.8, 1, 6, 65, 80, true, 930, "images/cpuImages/i5-7500.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "7400", "core i5", 14, 4, 4,
                3.0, 3.5, 1, 6, 65, 75, true, 850, "images/cpuImages/i5-7400.png"));
        cpuListView.setItems(cpuData);
        cpuListView.setCellFactory(new Callback<ListView<ModelCPU>, ListCell<ModelCPU>>() {
            @Override
            public ListCell<ModelCPU> call(ListView<ModelCPU> param) {
                ListCell<ModelCPU> cell = new ListCell<ModelCPU>(){
                    @Override
                    protected void updateItem(ModelCPU cpuItem, boolean empty){
                        setText(null);
                        setGraphic(null);
                        super.updateItem(cpuItem, empty);
                        if (cpuItem != null) {
                            try {
                                Image img = new Image(cpuItem.getImagePath(), true);
                                ImageView imageView = new ImageView(img);
                                imageView.setFitHeight(75);
                                imageView.setFitWidth(75);
                                setGraphic(imageView);
                            }
                            catch (Exception ex){
                                    Image img = new Image("images/no_img.png");
                                    ImageView imageView = new ImageView(img);
                                    imageView.setFitHeight(75);
                                    imageView.setFitWidth(75);
                                    setGraphic(imageView);
                                }
                            setText(cpuItem.getBrand() + " " + cpuItem.getFamily() + " " +  cpuItem.getName()
                                    + ", " + cpuItem.getSpeed() + "GHz, " + cpuItem.getCacheL3() + " MB");
                        }
                    }
                };
                return cell;
            }
        });
    }
}
