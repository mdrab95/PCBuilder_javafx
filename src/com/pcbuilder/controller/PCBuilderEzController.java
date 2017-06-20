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

    @FXML
    private Button startButton;

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
    ObservableList gpuNames = FXCollections.observableArrayList();
    ObservableList cpuNames = FXCollections.observableArrayList();
    ObservableList ramNames = FXCollections.observableArrayList();

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

                    String cpuDescription = (selectedCpu.getBrand() + " " + selectedCpu.getFamily() + spaceInName +  selectedCpu.getName() + " (" + howItIsPacked + ")"
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
                                setImg(cpuCoolerImg, cpuCoolerImageView);
                                cpuCoolerDesc.setText("There is no box cooler included!");
                            }
                            else {
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
                            setImg(moboImg, moboImageView);
                        }
                        catch (Exception ex){System.out.println("Cant load mobo img!");}

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

        for (int i=0; i<gpuList.size(); i++){
            String gpuName = gpuList.get(i).getChipManufacturer() + " " + gpuList.get(i).getseries() + " " + gpuList.get(i).getName();
            gpuNames.add(gpuName);
        }
        choiceGpu.setItems(gpuNames);
        choiceGpu.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        System.out.println(newValue);
                        for (int i=0; i< gpuList.size(); i++)
                        {
                            String selectedGpuName = gpuList.get(i).getChipManufacturer() + " " + gpuList.get(i).getseries() + " " + gpuList.get(i).getName();
                            if (newValue.matches(selectedGpuName))
                            {
                                selectedGpu = gpuList.get(i);
                            }
                        }
                        try {
                            gpuImg = new Image(selectedGpu.getSmallImagePath() + selectedGpu.getManufacturerCode() + ".png", true);
                            setImg(gpuImg, gpuImageView);
                        }
                        catch (Exception ex){System.out.println("Can't load GPU img!");}

                        String speed = "";
                        if (selectedGpu.getSpeed() == selectedGpu.getBoostSpeed())
                            speed = selectedGpu.getSpeed() + "MHz";
                        else
                            speed = selectedGpu.getSpeed() + "-" + selectedGpu.getBoostSpeed() + "MHz";
                        String videoConnectors = memoryConnectors(selectedGpu);

                        String gpuDescription = selectedGpu.getManufacturer() + " " + selectedGpu.getseries() + " " +  selectedGpu.getName() + " " + selectedGpu.getmemorySize() + "GB " + selectedGpu.getMemoryType()
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

        for (int i=0; i<ramList.size(); i++){
            String ramName = ramList.get(i).getBrand() + " " + ramList.get(i).getName() + " " + ramList.get(i).getStandard() + " " + ramList.get(i).getMemorySize() + "GB, " + ramList.get(i).getMemoryClock() + "MHz";
            ramNames.add(ramName);
        }
        choiceRam.setItems(ramNames);
        choiceRam.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        System.out.println(newValue);
                        for (int i=0; i< ramList.size(); i++)
                        {
                            String selectedRamName = ramList.get(i).getBrand() + " " + ramList.get(i).getName() + " " + ramList.get(i).getStandard() + " " + ramList.get(i).getMemorySize() + "GB, " + ramList.get(i).getMemoryClock() + "MHz";
                            if (newValue.matches(selectedRamName))
                            {
                                selectedRam = ramList.get(i);
                            }
                        }
                        try {
                            ramImg = new Image(selectedRam.getSmallImagePath() + selectedRam.getSerialNumber() + ".png", true);
                            setImg(ramImg, ramImageView);
                        }
                        catch (Exception ex){System.out.println("Can't load GPU img!");}


                        String ramDescription = selectedRam.getBrand() + " " + selectedRam.getName() + " " +  selectedRam.getStandard() + " " + selectedRam.getMemorySize() + "GB " + selectedRam.getMemoryClock() + "MHz"
                                + "\nNumber of modules: " + selectedRam.getNumberOfModules() + ", module size: " + selectedRam.getSingleModuleSize() + "GB"
                                + "\nCAS Latency: " + selectedRam.getCasLatency()
                                + "\nPrice: " + selectedRam.getPrice() + " PLN";
                        ramDesc.setText(ramDescription);
                    }
                });

        setNoImg(ramImg, ramImageView);
        //--------------------------------------
        //endregion
    }

    private void setNoImg(Image image, ImageView imageView)
    {
        image = new Image ("images/no_img.png");
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setImage(image);
    }

    private void setImg(Image image, ImageView imageView)
    {
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setImage(image);
    }
    @FXML
    private void startButtonAcction(){
        System.out.println("start button clicked");
        addCpu.getStyleClass().add("pcbuilder-enabled");
        cpuDesc.getStyleClass().add("pcbuilder-enabled");
        cpuHeaderLabel.getStyleClass().add("pcbuilder-enabled");
        cpuImageView.getStyleClass().add("pcbuilder-enabled");
        choiceCpu.getStyleClass().add("pcbuilder-enabled");
        startButton.getStyleClass().add("pcbuilder-disabled");
    }

    private void backButtonCpu(String buttonName, Button currentAdd, Button currentBack, Label currentDesc, Label currentHeader,
                                     ImageView currentImageView, Image currentImage, ChoiceBox currentChoice, Button previousAdd,
                                     Label previousHeader, ChoiceBox previousChoice, ObservableList currentNames){
        System.out.println(buttonName + " clicked");
        currentAdd.getStyleClass().remove("pcbuilder-enabled");
        currentBack.getStyleClass().remove("pcbuilder-enabled");
        currentDesc.getStyleClass().remove("pcbuilder-enabled");
        currentHeader.getStyleClass().remove("pcbuilder-enabled");
        currentImageView.getStyleClass().remove("pcbuilder-enabled");
        currentChoice.getStyleClass().remove("pcbuilder-enabled");

        previousAdd.getStyleClass().add("pcbuilder-enabled");
        previousHeader.setText("Select CPU Cooler:");
        previousChoice.getStyleClass().add("pcbuilder-enabled");


        currentDesc.setText(null);
        currentImage = new Image("images/no_img.png");
        currentImageView.setImage(currentImage);
    }

    private void backButtonUniversal(String buttonName, Button currentAdd, Button currentBack, Label currentDesc, Label currentHeader,
                                     ImageView currentImageView, Image currentImage, ChoiceBox currentChoice, Button previousAdd, Button previousBack,
                                     Label previousHeader, ChoiceBox previousChoice, ObservableList currentNames){

        backButtonCpu(buttonName, currentAdd, currentBack, currentDesc, currentHeader, currentImageView, currentImage, currentChoice,
                previousAdd, previousHeader, previousChoice, currentNames);

        previousBack.getStyleClass().add("pcbuilder-enabled");
        currentNames.clear();

    }

    private void addButtonCpu(String buttonName, Button nextAdd, Button nextBack, Label nextDesc, Label nextHeader, ImageView nextImageView,
                                    ChoiceBox nextChoice, Button currentAdd, ChoiceBox currentChoice, Label currentHeader, String currentLabel,
                              ObservableList nextNames,Image nextImage){
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
                                    ChoiceBox nextChoice, ObservableList nextNames, Button currentAdd, Button currentBack, ChoiceBox currentChoice, Label currentHeader, String currentLabel ){
        addButtonCpu(buttonName, nextAdd, nextBack, nextDesc, nextHeader, nextImageView, nextChoice, currentAdd, currentChoice, currentHeader, currentLabel, nextNames, nextImage);
        currentBack.getStyleClass().remove("pcbuilder-enabled");
    }

    @FXML
    private void addCpuButtonAction(){
        if (selectedCpu != null) {
            addButtonCpu("addCpuButton", addCpuCooler, backCpuCooler, cpuCoolerDesc, cpuCoolerHeaderLabel, cpuCoolerImageView, choiceCpuCooler, addCpu, choiceCpu,
                     cpuHeaderLabel, "Your CPU:", cpuCoolerNames, cpuCoolerImg);
            cpuCoolerNames.clear();
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
        backButtonCpu("backCpuCoolerButtonAction", addCpuCooler, backCpuCooler, cpuCoolerDesc, cpuCoolerHeaderLabel,
                cpuCoolerImageView, cpuCoolerImg, choiceCpuCooler, addCpu, cpuHeaderLabel, choiceCpu, cpuNames);
        selectedCpuCooler = null;


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
            addButtonUniversal("addCpuCoolerButtonAction", addMobo, backMobo, moboDesc, moboHeaderLabel, moboImageView, moboImg,
                    choiceMobo, moboNames, addCpuCooler, backCpuCooler, choiceCpuCooler, cpuCoolerHeaderLabel, "Your CPU Cooler:");
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
        backButtonUniversal("backMoboButtonAction", addMobo, backMobo, moboDesc, moboHeaderLabel, moboImageView,
                moboImg, choiceMobo, addCpuCooler, backCpuCooler, cpuCoolerHeaderLabel, choiceCpuCooler, moboNames);
        selectedMobo = null;
    }

    @FXML
    private void addMoboButtonAction(){
        addButtonUniversal("addMoboButtonAction", addGpu, backGpu, gpuDesc, gpuHeaderLabel, gpuImageView, gpuImg, choiceGpu, gpuNames,
                addMobo, backMobo, choiceMobo, moboHeaderLabel, "Your Motherboard: ");
    }

    @FXML
    private void backGpuButtonAction() {
        backButtonUniversal("backGpuButtonAction", addGpu, backGpu, gpuDesc, gpuHeaderLabel, gpuImageView, gpuImg,
                choiceGpu, addMobo, backMobo, moboHeaderLabel, choiceMobo, moboNames);
        selectedGpu = null;
    }

    @FXML
    private void addGpuButtonAction(){
        addButtonUniversal("addGpuButtonName", addRam, backRam, ramDesc, ramHeaderLabel, ramImageView, ramImg, choiceRam, ramNames,
                addGpu, backGpu, choiceGpu, gpuHeaderLabel, "Your Graphic card:");
    }

    @FXML
    private void backRamButtonAction() {
        backButtonUniversal("backRamButtonAction", addRam, backRam, ramDesc, ramHeaderLabel, ramImageView, ramImg,
                choiceRam, addGpu, backGpu, gpuHeaderLabel, choiceGpu, gpuNames);
        selectedRam = null;
    }
}
