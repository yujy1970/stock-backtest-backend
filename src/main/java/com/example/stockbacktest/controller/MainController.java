package com.example.stockbacktest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "股票回溯策略分析系统 - 后端API服务");
        return "index";
    }


    @GetMapping("/status")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> status() {
        Map<String, Object> status = new HashMap<>();
        status.put("status", "UP");
        status.put("service", "股票回溯策略分析系统后端");
        status.put("timestamp", System.currentTimeMillis());
        status.put("version", "1.0.0");
        
        Runtime runtime = Runtime.getRuntime();
        Map<String, Object> system = new HashMap<>();
        system.put("javaVersion", System.getProperty("java.version"));
        system.put("totalMemory", runtime.totalMemory() / 1024 / 1024 + " MB");
        system.put("freeMemory", runtime.freeMemory() / 1024 / 1024 + " MB");
        system.put("maxMemory", runtime.maxMemory() / 1024 / 1024 + " MB");
        status.put("system", system);
        
        return ResponseEntity.ok(status);
    }

    @GetMapping("/api-test")
    public String apiTest() {
        return "api-test";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Test OK";
    }


}