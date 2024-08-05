package com.example.jsonData.convertor;

import com.example.jsonData.domain.AccessRequest;
import com.example.jsonData.dto.AccessRequestDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccessRequestDtoConvertor implements Converter<AccessRequestDto, AccessRequest> {

    @Override
    public AccessRequest convert(AccessRequestDto source) {
        return AccessRequest.Builder.accessRequest()
                .withId(null)
                .withEmailId(source.getEmailId())
                .withDepartment(source.getDepartment())
                .withSubDepartment(source.getSubDepartment())
                .withApprovingManager(source.getApprovingManager())
                .withSystemName(source.getSystemName())
                .withModules(source.getModules())
                .withDateCreated(null)
                .withStatus(null)
                .withIsDeleted(false)
                .withOtherInput(source.getOtherInput())
                .build();
    }

}
