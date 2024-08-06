package com.example.jsonData.controller;

import com.example.jsonData.domain.SystemModule;
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
    @GetMapping("company")
    @ResponseBody
    public Map<String, String> getAllCompanies(){
        return jsonService.getAllCompanies();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("systems")
    @ResponseBody
    public Map<String, String> getAllSystems() {
        return jsonService.getAllSystemNames();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("modules")
    @ResponseBody
    public List<String> getModules(@RequestParam Systems system_name) {
        return jsonService.getModules(system_name);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("createEntry")
    public void addModule(@RequestBody SystemModule systemModule){
        jsonService.addModules(systemModule);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping ("getRMS")
    public Map<String, String> getRMS(@RequestParam String emailID, @RequestParam String approvingManager) {
        return jsonService.getRMS(emailID, approvingManager);
    }

    @PostMapping("deleteModule")
    public void deleteModule(@RequestParam String system_name, @RequestParam String module) throws Exception {
        jsonService.deleteModule(system_name, module);
    }

}




