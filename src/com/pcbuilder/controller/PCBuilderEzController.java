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
import javafx.scene.image.Image;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Ace on 19.06.2017.
 */
public class PCBuilderEzController implements Initializable {
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    DataLoader dataLoader = new DataLoader();

    //region GENERAL
    //--------------------------------------
    @FXML
    private Button startButton;
    @FXML
    private Label maxLoadLabel;
    @FXML
    private Label maxLoadCounter;
    @FXML
    private Label recommendedPsuLabel;
    @FXML
    private Label recommendedPsuCounter;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private Label totalPriceCounter;
    @FXML
    private Button saveBuildButton;
    private int maxLoad = 0;
    private double recommendedPsu = 0;
    private double totalPrice = 0;
    private DecimalFormat df = new DecimalFormat();
    private DecimalFormat df2 = new DecimalFormat("0.00");
    @FXML
    private Label labelSaved;
    //--------------------------------------
    //endregion


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
    private Button backCpu;

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

    //region GPU
    //--------------------------------------
    @FXML
    private ChoiceBox choiceGpu;
    @FXML
    private ImageView gpuImageView;
    @FXML
    private Label gpuHeaderLabel;
    @FXML
    private Label gpuDesc;
    @FXML
    private Button addGpu;
    @FXML
    private Button backGpu;

    private ModelGPU selectedGpu;
    private Image gpuImg;
    //--------------------------------------
    //endregion

    //region RAM
    //--------------------------------------
    @FXML
    private ChoiceBox choiceRam;
    @FXML
    private ImageView ramImageView;
    @FXML
    private Label ramHeaderLabel;
    @FXML
    private Label ramDesc;
    @FXML
    private Button addRam;
    @FXML
    private Button backRam;

    private ModelRAM selectedRam;
    private Image ramImg;
    //--------------------------------------
    //endregion

    //region SSD
    //--------------------------------------
    @FXML
    private ChoiceBox choiceSsd;
    @FXML
    private ImageView ssdImageView;
    @FXML
    private Label ssdHeaderLabel;
    @FXML
    private Label ssdDesc;
    @FXML
    private Button addSsd;
    @FXML
    private Button backSsd;

    private ModelSSD selectedSsd;
    private Image ssdImg;
    //--------------------------------------
    //endregion

    //region HDD
    //--------------------------------------
    @FXML
    private ChoiceBox choiceHdd;
    @FXML
    private ImageView hddImageView;
    @FXML
    private Label hddHeaderLabel;
    @FXML
    private Label hddDesc;
    @FXML
    private Button addHdd;
    @FXML
    private Button backHdd;

    private ModelHDD selectedHdd;
    private Image hddImg;
    //--------------------------------------
    //endregion

    //region PSU
    //--------------------------------------
    @FXML
    private ChoiceBox choicePsu;
    @FXML
    private ImageView psuImageView;
    @FXML
    private Label psuHeaderLabel;
    @FXML
    private Label psuDesc;
    @FXML
    private Button addPsu;
    @FXML
    private Button backPsu;

    private ModelPSU selectedPsu;
    private Image psuImg;
    //--------------------------------------
    //endregion

    //region Case
    //--------------------------------------
    @FXML
    private ChoiceBox choiceCase;
    @FXML
    private ImageView caseImageView;
    @FXML
    private Label caseHeaderLabel;
    @FXML
    private Label caseDesc;
    @FXML
    private Button addCase;
    @FXML
    private Button backCase;

    private ModelCase selectedCase;
    private Image caseImg;
    //--------------------------------------
    //endregion

    private final ObservableList<ModelCPU> cpuList = FXCollections.observableArrayList();
    private final ObservableList<ModelGPU> gpuList = FXCollections.observableArrayList();
    private final ObservableList<ModelCPUCooler> cpuCoolerList = FXCollections.observableArrayList();
    private final ObservableList<ModelMOBO> moboList = FXCollections.observableArrayList();
    private final ObservableList<ModelSSD> ssdList = FXCollections.observableArrayList();
    private final ObservableList<ModelHDD> hddList = FXCollections.observableArrayList();
    private final ObservableList<ModelRAM> ramList = FXCollections.observableArrayList();
    private final ObservableList<ModelPSU> psuList = FXCollections.observableArrayList();
    private final ObservableList<ModelCase> caseList = FXCollections.observableArrayList();
    ObservableList cpuCoolerNames = FXCollections.observableArrayList();
    ObservableList moboNames = FXCollections.observableArrayList();
    ObservableList gpuNames = FXCollections.observableArrayList();
    ObservableList cpuNames = FXCollections.observableArrayList();
    ObservableList ramNames = FXCollections.observableArrayList();
    ObservableList ssdNames = FXCollections.observableArrayList();
    ObservableList hddNames = FXCollections.observableArrayList();
    ObservableList psuNames = FXCollections.observableArrayList();
    ObservableList caseNames = FXCollections.observableArrayList();

