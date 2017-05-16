package com.pcbuilder.model;
import com.sun.javafx.scene.control.skin.IntegerFieldSkin;
import javafx.beans.property.*;

public class ModelCPUCooler {

    private final StringProperty brand;
    private final StringProperty name;
    private final StringProperty manufacturerCode;
    private final StringProperty sockets;
    private final StringProperty design;
    private final DoubleProperty depth;
    private final DoubleProperty width;
    private final DoubleProperty height;
    private final IntegerProperty weight;
    private final DoubleProperty airFlow;
    private final IntegerProperty heatPipes;
    private final IntegerProperty numberOfFans;
    private final DoubleProperty fanSizeX;
    private final DoubleProperty fanSizeY;
    private final DoubleProperty fanSizeHeight;
    private final IntegerProperty minFanSpeed;
    private final IntegerProperty maxFanSpeed;
    private final IntegerProperty minFanNoise;
    private final IntegerProperty maxFanNoise;
    private final IntegerProperty wattage;
    private final StringProperty connectorType;
    private final IntegerProperty price;
    private final StringProperty imagePath;
    private final StringProperty smallImagePath;


    public ModelCPUCooler (String cpuCoolerBrand, String cpuCoolerName, String cpuCoolerManufacturerCode, String cpuCoolerSockets,
                           String cpuCoolerDesign, double cpuCoolerDepth, double cpuCoolerWidth, double cpuCoolerHeight, int cpuCoolerWeight,
                           double cpuCoolerAirFlow, int cpuCoolerHeatPipes, int cpuCoolerNumberOfFans, double cpuCoolerFanSizeX, double cpuCoolerFanSizeY,
                           double cpuCoolerFanSizeHeight, int cpuCoolerMinFanSpeed, int cpuCoolerMaxFanSpeed, int cpuCoolerMinFanNoise,
                           int cpuCoolerMaxFanNoise, int cpuCoolerWattage, String cpuCoolerConnectorType, int cpuCoolerPrice,
                           String cpuCoolerImagePath, String cpuCoolerSmallImagePath ) {

        brand = new SimpleStringProperty(cpuCoolerBrand);
        name = new SimpleStringProperty(cpuCoolerName);
        manufacturerCode = new SimpleStringProperty(cpuCoolerManufacturerCode);
        sockets = new SimpleStringProperty(cpuCoolerSockets);
        design = new SimpleStringProperty(cpuCoolerDesign);
        depth = new SimpleDoubleProperty(cpuCoolerDepth);
        width = new SimpleDoubleProperty(cpuCoolerWidth);
        height = new SimpleDoubleProperty(cpuCoolerHeight);
        weight = new SimpleIntegerProperty(cpuCoolerWeight);
        airFlow = new SimpleDoubleProperty(cpuCoolerAirFlow);
        heatPipes = new SimpleIntegerProperty(cpuCoolerHeatPipes);
        numberOfFans = new SimpleIntegerProperty(cpuCoolerNumberOfFans);
        fanSizeX = new SimpleDoubleProperty(cpuCoolerFanSizeX);
        fanSizeY = new SimpleDoubleProperty(cpuCoolerFanSizeY);
        fanSizeHeight = new SimpleDoubleProperty(cpuCoolerFanSizeHeight);
        minFanSpeed = new SimpleIntegerProperty(cpuCoolerMinFanSpeed);
        maxFanSpeed = new SimpleIntegerProperty(cpuCoolerMaxFanSpeed);
        minFanNoise = new SimpleIntegerProperty(cpuCoolerMinFanNoise);
        maxFanNoise = new SimpleIntegerProperty(cpuCoolerMaxFanNoise);
        wattage = new SimpleIntegerProperty(cpuCoolerWattage);
        connectorType = new SimpleStringProperty(cpuCoolerConnectorType);
        price = new SimpleIntegerProperty(cpuCoolerPrice);
        imagePath = new SimpleStringProperty(cpuCoolerImagePath);
        smallImagePath = new SimpleStringProperty(cpuCoolerSmallImagePath);
    }

    public StringProperty brandProperty() { return brand;}
    public String getBrand(){return brand.get();}

    public StringProperty nameProperty() { return name;}
    public String getName(){return name.get();}

    public StringProperty manufacturerCodeProperty() { return manufacturerCode;}
    public String getManufacturerCode(){return manufacturerCode.get();}

    public StringProperty socketsProperty() {return sockets;}
    public String getSockets(){return sockets.get();}

    public StringProperty designProperty() {return design;}
    public String getDesign(){return design.get();}

    public DoubleProperty depthProperty() {return depth;}
    public double getDepth(){return depth.get(); }

    public DoubleProperty widthProperty() {return width;}
    public double getWidth(){return width.get(); }

    public DoubleProperty heightProperty() {return height;}
    public double getHeight(){return height.get(); }

    public IntegerProperty weightProperty() {return weight;}
    public int getWeight(){return weight.get(); }

    public DoubleProperty airFlowProperty() {return airFlow;}
    public double getAirFlow(){return airFlow.get(); }

    public IntegerProperty heatPipesProperty() {return heatPipes;}
    public int getHeatPipes() {return heatPipes.get();}

    public IntegerProperty numberOfFansProperty() {return numberOfFans;}
    public int getNumberOfFans() {return numberOfFans.get();}

    public DoubleProperty fanSizeXProperty() {return fanSizeX;}
    public double getFanSizeX() {return fanSizeX.get();}

    public DoubleProperty fanSizeYProperty() {return fanSizeY;}
    public double getFanSizeY() {return fanSizeY.get();}

    public DoubleProperty fanSizeHeightProperty() {return fanSizeHeight;}
    public double getFanSizeHeight() {return fanSizeHeight.get();}

    public IntegerProperty minFanSpeedProperty() {return minFanSpeed;}
    public int getMinFanSpeed(){return minFanSpeed.get(); }

    public IntegerProperty maxFanSpeedProperty() {return maxFanSpeed;}
    public int getMaxFanSpeed(){return maxFanSpeed.get(); }

    public IntegerProperty minFanNoiseProperty() {return minFanNoise;}
    public int getMinFanNoise(){return minFanNoise.get(); }

    public IntegerProperty maxFanNoiseProperty() {return maxFanNoise;}
    public int getMaxFanNoise(){return maxFanNoise.get(); }

    public IntegerProperty wattageProperty() {return wattage;}
    public int getWattage(){return wattage.get(); }

    public StringProperty connectorTypeProperty() {return connectorType;}
    public String getConnectorType(){return connectorType.get();}

    public IntegerProperty priceProperty(){return price;}
    public int getPrice(){return price.get(); }

    public StringProperty imagePathProperty(){return imagePath;}
    public String getImagePath(){return imagePath.get();}

    public StringProperty smallImagePathProperty(){return smallImagePath;}
    public String getSmallImagePath(){return smallImagePath.get();}

}
