package com.pcbuilder.test;

import com.pcbuilder.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ace on 28.06.2017.
 */
class ModelDataFilter {

    //region data init
    ModelDataLoaderAndFilter dlaf = new ModelDataLoaderAndFilter();
    ObservableList<ModelCPU> cpuList = FXCollections.observableArrayList();
    ObservableList <ModelCPUCooler> cpuCoolerList = FXCollections.observableArrayList();
    ObservableList <ModelMOBO> moboList = FXCollections.observableArrayList();
    ObservableList <ModelGPU> gpuList = FXCollections.observableArrayList();
    ObservableList <ModelRAM> ramList = FXCollections.observableArrayList();
    ObservableList <ModelHDD> hddList = FXCollections.observableArrayList();
    ObservableList <ModelSSD> ssdList = FXCollections.observableArrayList();
    ObservableList<ModelPSU> psuList = FXCollections.observableArrayList();
    ObservableList <ModelCase> caseList = FXCollections.observableArrayList();
    ModelCPU selectedCpu;
    ModelCPUCooler selectedCpuCooler;
    ModelMOBO selectedMobo;
    ModelGPU selectedGpu;
    ModelRAM selectedRam;
    ModelSSD selectedSsd;
    ModelHDD selectedHdd;
    ModelPSU selectedPsu;
    ModelCase selectedCase;
    ObservableList cpuCoolerNames = FXCollections.observableArrayList();
    ObservableList moboNames = FXCollections.observableArrayList();
    ObservableList gpuNames = FXCollections.observableArrayList();
    ObservableList cpuNames = FXCollections.observableArrayList();
    ObservableList ramNames = FXCollections.observableArrayList();
    ObservableList ssdNames = FXCollections.observableArrayList();
    ObservableList hddNames = FXCollections.observableArrayList();
    ObservableList psuNames = FXCollections.observableArrayList();
    ObservableList caseNames = FXCollections.observableArrayList();
    //endregion

    @Test
    void getCpuCoolerNamesTest () {
        System.out.println("CPU Cooler names method test: " +
                "\n1. Load all CPU Coolers" +
                "\n2. Create CPU Cooler names list based on selected cpu socket" +
                "\n3. For every CPU Cooler check if socket is ok.\n--------------------");
        try {
            cpuCoolerList.addAll(dlaf.cpuCoolerDataLoader());
        } catch (Exception ex) {fail("Can't load data!");}

        selectedCpu = new ModelCPU("Intel", "1151", "7700", "Core i7", 14, 4, 8, true, true,
                3.6, 4.2, 1, 8, 65, 95,"box", true, 1580,
                "images/cpuImages/big/i7-7700.png","images/cpuImages/small/i7-7700_small.png");

        cpuCoolerNames.addAll(dlaf.getCpuCoolerNames(selectedCpu, cpuCoolerList));
        if(cpuCoolerNames.size() == 0) {
            fail ("Cpu cooler names list is null!");
        }

        for (int i=0; i<cpuCoolerNames.size(); i++) {
            for (int j=0; j<cpuCoolerList.size(); j++){
                String name = cpuCoolerNames.get(i).toString();
                if (name.matches(cpuCoolerList.get(j).getBrand() + " " + cpuCoolerList.get(j).getName())) {
                    if (cpuCoolerList.get(j).getSockets().contains(selectedCpu.getSocket()) == false){
                        if (name.equals("BOX Cooler")==false) {
                            fail("CPU Cooler has wrong socket! Invalid method.");
                        }
                        if (name.equals("BOX Cooler")) {
                            if (selectedCpu.getBoxCooler() == false)
                            fail("CPU has no box cooler included! Invalid method.");
                        }
                    } else {
                        System.out.println("CPU Cooler number " + (j+1) + ": socket - ok");
                    }
                }
            }
        }
        System.out.println("--------------------  " +
                "\nAll CPU Coolers have proper sockets." +
                "\nMethod is OK." );
    }

    @Test
    void getMoboNamesTest () {
        System.out.println("MOBO names method test: " +
                "\n1. Load all motherboards" +
                "\n2. Create mobo names list based on selected cpu socket" +
                "\n3. For every motherboard check if socket is ok.\n--------------------");
        try {
            moboList.addAll(dlaf.moboDataLoader());
        } catch (Exception ex) {fail("Can't load data!");}

        selectedCpu = new ModelCPU("Intel", "1151", "7700", "Core i7", 14, 4, 8, true, true,
                3.6, 4.2, 1, 8, 91, 95,"box", true, 1350,
                "images/cpuImages/big/i7-7700.png","images/cpuImages/small/i7-7700_small.png");

        moboNames.addAll(dlaf.getMoboNames(selectedCpu, selectedCpuCooler ,moboList));
        if(moboNames.size() == 0) {
            fail ("Cpu cooler names list is null!");
        }

        for (int i=0; i<moboNames.size(); i++) {
            String name = moboNames.get(i).toString();
            for (int j=0; j<moboList.size(); j++){
                if (name.matches(moboList.get(j).getBrand() + " " + moboList.get(j).getChipset() + " " + moboList.get(j).getName())) {
                    if (moboList.get(j).getSocket().equals(selectedCpu.getSocket()) == false){
                        fail("MOBO has wrong socket! Invalid method.");
                    } else {
                        System.out.println("Mobo number " + (j+1) + ": socket - ok");
                    }
                }
            }
        }
        System.out.println("--------------------  " +
                "\nAll MOBOs have proper sockets." +
                "\nMethod is OK." );
    }

}