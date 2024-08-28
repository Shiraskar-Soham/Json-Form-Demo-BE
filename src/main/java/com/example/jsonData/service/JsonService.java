package com.example.jsonData.service;

import com.example.jsonData.domain.SystemModule;
import com.example.jsonData.enums.Company;
import com.example.jsonData.enums.Systems;
import com.example.jsonData.repository.SysModuleRepo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonService {

    @Autowired
    private SysModuleRepo sysModuleRepo;

    public Map<String, String> getAllCompanySystemNames(Company company_name) {
        List<Object[]> result = sysModuleRepo.getAllSystemNames(company_name.name());
        Map<String, String> resultMap = new HashMap<>();
        result.forEach(entry -> {
            resultMap.put((String) entry[0], (String) entry[1]);
        });
        return resultMap;
    }

    public Map<String, String> getAllCompanies() {
        List<Object[]> result = sysModuleRepo.getAllCompany();
        Map<String, String> comps = new HashMap<>();
        result.forEach(entry -> {
            comps.put((String) entry[0], (String) entry[1]);
        });
        return comps;
    }

    public List<String> getModules(Company company_name, Systems system_name) {
        return sysModuleRepo.getModules(company_name.name(), system_name.name());
    }

    public void addModules(SystemModule systemModule) {
        sysModuleRepo.save(systemModule);
        systemModule.setDeleted(false);
    }

    public List<String> getAllManagers() {
        return List.of("bhuvan@ofbusiness.in", "ashish@ofbusiness.in",
            "bhuvan.gupta@ofbusiness.in");
    }
}
