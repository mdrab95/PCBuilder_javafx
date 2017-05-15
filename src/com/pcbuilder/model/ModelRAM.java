package com.pcbuilder.model;

/**
 * Created by Ace on 05.05.2017.
 */
public class ModelRAM {

    private String brand;
    private String serialNumber;
    private String standard; // like ddr4
    private int memorySize;
    private int numberOfModules;
    private int singleModuleSize;
    private String memoryType;
    private int memoryClock;
    private int casLatency;
    private int voltage;
    private int wattage;
    private boolean hasRadiator;
    private boolean hasLighting;

    ModelRAM (String ramBrand, String ramSerialNumber, String ramStandard, int ramMemorySize, int ramNumberOfModules,
              int ramSingleModuleSize, String ramMemoryType, int ramMemoryClock, int ramCasLatency, int ramVoltage,
              int ramWattage, boolean ramHasRadiator, boolean ramHasLighting ) {
        brand = ramBrand;
        serialNumber = ramSerialNumber;
        standard = ramStandard;
        memorySize = ramMemorySize;
        numberOfModules = ramNumberOfModules;
        singleModuleSize = ramSingleModuleSize;
        memoryType = ramMemoryType;
        memoryClock = ramMemoryClock;
        casLatency = ramCasLatency;
        voltage = ramVoltage;
        wattage = ramWattage;
        hasRadiator = ramHasRadiator;
        hasLighting = ramHasLighting;
    }

    public String getBrand(){ return brand;}
    public String getSeries() {return serialNumber;}
    public String getStandard() {return standard;}
    public int getMemorySize() {return memorySize;}
    public int getNumberOfModules() {return numberOfModules;}
    public int getSingleModuleSize() {return singleModuleSize;}
    public String getMemoryType() {return memoryType;}
    public int getMemoryClock() {return memoryClock;}
    public int getCasLatency() {return casLatency;}
    public int getVoltage() {return voltage;}
    public int getWattage() {return wattage;}
    public boolean getHasRadiator() {return hasRadiator;}
    public boolean getHasLighting() {return hasLighting;}

}
