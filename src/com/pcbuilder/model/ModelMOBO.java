package com.pcbuilder.model;
import javafx.beans.property.*;

/**
 * Motherboard Model Class.
 */
public class ModelMOBO {

        private final StringProperty brand;
        private final StringProperty serialNumber;
        private final StringProperty name;
        private final StringProperty formFactor; // like ATX, µATX
        private final StringProperty chipset;
        private final IntegerProperty maxRam;
        private final IntegerProperty ramSlots;
        private final IntegerProperty maxRamSpeed;
        private final StringProperty connectors;
        private final StringProperty audio;
        private final IntegerProperty wattage;
        private final IntegerProperty price;
        private final StringProperty imagePath;
        private final StringProperty smallImagePath;

        /**
         * Constructor:
         * @param moboBrand brand
         * @param moboSerialNumber manufacturer serial number
         * @param moboName name
         * @param moboFormFactor mobo form factor
         * @param moboChipset chipset model
         * @param moboMaxRam max ram capacity
         * @param moboRamSlots ram slots number
         * @param moboMaxRamSpeed ram max speed (incl. oc profiles)
         * @param moboConnectors long desc about all connectors
         * @param moboAudio audio chip info
         * @param moboPrice mobo price
         * @param moboImagePath path to big image file
         * @param moboSmallImagePath path to small image file
         */
    public ModelMOBO (String moboBrand, String moboSerialNumber, String moboName, String moboFormFactor, String moboChipset,
                      int moboMaxRam, int moboRamSlots, int moboMaxRamSpeed, String moboConnectors, String moboAudio, int moboPrice,
                      String moboImagePath, String moboSmallImagePath) {
            brand = new SimpleStringProperty(moboBrand);
            serialNumber = new SimpleStringProperty(moboSerialNumber);
            name = new SimpleStringProperty(moboName);
            formFactor = new SimpleStringProperty(moboFormFactor);
            chipset = new SimpleStringProperty(moboChipset);
            maxRam = new SimpleIntegerProperty(moboMaxRam);
            ramSlots = new SimpleIntegerProperty(moboRamSlots);
            maxRamSpeed = new SimpleIntegerProperty(moboMaxRamSpeed);
            connectors = new SimpleStringProperty(moboConnectors);
            audio = new SimpleStringProperty(moboAudio);
            wattage = new SimpleIntegerProperty(5);
            price = new SimpleIntegerProperty(moboPrice);
            imagePath = new SimpleStringProperty(moboImagePath);
            smallImagePath = new SimpleStringProperty(moboSmallImagePath);
        }

    public String getBrand(){return brand.get();}
    public String getSerialNumber(){return serialNumber.get();}
    public String getName(){return name.get();}
    public String getFormFactor(){return formFactor.get();}
    public String getChipset(){return chipset.get(); }
    public int getMaxRam(){return maxRam.get(); }
    public int getRamSlots(){return ramSlots.get(); }
    public int getMaxRamSpeed(){return maxRamSpeed.get(); }
    public String getConnectors(){return connectors.get(); }
    public String getAudio(){return audio.get();}
    public int getWattage(){return wattage.get(); }
    public int getPrice(){return price.get(); }
    public String getImagePath(){return imagePath.get();}
    public String getSmallImagePath(){return smallImagePath.get();}
}
