package com.example.jsonData.service;

import com.example.jsonData.convertor.AccessRequestDtoConvertor;
import com.example.jsonData.domain.AccessRequest;
import com.example.jsonData.dto.AccessRequestDto;
import com.example.jsonData.enums.Status;
import com.example.jsonData.repository.AccessRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class AccessRequestService {

    @Autowired
    private AccessRequestRepo accessRequestRepo;

    @Autowired
    private AccessRequestDtoConvertor accessRequestDtoConvertor;

    public Long addRequest(AccessRequestDto accessRequestDto) throws Exception {
            if(ObjectUtils.isEmpty(accessRequestDto)){
                throw new Exception("Access Request Not valid");
            }
            AccessRequest accessRequest = accessRequestDtoConvertor.convert(accessRequestDto);
            accessRequest.setStatus(Status.PENDING);
            accessRequest.setDateCreated(System.currentTimeMillis());
            accessRequestRepo.save(accessRequest);
            return accessRequest.getId();
    }

    public List<AccessRequest> getAll() {
        return accessRequestRepo.findAll();
    }
}
