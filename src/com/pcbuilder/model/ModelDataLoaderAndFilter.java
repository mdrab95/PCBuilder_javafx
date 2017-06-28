package com.pcbuilder.model;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Comparator;

/**
 * Data loader class.
 */
public class ModelDataLoaderAndFilter {

    String path = "src/com/pcbuilder/files/"; // default path to 'files' directory
    String name;
    ObservableList <ModelCPU> cpuList = FXCollections.observableArrayList();
    ObservableList <ModelCPUCooler> cpuCoolerList = FXCollections.observableArrayList();
    ObservableList <ModelMOBO> moboList = FXCollections.observableArrayList();
    ObservableList <ModelGPU> gpuList = FXCollections.observableArrayList();
    ObservableList <ModelRAM> ramList = FXCollections.observableArrayList();
    ObservableList <ModelHDD> hddList = FXCollections.observableArrayList();
    ObservableList <ModelSSD> ssdList = FXCollections.observableArrayList();
    ObservableList<ModelPSU> psuList = FXCollections.observableArrayList();
    ObservableList <ModelCase> caseList = FXCollections.observableArrayList();

    /**
     * PSU data loader.
     * @return ModelPSU ObservableList
     * @throws IOException
     */
    public ObservableList<ModelPSU> psuDataLoader() throws IOException {
        String line;
        psuList.clear();
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

                psuList.add(new ModelPSU(data[0], data[1], data[2], data[3], data[4], data[5],data[6],Double.parseDouble(data[7]),
                        Double.parseDouble(data[8]), psuIsModular, Integer.parseInt(data[10]), Integer.parseInt(data[11]), data[12], data[13]));
            }
            Comparator<ModelPSU> comparator = Comparator.comparingInt(ModelPSU::getPrice);
            FXCollections.sort(psuList, comparator.reversed());
        }
        catch (IOException e) {}
        return psuList;
    }

    /**
     * GPU data loader.
     * @return ModelGPU ObservableList
     * @throws IOException
     */
    public ObservableList<ModelGPU> gpuDataLoader() throws IOException {
        String line;
        gpuList.clear();
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

                gpuList.add(new ModelGPU(data[0], data[1], data[2], data[3], data[4], data[5], Double.parseDouble(data[6]),
                        Integer.parseInt(data[7]), data[8], Integer.parseInt(data[9]), data[10], Integer.parseInt(data[11]),
                        Integer.parseInt(data[12]), Double.parseDouble(data[13]), Integer.parseInt(data[14]), Integer.parseInt(data[15]),
                        Integer.parseInt(data[16]), Integer.parseInt(data[17]), Integer.parseInt(data[18]), Integer.parseInt(data[19]),
                        Integer.parseInt(data[20]), Integer.parseInt(data[21]), gpuIsCooledPassive, gpuHasBackplate, Integer.parseInt(data[24]), data[25], data[26]));
            }
            Comparator<ModelGPU> comparator = Comparator.comparingInt(ModelGPU::getPrice);
            FXCollections.sort(gpuList, comparator.reversed());
        }
        catch (IOException e) {}
        return gpuList;
    }


    /**
     * CPU data loader.
     * @return ModelCPU ObservableList
     * @throws IOException
     */
    public ObservableList<ModelCPU> cpuDataLoader() throws IOException {
        String line;
        cpuList.clear();
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
                boolean cpuHasIntegratedGraphicCard = false;
                String cpuHasIntegratedGraphicCardString = data[8];
                if (cpuHasIntegratedGraphicCardString.equals("true"))
                    cpuHasIntegratedGraphicCard = true;
                boolean cpuIsTheCpuCoolerIncluded = false;
                String cpuIsTheCpuCoolerIncludedString = data[16];
                if (cpuIsTheCpuCoolerIncludedString.equals("true"))
                    cpuIsTheCpuCoolerIncluded = true;
                try {
                    cpuList.add(new ModelCPU(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]),
                            cpuIsUnlocked, cpuHasIntegratedGraphicCard, Double.parseDouble(data[9]), Double.parseDouble(data[10]), Double.parseDouble(data[11]), Double.parseDouble(data[12]),
                            Integer.parseInt(data[13]), Integer.parseInt(data[14]), data[15],
                            cpuIsTheCpuCoolerIncluded, Integer.parseInt(data[17]), data[18], data[19]));
                } catch (Exception ex) { System.out.println("Bad cpu data: " + line);}
            }
            Comparator<ModelCPU> comparator = Comparator.comparingInt(ModelCPU::getPrice);
            FXCollections.sort(cpuList, comparator.reversed());
            System.out.println("CPU data loaded.");
        }
        catch (IOException e) {}
        return cpuList;
    }


    /**
     * CPU Cooler data loader.
     * @return ModelCPUCooler ObservableList
     * @throws IOException
     */
    public ObservableList<ModelCPUCooler> cpuCoolerDataLoader() throws IOException {
        String line;
        cpuCoolerList.clear();
        try {
            name = "cpuCooler.txt";
            File file = new File (path + name);
            InputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                String[]data = line.split(";");
                try {
                    cpuCoolerList.add(new ModelCPUCooler(data[0], data[1], data[2], data[3], data[4], Double.parseDouble(data[5]), Double.parseDouble(data[6]),
                            Double.parseDouble(data[7]), Integer.parseInt(data[8]), Double.parseDouble(data[9]), Integer.parseInt(data[10]), Integer.parseInt(data[11]),
                            Double.parseDouble(data[12]), Double.parseDouble(data[13]), Double.parseDouble(data[14]), Integer.parseInt(data[15]),
                            Integer.parseInt(data[16]), Integer.parseInt(data[17]), Integer.parseInt(data[18]), Integer.parseInt(data[19]),
                            data[20], Integer.parseInt(data[21]), data[22], data[23]));
                } catch (Exception ex) { System.out.println("Bad cpu cooler data: " + line);}
            }
            Comparator<ModelCPUCooler> comparator = Comparator.comparingInt(ModelCPUCooler::getPrice);
            FXCollections.sort(cpuCoolerList, comparator.reversed());
            System.out.println("CPU Cooler data loaded.");
        }
        catch (IOException e) {}
        return cpuCoolerList;
    }

    /**
     * Case data loader.
     * @return ModelCase ObservableList
     * @throws IOException
     */
    public ObservableList<ModelCase> caseDataLoader() throws IOException {
        String line;
        caseList.clear();
        try {
            name = "case.txt";
            File file = new File (path + name);
            InputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                String[]data = line.split(";");
                try {
                caseList.add(new ModelCase(data[0], data[1], data[2], data[3], data[4], data[5], Double.parseDouble(data[6]),
                        Double.parseDouble(data[7]), Double.parseDouble(data[8]), Double.parseDouble(data[9]), Double.parseDouble(data[10]), Integer.parseInt(data[11]),
                        Integer.parseInt(data[12]), Integer.parseInt(data[13]), Integer.parseInt(data[14]), Integer.parseInt(data[15]),
                        Integer.parseInt(data[16]), Integer.parseInt(data[17]), Integer.parseInt(data[18]), Integer.parseInt(data[19]),
                        Integer.parseInt(data[20]), Integer.parseInt(data[21]), Integer.parseInt(data[22]), Integer.parseInt(data[23]),
                        data[24], data[25]));
                } catch (Exception ex) { System.out.println("Bad case data: " + line);}
            }
            Comparator<ModelCase> comparator = Comparator.comparingInt(ModelCase::getPrice);
            FXCollections.sort(caseList, comparator.reversed());
            System.out.println("Case data loaded.");
        }
        catch (IOException e) {}
        return caseList;
    }

    /**
     * HDD data loader.
     * @return ModelHDD ObservableList
     * @throws IOException
     */
    public ObservableList<ModelHDD> hddDataLoader() throws IOException {
        String line;
        hddList.clear();
        try {
            name = "hdd.txt";
            File file = new File (path + name);
            InputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                String[]data = line.split(";");
                try {
                hddList.add(new ModelHDD(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6]),
                        Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]),
                        Integer.parseInt(data[10]), Integer.parseInt(data[11]), data[12], data[13]));
                } catch (Exception ex) { System.out.println("Bad hdd data: " + line);}
            }
            Comparator<ModelHDD> comparator = Comparator.comparingInt(ModelHDD::getPrice);
            FXCollections.sort(hddList, comparator.reversed());
            System.out.println("HDD data loaded.");
        }
        catch (IOException e) {}
        return hddList;
    }

    /**
     * SSD data loader.
     * @return ModelSSD ObservableList
     * @throws IOException
     */
    public ObservableList<ModelSSD> ssdDataLoader() throws IOException {
        String line;
        ssdList.clear();
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
                try {
                ssdList.add(new ModelSSD(data[0], data[1], data[2], data[3], data[4], data[5], Integer.parseInt(data[6]),
                        Integer.parseInt(data[7]), Integer.parseInt(data[8]), data[9], Integer.parseInt(data[10]),
                        data[11], data[12], Integer.parseInt(data[13]), hasRadiator, Integer.parseInt(data[15]), data[16], data[17]));
                } catch (Exception ex) { System.out.println("Bad ssd data: " + line);}
            }
            Comparator<ModelSSD> comparator = Comparator.comparingInt(ModelSSD::getPrice);
            FXCollections.sort(ssdList, comparator.reversed());
            System.out.println("SSD data loaded.");
        }
        catch (IOException e) {}
        return ssdList;
    }

    /**
     * RAM data loader.
     * @return ModelRAM ObservableList
     * @throws IOException
     */
    public ObservableList<ModelRAM> ramDataLoader() throws IOException {
        String line;
        ObservableList <ModelRAM> ramList = FXCollections.observableArrayList();
        ramList.clear();
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
                try {
                ramList.add(new ModelRAM(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]),
                        data[7], Integer.parseInt(data[8]), Integer.parseInt(data[9]), Double.parseDouble(data[10]), Integer.parseInt(data[11]),
                        hasRadiator, hasLighting, Integer.parseInt(data[14]), data[15], data[16]));
                } catch (Exception ex) { System.out.println("Bad ram data: " + line);}
            }
            Comparator<ModelRAM> comparator = Comparator.comparingInt(ModelRAM::getPrice);
            FXCollections.sort(ramList, comparator.reversed());
            System.out.println("RAM data loaded.");
        }
        catch (IOException e) {}
        return ramList;
    }

    /**
     * PSU data loader.
     * @return ModelPSU ObservableList
     * @throws IOException
     */
    public ObservableList<ModelMOBO> moboDataLoader() throws IOException {
        String line;
        moboList.clear();
        try {
            name = "mobo.txt";
            File file = new File (path + name);
            InputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                String[]data = line.split(";");
                try {
                moboList.add(new ModelMOBO(data[0], data[1], data[2], data[3], data[4], data[5], data[6],Integer.parseInt(data[7]),Integer.parseInt(data[8]),
                        Integer.parseInt(data[9]), data[10], data[11], Integer.parseInt(data[12]), data[13], data[14]));
                } catch (Exception ex) { System.out.println("Bad mobo data: " + line);}
            }
            Comparator<ModelMOBO> comparator = Comparator.comparingInt(ModelMOBO::getPrice);
            FXCollections.sort(moboList, comparator.reversed());
            System.out.println("MOBO data loaded.");
        }
        catch (IOException e) {}
        return moboList;
    }

    ObservableList cpuCoolerNames = FXCollections.observableArrayList();
    ObservableList moboNames = FXCollections.observableArrayList();
    ObservableList gpuNames = FXCollections.observableArrayList();
    ObservableList cpuNames = FXCollections.observableArrayList();
    ObservableList ramNames = FXCollections.observableArrayList();
    ObservableList ssdNames = FXCollections.observableArrayList();
    ObservableList hddNames = FXCollections.observableArrayList();
    ObservableList psuNames = FXCollections.observableArrayList();
    ObservableList caseNames = FXCollections.observableArrayList();

    /**
     * This function creates cpu cooler names list based on selected CPU.
     * @param selectedCpu selectedCpu
     * @return cpu cooler names list
     */
    public ObservableList getCpuCoolerNames (ModelCPU selectedCpu, ObservableList<ModelCPUCooler> cpuCoolerList) {
        if (selectedCpu.getBoxCooler() == true) {
            cpuCoolerNames.add("BOX Cooler");
        }
        for (int i = 0; i < cpuCoolerList.size(); i++) {
            String cpuCoolerName = cpuCoolerList.get(i).getBrand() + " " + cpuCoolerList.get(i).getName();
            String sockets = cpuCoolerList.get(i).getSockets();
            if (sockets.contains(selectedCpu.getSocket())) {
                cpuCoolerNames.add(cpuCoolerName);
            }
        }
        return cpuCoolerNames;
    }

    /**
     * This function clears cpu cooler names list.
     * @return cpu cooler names list
     */
    public void clearCpuCoolerNames () {
        cpuCoolerNames.clear();
    }

    /**
     * This function creates mobo names list based on selected CPU.
     * @param selectedCpu selected cpu
     * @param selectedCpuCooler selected cpu cooler
     * @return
     */
    public ObservableList getMoboNames (ModelCPU selectedCpu, ModelCPUCooler selectedCpuCooler, ObservableList<ModelMOBO> moboList) {
        if (selectedCpu.getBoxCooler() == false && selectedCpuCooler != null || selectedCpu.getBoxCooler() == true && selectedCpuCooler != null || selectedCpu.getBoxCooler() == true && selectedCpuCooler == null) {
            moboNames.clear();
            for (int i = 0; i < moboList.size(); i++) {
                String moboName = moboList.get(i).getBrand() + " " + moboList.get(i).getChipset() + " " + moboList.get(i).getName();
                if (moboList.get(i).getSocket().equals(selectedCpu.getSocket())) {
                    moboNames.add(moboName);
                }
            }
        }
        return moboNames;
    }

    /**
     * This function clears mobo names list
     * @return mobo names list
     */
    public void clearMoboNames () {
        moboNames.clear();
    }

    /**
     * This function creates gpu names list based on selected CPU.
     * @param selectedCpu selected CPU
     * @return gpu names list
     */
    public ObservableList getGpuNames (ModelCPU selectedCpu, ObservableList<ModelGPU> gpuList){
        gpuNames.clear();
        if (selectedCpu.getHasIntegratedGraphic() == true) {
            gpuNames.add("CPU Integrated graphic card");
        }
        for (int i = 0; i < gpuList.size(); i++) {
            String gpuName = gpuList.get(i).getChipManufacturer() + " " + gpuList.get(i).getseries() + " " + gpuList.get(i).getName();
            gpuNames.add(gpuName);
        }
        return gpuNames;
    }

    /**
     * This function clears gpu names list
     * @return gpu names list
     */
    public void clearGpuNames () {
        gpuNames.clear();
    }

    /**
     * This function creates ram names list based on selected mobo.
     * @param selectedMobo selected motherboard
     * @return
     */
    public ObservableList getRamNames(ModelMOBO selectedMobo, ObservableList<ModelRAM> ramList){
        ramNames.clear();
        for (int i = 0; i < ramList.size(); i++) {
            if (selectedMobo.getRamStandard().equals(ramList.get(i).getStandard())) {
                if (selectedMobo.getChipset().equals("Z270") || selectedMobo.getChipset().equals("Z170")) {
                    String ramName = ramList.get(i).getBrand() + " " + ramList.get(i).getName() + " " + ramList.get(i).getMemorySize() + "GB (" + ramList.get(i).getNumberOfModules() + "x" + ramList.get(i).getSingleModuleSize() + "GB) " + ramList.get(i).getStandard() + " " + ramList.get(i).getMemoryClock() + "MHz (" + ramList.get(i).getSerialNumber() + ")";
                    ramNames.add(ramName);
                } else {
                    if (ramList.get(i).getMemoryClock() <= 2400) {
                        String ramName = ramList.get(i).getBrand() + " " + ramList.get(i).getName() + " " + ramList.get(i).getMemorySize() + "GB (" + ramList.get(i).getNumberOfModules() + "x" + ramList.get(i).getSingleModuleSize() + "GB) " + ramList.get(i).getStandard() + " " + ramList.get(i).getMemoryClock() + "MHz (" + ramList.get(i).getSerialNumber() + ")";
                        ramNames.add(ramName);
                    }
                }
            }
        }
        return ramNames;
    }

    /**
     * This function clears ram names list
     * @return ram names list
     */
    public void clearRamNames () {
        ramNames.clear();
    }

    /**
     * This function creates ssd names list based on selected mobo.
     * @param selectedMobo selected motherboard
     * @return ssd names list
     */
    public ObservableList getSsdNames(ModelMOBO selectedMobo, ObservableList<ModelSSD> ssdList){
        ssdNames.clear();
        ssdNames.add("Select nothing");
        for (int i = 0; i < ssdList.size(); i++) {
            if (selectedMobo.getConnectors().contains("M.2")) {
                String ssdName = ssdList.get(i).getBrand() + " " + ssdList.get(i).getName() + " " + ssdList.get(i).getCapacity() + "GB (" + ssdList.get(i).getSerialNumber() + ")";
                ssdNames.add(ssdName);
            } else {
                String formFactor = ssdList.get(i).getFormFactor();
                if (formFactor.contains("M.2") == false){
                    String ssdName = ssdList.get(i).getBrand() + " " + ssdList.get(i).getName() + " " + ssdList.get(i).getCapacity() + "GB (" + ssdList.get(i).getSerialNumber() + ")";
                    ssdNames.add(ssdName);
                }
            }
        }
        return ssdNames;
    }

    /**
     * This function clears ssd names list
     * @return ssd names list
     */
    public void clearSsdNames () {
        ssdNames.clear();
    }

    /**
     * This function creates hdd names list based on selected ssd
     * @param selectedSsd selected ssd
     * @return hdd names list
     */
    public ObservableList getHddNames (ModelSSD selectedSsd, ObservableList<ModelHDD> hddList) {
        hddNames.clear();
        if (selectedSsd != null) {
            hddNames.add("Select nothing");
        }
        for (int i = 0; i < hddList.size(); i++) {
            String capacity = "";
            if (hddList.get(i).getCapacity() >= 1000)
                capacity = String.valueOf(hddList.get(i).getCapacity()/1000) + "TB";
            else
                capacity = hddList.get(i).getCapacity() + "GB";
            String hddName = hddList.get(i).getBrand() + " " + hddList.get(i).getName() + " " + capacity;
            hddNames.add(hddName);
        }
        return hddNames;
    }

    /**
     * This function clears hdd names list
     * @return hdd names list
     */
    public void clearHddNames () {
        hddNames.clear();
    }

    /**
     * This function creates psu names list based on max load
     * @param maxLoad max load (max wattage)
     * @return psu names list
     */
    public ObservableList getPsuNames (double maxLoad, ObservableList<ModelPSU> psuList) {
        double minimalPsu = 1.2*maxLoad;
        psuNames.clear();
        for (int i = 0; i < psuList.size(); i++) {
            if(psuList.get(i).getWattage() >= minimalPsu) {
                String psuName = psuList.get(i).getBrand() + " " + psuList.get(i).getName() + " " + psuList.get(i).getWattage() + "W";
                psuNames.add(psuName);
            }
        }
        return psuNames;
    }

    /**
     * This function clears psu names list
     * @return psu names list
     */
    public void clearPsuNames () {
        psuNames.clear();
    }

    /**
     * This function creates case names list based on form factor of selected mobo
     * @param selectedMobo selected mobo
     * @return case names list
     */
    public ObservableList getCaseNames (ModelMOBO selectedMobo, ObservableList<ModelCase> caseList) {
        caseNames.clear();
        for (int i = 0; i < caseList.size(); i++) {
            if (caseList.get(i).getFormFactor().contains(selectedMobo.getFormFactor())){
                String caseName = caseList.get(i).getBrand() + " " + caseList.get(i).getName();
                caseNames.add(caseName);
            }
        }
        return caseNames;
    }
}
