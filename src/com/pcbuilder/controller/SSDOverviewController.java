package com.pcbuilder.controller;

import com.pcbuilder.MainApp;
import com.pcbuilder.model.ModelSSD;
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

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class SSDOverviewController implements Initializable {

    @FXML
    private ListView<ModelSSD> ssdListView;
    private final ObservableList<ModelSSD> ssdData = FXCollections.observableArrayList();
    private final ObservableList<ModelSSD> finalData = FXCollections.observableArrayList();
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void filterButton (ObservableList<ModelSSD> ssdDataList){

    }

    @FXML
    public void initialize (URL location, ResourceBundle resources) {
        ssdData.clear();
        DataLoader loader = new DataLoader();
        try {
            ssdData.addAll(loader.ssdDataLoader());
        } catch (IOException e) {}

        ssdListView.setItems(ssdData);

        ssdListView.setCellFactory(new Callback<ListView<ModelSSD>, ListCell<ModelSSD>>() {
            @Override
            public ListCell<ModelSSD> call(ListView<ModelSSD> param) {
                ListCell<ModelSSD> cell = new ListCell<ModelSSD>(){
                    @Override
                    protected void updateItem(ModelSSD ssdItem, boolean empty){
                        setText(null);
                        setGraphic(null);
                        super.updateItem(ssdItem, empty);
                        if (ssdItem != null) {
                            try {
                                Image img = new Image(ssdItem.getSmallImagePath() + ssdItem.getSerialNumber() + ".png", true);
                                ImageView imageView = new ImageView(img);
                                imageView.setFitHeight(100);
                                imageView.setFitWidth(100);
                                setGraphic(imageView);
                            }
                            catch (Exception ex){
                                Image img = new Image("images/no_img.png");
                                ImageView imageView = new ImageView(img);
                                imageView.setFitHeight(100);
                                imageView.setFitWidth(100);
                                setGraphic(imageView);
                            }

                            setText(ssdItem.getBrand() + " " + ssdItem.getName() + " " + ssdItem.getCapacity() + " GB"
                                    + "\n" + "Form factor: " + ssdItem.getFormFactor() + ", interface type: " + ssdItem.getInterfaceType() + ", memory type: " + ssdItem.getMemoryType()
                                    + "\nRead: " + ssdItem.getReadSpeed() + "MB/s, write: " + ssdItem.getWriteSpeed() + "MB/s " + ", TBW: " + ssdItem.getTbw() + "TB"
                                    + "\nPrice: " + ssdItem.getPrice() + "PLN");
                        }
                    }
                };
                return cell;
            }
        });
    }
}
