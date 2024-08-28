package com.example.jsonData.convertor;

import com.example.jsonData.domain.AccessRequest;
import com.example.jsonData.dto.AccessRequestDto;
import com.example.jsonData.enums.Company;
import com.example.jsonData.enums.Status;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccessRequestDtoConvertor implements Converter<AccessRequestDto, AccessRequest> {

    @Override
    public AccessRequest convert(AccessRequestDto source) {
        return AccessRequest.Builder.accessRequest()
            .withId(null)
            .withEmailId("soham.shiraskar@ofbusiness.in")
            .withDepartment("Technology")
            .withSubDepartment("Development")
            .withApprovingManager(source.getApprovingManager())
            .withCompanyName(Company.valueOf(source.getCompany()))
            .withPermissionRequired(source.getModules())
            .withDateCreated(null)
            .withApproveStatus(Status.PENDING)
            .withIsDeleted(false)
            .withRequestRemarks(source.getRemarks())
            .withEmployeeName(getEmployeeName("soham.shiraskar@ofbusiness.in"))
            .withManagerName(getManagerName("soham.shiraskar@ofbusiness.in"))
            .withControlTowerStatus(Status.PENDING)
            .withDateApproved(null)
            .withDateCompleted(null)
            .withEmployeeCompany(getCompanyName("soham.shiraskar@ofbusiness.in"))
            .withApproveRemarks(null)
            .withReviewRemarks(null)
            .build();
    }

    private String getEmployeeName(String emailId) {
        return "Soham";
    }

    private String getManagerName(String emailId) {
        return "Bhuvan";
    }

    private Company getCompanyName(String emailId) {
        return Company.OFBUSINESS;
    }
}
