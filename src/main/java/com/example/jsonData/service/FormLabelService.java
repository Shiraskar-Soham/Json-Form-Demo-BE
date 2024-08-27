package com.example.jsonData.service;

import com.example.jsonData.repository.FormLabelRepo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormLabelService {

    @Autowired
    private FormLabelRepo formLabelRepository;

    public Map<String, String> getAllLabels() {
        List<Object[]> results = formLabelRepository.findAllLabels();
        Map<String, String> labelsMap = new HashMap<>();
        for (Object[] result : results) {
            labelsMap.put((String) result[0], (String) result[1]);
        }
        return labelsMap;
    }
}
