package com.pcbuilder.model;

/**
 * Created by Ace on 05.05.2017.
 */
public class ModelHDD {
    private String brand;
    private String serialNumber;
    private String interfaceType; // like SATA, IDE
    private String formFactor; // like 2.5", 3.5"
    private int rotationalSpeed; // like 7200 (rpm)
    private int capacity;
    private int readSpeed;
    private int writeSpeed;
    private int cacheSize;
    private int acousticsIdle; // in dB
    private int acousticsOperation;
    private int wattage;


    ModelHDD (String hddBrand, String hddSerialNumber, String hddInterfaceType, String hddFormFactor, int hddRotationalSpeed,
              int hddCapacity, int hddReadSpeed, int hddWriteSpeed, int hddCacheSize, int hddAcousticsIdle,
              int hddAcousticsOperation,int hddWattage) {
        brand = hddBrand;
        serialNumber = hddSerialNumber;
        interfaceType = hddInterfaceType;
        formFactor = hddFormFactor;
        rotationalSpeed = hddRotationalSpeed;
        capacity = hddCapacity;
        readSpeed = hddReadSpeed;
        writeSpeed = hddWriteSpeed;
        cacheSize = hddCacheSize;
        acousticsIdle = hddAcousticsIdle;
        acousticsOperation = hddAcousticsOperation;
        wattage = hddWattage;
    }

    public String getBrand(){ return brand;}
    public String getSerialNumber() {return serialNumber;}
    public String getInterfaceType() {return interfaceType;}
    public String getFormFactor() {return formFactor;}
    public int getRotationalSpeed() {return rotationalSpeed;}
    public int getCapacity() {return capacity;}
    public int getReadSpeed() {return readSpeed;}
    public int getWriteSpeed() {return writeSpeed;}
    public int getCacheSize() {return cacheSize;}
    public int getAcousticsIdle() {return acousticsIdle;}
    public int getAcousticsOperation() {return acousticsOperation;}
    public int getWattage() {return wattage;}

}
