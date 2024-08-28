package com.example.jsonData.dto;

import com.example.jsonData.enums.Systems;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessRequestDto {

    private String approvingManager;

    private String company;

    private Map<Systems, List<String>> modules;

    private String remarks;
}
