package com.example.jsonData.controller;

import com.example.jsonData.enums.Systems;
import com.example.jsonData.service.JsonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/json")
public class JsonController {

    @Autowired
    private JsonService jsonService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("systems")
    @ResponseBody
    public Map<Systems, String> getAllSystems() {
        return jsonService.getAllSystems();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("modules")
    @ResponseBody
    public List<String> getModules(@RequestParam Systems system) {
        return jsonService.getModules(system);
    }

}
