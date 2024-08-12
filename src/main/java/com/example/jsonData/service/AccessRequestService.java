package com.example.jsonData.service;

import com.example.jsonData.convertor.AccessRequestDtoConvertor;
import com.example.jsonData.convertor.AccessRequestListingDTOConverter;
import com.example.jsonData.domain.AccessRequest;
import com.example.jsonData.dto.AccessRequestDto;
import com.example.jsonData.dto.AccessRequestListingDto;
import com.example.jsonData.enums.Status;
import com.example.jsonData.enums.Systems;
import com.example.jsonData.exceptions.CustomException;
import com.example.jsonData.repository.AccessRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AccessRequestService {

    @Autowired
    private AccessRequestRepo accessRequestRepo;

    @Autowired
    private AccessRequestListingDTOConverter accessRequestListingDTOConverter;

    @Autowired
    private AccessRequestDtoConvertor accessRequestDtoConvertor;

    public Long addRequest(AccessRequestDto accessRequestDto) throws CustomException {
        if (ObjectUtils.isEmpty(accessRequestDto)) {
            throw new CustomException("Access Request Not valid");
        }
        Map<Systems, List<String>> systemsListMap = accessRequestDto.getModules();
        if (ObjectUtils.isEmpty(systemsListMap)) {
            throw new CustomException("Modules can not be empty");
        }
        boolean allListsEmpty = systemsListMap.values().stream().allMatch(List::isEmpty);
        if (allListsEmpty) {
            throw new CustomException("All module lists cannot be empty");
        }

        AccessRequest accessRequest = accessRequestDtoConvertor.convert(accessRequestDto);
        accessRequest.setApproveStatus(Status.PENDING);
        accessRequest.setDateCreated(System.currentTimeMillis());
        accessRequestRepo.save(accessRequest);
        return accessRequest.getId();
    }

    public List<AccessRequest> getAll() {
        return accessRequestRepo.findAll();
    }

    public List<AccessRequestListingDto> getAllListing() {
        List<AccessRequest> e = accessRequestRepo.findAll();
        List<AccessRequestListingDto> convertedList = new ArrayList<>();

        for (AccessRequest accessRequest : e) {
            AccessRequestListingDto dto = accessRequestListingDTOConverter.convert(accessRequest);
            convertedList.add(dto);
        }
        return convertedList;
    }

    public AccessRequestListingDto managerApproval(Long id, Status action, String remarks) throws Exception {
        if(ObjectUtils.isEmpty(id)){
            throw new Exception("id cannot be empty");
        }
        AccessRequest accessRequest = accessRequestRepo.findByAccessRequestId(id);
        if(ObjectUtils.isEmpty(accessRequest)) {
            throw new Exception("No access request found");
        }


        if(accessRequest.getApproveStatus()!=Status.PENDING){
            throw new Exception("This request is already approved/rejected");
        }
        accessRequest.setApproveStatus(action);
        accessRequest.setApproveRemarks(remarks);
        accessRequest.setDateApproved(System.currentTimeMillis());
        accessRequestRepo.save(accessRequest);
        return accessRequestListingDTOConverter.convert(accessRequest);
    }

    public AccessRequestListingDto completeRequest(Long id, Status approval, String remarks) throws Exception {
        if(ObjectUtils.isEmpty(id)){
            throw new Exception("id cannot be empty");
        }
        AccessRequest accessRequest = accessRequestRepo.findByAccessRequestId(id);
        if(ObjectUtils.isEmpty(accessRequest)) {
            throw new Exception("No access request found");
        }

        if(accessRequest.getControlTowerStatus()!=Status.PENDING){
            throw new Exception("This request is already approved/rejected");
        }
        accessRequest.setControlTowerStatus(approval);
        accessRequest.setReviewRemarks(remarks);
        accessRequest.setDateCompleted(System.currentTimeMillis());
        accessRequestRepo.save(accessRequest);
        return accessRequestListingDTOConverter.convert(accessRequest);
    }
}
