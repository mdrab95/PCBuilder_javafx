package com.pcbuilder.model;
import javafx.beans.property.*;

/**
 * Created by Ace on 05.05.2017.
 */
public class ModelGPU {

    private final StringProperty chipManufacturer;
    private final StringProperty manufacturer;
    private final StringProperty series;
    private final StringProperty name;
    private final StringProperty architecture;
    private final IntegerProperty technology;
    private final StringProperty interfaceType;
    private final IntegerProperty memorySize;
    private final StringProperty memoryType;
    private final IntegerProperty speed;
    private final IntegerProperty boostSpeed;
    private final IntegerProperty memorySpeed;
    private final IntegerProperty external6Pin;
    private final IntegerProperty external8Pin;
    private final IntegerProperty dpConnectors;
    private final IntegerProperty hdmiConnectors;
    private final IntegerProperty dviConnectors;
    private final IntegerProperty vgaConnectors;
    private final IntegerProperty tdp;
    private final IntegerProperty wattage;
    private final BooleanProperty isCooledPassive;
    private final BooleanProperty hasBackplate;
    private final IntegerProperty price;
    private final StringProperty imagePath;


    public ModelGPU (String gpuChipManufacturer, String gpuManufacturer, String gpuSeries, String gpuName, String gpuArchitecture, int gpuTechnology, String gpuInterfaceType,
                     int gpuMemorySize, String gpuMemoryType, int gpuSpeed, int gpuBoostSpeed, int gpuMemorySpeed, int gpuExternal6Pin, int gpuExternal8Pin, int gpuDpConnectors,
                     int gpuHdmiConnectors, int gpuDviConnectors, int gpuVgaConnectors,
                     int gpuTdp, int gpuWattage, boolean gpuIsCooledPassive, boolean gpuHasBackplate, int gpuPrice, String gpuImagePath) {
        chipManufacturer = new SimpleStringProperty(gpuChipManufacturer);
        manufacturer = new SimpleStringProperty(gpuManufacturer);
        series = new SimpleStringProperty(gpuSeries);
        name = new SimpleStringProperty(gpuName);
        architecture = new SimpleStringProperty(gpuArchitecture);
        technology = new SimpleIntegerProperty(gpuTechnology);
        interfaceType = new SimpleStringProperty(gpuInterfaceType);
        memorySize = new SimpleIntegerProperty(gpuMemorySize);
        memoryType = new SimpleStringProperty(gpuMemoryType);
        speed = new SimpleIntegerProperty(gpuSpeed);
        boostSpeed = new SimpleIntegerProperty(gpuBoostSpeed);
        memorySpeed = new SimpleIntegerProperty(gpuMemorySpeed);
        external6Pin = new SimpleIntegerProperty(gpuExternal6Pin);
        external8Pin = new SimpleIntegerProperty(gpuExternal8Pin);
        dpConnectors = new SimpleIntegerProperty(gpuDpConnectors);
        hdmiConnectors = new SimpleIntegerProperty(gpuHdmiConnectors);
        dviConnectors = new SimpleIntegerProperty(gpuDviConnectors);
        vgaConnectors = new SimpleIntegerProperty(gpuVgaConnectors);
        tdp = new SimpleIntegerProperty(gpuTdp);
        wattage = new SimpleIntegerProperty(gpuWattage);
        isCooledPassive = new SimpleBooleanProperty(gpuIsCooledPassive);
        hasBackplate = new SimpleBooleanProperty(gpuHasBackplate);
        price = new SimpleIntegerProperty(gpuPrice);
        imagePath = new SimpleStringProperty(gpuImagePath);

    }

    public StringProperty chipManufacturerProperty() { return chipManufacturer;}
    public String getChipManufacturer(){return chipManufacturer.get();}

    public StringProperty manufacturerProperty() { return manufacturer;}
    public String getManufacturer(){return manufacturer.get();}

    public StringProperty seriesProperty() {return series;}
    public String getseries(){return series.get();}

    public StringProperty nameProperty() {return name;}
    public String getName(){return name.get();}

    public StringProperty architectureProperty() {return architecture;}
    public String getarchitecture(){return architecture.get();}

    public IntegerProperty technologyProperty() {return technology;}
    public int getTechnology(){return technology.get(); }

    public StringProperty interfaceTypeProperty() {return interfaceType;}
    public String getinterfaceType(){return interfaceType.get(); }

    public IntegerProperty memorySizeProperty() {return memorySize;}
    public int getmemorySize(){return memorySize.get(); }

    public StringProperty memoryTypeProperty() {return memoryType;}
    public String getMemoryType(){return memoryType.get();}

    public IntegerProperty speedProperty() {return speed;}
    public int getSpeed(){return speed.get(); }

    public IntegerProperty boostSpeedProperty() {return boostSpeed;}
    public int getBoostSpeed(){return boostSpeed.get(); }

    public IntegerProperty memorySpeedProperty() {return memorySpeed;}
    public int getMemorySpeed() {return memorySpeed.get();}

    public IntegerProperty external6PinProperty() {return external6Pin;}
    public int getExternal6Pin(){return external6Pin.get(); }

    public IntegerProperty external8PinProperty() {return external8Pin;}
    public int getExternal8Pin(){return external8Pin.get(); }

    public IntegerProperty dpConnectorsProperty() {return dpConnectors;}
    public int getDpConnectors(){return dpConnectors.get(); }

    public IntegerProperty hdmiConnectorsProperty() {return hdmiConnectors;}
    public int getHdmiConnectors(){return hdmiConnectors.get(); }

    public IntegerProperty dviConnectorsProperty() {return dviConnectors;}
    public int getDviConnectors(){return dviConnectors.get(); }

    public IntegerProperty vgaConnectorsPropertyProperty() {return vgaConnectors;}
    public int getVgaConnectors(){return vgaConnectors.get(); }

    public IntegerProperty tdpProperty() {return tdp;}
    public int getTdp(){return tdp.get(); }

    public IntegerProperty wattageProperty() {return wattage;}
    public int getWattage(){return wattage.get(); }

    public BooleanProperty isCooledPassiveProperty() {return isCooledPassive;}
    public boolean getBoxCooler(){return isCooledPassive.get(); }

    public BooleanProperty hasBackplateProperty() {return hasBackplate;}
    public boolean getHasBackplate(){return hasBackplate.get(); }

    public IntegerProperty priceProperty(){return price;}
    public int getPrice(){return price.get(); }

    public StringProperty imagePathProperty(){return imagePath;}
    public String getImagePath(){return imagePath.get();}

}
