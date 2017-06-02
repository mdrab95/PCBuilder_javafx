package com.pcbuilder.controller;

import com.pcbuilder.MainApp;
import com.pcbuilder.model.ModelGPU;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GPUOverviewController implements Initializable {

    private String memoryConnectors (ModelGPU modelItem){
        String connectors = "";
        if (modelItem.getDviConnectors() > 0) {
            if (modelItem.getDviConnectors() == 1)
                connectors += "DVI ";
            else
                connectors += modelItem.getDviConnectors() + "x DVI";
        }
        if (modelItem.getHdmiConnectors() > 0) {
            if (modelItem.getHdmiConnectors() == 1)
                connectors += "HDMI ";
            else
                connectors += modelItem.getHdmiConnectors() + "x HDMI";
        }
        if (modelItem.getDpConnectors() > 0) {
            if (modelItem.getDpConnectors() == 1)
                connectors += "DP ";
            else
                connectors += modelItem.getDpConnectors() + "x DP";
        }
        if (modelItem.getVgaConnectors() > 0) {
            if (modelItem.getVgaConnectors() == 1)
                connectors += "VGA ";
            else
                connectors += modelItem.getVgaConnectors() + "x VGA";
        }
        return connectors;
    }

    @FXML
    private ListView<ModelGPU> gpuListView;
    private final ObservableList<ModelGPU> gpuData = FXCollections.observableArrayList();
    private FilteredList<ModelGPU> filteredData = new FilteredList<ModelGPU>(gpuData, p->true);
    private SortedList<ModelGPU> sortedData = new SortedList<ModelGPU>(filteredData);
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    Button filterButton;
    @FXML
    CheckBox selectNvidia;
    @FXML
    CheckBox selectRadeon;
    @FXML
    CheckBox selectMSI;
    @FXML
    CheckBox selectZotac;
    @FXML
    CheckBox selectPalit;
    @FXML
    CheckBox selectGigabyte;
    @FXML
    CheckBox select1GB;
    @FXML
    CheckBox select2GB;
    @FXML
    CheckBox select3GB;
    @FXML
    CheckBox select4GB;
    @FXML
    CheckBox select6GB;
    @FXML
    CheckBox select8GB;
    @FXML
    CheckBox selectGDDR5X;
    @FXML
    CheckBox selectGDDR5;
    @FXML
    CheckBox selectDDR3;

    @FXML
    private void filterButtonClick (ActionEvent event){
        filteredData.setPredicate(gpu -> true);
        if (selectNvidia.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getChipManufacturer().contains("Nvidia"))
                    return true;
                else
                    return false;
            });
        }
        if (selectRadeon.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getChipManufacturer().contains("Radeon"))
                    return true;
                else
                    return false;
            });
        }
        if (select1GB.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getmemorySize() <= 1)
                    return true;
                else
                    return false;
            });
        }
        if (select2GB.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getmemorySize() == 2)
                    return true;
                else
                    return false;
            });
        }
        if (select3GB.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getmemorySize() == 3)
                    return true;
                else
                    return false;
            });
        }
        if (select4GB.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getmemorySize() == 4)
                    return true;
                else
                    return false;
            });
        }
        if (select6GB.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getmemorySize() == 6)
                    return true;
                else
                    return false;
            });
        }
        if (select8GB.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getmemorySize() >= 8)
                    return true;
                else
                    return false;
            });
        }
        if (selectGDDR5X.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getMemoryType().equals("GDDR5X"))
                    return true;
                else
                    return false;
            });
        }
        if (selectGDDR5.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getMemoryType().equals("GDDR5"))
                    return true;
                else
                    return false;
            });
        }
        if (selectDDR3.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getMemoryType().equals("DDR3"))
                    return true;
                else
                    return false;
            });
        }
        if (selectMSI.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getManufacturer().equals("MSI"))
                    return true;
                else
                    return false;
            });
        }
        if (selectZotac.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getManufacturer().equals("Zotac"))
                    return true;
                else
                    return false;
            });
        }
        if (selectPalit.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getManufacturer().equals("Palit"))
                    return true;
                else
                    return false;
            });
        }
        if (selectGigabyte.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getManufacturer().equals("Gigabyte"))
                    return true;
                else
                    return false;
            });
        }
    }

    @FXML
    public void initialize (URL location, ResourceBundle resources) {
        gpuData.clear();
        gpuData.add(new ModelGPU("Nvidia","Zotac", "GeForce GTX 1080", "AMP! extreme", "ZT-P10800B-10P",
                "Pascal", 325,16, "PCIEe 3.0 x16",8, "GDDR5X",
                1771, 1911, 10.8, 0, 2, 3,1,1,
                0, 180, 270,false, true, 2600, "images/gpuImages/big/", "images/gpuImages/small/"));
        gpuData.add(new ModelGPU("Nvidia","Zotac", "GeForce GTX 1080", "AMP!", "ZT-P10800C-10P",
                "Pascal", 300, 16, "PCIEe 3.0 x16",8, "GDDR5X", 1683, 1822,
                10, 0, 2, 3, 1, 1, 0,
                180, 220, false, true,2450, "images/gpuImages/big/", "images/gpuImages/small/"));
        gpuData.add(new ModelGPU("Nvidia","Zotac", "GeForce GTX 1080", "Mini", "ZT-P10800H-10P",
                "Pascal", 211, 16, "PCIEe 3.0 x16",8, "GDDR5X",
                1620, 1759, 130, 0, 2, 3,1,1,
                0, 180, 200,false, false, 2600, "images/gpuImages/big/", "images/gpuImages/small/"));

        gpuData.add(new ModelGPU("Nvidia","Zotac", "GeForce GTX 1070", "AMP! extreme", "ZT-P10800B-10P",
                "Pascal", 300,16, "PCIEe 3.0 x16",8, "GDDR5",
                1632, 1835, 8.202, 0, 2, 3,1,1,
                0, 180, 230,false, true, 2100, "images/gpuImages/big/", "images/gpuImages/small/"));
        gpuData.add(new ModelGPU("Nvidia","Zotac", "GeForce GTX 1070", "AMP!", "ZT-P10800C-10P",
                "Pascal", 325, 16, "PCIEe 3.0 x16",8, "GDDR5", 1607, 1797,
                8, 0, 2, 3, 1, 1, 0,
                180, 200, false, true,2000, "images/gpuImages/big/", "images/gpuImages/small/"));
        gpuData.add(new ModelGPU("Nvidia","Zotac", "GeForce GTX 1070", "Mini", "ZT-P10800H-10P",
                "Pascal", 210, 16, "PCIEe 3.0 x16",8, "GDDR5",
                1518, 1708, 8, 0, 1, 3,1,1,
                0, 180, 180,false, false, 1850, "images/gpuImages/big/", "images/gpuImages/small/"));

        gpuData.add(new ModelGPU("Nvidia","MSI", "GeForce GTX 1080", "Gaming X", "GTX 1080 GAMING X 8G",
                "Pascal", 325,16, "PCIEe 3.0 x16",8, "GDDR5X",
                1607, 1847, 10.108, 1, 1, 3,1,1,
                0, 180, 230,false, true, 2600, "images/gpuImages/big/", "images/gpuImages/small/"));
        gpuData.add(new ModelGPU("Nvidia","MSI", "GeForce GTX 1080", "Gaming", "GTX 1080 GAMING 8G",
                "Pascal", 279, 16, "PCIEe 3.0 x16",8, "GDDR5X", 1632, 1771,
                10.01, 1, 1, 3, 1, 1, 0,
                180, 200, false, true,2550, "images/gpuImages/big/", "images/gpuImages/small/"));
        gpuData.add(new ModelGPU("Nvidia","MSI", "GeForce GTX 1080", "Armor OC", "GTX 1080 ARMOR 8G OC",
                "Pascal", 279, 16, "PCIEe 3.0 x16",8, "GDDR5X",
                1657, 1797, 10.01, 1, 1, 3,1,1,
                0, 180, 200,false, false, 2300, "images/gpuImages/big/", "images/gpuImages/small/"));

        gpuData.add(new ModelGPU("Nvidia","MSI", "GeForce GTX 1070", "Gaming X", "GTX 1070 GAMING X 8G",
                "Pascal", 300,16, "PCIEe 3.0 x16",8, "GDDR5",
                1607, 1797, 8.108, 1, 1, 3,1,1,
                0, 180, 220,false, true, 2050, "images/gpuImages/big/", "images/gpuImages/small/"));
        gpuData.add(new ModelGPU("Nvidia","MSI", "GeForce GTX 1070", "Gaming", "GTX 1070 GAMING 8G",
                "Pascal", 279, 16, "PCIEe 3.0 x16",8, "GDDR5", 1531, 1721,
                8, 1, 1, 3, 1, 1, 0,
                180, 200, false, true,2000, "images/gpuImages/big/", "images/gpuImages/small/"));
        gpuData.add(new ModelGPU("Nvidia","MSI", "GeForce GTX 1070", "Armor OC", "GTX 1070 ARMOR 8G OC",
                "Pascal", 279, 16, "PCIEe 3.0 x16",8, "GDDR5",
                1556, 1746, 8.008, 0, 1, 3,1,1,
                0, 180, 180,false, false, 1820, "images/gpuImages/big/", "images/gpuImages/small/"));
        Comparator<ModelGPU> comparator = Comparator.comparingInt(ModelGPU::getPrice);
        FXCollections.sort(gpuData, comparator.reversed());
        gpuListView.setItems(sortedData);
        gpuListView.setCellFactory(new Callback<ListView<ModelGPU>, ListCell<ModelGPU>>() {

            @Override
            public ListCell<ModelGPU> call(ListView<ModelGPU> param) {
                ListCell<ModelGPU> cell = new ListCell<ModelGPU>(){
                    @Override
                    protected void updateItem(ModelGPU gpuItem, boolean empty){
                        setText(null);
                        setGraphic(null);
                        super.updateItem(gpuItem, empty);
                        if (gpuItem != null) {
                            try {
                                Image img = new Image(gpuItem.getSmallImagePath() + gpuItem.getManufacturerCode() + ".png", true);
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

                            String speed = "";
                            if (gpuItem.getSpeed() == gpuItem.getBoostSpeed())
                                speed = gpuItem.getSpeed() + "MHz";
                            else
                                speed = gpuItem.getSpeed() + "-" + gpuItem.getBoostSpeed() + "MHz";
                            String videoConnectors = memoryConnectors(gpuItem);

                            setText(gpuItem.getManufacturer() + " " + gpuItem.getseries() + " " +  gpuItem.getName() + " " + gpuItem.getmemorySize() + "GB " + gpuItem.getMemoryType()
                                    + "\nVideo connectors: " + videoConnectors
                                    + "\nCore speed: " + speed + ", Memory speed: " + mainApp.noZeros(gpuItem.getMemorySpeed()) + " GHz"
                                    + "\nPrice: " + gpuItem.getPrice() + " PLN");
                        }
                    }
                };
                return cell;
            }
        });
    }
}
