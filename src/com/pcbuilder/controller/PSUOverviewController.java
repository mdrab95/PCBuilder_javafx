package com.pcbuilder.controller;

import com.pcbuilder.MainApp;
import com.pcbuilder.model.ModelPSU;
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

public class PSUOverviewController implements Initializable {

    @FXML
    private ListView<ModelPSU> psuListView;
    private final ObservableList<ModelPSU> psuData = FXCollections.observableArrayList();
    private final ObservableList<ModelPSU> finalData = FXCollections.observableArrayList();
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void filterButton (ObservableList<ModelPSU> psuDataList){

    }

    @FXML
    public void initialize (URL location, ResourceBundle resources) {
        psuData.clear();
        psuData.add(new ModelPSU("SilentiumPC", "Supremo M2 Gold", "SPC140", "ATX", "80 Plus Gold",
                "Active with passive mode", "SIP, OPP, OVP, SCP, UVP", 120, 163,
                true, 550,320, "images/psuImages/big/","images/psuImages/small/"));
        psuData.add(new ModelPSU("Corsair", "Corsair VS Series", "CP-9020097-EU", "ATX", "80 Plus",
                "Active with passive mode", "OVP, UVP, OCP, SCP", 120, 150, false, 550, 205,
                "images/psuImages/big/", "images/psuImages/small/"));


        Comparator<ModelPSU> comparator = Comparator.comparingInt(ModelPSU::getPrice);
        FXCollections.sort(psuData, comparator.reversed());

        psuListView.setItems(psuData);

        psuListView.setCellFactory(new Callback<ListView<ModelPSU>, ListCell<ModelPSU>>() {
            @Override
            public ListCell<ModelPSU> call(ListView<ModelPSU> param) {
                ListCell<ModelPSU> cell = new ListCell<ModelPSU>(){
                    @Override
                    protected void updateItem(ModelPSU psuItem, boolean empty){
                        setText(null);
                        setGraphic(null);
                        super.updateItem(psuItem, empty);
                        if (psuItem != null) {
                            try {
                                Image img = new Image(psuItem.getSmallImagePath()+ psuItem.getManufacturerCode() + ".png", true);
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

                            String modular = "";
                            if (psuItem.getIsModular() == true)
                                modular = "Modular";

                            String certificate = "";
                            if (psuItem.getCertificate80Plus().length()==0)
                                certificate = "no data";

                            setText(psuItem.getBrand() + " " + psuItem.getName() + " " + psuItem.getWattage() + "W " + modular
                                    + "\nCertificate: " + psuItem.getCertificate80Plus() + ", Protection:  " + psuItem.getProtection()
                                    + "\nPrice: " + psuItem.getPrice() + " PLN");
                        }
                    }
                };
                return cell;
            }
        });
    }
}
