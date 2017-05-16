package com.pcbuilder.controller;

import com.pcbuilder.MainApp;
import com.pcbuilder.model.ModelCPUCooler;
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

public class CPUCoolerOverviewController implements Initializable {

    @FXML
    private ListView<ModelCPUCooler> cpuCoolerListView;
    private final ObservableList<ModelCPUCooler> cpuCoolerData = FXCollections.observableArrayList();
    private final ObservableList<ModelCPUCooler> finalData = FXCollections.observableArrayList();
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void filterButton (ObservableList<ModelCPUCooler> cpuCoolerDataList){

    }


    @FXML
    public void initialize (URL location, ResourceBundle resources) {
        cpuCoolerData.clear();
        cpuCoolerData.add(new ModelCPUCooler("Cooler Master", "Hyper 212 LED Turbo black", "RR-212TK-16PR-R1",
                "775, 1150, 1151, 1155, 1156, 2011, 2011-3, AM2, AM3, AM3+, AM4, FM1, FM2, FM2+", "Tower Cooler", 108,
                120,163, 468, 113, 4, 2, 120, 25,
                650, 2000,6, 30, 5, "4-Pin PWM",
                180, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));
        cpuCoolerData.add(new ModelCPUCooler("Cooler Master", "GeminII M4", "RR-GMM4-16PK-R1",
                "775, 1150, 1151, 1155, 1156, 1366, AM2, AM2+, AM3, AM3+, FM1, FM2, FM2+", "Top-Blow Cooler", 122,
                137,59, 210, 99.2, 4, 1, 120, 15,
                500, 1600,8, 30, 5, "4-Pin PWM",
                150, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));
        cpuCoolerData.add(new ModelCPUCooler("Cooler Master", "MasterAir Pro 4", "MAY-T4PN-220PK-R1",
                "775, 1150, 1151, 1155, 1156, 1366, 2011, 2011-3, AM2, AM2+, AM3, AM3+, AM4, FM1, FM2, FM2+", "Tower Cooler", 84,
                129,158.5, 472, 113, 4, 1, 120, 25,
                650, 2000,6, 30, 5, "4-Pin PWM",
                170, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));
        cpuCoolerData.add(new ModelCPUCooler("Cooler Master", "V8", "RR-V8VC-16PR-R1",
                "775, 1150, 1151, 1155, 1156, 1366, 2011, 2011-3, AM2, AM2+, AM3, AM3+, FM1, FM2, FM2+", "Tower Cooler", 145,
                148.5,166.5, 854, 138.58, 8, 2, 120, 25,
                600, 1600,16, 36, 5, "4-Pin PWM",
                400, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));
        cpuCoolerListView.setItems(cpuCoolerData);
        cpuCoolerListView.setCellFactory(new Callback<ListView<ModelCPUCooler>, ListCell<ModelCPUCooler>>() {
            @Override
            public ListCell<ModelCPUCooler> call(ListView<ModelCPUCooler> param) {
                ListCell<ModelCPUCooler> cell = new ListCell<ModelCPUCooler>(){
                    @Override
                    protected void updateItem(ModelCPUCooler cpuCoolerItem, boolean empty){
                        setText(null);
                        setGraphic(null);
                        super.updateItem(cpuCoolerItem, empty);
                        if (cpuCoolerItem != null) {
                            try {
                                Image img = new Image(cpuCoolerItem.getSmallImagePath() + cpuCoolerItem.getManufacturerCode() + ".png", true);
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
                            String dimensions = cpuCoolerItem.getWidth() + "x" + cpuCoolerItem.getHeight() + "x" + cpuCoolerItem.getDepth() + "mm";
                            String fans = "";
                                    if (cpuCoolerItem.getNumberOfFans() >1)
                                        fans += cpuCoolerItem.getNumberOfFans() + "x ";
                            fans += cpuCoolerItem.getFanSizeDiameter() + "x" + cpuCoolerItem.getFanSizeDiameter() + "x" + cpuCoolerItem.getFanSizeHeight() + "mm";

                            setText(cpuCoolerItem.getBrand() + " " + cpuCoolerItem.getName() + " (" + cpuCoolerItem.getManufacturerCode() + " )"
                                    + "\nDimensions (WxHxD): " + dimensions + ", Fan(s):  " + fans
                                    + "\nWeight: " + cpuCoolerItem.getWeight() + "g, " + cpuCoolerItem.getAirFlow() + "m³/h, " + cpuCoolerItem.getMinFanNoise() + "-" + cpuCoolerItem.getMaxFanNoise() + "dB(A), Connector: "  + cpuCoolerItem.getConnectorType());
                        }
                    }
                };
                return cell;
            }
        });
    }
}