    private String memoryConnectors(ModelGPU modelItem) {
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
    public void initialize(URL location, ResourceBundle resources) {
        df.setMaximumFractionDigits(0);
        //region Data Loader
        // --------------------------------------
        try {
            cpuList.addAll(dataLoader.cpuDataLoader());
        } catch (IOException e) {
        }
        try {
            cpuCoolerList.addAll(dataLoader.cpuCoolerDataLoader());
        } catch (IOException e) {
        }
        try {
            ramList.addAll(dataLoader.ramDataLoader());
        } catch (IOException e) {
        }
        try {
            ssdList.addAll(dataLoader.ssdDataLoader());
        } catch (IOException e) {
        }
        try {
            hddList.addAll(dataLoader.hddDataLoader());
        } catch (IOException e) {
        }
        try {
            gpuList.addAll(dataLoader.gpuDataLoader());
        } catch (IOException e) {
        }
        try {
            psuList.addAll(dataLoader.psuDataLoader());
        } catch (IOException e) {
        }
        try {
            caseList.addAll(dataLoader.caseDataLoader());
        } catch (IOException e) {
        }
        try {
            moboList.addAll(dataLoader.moboDataLoader());
        } catch (IOException e) {
        }
        //--------------------------------------
        //endregion

        //region CPU init
        // --------------------------------------
        for (int i = 0; i < cpuList.size(); i++) {
            String cpuName = cpuList.get(i).getBrand() + " " + cpuList.get(i).getFamily() + " " + cpuList.get(i).getName();
            cpuNames.add(cpuName);
        }
        choiceCpu.setItems(cpuNames);
        choiceCpu.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        System.out.println(newValue);
                        for (int i = 0; i < cpuList.size(); i++) {
                            String cpuItemName = cpuList.get(i).getBrand() + " " + cpuList.get(i).getFamily() + " " + cpuList.get(i).getName();
                            if (newValue.matches(cpuItemName)) {
                                selectedCpu = cpuList.get(i);
                            }
                        }
                        cpuImg = new Image(selectedCpu.getSmallImagePath());
                        setImg(cpuImg, cpuImageView);

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

                        String cpuDescription = (selectedCpu.getBrand() + " " + selectedCpu.getFamily() + spaceInName + selectedCpu.getName() + " (" + howItIsPacked + ")"
                                + "\n" + selectedCpu.getNumberOfCores() + "C/" + selectedCpu.getNumberOfThreads() + "T, " + speed + ", " + mainApp.noZeros(selectedCpu.getCacheL3()) + " MB" + ", "
                                + selectedCpu.getTdp() + "W TDP"
                                + "\nPrice: " + selectedCpu.getPrice() + " PLN");
                        cpuDesc.setText(cpuDescription);
                    }
                });
        setNoImg(cpuImg, cpuImageView);
        //--------------------------------------
        //endregion

        //region CPUCooler init
        // --------------------------------------
        cpuCoolerNames.add("BOX Cooler");
        for (int i = 0; i < cpuCoolerList.size(); i++) {
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
                                setImg(cpuCoolerImg, cpuCoolerImageView);
                                cpuCoolerDesc.setText("There is no box cooler included!");
                            } else {
                                cpuCoolerImg = new Image(selectedCpu.getSmallImagePath());
                                setImg(cpuCoolerImg, cpuCoolerImageView);
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
                            setImg(cpuCoolerImg, cpuCoolerImageView);

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
        setNoImg(cpuCoolerImg, cpuCoolerImageView);
        //--------------------------------------
        //endregion

        //region MOBO init
        // --------------------------------------

        for (int i = 0; i < moboList.size(); i++) {
            String moboName = moboList.get(i).getBrand() + " " + moboList.get(i).getChipset() + " " + moboList.get(i).getName();
            moboNames.add(moboName);
        }
        choiceMobo.setItems(moboNames);
        choiceMobo.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        System.out.println(newValue);
                        for (int i = 0; i < moboList.size(); i++) {
                            String selectedMoboName = moboList.get(i).getBrand() + " " + moboList.get(i).getChipset() + " " + moboList.get(i).getName();
                            if (newValue.matches(selectedMoboName)) {
                                selectedMobo = moboList.get(i);
                            }
                        }
                        try {
                            moboImg = new Image(selectedMobo.getSmallImagePath() + selectedMobo.getSerialNumber() + ".png", true);
                            setImg(moboImg, moboImageView);
                        } catch (Exception ex) {
                            System.out.println("Cant load mobo img!");
                        }

                        String moboDescription = selectedMobo.getBrand() + " " + selectedMobo.getChipset() + " " + selectedMobo.getName()
                                + "\n" + "Socket: " + selectedMobo.getSocket() + ", form factor: " + selectedMobo.getFormFactor()
                                + "\nRAM standard: " + selectedMobo.getRamStandard() + ", Max RAM speed: " + selectedMobo.getMaxRamSpeed() + " MHz"
                                + "\nMax RAM capacity: " + selectedMobo.getMaxRam() + "GB, in " + selectedMobo.getRamSlots() + " slots."
                                + "\nPrice: " + selectedMobo.getPrice() + " PLN";
                        moboDesc.setText(moboDescription);
                    }
                });

        setNoImg(moboImg, moboImageView);
        //--------------------------------------
        //endregion

        //region GPU init
        // --------------------------------------

        for (int i = 0; i < gpuList.size(); i++) {
            String gpuName = gpuList.get(i).getChipManufacturer() + " " + gpuList.get(i).getseries() + " " + gpuList.get(i).getName();
            gpuNames.add(gpuName);
        }
        choiceGpu.setItems(gpuNames);
        choiceGpu.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        System.out.println(newValue);
                        for (int i = 0; i < gpuList.size(); i++) {
                            String selectedGpuName = gpuList.get(i).getChipManufacturer() + " " + gpuList.get(i).getseries() + " " + gpuList.get(i).getName();
                            if (newValue.matches(selectedGpuName)) {
                                selectedGpu = gpuList.get(i);
                            }
                        }
                        try {
                            gpuImg = new Image(selectedGpu.getSmallImagePath() + selectedGpu.getManufacturerCode() + ".png", true);
                            setImg(gpuImg, gpuImageView);
                        } catch (Exception ex) {
                            System.out.println("Can't load GPU img!");
                        }

                        String speed = "";
                        if (selectedGpu.getSpeed() == selectedGpu.getBoostSpeed())
                            speed = selectedGpu.getSpeed() + "MHz";
                        else
                            speed = selectedGpu.getSpeed() + "-" + selectedGpu.getBoostSpeed() + "MHz";
                        String videoConnectors = memoryConnectors(selectedGpu);

                        String gpuDescription = selectedGpu.getManufacturer() + " " + selectedGpu.getseries() + " " + selectedGpu.getName() + " " + selectedGpu.getmemorySize() + "GB " + selectedGpu.getMemoryType()
                                + "\nVideo connectors: " + videoConnectors
                                + "\nCore speed: " + speed + ", Memory speed: " + mainApp.noZeros(selectedGpu.getMemorySpeed()) + " GHz"
                                + "\nPrice: " + selectedGpu.getPrice() + " PLN";
                        gpuDesc.setText(gpuDescription);
                    }
                });

        setNoImg(gpuImg, gpuImageView);
        //--------------------------------------
        //endregion

        //region RAM init
        // --------------------------------------

        for (int i = 0; i < ramList.size(); i++) {
            String ramName = ramList.get(i).getBrand() + " " + ramList.get(i).getName() + " " + ramList.get(i).getStandard() + " " + ramList.get(i).getMemorySize() + "GB, " + ramList.get(i).getMemoryClock() + "MHz";
            ramNames.add(ramName);
        }
        choiceRam.setItems(ramNames);
        choiceRam.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        System.out.println(newValue);
                        for (int i = 0; i < ramList.size(); i++) {
                            String selectedRamName = ramList.get(i).getBrand() + " " + ramList.get(i).getName() + " " + ramList.get(i).getStandard() + " " + ramList.get(i).getMemorySize() + "GB, " + ramList.get(i).getMemoryClock() + "MHz";
                            if (newValue.matches(selectedRamName)) {
                                selectedRam = ramList.get(i);
                            }
                        }
                        try {
                            ramImg = new Image(selectedRam.getSmallImagePath() + selectedRam.getSerialNumber() + ".png", true);
                            setImg(ramImg, ramImageView);
                        } catch (Exception ex) {
                            System.out.println("Can't load RAM img!");
                        }


                        String ramDescription = selectedRam.getBrand() + " " + selectedRam.getName() + " " + selectedRam.getStandard() + " " + selectedRam.getMemorySize() + "GB " + selectedRam.getMemoryClock() + "MHz"
                                + "\nNumber of modules: " + selectedRam.getNumberOfModules() + ", module size: " + selectedRam.getSingleModuleSize() + "GB"
                                + "\nCAS Latency: " + selectedRam.getCasLatency()
                                + "\nPrice: " + selectedRam.getPrice() + " PLN";
                        ramDesc.setText(ramDescription);
                    }
                });

        setNoImg(ramImg, ramImageView);
        //--------------------------------------
        //endregion

        //region SSD init
        // --------------------------------------

        for (int i = 0; i < ssdList.size(); i++) {
            String ssdName = ssdList.get(i).getBrand() + " " + ssdList.get(i).getName() + " " + ssdList.get(i).getCapacity() + "GB";
            ssdNames.add(ssdName);
        }
        choiceSsd.setItems(ssdNames);
        choiceSsd.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        System.out.println(newValue);
                        for (int i = 0; i < ssdList.size(); i++) {
                            String selectedSsdName = ssdList.get(i).getBrand() + " " + ssdList.get(i).getName() + " " + ssdList.get(i).getCapacity() + "GB";
                            if (newValue.matches(selectedSsdName)) {
                                selectedSsd = ssdList.get(i);
                            }
                        }
                        try {
                            ssdImg = new Image(selectedSsd.getSmallImagePath() + selectedSsd.getSerialNumber() + ".png", true);
                            setImg(ssdImg, ssdImageView);
                        } catch (Exception ex) {
                            System.out.println("Can't load SSD img!");
                        }


                        String ssdDescription = selectedSsd.getBrand() + " " + selectedSsd.getName() + " " + selectedSsd.getCapacity() + " GB"
                                + "\n" + "Form factor: " + selectedSsd.getFormFactor() + ", interface type: " + selectedSsd.getInterfaceType() + ", memory type: " + selectedSsd.getMemoryType()
                                + "\nRead: " + selectedSsd.getReadSpeed() + "MB/s, write: " + selectedSsd.getWriteSpeed() + "MB/s " + ", TBW: " + selectedSsd.getTbw() + "TB"
                                + "\nPrice: " + selectedSsd.getPrice() + " PLN";
                        ssdDesc.setText(ssdDescription);
                    }
                });

        setNoImg(ssdImg, ssdImageView);
        //--------------------------------------
        //endregion

        //region HDD init
        // --------------------------------------

        for (int i = 0; i < hddList.size(); i++) {
            String hddName = hddList.get(i).getBrand() + " " + hddList.get(i).getName() + " " + hddList.get(i).getCapacity() + "GB";
            hddNames.add(hddName);
        }
        choiceHdd.setItems(hddNames);
        choiceHdd.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        System.out.println(newValue);
                        for (int i = 0; i < hddList.size(); i++) {
                            String selectedHddName = hddList.get(i).getBrand() + " " + hddList.get(i).getName() + " " + hddList.get(i).getCapacity() + "GB";
                            if (newValue.matches(selectedHddName)) {
                                selectedHdd = hddList.get(i);
                            }
                        }
                        try {
                            hddImg = new Image(selectedHdd.getSmallImagePath() + selectedHdd.getSerialNumber() + ".png", true);
                            setImg(hddImg, hddImageView);
                        } catch (Exception ex) {
                            System.out.println("Can't load HDD img!");
                        }


                        String hddDescription = selectedHdd.getBrand() + " " + selectedHdd.getName() + " " + selectedHdd.getCapacity() + "GB "
                                + "\nInterface type: " + selectedHdd.getHddInterfaceType() + ", form factor: " + selectedHdd.getFormFactor()
                                + "\nRotational speed: " + selectedHdd.getRotationalSpeed() + "rpm"
                                + "\nPrice: " + selectedHdd.getPrice() + " PLN";
                        hddDesc.setText(hddDescription);
                    }
                });

        setNoImg(hddImg, hddImageView);
        //--------------------------------------
        //endregion

        //region PSU init
        // --------------------------------------

        for (int i = 0; i < psuList.size(); i++) {
            String psuName = psuList.get(i).getBrand() + " " + psuList.get(i).getName() + " " + psuList.get(i).getWattage() + "W";
            psuNames.add(psuName);
        }
        choicePsu.setItems(psuNames);
        choicePsu.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        System.out.println(newValue);
                        for (int i = 0; i < psuList.size(); i++) {
                            String selectedPsuName = psuList.get(i).getBrand() + " " + psuList.get(i).getName() + " " + psuList.get(i).getWattage() + "W";
                            if (newValue.matches(selectedPsuName)) {
                                selectedPsu = psuList.get(i);
                            }
                        }
                        try {
                            psuImg = new Image(selectedPsu.getSmallImagePath() + selectedPsu.getManufacturerCode() + ".png", true);
                            setImg(psuImg, psuImageView);
                        } catch (Exception ex) {
                            System.out.println("Can't load PSU img!");
                        }

                        String modular = "";
                        if (selectedPsu.getIsModular() == true)
                            modular = "Modular";

                        String certificate = "";
                        if (selectedPsu.getCertificate80Plus().length() == 0)
                            certificate = "no data";
                        else
                            certificate = selectedPsu.getCertificate80Plus();

                        String psuDescription = selectedPsu.getBrand() + " " + selectedPsu.getName() + " " + selectedPsu.getWattage() + "W " + modular
                                + "\nCertificate: " + certificate + ", Protection:  " + selectedPsu.getProtection()
                                + "\nPrice: " + selectedPsu.getPrice() + " PLN";
                        psuDesc.setText(psuDescription);
                    }
                });

        setNoImg(psuImg, psuImageView);
        //--------------------------------------
        //endregion

        //region Case init
        // --------------------------------------

        for (int i = 0; i < caseList.size(); i++) {
            String caseName = caseList.get(i).getBrand() + " " + caseList.get(i).getName();
            caseNames.add(caseName);
        }
        choiceCase.setItems(caseNames);
        choiceCase.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        System.out.println(newValue);
                        for (int i = 0; i < caseList.size(); i++) {
                            String selectedCaseName = caseList.get(i).getBrand() + " " + caseList.get(i).getName();
                            if (newValue.matches(selectedCaseName)) {
                                selectedCase = caseList.get(i);
                            }
                        }
                        try {
                            caseImg = new Image(selectedCase.getSmallImagePath() + selectedCase.getSerialNumber() + ".png", true);
                            setImg(caseImg, caseImageView);
                        } catch (Exception ex) {
                            System.out.println("Can't load Case img!");
                        }


                        String caseDescription = selectedCase.getBrand() + " " + selectedCase.getName()
                                + "\nCompatibility: " + selectedCase.getFormFactor() + ", Type: " + selectedCase.getType()
                                + "\nPrice: " + selectedCase.getPrice() + " PLN";
                        caseDesc.setText(caseDescription);
                    }
                });

        setNoImg(caseImg, caseImageView);
        //--------------------------------------
        //endregion


    }

    private void setNoImg(Image image, ImageView imageView) {
        image = new Image("images/no_img.png");
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setImage(image);
    }

    private void setImg(Image image, ImageView imageView) {
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setImage(image);
    }

    @FXML
    private void startButtonAcction() {
        System.out.println("start button clicked");
        addCpu.getStyleClass().add("pcbuilder-enabled");
        cpuDesc.getStyleClass().add("pcbuilder-enabled");
        cpuHeaderLabel.getStyleClass().add("pcbuilder-enabled");
        cpuImageView.getStyleClass().add("pcbuilder-enabled");
        choiceCpu.getStyleClass().add("pcbuilder-enabled");
        startButton.getStyleClass().add("pcbuilder-disabled");
        maxLoadLabel.getStyleClass().add("pcbuilder-enabled");
        maxLoadCounter.getStyleClass().add("pcbuilder-enabled");
        recommendedPsuLabel.getStyleClass().add("pcbuilder-enabled");
        recommendedPsuCounter.getStyleClass().add("pcbuilder-enabled");
        totalPriceLabel.getStyleClass().add("pcbuilder-enabled");
        totalPriceCounter.getStyleClass().add("pcbuilder-enabled");
    }

    @FXML
    private void lastButtonAction() {
        if (selectedCase != null) {
            choiceCase.getStyleClass().remove("pcbuilder-enabled");
            addCase.getStyleClass().remove("pcbuilder-enabled");
            caseHeaderLabel.setText("Your Case:");
            maxLoad += 0;
            maxLoadCounter.setText(String.valueOf(maxLoad) + "W");
            recommendedPsu = 1.4 * maxLoad;
            recommendedPsuCounter.setText(String.valueOf(df.format(recommendedPsu)) + "W");
            totalPrice += selectedCase.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
            saveBuildButton.getStyleClass().add("pcbuilder-enabled");
        }
    }


    private void backButtonCpu(String buttonName, Button currentAdd, Button currentBack, Label currentDesc, Label currentHeader,
                               ImageView currentImageView, Image currentImage, ChoiceBox currentChoice, Button previousAdd,
                               Label previousHeader, ChoiceBox previousChoice, ObservableList currentNames, String selectWhat) {
        System.out.println(buttonName + " clicked");
        currentAdd.getStyleClass().remove("pcbuilder-enabled");
        currentBack.getStyleClass().remove("pcbuilder-enabled");
        currentDesc.getStyleClass().remove("pcbuilder-enabled");
        currentHeader.getStyleClass().remove("pcbuilder-enabled");
        currentImageView.getStyleClass().remove("pcbuilder-enabled");
        currentChoice.getStyleClass().remove("pcbuilder-enabled");

        previousAdd.getStyleClass().add("pcbuilder-enabled");
        previousHeader.setText("Add " + selectWhat + ":");
        previousChoice.getStyleClass().add("pcbuilder-enabled");


        currentDesc.setText(null);
        currentImage = new Image("images/no_img.png");
        currentImageView.setImage(currentImage);
    }

    private void backButtonUniversal(String buttonName, Button currentAdd, Button currentBack, Label currentDesc, Label currentHeader,
                                     ImageView currentImageView, Image currentImage, ChoiceBox currentChoice, Button previousAdd, Button previousBack,
                                     Label previousHeader, ChoiceBox previousChoice, ObservableList currentNames, String selectWhat) {

        backButtonCpu(buttonName, currentAdd, currentBack, currentDesc, currentHeader, currentImageView, currentImage, currentChoice,
                previousAdd, previousHeader, previousChoice, currentNames, selectWhat);

        previousBack.getStyleClass().add("pcbuilder-enabled");
    }

    private void addButtonCpu(String buttonName, Button nextAdd, Button nextBack, Label nextDesc, Label nextHeader, ImageView nextImageView,
                              ChoiceBox nextChoice, Button currentAdd, ChoiceBox currentChoice, Label currentHeader, String currentLabel,
                              ObservableList nextNames, Image nextImage) {
        System.out.println(buttonName + " clicked");
        nextAdd.getStyleClass().add("pcbuilder-enabled");
        nextBack.getStyleClass().add("pcbuilder-enabled");
        nextDesc.getStyleClass().add("pcbuilder-enabled");
        nextHeader.getStyleClass().add("pcbuilder-enabled");
        nextImageView.getStyleClass().add("pcbuilder-enabled");
        nextChoice.getStyleClass().add("pcbuilder-enabled");

        currentAdd.getStyleClass().remove("pcbuilder-enabled");
        currentChoice.getStyleClass().remove("pcbuilder-enabled");
        currentHeader.setText(currentLabel);

        nextDesc.setText(null);
        nextImage = new Image("images/no_img.png");
        nextImageView.setImage(nextImage);

    }

    private void addButtonUniversal(String buttonName, Button nextAdd, Button nextBack, Label nextDesc, Label nextHeader, ImageView nextImageView, Image nextImage,
                                    ChoiceBox nextChoice, ObservableList nextNames, Button currentAdd, Button currentBack, ChoiceBox currentChoice, Label currentHeader, String currentLabel) {
        addButtonCpu(buttonName, nextAdd, nextBack, nextDesc, nextHeader, nextImageView, nextChoice, currentAdd, currentChoice, currentHeader, currentLabel, nextNames, nextImage);
        currentBack.getStyleClass().remove("pcbuilder-enabled");
    }

    @FXML
    private void addCpuButtonAction() {
        if (selectedCpu != null) {
            addButtonCpu("addCpuButton", addCpuCooler, backCpuCooler, cpuCoolerDesc, cpuCoolerHeaderLabel, cpuCoolerImageView, choiceCpuCooler, addCpu, choiceCpu,
                    cpuHeaderLabel, "Your CPU:", cpuCoolerNames, cpuCoolerImg);
            cpuCoolerNames.clear();
            if (selectedCpu.getBoxCooler() == true) {
                cpuCoolerNames.add("BOX Cooler");
            }
            for (int i = 0; i < cpuCoolerList.size(); i++) {
                String cpuCoolerName = cpuCoolerList.get(i).getBrand() + " " + cpuCoolerList.get(i).getName();
                String sockets = cpuCoolerList.get(i).getSockets();
                if (sockets.contains(selectedCpu.getSocket())) {
                    cpuCoolerNames.add(cpuCoolerName);
                }
            }
            choiceCpuCooler.setItems(cpuCoolerNames);
            maxLoad += selectedCpu.getWattage();
            maxLoadCounter.setText(String.valueOf(maxLoad) + "W");
            recommendedPsu = 1.4 * maxLoad;
            recommendedPsuCounter.setText(String.valueOf(df.format(recommendedPsu)) + "W");
            totalPrice += selectedCpu.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
        }
    }

    @FXML
    private void backCpuCoolerButtonAction() {
        backButtonCpu("backCpuCoolerButtonAction", addCpuCooler, backCpuCooler, cpuCoolerDesc, cpuCoolerHeaderLabel,
                cpuCoolerImageView, cpuCoolerImg, choiceCpuCooler, addCpu, cpuHeaderLabel, choiceCpu, cpuNames, "CPU");
        selectedCpuCooler = null;
        if (selectedCpu != null) {
            maxLoad -= selectedCpu.getWattage();
            maxLoadCounter.setText(String.valueOf(maxLoad) + "W");
            recommendedPsu = 1.4 * maxLoad;
            recommendedPsuCounter.setText(String.valueOf(df.format(recommendedPsu)) + "W");
            totalPrice -= selectedCpu.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
            saveBuildButton.getStyleClass().add("pcbuilder-enabled");
        }
    }

    @FXML
    private void addCpuCoolerButtonAction() {
        if (selectedCpu.getBoxCooler() == false && selectedCpuCooler == null) {
            cpuCoolerDesc.setText("There is no box cooler included!");
            Image boxCoolerImg = new Image("images/error.png");
            cpuCoolerImageView.setImage(boxCoolerImg);
        }
        if (selectedCpu.getBoxCooler() == true && selectedCpuCooler == null) {
            addButtonUniversal("addCpuCoolerButtonAction", addMobo, backMobo, moboDesc, moboHeaderLabel, moboImageView, moboImg,
                    choiceMobo, moboNames, addCpuCooler, backCpuCooler, choiceCpuCooler, cpuCoolerHeaderLabel, "Your CPU Cooler:");
            moboNames.clear();
            for (int i = 0; i < moboList.size(); i++) {
                String moboName = moboList.get(i).getBrand() + " " + moboList.get(i).getChipset() + " " + moboList.get(i).getName();
                if (moboList.get(i).getSocket().equals(selectedCpu.getSocket())) {
                    moboNames.add(moboName);
                }
            }
            choiceMobo.setItems(moboNames);
        }
        if (selectedCpu.getBoxCooler() == false && selectedCpuCooler != null || selectedCpu.getBoxCooler() == true && selectedCpuCooler != null) {
            addButtonUniversal("addCpuCoolerButtonAction", addMobo, backMobo, moboDesc, moboHeaderLabel, moboImageView, moboImg,
                    choiceMobo, moboNames, addCpuCooler, backCpuCooler, choiceCpuCooler, cpuCoolerHeaderLabel, "Your CPU Cooler:");
            moboNames.clear();
            for (int i = 0; i < moboList.size(); i++) {
                String moboName = moboList.get(i).getBrand() + " " + moboList.get(i).getChipset() + " " + moboList.get(i).getName();
                if (moboList.get(i).getSocket().equals(selectedCpu.getSocket())) {
                    moboNames.add(moboName);
                }
            }
            choiceMobo.setItems(moboNames);
            maxLoad += selectedCpuCooler.getWattage();
            maxLoadCounter.setText(String.valueOf(maxLoad) + "W");
            recommendedPsu = 1.4 * maxLoad;
            recommendedPsuCounter.setText(String.valueOf(df.format(recommendedPsu)) + "W");
            totalPrice += selectedCpuCooler.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
        }
    }

    @FXML
    private void backMoboButtonAction() {
        backButtonUniversal("backMoboButtonAction", addMobo, backMobo, moboDesc, moboHeaderLabel, moboImageView, moboImg, choiceMobo,
                addCpuCooler, backCpuCooler, cpuCoolerHeaderLabel, choiceCpuCooler, moboNames, "Cpu cooler");
        selectedMobo = null;
        if (selectedCpuCooler != null) {
            maxLoad -= selectedCpuCooler.getWattage();
            maxLoadCounter.setText(String.valueOf(maxLoad) + "W");
            recommendedPsu = 1.4 * maxLoad;
            recommendedPsuCounter.setText(String.valueOf(df.format(recommendedPsu)) + "W");
            totalPrice -= selectedCpuCooler.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
            saveBuildButton.getStyleClass().add("pcbuilder-enabled");
        }
    }

    @FXML
    private void addMoboButtonAction() {
        if (selectedMobo != null) {
            addButtonUniversal("addMoboButtonAction", addGpu, backGpu, gpuDesc, gpuHeaderLabel, gpuImageView, gpuImg, choiceGpu, gpuNames,
                    addMobo, backMobo, choiceMobo, moboHeaderLabel, "Your Motherboard: ");
            maxLoad += selectedMobo.getWattage();
            maxLoadCounter.setText(String.valueOf(maxLoad) + "W");
            recommendedPsu = 1.4 * maxLoad;
            recommendedPsuCounter.setText(String.valueOf(df.format(recommendedPsu)) + "W");
            totalPrice += selectedMobo.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
        }
    }

    @FXML
    private void backGpuButtonAction() {
        backButtonUniversal("backGpuButtonAction", addGpu, backGpu, gpuDesc, gpuHeaderLabel, gpuImageView, gpuImg, choiceGpu,
                addMobo, backMobo, moboHeaderLabel, choiceMobo, moboNames, "Motherboard");
        selectedGpu = null;
        if (selectedMobo != null) {
            maxLoad -= selectedMobo.getWattage();
            maxLoadCounter.setText(String.valueOf(maxLoad) + "W");
            recommendedPsu = 1.4 * maxLoad;
            recommendedPsuCounter.setText(String.valueOf(df.format(recommendedPsu)) + "W");
            totalPrice -= selectedMobo.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
            saveBuildButton.getStyleClass().add("pcbuilder-enabled");
        }
    }

    @FXML
    private void addGpuButtonAction() {
        if (selectedGpu != null) {
            addButtonUniversal("addGpuButtonName", addRam, backRam, ramDesc, ramHeaderLabel, ramImageView, ramImg, choiceRam, ramNames,
                    addGpu, backGpu, choiceGpu, gpuHeaderLabel, "Your Graphic card:");
            maxLoad += selectedGpu.getWattage();
            maxLoadCounter.setText(String.valueOf(maxLoad) + "W");
            recommendedPsu = 1.4 * maxLoad;
            recommendedPsuCounter.setText(String.valueOf(df.format(recommendedPsu)) + "W");
            totalPrice += selectedGpu.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
        }
    }

    @FXML
    private void backRamButtonAction() {
        backButtonUniversal("backRamButtonAction", addRam, backRam, ramDesc, ramHeaderLabel, ramImageView, ramImg, choiceRam,
                addGpu, backGpu, gpuHeaderLabel, choiceGpu, gpuNames, "GPU");
        selectedRam = null;
        if (selectedGpu != null) {
            maxLoad -= selectedGpu.getWattage();
            maxLoadCounter.setText(String.valueOf(maxLoad) + "W");
            recommendedPsu = 1.4 * maxLoad;
            recommendedPsuCounter.setText(String.valueOf(df.format(recommendedPsu)) + "W");
            totalPrice -= selectedGpu.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
            saveBuildButton.getStyleClass().add("pcbuilder-enabled");
        }
    }

    @FXML
    private void addRamButtonAction() {
        if (selectedRam != null) {
            addButtonUniversal("addRamButtonName", addSsd, backSsd, ssdDesc, ssdHeaderLabel, ssdImageView, ssdImg, choiceSsd, ssdNames,
                    addRam, backRam, choiceRam, ramHeaderLabel, "Your RAM:");
            maxLoad += selectedRam.getWattage();
            maxLoadCounter.setText(String.valueOf(maxLoad) + "W");
            recommendedPsu = 1.4 * maxLoad;
            recommendedPsuCounter.setText(String.valueOf(df.format(recommendedPsu)) + "W");
            totalPrice += selectedRam.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
        }
    }

    @FXML
    private void backSsdButtonAction() {
        backButtonUniversal("backSsdButtonAction", addSsd, backSsd, ssdDesc, ssdHeaderLabel, ssdImageView, ssdImg, choiceSsd,
                addRam, backRam, ramHeaderLabel, choiceRam, ramNames, "RAM");
        selectedSsd = null;
        if (selectedRam != null) {
            maxLoad -= selectedRam.getWattage();
            maxLoadCounter.setText(String.valueOf(maxLoad) + "W");
            recommendedPsu = 1.4 * maxLoad;
            recommendedPsuCounter.setText(String.valueOf(df.format(recommendedPsu)) + "W");
            totalPrice -= selectedRam.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
            saveBuildButton.getStyleClass().add("pcbuilder-enabled");
        }
    }

    @FXML
    private void addSsdButtonAction() {
        if (selectedSsd != null) {
            addButtonUniversal("addSsdButtonName", addHdd, backHdd, hddDesc, hddHeaderLabel, hddImageView, hddImg, choiceHdd, hddNames,
                    addSsd, backSsd, choiceSsd, ssdHeaderLabel, "Your SSD:");
            maxLoad += selectedSsd.getWattage();
            maxLoadCounter.setText(String.valueOf(maxLoad) + "W");
            recommendedPsu = 1.4 * maxLoad;
            recommendedPsuCounter.setText(String.valueOf(df.format(recommendedPsu)) + "W");
            totalPrice += selectedSsd.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
        }
    }

    @FXML
    private void backHddButtonAction() {
        backButtonUniversal("backHddButtonAction", addHdd, backHdd, hddDesc, hddHeaderLabel, hddImageView, hddImg, choiceHdd,
                addSsd, backSsd, ssdHeaderLabel, choiceSsd, ssdNames, "SSD");
        selectedHdd = null;
        if (selectedSsd != null) {
            maxLoad -= selectedSsd.getWattage();
            maxLoadCounter.setText(String.valueOf(maxLoad) + "W");
            recommendedPsu = 1.4 * maxLoad;
            recommendedPsuCounter.setText(String.valueOf(df.format(recommendedPsu)) + "W");
            totalPrice -= selectedSsd.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
            saveBuildButton.getStyleClass().add("pcbuilder-enabled");
        }
    }

    @FXML
    private void addHddButtonAction() {
        if (selectedHdd != null) {
            addButtonUniversal("addHddButtonName", addPsu, backPsu, psuDesc, psuHeaderLabel, psuImageView, psuImg, choicePsu, psuNames,
                    addHdd, backHdd, choiceHdd, hddHeaderLabel, "Your HDD:");
            maxLoad += selectedHdd.getWattage();
            maxLoadCounter.setText(String.valueOf(maxLoad) + "W");
            recommendedPsu = 1.4 * maxLoad;
            recommendedPsuCounter.setText(String.valueOf(df.format(recommendedPsu)) + "W");
            totalPrice += selectedHdd.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
        }
    }

    @FXML
    private void backPsuButtonAction() {
        backButtonUniversal("backPsuButtonAction", addPsu, backPsu, psuDesc, psuHeaderLabel, psuImageView, psuImg, choicePsu,
                addHdd, backHdd, hddHeaderLabel, choiceHdd, hddNames, "HDD");
        selectedPsu = null;
        if (selectedHdd != null) {
            maxLoad -= selectedHdd.getWattage();
            maxLoadCounter.setText(String.valueOf(maxLoad) + "W");
            recommendedPsu = 1.4 * maxLoad;
            recommendedPsuCounter.setText(String.valueOf(df.format(recommendedPsu)) + "W");
            totalPrice -= selectedHdd.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
            saveBuildButton.getStyleClass().add("pcbuilder-enabled");
        }
    }

    @FXML
    private void addPsuButtonAction() {
        if (selectedPsu != null) {
            addButtonUniversal("addHddButtonName", addCase, backCase, caseDesc, caseHeaderLabel, caseImageView, caseImg, choiceCase, caseNames,
                    addPsu, backPsu, choicePsu, psuHeaderLabel, "Your PSU:");
            totalPrice += selectedPsu.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
        }
    }

    @FXML
    private void backCaseButtonAction() {
        backButtonUniversal("backHddButtonAction", addCase, backCase, caseDesc, caseHeaderLabel, caseImageView, caseImg, choiceCase,
                addPsu, backPsu, psuHeaderLabel, choicePsu, psuNames, "PSU");
        if (selectedPsu != null) {
            totalPrice -= selectedPsu.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
            saveBuildButton.getStyleClass().add("pcbuilder-enabled");
        }
        if (selectedCase != null) {
            totalPrice -= selectedCase.getPrice();
            totalPriceCounter.setText(String.valueOf(df2.format(totalPrice)) + "PLN");
            saveBuildButton.getStyleClass().add("pcbuilder-enabled");
        }
        selectedCase = null;
        selectedPsu = null;
        labelSaved.getStyleClass().remove("pcbuild-enabled");
    }

    @FXML
    private void saveBuildButtonAction() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hhmmss");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        String savedString = createTextToSave(currentDate);
        String filePath = "C:/PCBuilder";
        String fileName = currentDate;
        String fileNameAndPath = "C:/PCBuilder/PCBuilder " + fileName + ".txt";
        saveTextToFile(fileNameAndPath, filePath, savedString);
    }

    private String createTextToSave(String currentDate){
        String savedString = "This file has been generated on " + currentDate
                + "\r\n----------------------------------------------------------------------------"
                + "\r\n" + padRight("Your build", 13) + " " + padLeft("Price",62)
                + "\r\n----------------------------------------------------------------------------";
        savedString += "\r\n" + padRight("CPU:", 13) + padRight(selectedCpu.getBrand() + " " + selectedCpu.getFamily()
                + " " + selectedCpu.getName(), 50) + " " + padRight(String.valueOf(selectedCpu.getPrice()), 8) + " PLN";
        if (selectedCpuCooler != null) {
            savedString += "\r\n" + padRight("CPU Cooler:", 13) + padRight(selectedCpuCooler.getBrand() + " "
                    + selectedCpuCooler.getName(), 50) + " " + padRight(String.valueOf(selectedCpuCooler.getPrice()),8) + " PLN";
        }
        else {
            savedString += "\r\n" + padRight("CPU Cooler:", 13) + " " + padRight("BOX Cooler", 50) + padRight("0",8) +" PLN";
        }
        savedString += "\r\n"+ padRight("Motherboard:", 13) + padRight(selectedMobo.getBrand() + " "
                + selectedMobo.getName(),50) + " " + padRight(String.valueOf(selectedMobo.getPrice()),8) + " PLN";
        savedString += "\r\n"+ padRight("GPU:", 13)+  padRight(selectedGpu.getChipManufacturer() + " "
                + selectedGpu.getseries() + " " + selectedGpu.getName(),50) + " " + padRight(String.valueOf(selectedMobo.getPrice()),8) + " PLN";
        savedString += "\r\n"+ padRight("RAM:", 13) + padRight(selectedRam.getBrand() + " " + selectedRam.getName()
                + " " + selectedRam.getRamType() + " " +
                selectedRam.getMemorySize() + "GB " + selectedRam.getMemoryClock() + "MHz CL " + selectedRam.getCasLatency(),50)
                + " " + padRight(String.valueOf(selectedRam.getPrice()),8) + " PLN";
        savedString += "\r\n"+ padRight("SSD:", 13) + padRight(selectedSsd.getBrand() + " " + selectedSsd.getName() + " "
                + selectedSsd.getCapacity() + "GB " + selectedSsd.getMemoryType(),50) + " " + padRight(String.valueOf(selectedSsd.getPrice()),8) + " PLN";
        savedString += "\r\n"+ padRight("HDD:", 13) + padRight(selectedHdd.getBrand() + " " + selectedHdd.getName() + " "
                + selectedHdd.getCapacity() + "GB " + selectedHdd.getRotationalSpeed() + "rpm",50) + " " + padRight(String.valueOf(selectedHdd.getPrice()),8) + " PLN";
        savedString += "\r\n"+ padRight("PSU:", 13) + padRight(selectedPsu.getBrand() + " " + selectedPsu.getName() + " "
                + selectedPsu.getWattage() + "W" + selectedPsu.getCertificate80Plus(),50) + " " + padRight(String.valueOf(selectedPsu.getPrice()),8) + " PLN";
        savedString += "\r\n"+ padRight("Case:", 13) + padRight(selectedCase.getBrand() + " " + selectedCase.getName() + " "
                + selectedCase.getFormFactor(),50) + " " + padRight(String.valueOf(selectedCase.getPrice()),8) + " PLN";
        savedString += "\r\n----------------------------------------------------------------------------";
        savedString += "\r\n" + padRight("Total price:", 64) +  padRight(String.valueOf(df2.format(totalPrice)), 9) + "PLN";
        savedString += "\r\n----------------------------------------------------------------------------";
        savedString += "\r\n"+ padRight("Max load:", 70)  + padRight(String.valueOf(maxLoad), 5) + "W";
        savedString += "\r\n"+ padRight("Recommended PSU wattage: ", 70) + padRight(String.valueOf(df.format(recommendedPsu)), 5) + "W";
        savedString += "\r\n----------------------------------------------------------------------------";
        savedString += "\r\nPCBuilder - made by Michał Drab";
        savedString += "\r\n----------------------------------------------------------------------------";
        return savedString;
    }

    private void saveTextToFile(String fileNameAndPath, String path, String savedString) {
        File dir = new File(path);
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
        BufferedWriter bw = null;
        try {
            File file = new File(fileNameAndPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(savedString);
            System.out.println("saved to " + fileNameAndPath);
            labelSaved.setText("saved to " + fileNameAndPath);
            labelSaved.getStyleClass().add("pcbuilder-enabled");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception ex) {
                System.out.println("Error in closing the BufferedWriter" + ex);
            }

        }
    }


    private static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    private static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }
}
