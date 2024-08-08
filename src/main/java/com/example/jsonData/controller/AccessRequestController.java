package com.example.jsonData.controller;

import com.example.jsonData.domain.AccessRequest;
import com.example.jsonData.dto.AccessRequestDto;
import com.example.jsonData.dto.AccessRequestListingDto;
import com.example.jsonData.exceptions.CustomException;
import com.example.jsonData.service.AccessRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/request")

public class AccessRequestController {

    @Autowired
    private AccessRequestService accessRequestService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("submit")
    public Long addRequest(@RequestBody AccessRequestDto accessRequestDto) throws CustomException {
        return accessRequestService.addRequest(accessRequestDto);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getAll")
    public List<AccessRequest> getAll(){
        return accessRequestService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getAccessRequestListings")
    public List<AccessRequestListingDto> getAllListing(){
        return accessRequestService.getAllListing();
    }
}
