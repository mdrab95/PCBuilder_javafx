package com.pcbuilder.controller;

import com.pcbuilder.MainApp;
import com.pcbuilder.model.ModelRAM;
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
import java.util.Comparator;
import java.util.ResourceBundle;

public class RAMOverviewController implements Initializable {

    @FXML
    private ListView<ModelRAM> ramListView;
    private final ObservableList<ModelRAM> ramData = FXCollections.observableArrayList();
    private final ObservableList<ModelRAM> finalData = FXCollections.observableArrayList();
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void filterButton (ObservableList<ModelRAM> ramDataList){

    }

    @FXML
    public void initialize (URL location, ResourceBundle resources) {
        ramData.clear();
        ramData.add(new ModelRAM("test", "test", "test", "test", 0, 0,
                0, "test", 0, 0, 0, 0, false, false,
                0, "", ""));

        Comparator<ModelRAM> comparator = Comparator.comparingInt(ModelRAM::getPrice);
        FXCollections.sort(ramData, comparator.reversed());

        ramListView.setItems(ramData);

        ramListView.setCellFactory(new Callback<ListView<ModelRAM>, ListCell<ModelRAM>>() {
            @Override
            public ListCell<ModelRAM> call(ListView<ModelRAM> param) {
                ListCell<ModelRAM> cell = new ListCell<ModelRAM>(){
                    @Override
                    protected void updateItem(ModelRAM ramItem, boolean empty){
                        setText(null);
                        setGraphic(null);
                        super.updateItem(ramItem, empty);
                        if (ramItem != null) {
                            try {
                                Image img = new Image(ramItem.getSmallImagePath(), true);
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

                            setText(ramItem.getBrand());
                        }
                    }
                };
                return cell;
            }
        });
    }
}
