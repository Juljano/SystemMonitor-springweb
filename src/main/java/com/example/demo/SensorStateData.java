package com.example.demo;

public class SensorStateData {

    private static String[] ip;
    private static String processorName;
    private static String diskName;
    private static long maxFrequency;
    private static String osName;
    private static String pcName;
    private static long storageSize;
    private static long usedStorage;
    private static long unusedStorage;
    private static long systemUpTime;
    private static long downloadSpeed;
    private static long uploadSpeed;
    private static String networkName;
    private static String[] dnsServer;
    private static long[] currentFrequency;


    public static long getMaxFrequency() {
        return maxFrequency;
    }

    public static void setMaxFrequency(long maxFrequency) {
        SensorStateData.maxFrequency = maxFrequency;
    }

    public static long[] getCurrentFrequency() {
        return currentFrequency;
    }

    public static void setCurrentFrequency(long[] currentFrequency) {
        SensorStateData.currentFrequency = currentFrequency;
    }

    public String[] getIp() {
        return ip;
    }

    public void setIp(String[] ip) {
        this.ip = ip;
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public String getDiskName() {
        return diskName;
    }

    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public static long getStorageSize() {
        return storageSize;
    }

    public static void setStorageSize(long storageSize) {
        SensorStateData.storageSize = storageSize;
    }

    public long getUsedStorage() {
        return usedStorage;
    }

    public void setUsedStorage(long usedStorage) {
        this.usedStorage = usedStorage;
    }

    public long getUnusedStorage() {
        return unusedStorage;
    }

    public void setUnusedStorage(long unusedStorage) {
        this.unusedStorage = unusedStorage;
    }

    public long getDownloadSpeed() {
        return downloadSpeed;
    }

    public void setDownloadSpeed(long downloadSpeed) {
        this.downloadSpeed = downloadSpeed;
    }

    public long getUploadSpeed() {
        return uploadSpeed;
    }

    public void setUploadSpeed(long uploadSpeed) {
        this.uploadSpeed = uploadSpeed;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String[] getDnsServer() {
        return dnsServer;
    }

    public void setDnsServer(String[] dnsServer) {
        this.dnsServer = dnsServer;
    }


    public long getSystemUpTime() {
        return systemUpTime;
    }

    public void setSystemUpTime(long systemUpTime) {
        this.systemUpTime = systemUpTime;
    }


}
