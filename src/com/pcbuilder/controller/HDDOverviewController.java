package com.pcbuilder.controller;

import com.pcbuilder.MainApp;
import com.pcbuilder.model.ModelHDD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class HDDOverviewController implements Initializable {

    @FXML
    private ListView<ModelHDD> hddListView;
    private final ObservableList<ModelHDD> hddData = FXCollections.observableArrayList();
    private final ObservableList<ModelHDD> finalData = FXCollections.observableArrayList();
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void filterButton (ObservableList<ModelHDD> hddDataList){

    }

    @FXML
    public void initialize (URL location, ResourceBundle resources) {
        hddData.clear();
        hddData.add(new ModelHDD("test", "test", "test", "test", "test",
                0, 0, 0, 0, 0, 0, 0,
                0, 0, "", ""));

        Comparator<ModelHDD> comparator = Comparator.comparingInt(ModelHDD::getPrice);
        FXCollections.sort(hddData, comparator.reversed());

        hddListView.setItems(hddData);

        hddListView.setCellFactory(new Callback<ListView<ModelHDD>, ListCell<ModelHDD>>() {
            @Override
            public ListCell<ModelHDD> call(ListView<ModelHDD> param) {
                ListCell<ModelHDD> cell = new ListCell<ModelHDD>(){
                    @Override
                    protected void updateItem(ModelHDD hddItem, boolean empty){
                        setText(null);
                        setGraphic(null);
                        super.updateItem(hddItem, empty);
                        if (hddItem != null) {
                            try {
                                Image img = new Image(hddItem.getSmallImagePath(), true);
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

                            setText(hddItem.getBrand());
                        }
                    }
                };
                return cell;
            }
        });
    }
}
