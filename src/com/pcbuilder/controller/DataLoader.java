package com.pcbuilder.controller;
import com.pcbuilder.model.*;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Comparator;

/**
 * Data loader class.
 */
public class DataLoader {

    String path = "src/com/pcbuilder/files/"; // default path to 'files' directory
    String name;

    /**
     * PSU data loader.
     * @return ModelPSU ObservableList
     * @throws IOException
     */
    public ObservableList<ModelPSU> psuDataLoader() throws IOException {
        String line;
        ObservableList <ModelPSU> psuDataList = FXCollections.observableArrayList();
        psuDataList.clear();
        try {
            name = "psu.txt";
            File file = new File (path + name);
            InputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                String[]data = line.split(";");
                String psuIsModularString = data[9];
                Boolean psuIsModular = false;
                if (psuIsModularString.equals("true"))
                    psuIsModular = true;

                psuDataList.add(new ModelPSU(data[0], data[1], data[2], data[3], data[4], data[5],data[6],Double.parseDouble(data[7]),
                        Double.parseDouble(data[8]), psuIsModular, Integer.parseInt(data[10]), Integer.parseInt(data[11]), data[12], data[13]));
            }
            Comparator<ModelPSU> comparator = Comparator.comparingInt(ModelPSU::getPrice);
            FXCollections.sort(psuDataList, comparator.reversed());
        }
        catch (IOException e) {}
        return psuDataList;
    }

    /**
     * GPU data loader.
     * @return ModelGPU ObservableList
     * @throws IOException
     */
    public ObservableList<ModelGPU> gpuDataLoader() throws IOException {
        String line;
        ObservableList <ModelGPU> gpuDataList = FXCollections.observableArrayList();
        gpuDataList.clear();
        try {
            name = "gpu.txt";
            File file = new File (path + name);
            InputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                String[]data = line.split(";");
                String gpuIsCooledPassiveString = data[22];
                Boolean gpuIsCooledPassive = false;
                if (gpuIsCooledPassiveString.equals("true"))
                    gpuIsCooledPassive = true;
                String gpuHasBackplateString = data[23];
                Boolean gpuHasBackplate = false;
                if (gpuHasBackplateString.equals("true"))
                    gpuHasBackplate = true;

                gpuDataList.add(new ModelGPU(data[0], data[1], data[2], data[3], data[4], data[5], Double.parseDouble(data[6]),
                        Integer.parseInt(data[7]), data[8], Integer.parseInt(data[9]), data[10], Integer.parseInt(data[11]),
                        Integer.parseInt(data[12]), Double.parseDouble(data[13]), Integer.parseInt(data[14]), Integer.parseInt(data[15]),
                        Integer.parseInt(data[16]), Integer.parseInt(data[17]), Integer.parseInt(data[18]), Integer.parseInt(data[19]),
                        Integer.parseInt(data[20]), Integer.parseInt(data[21]), gpuIsCooledPassive, gpuHasBackplate, Integer.parseInt(data[24]), data[25], data[26]));
            }
            Comparator<ModelGPU> comparator = Comparator.comparingInt(ModelGPU::getPrice);
            FXCollections.sort(gpuDataList, comparator.reversed());
        }
        catch (IOException e) {}
        return gpuDataList;
    }


    /**
     * CPU data loader.
     * @return ModelCPU ObservableList
     * @throws IOException
     */
    public ObservableList<ModelCPU> cpuDataLoader() throws IOException {
        String line;
        ObservableList <ModelCPU> cpuDataList = FXCollections.observableArrayList();
        cpuDataList.clear();
        try {
            name = "cpu.txt";
            File file = new File (path + name);
            InputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                String[]data = line.split(";");
                boolean cpuIsUnlocked = false;
                String cpuIsUnlockedString = data[7];
                if (cpuIsUnlockedString.equals("true"))
                    cpuIsUnlocked = true;
                boolean cpuIsTheCpuCoolerIncluded = false;
                String cpuIsTheCpuCoolerIncludedString = data[15];
                if (cpuIsTheCpuCoolerIncludedString.equals("true"))
                    cpuIsTheCpuCoolerIncluded = true;

                cpuDataList.add(new ModelCPU(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]),
                        cpuIsUnlocked, Double.parseDouble(data[8]), Double.parseDouble(data[9]), Double.parseDouble(data[10]), Double.parseDouble(data[11]),
                        Integer.parseInt(data[12]), Integer.parseInt(data[13]), data[14],
                        cpuIsTheCpuCoolerIncluded, Integer.parseInt(data[16]), data[17], data[18]));
            }
            Comparator<ModelCPU> comparator = Comparator.comparingInt(ModelCPU::getPrice);
            FXCollections.sort(cpuDataList, comparator.reversed());
        }
        catch (IOException e) {}
        return cpuDataList;
    }


    /**
     * CPU Cooler data loader.
     * @return ModelCPUCooler ObservableList
     * @throws IOException
     */
    public ObservableList<ModelCPUCooler> cpuCoolerDataLoader() throws IOException {
        String line;
        ObservableList <ModelCPUCooler> cpuCoolerDataList = FXCollections.observableArrayList();
        cpuCoolerDataList.clear();
        try {
            name = "cpuCooler.txt";
            File file = new File (path + name);
            InputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                String[]data = line.split(";");

                cpuCoolerDataList.add(new ModelCPUCooler(data[0], data[1], data[2], data[3], data[4], Double.parseDouble(data[5]), Double.parseDouble(data[6]),
                        Double.parseDouble(data[7]), Integer.parseInt(data[8]), Double.parseDouble(data[9]), Integer.parseInt(data[10]), Integer.parseInt(data[11]),
                        Double.parseDouble(data[12]), Double.parseDouble(data[13]), Double.parseDouble(data[14]), Integer.parseInt(data[15]),
                        Integer.parseInt(data[16]), Integer.parseInt(data[17]), Integer.parseInt(data[18]), Integer.parseInt(data[19]),
                        data[20], Integer.parseInt(data[21]), data[22], data[23] ));
            }
            Comparator<ModelCPUCooler> comparator = Comparator.comparingInt(ModelCPUCooler::getPrice);
            FXCollections.sort(cpuCoolerDataList, comparator.reversed());
        }
        catch (IOException e) {}
        return cpuCoolerDataList;
    }

    /**
     * Case data loader.
     * @return ModelCase ObservableList
     * @throws IOException
     */
    public ObservableList<ModelCase> caseDataLoader() throws IOException {
        String line;
        ObservableList <ModelCase> caseDataList = FXCollections.observableArrayList();
        caseDataList.clear();
        try {
            name = "case.txt";
            File file = new File (path + name);
            InputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                String[]data = line.split(";");

                caseDataList.add(new ModelCase(data[0], data[1], data[2], data[3], data[4], data[5], Double.parseDouble(data[6]),
                        Double.parseDouble(data[7]), Double.parseDouble(data[8]), Double.parseDouble(data[9]), Double.parseDouble(data[10]), Integer.parseInt(data[11]),
                        Integer.parseInt(data[12]), Integer.parseInt(data[13]), Integer.parseInt(data[14]), Integer.parseInt(data[15]),
                        Integer.parseInt(data[16]), Integer.parseInt(data[17]), Integer.parseInt(data[18]), Integer.parseInt(data[19]),
                        Integer.parseInt(data[20]), Integer.parseInt(data[21]), Integer.parseInt(data[22]), Integer.parseInt(data[23]),
                        data[24], data[25]));
            }
            Comparator<ModelCase> comparator = Comparator.comparingInt(ModelCase::getPrice);
            FXCollections.sort(caseDataList, comparator.reversed());
        }
        catch (IOException e) {}
        return caseDataList;
    }

    /**
     * HDD data loader.
     * @return ModelHDD ObservableList
     * @throws IOException
     */
    public ObservableList<ModelHDD> hddDataLoader() throws IOException {
        String line;
        ObservableList <ModelHDD> hddDataList = FXCollections.observableArrayList();
        hddDataList.clear();
        try {
            name = "hdd.txt";
            File file = new File (path + name);
            InputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                String[]data = line.split(";");

                hddDataList.add(new ModelHDD(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6]),
                        Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]),
                        Integer.parseInt(data[10]), Integer.parseInt(data[11]), data[12], data[13]));
            }
            Comparator<ModelHDD> comparator = Comparator.comparingInt(ModelHDD::getPrice);
            FXCollections.sort(hddDataList, comparator.reversed());
        }
        catch (IOException e) {}
        return hddDataList;
    }

    /**
     * SSD data loader.
     * @return ModelSSD ObservableList
     * @throws IOException
     */
    public ObservableList<ModelSSD> ssdDataLoader() throws IOException {
        String line;
        ObservableList <ModelSSD> ssdDataList = FXCollections.observableArrayList();
        ssdDataList.clear();
        try {
            name = "ssd.txt";
            File file = new File (path + name);
            InputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                String[]data = line.split(";");
                boolean hasRadiator = false;
                if (data[14] == "true")
                    hasRadiator = true;

                ssdDataList.add(new ModelSSD(data[0], data[1], data[2], data[3], data[4], data[5], Integer.parseInt(data[6]),
                        Integer.parseInt(data[7]), Integer.parseInt(data[8]), data[9], Integer.parseInt(data[10]),
                        data[11], data[12], Integer.parseInt(data[13]), hasRadiator, Integer.parseInt(data[15]), data[16], data[17]));
            }
            Comparator<ModelSSD> comparator = Comparator.comparingInt(ModelSSD::getPrice);
            FXCollections.sort(ssdDataList, comparator.reversed());
        }
        catch (IOException e) {}
        return ssdDataList;
    }

    /**
     * RAM data loader.
     * @return ModelRAM ObservableList
     * @throws IOException
     */
    public ObservableList<ModelRAM> ramDataLoader() throws IOException {
        String line;
        ObservableList <ModelRAM> ramDataList = FXCollections.observableArrayList();
        ramDataList.clear();
        try {
            name = "ram.txt";
            File file = new File (path + name);
            InputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                String[]data = line.split(";");
                boolean hasRadiator = false;
                if (data[12] == "true")
                    hasRadiator = true;
                boolean hasLighting = false;
                if (data[13] == "true")
                    hasLighting = true;

                ramDataList.add(new ModelRAM(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]),
                        data[7], Integer.parseInt(data[8]), Integer.parseInt(data[9]), Double.parseDouble(data[10]), Integer.parseInt(data[11]),
                        hasRadiator, hasLighting, Integer.parseInt(data[14]), data[15], data[16]));
            }
            Comparator<ModelRAM> comparator = Comparator.comparingInt(ModelRAM::getPrice);
            FXCollections.sort(ramDataList, comparator.reversed());
        }
        catch (IOException e) {}
        return ramDataList;
    }

    /**
     * PSU data loader.
     * @return ModelPSU ObservableList
     * @throws IOException
     */
    public ObservableList<ModelMOBO> moboDataLoader() throws IOException {
        String line;
        ObservableList <ModelMOBO> moboDataList = FXCollections.observableArrayList();
        moboDataList.clear();
        try {
            name = "mobo.txt";
            File file = new File (path + name);
            InputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                String[]data = line.split(";");
                moboDataList.add(new ModelMOBO(data[0], data[1], data[2], data[3], data[4], data[5], data[6],Integer.parseInt(data[7]),Integer.parseInt(data[8]),
                        Integer.parseInt(data[9]), data[10], data[11], Integer.parseInt(data[12]), data[13], data[14]));
            }
            Comparator<ModelMOBO> comparator = Comparator.comparingInt(ModelMOBO::getPrice);
            FXCollections.sort(moboDataList, comparator.reversed());
        }
        catch (IOException e) {}
        return moboDataList;
    }
}
