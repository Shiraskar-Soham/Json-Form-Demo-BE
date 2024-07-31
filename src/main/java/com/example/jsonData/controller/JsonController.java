package com.example.jsonData.controller;

import com.example.jsonData.enums.Systems;
import com.example.jsonData.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("api/v1/json")
public class JsonController {

    @Autowired
    private JsonService jsonService;

    @GetMapping("systems")
    @ResponseBody
    public Map<Systems, String> getAllSystems() {
        return jsonService.getAllSystems();
    }

    @GetMapping("modules")
    @ResponseBody
    public Set<String> getModules(@RequestParam Systems system) {
        return jsonService.getModules(system);
    }

}
