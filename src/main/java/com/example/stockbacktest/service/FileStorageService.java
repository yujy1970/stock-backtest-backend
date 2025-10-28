package com.example.stockbacktest.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {
    
    @Value("${file.upload.cn-dir}")
    private String cnDir;
    
    @Value("${file.upload.us-dir}")
    private String usDir;
    
    @Value("${file.upload.hk-dir}")
    private String hkDir;
    
    public void init() {
        try {
            Files.createDirectories(Paths.get(cnDir));
            Files.createDirectories(Paths.get(usDir));
            Files.createDirectories(Paths.get(hkDir));
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directories!");
        }
    }
    
    public String storeFile(MultipartFile file, String market, String fileName) {
        try {
            String dir = getMarketDirectory(market);
            Path targetLocation = Paths.get(dir).resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName, ex);
        }
    }
    
    private String getMarketDirectory(String market) {
        switch (market.toLowerCase()) {
            case "cn": return cnDir;
            case "us": return usDir;
            case "hk": return hkDir;
            default: throw new IllegalArgumentException("Invalid market: " + market);
        }
    }
    
    public Path loadFile(String market, String filename) {
        String dir = getMarketDirectory(market);
        return Paths.get(dir).resolve(filename);
    }
    
    public boolean fileExists(String market, String filename) {
        Path file = loadFile(market, filename);
        return Files.exists(file);
    }
}