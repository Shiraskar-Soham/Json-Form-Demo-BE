package com.example.jsonData.service;

import com.example.jsonData.enums.Systems;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class JsonService {

    public Map<Systems, String> getAllSystems() {
        return Systems.getAll();
    }

    public Set<String> getModules(Systems system) {
        return new HashSet<>();
    }
}
