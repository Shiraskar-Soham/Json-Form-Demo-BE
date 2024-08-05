package com.example.jsonData.service;

import com.example.jsonData.domain.SystemModule;

import com.example.jsonData.enums.Systems;
import java.util.HashMap;
import java.util.List;

import com.example.jsonData.repository.SysModuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Map;
import java.util.Objects;

@Service
public class JsonService {

    @Autowired
    private SysModuleRepo sysModuleRepo;

    public Map<String, String> getAllSystemNames() {
        List<Object[]> result = sysModuleRepo.getAllSystemNames();
        Map<String, String> ans = new HashMap<>();
        result.forEach(entry -> {
            ans.put((String) entry[0], (String) entry[1]);
        });
        return ans;
    }

    public List<String> getModules(Systems system_name) {
        return sysModuleRepo.getModules(system_name.name());
    }

    public void addModules(SystemModule systemModule) {
        sysModuleRepo.save(systemModule);
        systemModule.setDeleted(false);
    }

    public void deleteModule(String system_name, String module) throws Exception{
        if(ObjectUtils.isEmpty(system_name)||ObjectUtils.isEmpty(module)){
            throw new Exception("Module or System Name cannot be empty");
        }
        SystemModule systemModule = sysModuleRepo.findModule(system_name, module);

        if(ObjectUtils.isEmpty(systemModule)){
            throw new Exception("No such module present");
        }

        if(systemModule.isDeleted()){
            throw new Exception("This module is already deleted");
        }
        systemModule.setDeleted(true);
        sysModuleRepo.save(systemModule);
    }

    public Map<String, String> getRMS(String emailID, String approvingManager) {

//        Map<String, String> map = new HashMap<>();
//        map.put("department", getDepartment(emailID));
//        map.put("subDepartment", getSubDepartment(emailID));
//        if(approvingManager=="L2 Manager") map.put("reportingManager", getManager(getManager(emailID)));
//        else map.put("reportingManager", getManager(emailID));


        Map<String, String> map = new HashMap<>();
        map.put("department", "Tech");
        map.put("subDepartment", "Development");
        map.put("reportingManager", "bhuvan@ofbusiness.in");

        Map<String, String> map2 = new HashMap<>();
        map2.put("department", "Tech");
        map2.put("subDepartment", "Development");
        map2.put("reportingManager", "ashish@ofbusiness.in");
        if(Objects.equals(approvingManager, "L2 Manager")){
            return map2;
        }
        else return map;
    }
}
