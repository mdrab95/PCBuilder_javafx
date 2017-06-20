package com.pcbuilder.controller;

import com.pcbuilder.MainApp;
import com.pcbuilder.model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ace on 19.06.2017.
 */
public class PCBuilderEzController implements Initializable{
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    DataLoader dataLoader = new DataLoader();

    //region CPU
    //--------------------------------------

    @FXML
    private ChoiceBox choiceCpu;
    @FXML
    private ImageView cpuImageView;
    @FXML
    private Label cpuDesc;

    @FXML
    private Button addCpu;

    @FXML
    private Label cpuHeaderLabel;

    private ModelCPU selectedCpu;
    private Image cpuImg;
    //--------------------------------------
    //endregion

    //region CPU Cooler
    //--------------------------------------
    @FXML
    private ChoiceBox choiceCpuCooler;
    @FXML
    private ImageView cpuCoolerImageView;
    @FXML
    private Label cpuCoolerHeaderLabel;
    @FXML
    private Label cpuCoolerDesc;
    @FXML
    private Button addCpuCooler;
    @FXML
    private Button backCpuCooler;

    private ModelCPUCooler selectedCpuCooler;
    private Image cpuCoolerImg;
    //--------------------------------------
    //endregion

    //region Motherboard
    //--------------------------------------
    @FXML
    private ChoiceBox choiceMobo;
    @FXML
    private ImageView moboImageView;
    @FXML
    private Label moboHeaderLabel;
    @FXML
    private Label moboDesc;
    @FXML
    private Button addMobo;
    @FXML
    private Button backMobo;

    private ModelMOBO selectedMobo;
    private Image moboImg;
    //--------------------------------------
    //endregion

    private final ObservableList<ModelCPU> cpuList= FXCollections.observableArrayList();
    private final ObservableList<ModelGPU> gpuList= FXCollections.observableArrayList();
    private final ObservableList<ModelCPUCooler> cpuCoolerList= FXCollections.observableArrayList();
    private final ObservableList<ModelMOBO> moboList= FXCollections.observableArrayList();
    private final ObservableList<ModelSSD> ssdList= FXCollections.observableArrayList();
    private final ObservableList<ModelHDD> hddList= FXCollections.observableArrayList();
    private final ObservableList<ModelRAM> ramList= FXCollections.observableArrayList();
    private final ObservableList<ModelPSU> psuList= FXCollections.observableArrayList();
    private final ObservableList<ModelCase> caseList= FXCollections.observableArrayList();
    ObservableList cpuCoolerNames = FXCollections.observableArrayList();
    ObservableList moboNames = FXCollections.observableArrayList();

