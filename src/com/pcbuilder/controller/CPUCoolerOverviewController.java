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
                120,163, 468, 113, 4, 2, 120, 120, 25,
                650, 2000,6, 30, 5, "4-Pin PWM",
                180, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));
        cpuCoolerData.add(new ModelCPUCooler("Cooler Master", "GeminII M4", "RR-GMM4-16PK-R1",
                "775, 1150, 1151, 1155, 1156, 1366, AM2, AM2+, AM3, AM3+, FM1, FM2, FM2+", "Top-Blow Cooler", 122,
                137,59, 210, 99.2, 4, 1, 120, 120,15,
                500, 1600,8, 30, 5, "4-Pin PWM",
                150, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));
        cpuCoolerData.add(new ModelCPUCooler("Cooler Master", "MasterAir Pro 4", "MAY-T4PN-220PK-R1",
                "775, 1150, 1151, 1155, 1156, 1366, 2011, 2011-3, AM2, AM2+, AM3, AM3+, AM4, FM1, FM2, FM2+", "Tower Cooler", 84,
                129,158.5, 472, 113, 4, 1, 120, 120, 25,
                650, 2000,6, 30, 5, "4-Pin PWM",
                170, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));
        cpuCoolerData.add(new ModelCPUCooler("Cooler Master", "V8", "RR-V8VC-16PR-R1",
                "775, 1150, 1151, 1155, 1156, 1366, 2011, 2011-3, AM2, AM2+, AM3, AM3+, FM1, FM2, FM2+", "Tower Cooler", 145,
                148.5,166.5, 854, 138.58, 8, 2, 140, 140, 25,
                600, 1600,16, 36, 5, "4-Pin PWM",
                400, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));

        cpuCoolerData.add(new ModelCPUCooler("Thermalright", "HR-02 Macho Rev. B", "100700726",
                "775, 1150, 1151, 1155, 1156, 1366, 2011, 2011-3, AM2, AM3, AM3+, AM4, FM1, FM2, FM2+", "Tower Cooler", 129,
                150,162, 880, 125, 6, 1, 140, 152,  26.5,
                300, 1300,15, 21, 5, "4-Pin PWM",
                210, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));
        cpuCoolerData.add(new ModelCPUCooler("Thermalright", "Macho 120 SBM", "100700735",
                "775, 1150, 1151, 1155, 1156, 1366, 2011, 2011-3, AM2, AM3, AM3+, AM4, FM1, FM2, FM2+", "Tower Cooler", 130,
                111,150, 690, 94.8, 5, 1, 130, 120,  25,
                300, 1300,15, 21, 5, "4-Pin PWM",
                180, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));
        cpuCoolerData.add(new ModelCPUCooler("Thermalright", "Silver Arrow IB-E Extreme", "100700414",
                "775, 1150, 1151, 1155, 1156, 1366, 2011, 2011-3, AM2, AM3, AM3+, AM4, FM1, FM2, FM2+", "Tower Cooler", 103,
                154,163, 1009, 221, 8, 2, 140, 152,  26.5,
                600, 2500,21, 45, 5, "4-Pin PWM",
                420, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));
        cpuCoolerData.add(new ModelCPUCooler("Thermalright", "Macho Direct", "100700732",
                "1150, 1151, 1155, 1156, 2011, 2011-3, AM2, AM3, AM3+, AM4, FM1", "Tower Cooler", 129,
                152,158, 820, 125, 5, 1, 140, 152,  26.5,
                300, 1300,15, 21, 5, "4-Pin PWM",
                190, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));

        cpuCoolerData.add(new ModelCPUCooler("Phanteks", "PH-TC14PE_BK", "PH-TC14PE_BK",
                "775, 1150, 1151, 1155, 1156, 1366, 2011, 2011-3, AM2, AM2+, AM3, AM3+, FM1, FM2, FM2+", "Tower Cooler", 171,
                140, 159.7, 1025, 130.9, 5, 2, 140, 160, 25,
                900, 1200, 19, 21, 5, "4-Pin PWM",
                240, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));
        cpuCoolerData.add(new ModelCPUCooler("Phanteks", "PH-TC12DX_BK", "PH-TC12DX_BK",
                "775, 1150, 1151, 1155, 1156, 1366, 2011, 2011-3, AM2, AM2+, AM3, AM3+, FM1, FM2, FM2+", "Tower Cooler", 107,
                126, 169, 868, 116, 4, 2, 120, 120, 25,
                600, 1800, 22, 27, 5, "4-Pin PWM",
                260, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));

        cpuCoolerData.add(new ModelCPUCooler("Noctua", "NH-D14", "NH-D14",
                "775, 1150, 1151, 1155, 1156, 1366, AMD, AM2, AM2+, AM3, AM3+, AN4, FM1, FM2, FM2+", "Tower Cooler", 158,
                140, 160, 1240, 110.3, 6, 2, 120, 120, 25,
                1300, 1400, 19, 19, 5, "3-Pin",
                300, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));
        cpuCoolerData.add(new ModelCPUCooler("Noctua", "NH-D15", "NH-D15",
                "1150, 1151, 1155, 1156, 2011, 2011-3, AM2, AM2+, AM3, AM3+, AM4, FM1, FM2, FM2+ ", "Tower Cooler", 161,
                150, 165, 1320, 140.2, 6, 2, 140, 150, 25,
                1500, 1500, 24, 24, 5, "4-Pin PWM",
                300, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));

        cpuCoolerData.add(new ModelCPUCooler("SilentiumPC", "Grandis 2 XE1436", "SPC154",
                "775, 1150, 1151, 1155, 1156, 2011, 2011-3, AM2, AM2+, AM3, AM3+, AM4, FM1, FM2, FM2+ ", "Tower Cooler", 105,
                130, 159, 1030, 99, 6, 2, 140, 140, 25,
                500, 1600, 13, 15, 5, "4-Pin PWM",
                185, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));
        cpuCoolerData.add(new ModelCPUCooler("SilentiumPC", "Fortis 3 HE1425 v2", "SPC130",
                "775, 1150, 1151, 1155, 1156, 2011, 2011-3, AM2, AM2+, AM3, AM3+, AM4, FM1, FM2, FM2+ ", "Tower Cooler", 125,
                140, 158, 820, 133.6, 4, 1, 140, 140, 25,
                500, 1400, 13, 22, 5, "4-Pin PWM",
                150, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));
        cpuCoolerData.add(new ModelCPUCooler("SilentiumPC", "Fera 3 HE1224 v2", "SPC144",
                "775, 1150, 1151, 1155, 1156, 2011, 2011-3, AM2, AM2+, AM3, AM3+, AM4, FM1, FM2, FM2+ ", "Tower Cooler", 78,
                125, 155, 613, 79, 3, 1, 120, 120, 25,
                500, 1600, 8, 15, 5, "4-Pin PWM",
                110, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));
        cpuCoolerData.add(new ModelCPUCooler("SilentiumPC", "Spartan 3 LT HE1012", "SPC145",
                "775, 1150, 1151, 1155, 1156, AM2, AM2+, AM3, AM3+, AM4, FM1, FM2, FM2+ ", "Tower Cooler", 82,
                110, 135, 466, 94.6, 2, 1, 100, 100, 25,
                800, 2000, 9, 21, 5, "4-Pin PWM",
                65, "images/cpuCoolerImages/big/","images/cpuCoolerImages/small/"));

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
                            String dimensions = mainApp.noZeros(cpuCoolerItem.getWidth()) + "x" + mainApp.noZeros(cpuCoolerItem.getHeight()) + "x" + mainApp.noZeros(cpuCoolerItem.getDepth()) + "mm";
                            String fans = "";
                            if (cpuCoolerItem.getNumberOfFans() >1)
                                fans += cpuCoolerItem.getNumberOfFans() + "x ";
                            fans += mainApp.noZeros(cpuCoolerItem.getFanSizeX()) + "x" + mainApp.noZeros(cpuCoolerItem.getFanSizeY()) + "x" + mainApp.noZeros(cpuCoolerItem.getFanSizeHeight()) + "mm";
                            String noise = "";
                            if (cpuCoolerItem.getMinFanNoise() == cpuCoolerItem.getMaxFanNoise())
                                noise = cpuCoolerItem.getMaxFanNoise()+ "dB(A)";
                            else
                                noise = cpuCoolerItem.getMinFanNoise() + "-" + cpuCoolerItem.getMaxFanNoise() + "dB(A)";
                            String fanSpeed = "";
                            if (cpuCoolerItem.getMinFanSpeed() == cpuCoolerItem.getMaxFanSpeed())
                                fanSpeed = cpuCoolerItem.getMaxFanSpeed() + "rpm";
                            else
                                fanSpeed = cpuCoolerItem.getMinFanSpeed() + "-" + cpuCoolerItem.getMaxFanSpeed() + "rpm";

                            setText(cpuCoolerItem.getBrand() + " " + cpuCoolerItem.getName() + " (" + cpuCoolerItem.getManufacturerCode() + ")"
                                    + "\nDesign: " + cpuCoolerItem.getDesign() + ", Dimensions (WxHxD): " + dimensions + ", Fan(s): " + fans
                                    + "\nWeight: " + cpuCoolerItem.getWeight() + "g, " + fanSpeed +  ", " + cpuCoolerItem.getAirFlow() + "m³/h, " + noise + ", Connector: "  + cpuCoolerItem.getConnectorType()
                                    + "\nPrice: " + cpuCoolerItem.getPrice() + " PLN");
                        }
                    }
                };
                return cell;
            }
        });
    }
}