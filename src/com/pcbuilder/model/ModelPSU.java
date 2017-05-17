package com.pcbuilder.model;

import javafx.beans.property.*;

/**
 * PSU Model Class.
 */
public class ModelPSU {
    private final StringProperty brand;
    private final StringProperty name;
    private final StringProperty manufacturerCode;
    private final StringProperty specification;
    private final StringProperty certificate80PlusEurope;
    private final StringProperty coolingMode;
    private final DoubleProperty fanSize;
    private final DoubleProperty depth;
    private final IntegerProperty wattage;
    private final IntegerProperty price;
    private final StringProperty imagePath;
    private final StringProperty smallImagePath;

    public ModelPSU(String psuBrand, String psuName, String psuManufacturerCode, String psuSpecification, String psuCertificate80PlusEurope, String psuCoolingMode,
                    double psuFanSize, double psuDepth, int psuWattage, int psuPrice, String psuImagePath, String psuSmallImagePath){
        brand = new SimpleStringProperty(psuBrand);
        name = new SimpleStringProperty(psuName);
        manufacturerCode = new SimpleStringProperty(psuManufacturerCode);
        specification = new SimpleStringProperty(psuSpecification);
        certificate80PlusEurope = new SimpleStringProperty(psuCertificate80PlusEurope);
        coolingMode = new SimpleStringProperty(psuCoolingMode);
        fanSize = new SimpleDoubleProperty(psuFanSize);
        depth = new SimpleDoubleProperty(psuDepth);
        wattage = new SimpleIntegerProperty(psuWattage);
        price = new SimpleIntegerProperty(psuPrice);
        imagePath = new SimpleStringProperty(psuImagePath);
        smallImagePath = new SimpleStringProperty(psuSmallImagePath);
    }

    public String getBrand(){ return brand.get();}
    public String getName(){ return name.get();}
    public String getManufacturerCode(){return manufacturerCode.get();}
    public String getSpecification(){ return specification.get();}
    public String getCertificate80PlusEurope(){ return certificate80PlusEurope.get();}
    public String getCoolingMode(){ return coolingMode.get();}
    public double getFanSize(){return fanSize.get();}
    public double getDepth(){return depth.get();}
    public int getWattage(){return wattage.get(); }
    public int getPrice(){return price.get(); }
    public String getImagePath(){return imagePath.get();}
    public String getSmallImagePath(){return smallImagePath.get();}

}
