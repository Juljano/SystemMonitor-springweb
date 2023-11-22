package com.example.demo;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;
import oshi.software.os.OperatingSystem;

import java.util.Arrays;


public class SensorState {

    private final SensorStateData sensorStateData;
    private final SystemInfo systemInfo;


    public SensorState() {

        systemInfo = new SystemInfo();
        sensorStateData = new SensorStateData();
    }


    public void getHardwareState() {
        HardwareAbstractionLayer hardware = systemInfo.getHardware();

        // CPU-Informationen
        CentralProcessor centralProcessor = hardware.getProcessor();

        System.out.println("Prozessor: " + centralProcessor.getProcessorIdentifier().getName());

        sensorStateData.setProcessorName("HALLO");

        System.out.println("Anzahl der physischen Kerne: " + centralProcessor.getPhysicalProcessorCount());

        System.out.println("Anzahl der logischen Kerne: " + centralProcessor.getLogicalProcessorCount());

        System.out.println(centralProcessor.getMaxFreq() + " Hertz");

        sensorStateData.setMaxFrequency(centralProcessor.getMaxFreq());

        System.out.println(Arrays.toString(centralProcessor.getCurrentFreq()) + " Hertz");

        sensorStateData.setCurrentFrequency(centralProcessor.getCurrentFreq());

    }


    public void getOperationSystemInfo() {

        // Betriebssystem-Information
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();

        sensorStateData.setOsName(operatingSystem.toString());

        System.out.println("Betriebssystem: " + operatingSystem);

        long systemUpTimeinHours = operatingSystem.getSystemUptime() / 3600;

        sensorStateData.setSystemUpTime(systemUpTimeinHours);

        System.out.println(operatingSystem.getSystemUptime() / 3600 + " Stunden");

        System.out.println(operatingSystem.getNetworkParams().getHostName());

        sensorStateData.setPcName(operatingSystem.getNetworkParams().getHostName());

        sensorStateData.setDnsServer(operatingSystem.getNetworkParams().getDnsServers());


        if (operatingSystem.getNetworkParams().getDnsServers() != null) {

            System.out.println(Arrays.toString(operatingSystem.getNetworkParams().getDnsServers()));

        }

    }


    public void getDiskInfo() {

        //HardwareDisk-Information
        HWDiskStore[] stores = systemInfo.getHardware().getDiskStores().toArray(new HWDiskStore[0]);

        for (HWDiskStore diskStore : stores) {

            System.out.println("Festplatte: " + diskStore.getName());

            sensorStateData.setDiskName(diskStore.getName());

            System.out.println("Größe: " + convert(diskStore.getSize()));

            long storageSizeinTerabyte = (long) (diskStore.getSize() / Math.pow(1024, 2));


            SensorStateData.setStorageSize(storageSizeinTerabyte);


            System.out.println("Belegt: " + (diskStore.getWrites() / Math.pow(1024, 2)));

            long usedStorageinTerabyte = (long) (diskStore.getWrites() / Math.pow(1024, 2));

            sensorStateData.setUsedStorage(usedStorageinTerabyte);

            System.out.println("Verfügbar: " + diskStore.getReads() / Math.pow(1024, 2));

            long unusedStorageinTerabyte = (long) (diskStore.getWrites() / Math.pow(1024, 2));


            sensorStateData.setUnusedStorage(unusedStorageinTerabyte);


        }


    }


    public void getNetworkInfo() {

        //Network-Information
        HardwareAbstractionLayer hardware = systemInfo.getHardware();

        NetworkIF[] networkIFs = hardware.getNetworkIFs().toArray(new NetworkIF[0]);
        for (NetworkIF net : networkIFs) {
            System.out.println("Netzwerkschnittstelle: " + net.getName());

            sensorStateData.setNetworkName(net.getName());

            if (net.getIPv4addr() != null) {

                System.out.println("IP-Adresse: " + Arrays.toString(net.getIPv4addr()));
                sensorStateData.setIp(net.getIPv4addr());
            }


            System.out.println("Download: " + net.getSpeed() / Math.pow(1000, 2) + " MBps");
            sensorStateData.setDownloadSpeed(net.getSpeed());
            System.out.println("Upload: " + net.getSpeed() / Math.pow(1000, 2) / 8 + " MBps");
            sensorStateData.setUploadSpeed(net.getSpeed() / 8);
        }
    }


    //convert byte to TB
    private String convert(long bytes) {

        return bytes / Math.pow(1024, 4) + " Terabyte";

    }

}
