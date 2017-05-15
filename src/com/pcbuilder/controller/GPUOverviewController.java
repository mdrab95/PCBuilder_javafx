package com.pcbuilder.controller;

import com.pcbuilder.MainApp;
import com.pcbuilder.model.ModelGPU;
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
public class GPUOverviewController implements Initializable {

    @FXML
    private ListView<ModelGPU> gpuListView;
    private final ObservableList<ModelGPU> gpuData = FXCollections.observableArrayList();
    private final ObservableList<ModelGPU> finalData = FXCollections.observableArrayList();
    private MainApp mainApp;
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void filterButton (ObservableList<ModelGPU> gpuDataList){

    }


    @FXML
    public void initialize (URL location, ResourceBundle resources) {
        gpuData.clear();
        gpuData.add(new ModelGPU("Nvidia","Zotac", "GeForce GTX 1080", "AMP!", "Pascal",
                    16, "PCIEe 3.0 x16",8, "GDDR5", 1683, 1822,
                    1251, 0, 2, 3, 1, 1, 0,
                    180, 230, false, true,2400, "images/gpuImages/amp.jpg"));
        gpuData.add(new ModelGPU("Nvidia","Zotac", "GeForce GTX 1080", "AMP! extreme",
                    "Pascal", 16, "PCIEe 3.0 x16",8, "GDDR5",
                    1771, 1911, 1350, 0, 2, 3,1,1,
                    0, 180, 270,false, true, 2400, "images/gpuImages/ampExtreme.jpg"));
            gpuListView.setItems(gpuData);
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
                                    Image img = new Image(gpuItem.getImagePath());
                                    ImageView imageView = new ImageView(img);
                                    imageView.setFitHeight(75);
                                    imageView.setFitWidth(75);
                                    setGraphic(imageView);
                                }
                                catch (Exception ex) {
                                    Image img = new Image("images/no_img.png");
                                    ImageView imageView = new ImageView(img);
                                    imageView.setFitHeight(75);
                                    imageView.setFitWidth(75);
                                    setGraphic(imageView);
                                }

                                String videoConnectors = "";
                                if (gpuItem.getDviConnectors() > 0) {
                                    if (gpuItem.getDviConnectors() == 1)
                                        videoConnectors += ", DVI";
                                    else
                                    videoConnectors += ", " + gpuItem.getDviConnectors() + "x DVI";
                                }
                                if (gpuItem.getHdmiConnectors() > 0) {
                                    if (gpuItem.getHdmiConnectors() == 1)
                                        videoConnectors += ", HDMI";
                                    else
                                        videoConnectors += ", " + gpuItem.getHdmiConnectors() + "x HDMI";
                                }
                                if (gpuItem.getDpConnectors() > 0) {
                                    if (gpuItem.getDpConnectors() == 1)
                                        videoConnectors += ", DP";
                                    else
                                        videoConnectors += ", " + gpuItem.getDpConnectors() + "x DP";
                                }
                                if (gpuItem.getVgaConnectors() > 0) {
                                    if (gpuItem.getVgaConnectors() == 1)
                                        videoConnectors += ", VGA";
                                    else
                                        videoConnectors += ", " + gpuItem.getVgaConnectors() + "x VGA";
                                }
                                setText(gpuItem.getseries() + " " +  gpuItem.getName()
                                        + " " + gpuItem.getmemorySize() + "GB" + " "
                                        + gpuItem.getMemoryType() + videoConnectors);
                            }
                        }
                    };
                    return cell;
                }
            });
    }
}