    @FXML
    public void initialize (URL location, ResourceBundle resources) {

        //region Data Loader
        // --------------------------------------
        try {
            cpuList.addAll(dataLoader.cpuDataLoader());
        } catch (IOException e) {}
        try {
            cpuCoolerList.addAll(dataLoader.cpuCoolerDataLoader());
        } catch (IOException e) {}
        try {
            ramList.addAll(dataLoader.ramDataLoader());
        } catch (IOException e) {}
        try {
            ssdList.addAll(dataLoader.ssdDataLoader());
        } catch (IOException e) {}
        try {
            hddList.addAll(dataLoader.hddDataLoader());
        } catch (IOException e) {}
        try {
            gpuList.addAll(dataLoader.gpuDataLoader());
        } catch (IOException e) {}
        try {
            psuList.addAll(dataLoader.psuDataLoader());
        } catch (IOException e) {}
        try {
            caseList.addAll(dataLoader.caseDataLoader());
        } catch (IOException e) {}
        try {
            moboList.addAll(dataLoader.moboDataLoader());
        } catch (IOException e) {}
        //--------------------------------------
        //endregion

        //region CPU init
        // --------------------------------------
        ObservableList cpuNames = FXCollections.observableArrayList();
        for (int i=0; i<cpuList.size(); i++){
            String cpuName = cpuList.get(i).getBrand() + " " + cpuList.get(i).getFamily() + " " + cpuList.get(i).getName();
            cpuNames.add(cpuName);
        }
        choiceCpu.setItems(cpuNames);
        choiceCpu.getSelectionModel().selectedItemProperty()
            .addListener(new ChangeListener<String>() {
                public void changed(ObservableValue<? extends String> observable,
                                    String oldValue, String newValue) {
                    System.out.println(newValue);
                    for (int i=0; i< cpuList.size(); i++)
                    {
                        String cpuItemName = cpuList.get(i).getBrand() + " " + cpuList.get(i).getFamily() + " " + cpuList.get(i).getName();
                        if (newValue.matches(cpuItemName))
                        {
                            selectedCpu = cpuList.get(i);
                        }
                    }
                    cpuImg = new Image(selectedCpu.getSmallImagePath());
                    cpuImageView.setFitHeight(100);
                    cpuImageView.setFitWidth(100);
                    cpuImageView.setImage(cpuImg);
                    String howItIsPacked = selectedCpu.getPackageType();
                    String spaceInName = " ";
                    if (selectedCpu.getFamily().contains("Core"))
                        spaceInName = "-";
                    if (selectedCpu.getBoxCooler() == false)
                        howItIsPacked += " without cooler";
                    String speed = "";
                    if (selectedCpu.getSpeed() == selectedCpu.getBoostSpeed())
                        speed = selectedCpu.getSpeed() + "GHz";
                    else
                        speed = selectedCpu.getSpeed() + "-" + selectedCpu.getBoostSpeed() + "GHz";

                    String cpuDescription = (selectedCpu.getBrand() + " " + selectedCpu.getFamily() + spaceInName +  selectedCpu.getName() + " (" + howItIsPacked + ")"
                            + "\n" + selectedCpu.getNumberOfCores() + "C/" + selectedCpu.getNumberOfThreads() + "T, " + speed + ", " + mainApp.noZeros(selectedCpu.getCacheL3()) + " MB" + ", "
                            + selectedCpu.getTdp() + "W TDP"
                            + "\nPrice: " + selectedCpu.getPrice() + " PLN");
                    cpuDesc.setText(cpuDescription);
                }
            });
        cpuImg = new Image("images/no_img.png");
        cpuImageView.setFitHeight(100);
        cpuImageView.setFitWidth(100);
        cpuImageView.setImage(cpuImg);
        //--------------------------------------
        //endregion

        //region CPUCooler init
        // --------------------------------------
            cpuCoolerNames.add("BOX Cooler");
            for (int i=0; i<cpuCoolerList.size(); i++){
                String cpuCoolerName = cpuCoolerList.get(i).getBrand() + " " + cpuCoolerList.get(i).getName();
                cpuCoolerNames.add(cpuCoolerName);
            }
            choiceCpuCooler.setItems(cpuCoolerNames);
            choiceCpuCooler.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        System.out.println(newValue);
                        if (newValue.equals("BOX Cooler")) {
                            if (selectedCpu.getBoxCooler() == false) {
                                selectedCpuCooler = null;
                                cpuCoolerImg = new Image("images/error.png");
                                cpuCoolerImageView.setImage(cpuCoolerImg);
                                cpuCoolerDesc.setText("There is no box cooler included!");
                            }
                            else {
                                cpuCoolerImg = new Image(selectedCpu.getSmallImagePath());
                                cpuCoolerImageView.setImage(cpuCoolerImg);
                                cpuCoolerDesc.setText("BOX Cooler");
                            }
                        } else {
                            for (int i = 0; i < cpuCoolerList.size(); i++) {
                                String cpuCoolerItemName = cpuCoolerList.get(i).getBrand() + " " + cpuCoolerList.get(i).getName();
                                if (newValue.matches(cpuCoolerItemName)) {
                                    selectedCpuCooler = cpuCoolerList.get(i);
                                }
                            }
                            cpuCoolerImg = new Image(selectedCpuCooler.getSmallImagePath() + selectedCpuCooler.getManufacturerCode() + ".png", true);
                            cpuCoolerImageView.setFitHeight(100);
                            cpuCoolerImageView.setFitWidth(100);
                            cpuCoolerImageView.setImage(cpuCoolerImg);
                            String dimensions = mainApp.noZeros(selectedCpuCooler.getWidth()) + "x" + mainApp.noZeros(selectedCpuCooler.getHeight()) + "x" + mainApp.noZeros(selectedCpuCooler.getDepth()) + "mm";
                            String fans = "";
                            if (selectedCpuCooler.getNumberOfFans() > 1)
                                fans += selectedCpuCooler.getNumberOfFans() + "x ";
                            fans += mainApp.noZeros(selectedCpuCooler.getFanSizeX()) + "x" + mainApp.noZeros(selectedCpuCooler.getFanSizeY()) + "x" + mainApp.noZeros(selectedCpuCooler.getFanSizeHeight()) + "mm";
                            String noise = "";
                            if (selectedCpuCooler.getMinFanNoise() == selectedCpuCooler.getMaxFanNoise())
                                noise = selectedCpuCooler.getMaxFanNoise() + "dBA";
                            else
                                noise = selectedCpuCooler.getMinFanNoise() + "-" + selectedCpuCooler.getMaxFanNoise() + "dBA";
                            String fanSpeed = "";
                            if (selectedCpuCooler.getMinFanSpeed() == selectedCpuCooler.getMaxFanSpeed())
                                fanSpeed = selectedCpuCooler.getMaxFanSpeed() + "rpm";
                            else
                                fanSpeed = selectedCpuCooler.getMinFanSpeed() + "-" + selectedCpuCooler.getMaxFanSpeed() + "rpm";
                            String cpuCoolerDescription = selectedCpuCooler.getBrand() + " " + selectedCpuCooler.getName() + " (" + selectedCpuCooler.getManufacturerCode() + ")"
                                    + "\nDesign: " + selectedCpuCooler.getDesign() + ", Dimensions (WxHxD): " + dimensions + ", Fan(s): " + fans
                                    + "\nWeight: " + selectedCpuCooler.getWeight() + "g, " + fanSpeed + ", " + selectedCpuCooler.getAirFlow() + "m³/h, " + noise + ", Connector: " + selectedCpuCooler.getConnectorType()
                                    + "\nPrice: " + selectedCpuCooler.getPrice() + " PLN";
                            cpuCoolerDesc.setText(cpuCoolerDescription);
                        }
                    }
                });
        cpuCoolerImg = new Image("images/no_img.png");
        cpuCoolerImageView.setFitHeight(100);
        cpuCoolerImageView.setFitWidth(100);
        cpuCoolerImageView.setImage(cpuImg);
        //--------------------------------------
        //endregion

        //region MOBO init
        // --------------------------------------

        for (int i=0; i<moboList.size(); i++){
            String moboName = moboList.get(i).getBrand() + " " + moboList.get(i).getChipset() + " " + moboList.get(i).getName();
            moboNames.add(moboName);
        }
        choiceMobo.setItems(moboNames);
        choiceMobo.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        System.out.println(newValue);
                        for (int i=0; i< moboList.size(); i++)
                        {
                            String selectedMoboName = moboList.get(i).getBrand() + " " + moboList.get(i).getChipset() + " " + moboList.get(i).getName();
                            if (newValue.matches(selectedMoboName))
                            {
                                selectedMobo = moboList.get(i);
                            }
                        }
                        try {
                            moboImg = new Image(selectedMobo.getSmallImagePath() + selectedMobo.getSerialNumber() + ".png", true);
                            moboImageView.setFitHeight(100);
                            moboImageView.setFitWidth(100);
                            moboImageView.setImage(moboImg);
                        }
                        catch (Exception ex){System.out.println("DUPAAA");}

                        String moboDescription = selectedMobo.getBrand() + " " + selectedMobo.getChipset() + " " + selectedMobo.getName()
                                + "\n" + "Socket: " + selectedMobo.getSocket() + ", form factor: " + selectedMobo.getFormFactor()
                                + "\nRAM standard: " + selectedMobo.getRamStandard() + ", Max RAM speed: " + selectedMobo.getMaxRamSpeed() + " MHz"
                                + "\nMax RAM capacity: " + selectedMobo.getMaxRam() + "GB, in " + selectedMobo.getRamSlots() + " slots."
                                + "\nPrice: " + selectedMobo.getPrice() + " PLN";
                        moboDesc.setText(moboDescription);
                    }
                });

        moboImg = new Image("images/no_img.png");
        moboImageView.setFitHeight(100);
        moboImageView.setFitWidth(100);
        moboImageView.setImage(moboImg);
        //--------------------------------------
        //endregion

    }
    @FXML
    private void addCpuButtonAction(){
        if (selectedCpu != null) {
        System.out.println("addCpuButton clicked");
        choiceCpuCooler.getStyleClass().add("pcbuilder-enabled");
        cpuCoolerImageView.getStyleClass().add("pcbuilder-enabled");
        cpuCoolerDesc.getStyleClass().add("pcbuilder-enabled");
        addCpuCooler.getStyleClass().add("pcbuilder-enabled");
        cpuCoolerHeaderLabel.getStyleClass().add("pcbuilder-enabled");
        backCpuCooler.getStyleClass().add("pcbuilder-enabled");

        cpuHeaderLabel.setText("Your CPU:");
        addCpu.getStyleClass().add("pcbuilder-disabled");
        choiceCpu.getStyleClass().add("pcbuilder-disabled");
        cpuCoolerNames.clear();
        cpuCoolerDesc.setText(null);
        cpuCoolerImg = new Image("images/no_img.png");
        cpuCoolerImageView.setImage(cpuCoolerImg);
            if (selectedCpu.getBoxCooler()==true) {
                cpuCoolerNames.add("BOX Cooler");
            }
            for (int i=0; i<cpuCoolerList.size(); i++){
                String cpuCoolerName = cpuCoolerList.get(i).getBrand() + " " + cpuCoolerList.get(i).getName();
                String sockets = cpuCoolerList.get(i).getSockets();
                if (sockets.contains(selectedCpu.getSocket())) {
                    cpuCoolerNames.add(cpuCoolerName);
                }
            }
            choiceCpuCooler.setItems(cpuCoolerNames);

        }
    }
    @FXML
    private void backCpuCoolerButtonAction(){
        System.out.println("backCpuCoolerButton clicked");
        choiceCpuCooler.getStyleClass().remove("pcbuilder-enabled");
        cpuCoolerImageView.getStyleClass().remove("pcbuilder-enabled");
        cpuCoolerDesc.getStyleClass().remove("pcbuilder-enabled");
        addCpuCooler.getStyleClass().remove("pcbuilder-enabled");
        cpuCoolerHeaderLabel.getStyleClass().remove("pcbuilder-enabled");
        backCpuCooler.getStyleClass().remove("pcbuilder-enabled");

        cpuHeaderLabel.setText("SelectCPU:");
        addCpu.getStyleClass().remove("pcbuilder-disabled");
        choiceCpu.getStyleClass().remove("pcbuilder-disabled");
        cpuCoolerNames.clear();
        selectedCpuCooler = null;
        cpuCoolerDesc.setText(null);
        cpuCoolerImg = new Image("images/no_img.png");
        cpuCoolerImageView.setImage(cpuCoolerImg);

    }
    @FXML
    private void addCpuCoolerButtonAction() {
        if (selectedCpu.getBoxCooler() == false && selectedCpuCooler == null) {
            cpuCoolerDesc.setText("There is no box cooler included!");
            Image boxCoolerImg = new Image("images/error.png");
            cpuCoolerImageView.setImage(boxCoolerImg);
        }
        if (selectedCpu.getBoxCooler() == true && selectedCpuCooler == null) {
            System.out.println("addCpuCoolerButton clicked");
            addMobo.getStyleClass().add("pcbuilder-enabled");
            moboDesc.getStyleClass().add("pcbuilder-enabled");
            moboHeaderLabel.getStyleClass().add("pcbuilder-enabled");
            moboImageView.getStyleClass().add("pcbuilder-enabled");
            backMobo.getStyleClass().add("pcbuilder-enabled");
            choiceMobo.getStyleClass().add("pcbuilder-enabled");

            choiceCpuCooler.getStyleClass().remove("pcbuilder-enabled");
            addCpuCooler.getStyleClass().remove("pcbuilder-enabled");
            cpuCoolerHeaderLabel.setText("Your CPU Cooler:");
            backCpuCooler.getStyleClass().remove("pcbuilder-enabled");

            cpuCoolerDesc.setText("BOX Cooler");
            Image boxCoolerImg = new Image(selectedCpu.getSmallImagePath());
            cpuCoolerImageView.setImage(boxCoolerImg);
            moboNames.clear();
            for (int i=0; i<moboList.size(); i++){
                String moboName = moboList.get(i).getBrand() + " " + moboList.get(i).getChipset() + " " + moboList.get(i).getName();
                if (moboList.get(i).getSocket().equals(selectedCpu.getSocket())) {
                    moboNames.add(moboName);
                }
            }
            choiceMobo.setItems(moboNames);
        }
        if (selectedCpu.getBoxCooler() == false && selectedCpuCooler != null || selectedCpu.getBoxCooler() == true && selectedCpuCooler != null)
        {
            System.out.println("addCpuCoolerButton clicked");
            addMobo.getStyleClass().add("pcbuilder-enabled");
            moboDesc.getStyleClass().add("pcbuilder-enabled");
            moboHeaderLabel.getStyleClass().add("pcbuilder-enabled");
            moboImageView.getStyleClass().add("pcbuilder-enabled");
            backMobo.getStyleClass().add("pcbuilder-enabled");
            choiceMobo.getStyleClass().add("pcbuilder-enabled");

            choiceCpuCooler.getStyleClass().remove("pcbuilder-enabled");
            addCpuCooler.getStyleClass().remove("pcbuilder-enabled");
            cpuCoolerHeaderLabel.setText("Your CPU Cooler:");
            backCpuCooler.getStyleClass().remove("pcbuilder-enabled");
            moboNames.clear();
            for (int i=0; i<moboList.size(); i++){
                String moboName = moboList.get(i).getBrand() + " " + moboList.get(i).getChipset() + " " + moboList.get(i).getName();
                if (moboList.get(i).getSocket().equals(selectedCpu.getSocket())) {
                    moboNames.add(moboName);
                }
            }
            choiceMobo.setItems(moboNames);
        }
    }

    @FXML
    private void backMoboButtonAction() {
        System.out.println("backMoboButton clicked");
        addMobo.getStyleClass().remove("pcbuilder-enabled");
        moboDesc.getStyleClass().remove("pcbuilder-enabled");
        moboHeaderLabel.getStyleClass().remove("pcbuilder-enabled");
        moboImageView.getStyleClass().remove("pcbuilder-enabled");
        backMobo.getStyleClass().remove("pcbuilder-enabled");
        choiceMobo.getStyleClass().remove("pcbuilder-enabled");

        cpuCoolerHeaderLabel.setText("Select CPU Cooler:");
        addCpuCooler.getStyleClass().add("pcbuilder-enabled");
        choiceCpuCooler.getStyleClass().add("pcbuilder-enabled");
        backCpuCooler.getStyleClass().add("pcbuilder-enabled");
    }
}
