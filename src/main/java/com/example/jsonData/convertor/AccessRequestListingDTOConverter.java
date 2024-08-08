package com.example.jsonData.convertor;

import com.example.jsonData.domain.AccessRequest;
import com.example.jsonData.dto.AccessRequestListingDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccessRequestListingDTOConverter implements Converter<AccessRequest, AccessRequestListingDto> {

    @Override
    public AccessRequestListingDto convert(AccessRequest source) {
        return AccessRequestListingDto.Builder.accessRequestListingDto()
                .withId(source.getId())
                .withEmployeeName(source.getEmployeeName())
                .withSubDepartment(source.getSubDepartment())
                .withCompanyName(source.getCompanyName())
                .withEmailId(source.getEmailId())
                .withApprovingManagerName(source.getManagerName())
                .withApprovalStatus(source.getApproveStatus())
                .withControlTowerStatus(source.getControlTowerStatus())
                .withDateCreated(source.getDateCreated())
                .withDateApproved(source.getDateApproved())
                .withDateCompleted(source.getDateCompleted())
                .withModules(source.getPermissionRequired())
                .withEmployeeCompany(source.getEmployeeCompany())
                .withRequestRemarks(source.getRequestRemarks())
                .withApproveRemarks(source.getApproveRemarks())
                .withReviewRemarks(source.getReviewRemarks())
                .build();
    }

}
