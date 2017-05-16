package com.pcbuilder.model;
import javafx.beans.property.*;

/**
 * Created by Ace on 05.05.2017.
 */
public class ModelCPU {

    private final StringProperty brand;
    private final StringProperty socket;
    private final StringProperty name;
    private final StringProperty family;
    private final IntegerProperty technology;
    private final IntegerProperty numberOfCores;
    private final IntegerProperty numberOfThreads;
    private final BooleanProperty isUnlocked;
    private final DoubleProperty speed;
    private final DoubleProperty boostSpeed;
    private final DoubleProperty cacheL2;
    private final DoubleProperty cacheL3;
    private final IntegerProperty tdp;
    private final IntegerProperty wattage;
    private final StringProperty packageType;
    private final BooleanProperty isTheCpuCoolerIncluded;
    private final IntegerProperty price;
    private final StringProperty imagePath;
    private final StringProperty smallImagePath;


    public ModelCPU (String cpuBrand, String cpuSocket, String cpuName, String cpuFamily, int cpuTechnology, int cpuNumberOfCores,
              int cpuNumberOfThreads, boolean cpuIsUnlocked, double cpuSpeed, double cpuBoostSpeed, double cpuCacheL2, double cpuCacheL3,
              int cpuTdp, int cpuWattage, String cpuPackageType, boolean cpuIsTheCpuCoolerIncluded, int cpuPrice, String cpuImagePath, String cpuSmallImagePath ) {
        brand = new SimpleStringProperty(cpuBrand);
        socket = new SimpleStringProperty(cpuSocket);
        name = new SimpleStringProperty(cpuName);
        family = new SimpleStringProperty(cpuFamily);
        technology = new SimpleIntegerProperty(cpuTechnology);
        numberOfCores = new SimpleIntegerProperty(cpuNumberOfCores);
        numberOfThreads = new SimpleIntegerProperty(cpuNumberOfThreads);
        isUnlocked = new SimpleBooleanProperty(cpuIsUnlocked);
        speed = new SimpleDoubleProperty(cpuSpeed);
        boostSpeed = new SimpleDoubleProperty(cpuBoostSpeed);
        cacheL2 = new SimpleDoubleProperty(cpuCacheL2);
        cacheL3 = new SimpleDoubleProperty(cpuCacheL3);
        tdp = new SimpleIntegerProperty(cpuTdp);
        wattage = new SimpleIntegerProperty(cpuWattage);
        packageType = new SimpleStringProperty(cpuPackageType);
        isTheCpuCoolerIncluded = new SimpleBooleanProperty(cpuIsTheCpuCoolerIncluded);
        price = new SimpleIntegerProperty(cpuPrice);
        imagePath = new SimpleStringProperty(cpuImagePath);
        smallImagePath = new SimpleStringProperty(cpuSmallImagePath);
    }

    public StringProperty brandProperty() { return brand;}
    public String getBrand(){return brand.get();}

    public StringProperty socketProperty() {return socket;}
    public String getSocket(){return socket.get();}

    public StringProperty nameProperty() {return name;}
    public String getName(){return name.get();}

    public StringProperty familyProperty() {return family;}
    public String getFamily(){return family.get();}

    public IntegerProperty technologyProperty() {return technology;}
    public int getTechnology(){return technology.get(); }

    public IntegerProperty numberOfCoresProperty() {return numberOfCores;}
    public int getNumberOfCores(){return numberOfCores.get(); }

    public IntegerProperty numberOfThreadsProperty() {return numberOfThreads;}
    public int getNumberOfThreads(){return numberOfThreads.get(); }

    public BooleanProperty isUnlockedProperty() {return isUnlocked;}
    public boolean getIsUnlocked() {return isUnlocked.get();}

    public DoubleProperty speedProperty() {return speed;}
    public double getSpeed(){return speed.get(); }

    public DoubleProperty boostSpeedProperty() {return boostSpeed;}
    public double getBoostSpeed(){return boostSpeed.get(); }

    public DoubleProperty cacheL2Property() {return cacheL2;}
    public double getCacheL2(){return cacheL2.get(); }

    public DoubleProperty cacheL3Property() {return cacheL3;}
    public double getCacheL3(){return cacheL3.get(); }

    public IntegerProperty tdpProperty() {return tdp;}
    public int getTdp(){return tdp.get(); }

    public IntegerProperty wattageProperty() {return wattage;}
    public int getWattage(){return wattage.get(); }

    public StringProperty packageTypeProperty() {return packageType;}
    public String getPackageType(){return packageType.get();}

    public BooleanProperty isTheCpuCoolerIncludedProperty() {return isTheCpuCoolerIncluded;}
    public boolean getBoxCooler(){return isTheCpuCoolerIncluded.get(); }

    public IntegerProperty priceProperty(){return price;}
    public int getPrice(){return price.get(); }

    public StringProperty imagePathProperty(){return imagePath;}
    public String getImagePath(){return imagePath.get();}

    public StringProperty smallImagePathProperty(){return smallImagePath;}
    public String getSmallImagePath(){return smallImagePath.get();}

}
