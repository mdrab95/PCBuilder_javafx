package com.pcbuilder.controller;

import com.pcbuilder.MainApp;
import com.pcbuilder.model.ModelCase;
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

public class CaseOverviewController implements Initializable {
    
    @FXML
    private ListView<ModelCase> caseListView;
    private final ObservableList<ModelCase> caseData = FXCollections.observableArrayList();
    private final ObservableList<ModelCase> finalData = FXCollections.observableArrayList();
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void filterButton (ObservableList<ModelCase> caseDataList){

    }

    @FXML
    public void initialize (URL location, ResourceBundle resources) {
        caseData.clear();
        caseData.add(new ModelCase("SilentiumPC", "SPC143", "RG1 Pure Black", "ATX, µATX", "midi-tower",
                "bottom",44.7, 20.8, 43, 4.4, 160, 2,2,2,
                0, 3,120, 0, 0, 0, 1,
                1, 120, 130,"images/caseImages/big/", "images/caseImages/small/" ));
        Comparator<ModelCase> comparator = Comparator.comparingInt(ModelCase::getPrice);
        FXCollections.sort(caseData, comparator.reversed());

        caseListView.setItems(caseData);

        caseListView.setCellFactory(new Callback<ListView<ModelCase>, ListCell<ModelCase>>() {

            @Override
            public ListCell<ModelCase> call(ListView<ModelCase> param) {
                ListCell<ModelCase> cell = new ListCell<ModelCase>(){
                    @Override
                    protected void updateItem(ModelCase caseItem, boolean empty){
                        setText(null);
                        setGraphic(null);
                        super.updateItem(caseItem, empty);
                        if (caseItem != null) {
                            try {
                                Image img = new Image(caseItem.getSmallImagePath() + caseItem.getSerialNumber() + ".png", true);
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

                            setText(caseItem.getBrand() + " " + caseItem.getName()
                                    + "\nCompatibility: " + caseItem.getFormFactor() + ", Type: " + caseItem.getType()
                                    + "\nPrice: " + caseItem.getPrice() + " PLN");
                        }
                    }
                };
                return cell;
            }
        });
    }
}
