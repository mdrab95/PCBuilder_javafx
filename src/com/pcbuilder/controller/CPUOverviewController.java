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
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "7700k", "Core i7", 14, 4, 8, true,
                4.2, 4.5, 1, 8, 91, 140,"box", false, 1580,
                "images/cpuImages/big/i7-7700k.png","images/cpuImages/small/i7-7700k_small.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "7700", "Core i7", 14, 4, 8, false,
                3.6, 4.2, 1, 8, 65, 95, "box", true, 1400,
                "images/cpuImages/big/i7-7700.png","images/cpuImages/small/i7-7700_small.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "7600k", "Core i5", 14, 4, 4, true,
                3.8, 4.2, 1, 6, 91, 115,"box", false, 1100,
                "images/cpuImages/big/i5-7600k.png","images/cpuImages/small/i5-7600k_small.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "7600", "Core i5", 14, 4, 4, false,
                3.5, 4.1, 1, 6, 65, 85,"box", true,  995,
                "images/cpuImages/big/i5-kaby.png","images/cpuImages/small/i5-kaby_small.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "7500", "Core i5", 14, 4, 4, false,
                3.4, 3.8, 1, 6, 65, 80,"box", true, 930,
                "images/cpuImages/big/i5-kaby.png","images/cpuImages/small/i5-kaby_small.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "7400", "Core i5", 14, 4, 4, false,
                3.0, 3.5, 1, 6, 65, 75,"box", true, 850,
                "images/cpuImages/big/i5-kaby.png","images/cpuImages/small/i5-kaby_small.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "7350k", "Core i3", 14, 2, 4, true,
                4.2, 3.5, 0.5, 4, 60, 90,"box", false, 850,
                "images/cpuImages/big/i3-7350k.png","images/cpuImages/small/i3-7350k_small.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "7300", "Core i3", 14, 2, 4, false,
                4.0, 3.5, 0.5, 4, 51, 55,"box", true, 650,
                "images/cpuImages/big/i3-kaby.png","images/cpuImages/small/i3-kaby_small.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "7100", "Core i3", 14, 2, 4, false,
                3.9, 3.5, 0.5, 3, 51, 50,"box", true, 500,
                "images/cpuImages/big/i3-kaby.png","images/cpuImages/small/i3-kaby_small.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "G4620", "Pentium", 14, 2, 4, false,
                3.7, 3.5, 0.5, 3, 51, 47,"box", true, 400,
                "images/cpuImages/big/pentium-kaby.png","images/cpuImages/small/pentium-kaby_small.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "G4600", "Pentium", 14, 2, 4, false,
                3.6, 3.5, 0.5, 3, 61, 45,"box", true, 370,
                "images/cpuImages/big/pentium-kaby.png","images/cpuImages/small/pentium-kaby_small.png"));
        cpuData.add(new ModelCPU("Intel", "LGA 1151", "G4560", "Pentium", 14, 2, 4, false,
                3.5, 3.5, 0.5, 3, 54, 40,"box", true, 250,
                "images/cpuImages/big/pentium-kaby.png","images/cpuImages/small/pentium-kaby_small.png"));
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
                                Image img = new Image(cpuItem.getSmallImagePath(), true);
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
                            String howItIsPacked = cpuItem.getPackageType();
                            String spaceInName = " ";
                            if (cpuItem.getFamily().contains("Core"))
                                spaceInName = "-";
                            if (cpuItem.getBoxCooler() == false)
                                howItIsPacked += " without cooler";
                            String speed = "";
                            if (cpuItem.getSpeed() == cpuItem.getBoostSpeed())
                                speed = cpuItem.getSpeed() + "GHz";
                            else
                                speed = cpuItem.getSpeed() + "-" + cpuItem.getBoostSpeed() + "GHz";

                            setText(cpuItem.getBrand() + " " + cpuItem.getFamily() + spaceInName +  cpuItem.getName() + " (" + howItIsPacked + ")"
                                    + "\n" + cpuItem.getNumberOfCores() + "C/" + cpuItem.getNumberOfThreads() + "T, " + speed + ", " + mainApp.noZeros(cpuItem.getCacheL3()) + " MB" + ", "
                                    + cpuItem.getTdp() + "W TDP"
                                    + "\nPrice: " + cpuItem.getPrice() + " PLN");
                        }
                    }
                };
                return cell;
            }
        });
    }
}
