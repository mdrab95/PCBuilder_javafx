package com.pcbuilder.model;

/**
 * Created by Ace on 05.05.2017.
 */
public class ModelSSD {

    private String brand;
    private String serialNumber;
    private String interfaceType; // like SATA, M.2
    private String formFactor; // like 2.5", M.2 2280
    private String protocol; // like AHCI, NVME 1.2
    private int capacity;
    private int readSpeed;
    private int writeSpeed;
    private String memoryType; // like TLC, MLC, SLC
    private int cacheSize;
    private int tbw;
    private String controllerManufacturer;
    private String controllerModel;
    private int wattage;
    private boolean hasRadiator;

    ModelSSD (String ssdBrand, String ssdSerialNumber, String ssdInterfaceType, String ssdFormFactor, String ssdProtocol,
              int ssdCapacity, int ssdReadSpeed, int ssdWriteSpeed, String ssdMemoryType, int ssdCacheSize, int ssdTbw,
              String ssdControllerManufacturer, String ssdControllerModel, int ssdWattage, boolean ssdhasRadiator ) {
        brand = ssdBrand;
        serialNumber = ssdSerialNumber;
        interfaceType = ssdInterfaceType;
        formFactor = ssdFormFactor;
        protocol = ssdProtocol;
        capacity = ssdCapacity;
        readSpeed = ssdReadSpeed;
        writeSpeed = ssdWriteSpeed;
        memoryType = ssdMemoryType;
        cacheSize = ssdCacheSize;
        tbw = ssdTbw;
        controllerManufacturer = ssdControllerManufacturer;
        controllerModel = ssdControllerModel;
        wattage = ssdWattage;
        hasRadiator = ssdhasRadiator;
    }

    public String getBrand(){ return brand;}
    public String getSerialNumber() {return serialNumber;}
    public String getInterfaceType() {return interfaceType;}
    public String getFormFactor() {return formFactor;}
    public String getProtocol() {return protocol;}
    public int getCapacity() {return capacity;}
    public int getReadSpeed() {return readSpeed;}
    public int getWriteSpeed() {return writeSpeed;}
    public String getMemoryType() {return memoryType;}
    public int getCacheSize() {return cacheSize;}
    public int getTbw() {return tbw;}
    public String getControllerManufacturer() {return controllerManufacturer;}
    public String getControllerModel() {return controllerModel;}
    public int getWattage() {return wattage;}
    public boolean getHasRadiator() {return hasRadiator;}

}
