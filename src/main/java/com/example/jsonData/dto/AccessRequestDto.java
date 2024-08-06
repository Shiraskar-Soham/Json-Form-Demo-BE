package com.example.jsonData.dto;

import com.example.jsonData.enums.Systems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessRequestDto {

    private String emailId;
    private String department;
    private String subDepartment;
    private String approvingManager;
    private String companyName;
    private Systems systemName;
    private List<String> modules;
    private String otherInput;
}
