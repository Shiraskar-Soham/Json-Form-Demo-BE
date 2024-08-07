package com.example.jsonData.convertor;

import com.example.jsonData.domain.AccessRequest;
import com.example.jsonData.dto.AccessRequestDto;
import com.example.jsonData.enums.Company;
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
                .withStatus(null)
                .withIsDeleted(false)
                .withRemarks(source.getRemarks())
                .build();
    }

}
