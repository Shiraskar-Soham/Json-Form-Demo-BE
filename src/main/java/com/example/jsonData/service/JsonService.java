package com.example.jsonData.service;

import com.example.jsonData.enums.Systems;
import java.util.List;

import com.example.jsonData.repository.SysModuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JsonService {

    @Autowired
    private SysModuleRepo sysModuleRepo;

    public Map<Systems, String> getAllSystems() {
        return Systems.getAll();
    }

    public List<String> getModules(Systems system) {
        return system.getModules();
    }
}
