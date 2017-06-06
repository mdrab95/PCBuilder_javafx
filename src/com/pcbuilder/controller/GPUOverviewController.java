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

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;


public class GPUOverviewController implements Initializable {

    private void filterChipManufacturer(CheckBox cb, FilteredList<ModelGPU> list, String chipManufacturer){
        if (cb.isSelected()) {
            filteredData.setPredicate(gpu -> {
                if (gpu.getChipManufacturer().contains(chipManufacturer))
                    return true;
                else
                    return false;
            });
        }
    }

    private void filterManufacturer(CheckBox cb, FilteredList<ModelGPU> list, String producer) {
        if (cb.isSelected()) {
            list.setPredicate(gpu -> {
                if (gpu.getManufacturer().equals(producer))
                    return true;
                else
                    return false;
            });
        }
    }

    private void filterMemorySize(CheckBox cb, FilteredList<ModelGPU> list, int memorySize) {
        if (cb.isSelected()) {
            if (memorySize >=8)
            {
                list.setPredicate(gpu -> {
                    if (gpu.getmemorySize() >= 8)
                        return true;
                    else
                        return false;
                });
            }
            if (memorySize <=1)
            {
                list.setPredicate(gpu -> {
                    if (gpu.getmemorySize() <=1 )
                        return true;
                    else
                        return false;
                });
            }
            list.setPredicate(gpu -> {
                if (gpu.getmemorySize() == memorySize)
                    return true;
                else
                    return false;
            });
        }
    }

    private void filterMemoryType(CheckBox cb, FilteredList<ModelGPU> list, String memoryType) {
        if (cb.isSelected()) {
            list.setPredicate(gpu -> {
                if (gpu.getMemoryType().equals(memoryType))
                    return true;
                else
                    return false;
            });
        }
    }

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
    private ObservableList<ModelGPU> gpuData = FXCollections.observableArrayList();

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
    private void filterButtonClick (ActionEvent event){ // do zrobienia - filtrowanie dziala jako ostatnia wykonywana funkcja
        // filtrowanie w pewnych momentach musi sie nachodzic tworzac zestaw produktow
        filteredData.setPredicate(gpu -> true);
        filterChipManufacturer(selectNvidia, filteredData, "Nvidia");
        filterChipManufacturer(selectRadeon, filteredData, "Radeon");
        filterMemorySize(select1GB, filteredData, 1);
        filterMemorySize(select2GB, filteredData, 2);
        filterMemorySize(select3GB, filteredData, 3);
        filterMemorySize(select4GB, filteredData, 4);
        filterMemorySize(select6GB, filteredData, 6);
        filterMemorySize(select8GB, filteredData, 8);
        filterMemoryType(selectGDDR5X, filteredData, "GDDR5X");
        filterMemoryType(selectGDDR5, filteredData, "GDDR5");
        filterMemoryType(selectDDR3, filteredData, "DDR3");
        filterManufacturer(selectMSI, filteredData, "MSI");
        filterManufacturer(selectZotac, filteredData, "Zotac");
        filterManufacturer(selectPalit, filteredData, "Palit");
        filterManufacturer(selectGigabyte, filteredData, "Gigabyte");
    }

    @FXML
    public void initialize (URL location, ResourceBundle resources) {
        gpuData.clear();
        DataLoader loader = new DataLoader();
        try {gpuData.addAll(loader.gpuDataLoader());}
        catch(IOException e){};
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
