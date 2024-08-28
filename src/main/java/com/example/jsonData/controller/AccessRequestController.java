package com.example.jsonData.controller;

import com.example.jsonData.domain.AccessRequest;
import com.example.jsonData.dto.AccessRequestDto;
import com.example.jsonData.dto.AccessRequestListingDto;
import com.example.jsonData.enums.Status;
import com.example.jsonData.exceptions.CustomException;
import com.example.jsonData.service.AccessRequestService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/request")

public class AccessRequestController {

    @Autowired
    private AccessRequestService accessRequestService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("submit")
    public Long addRequest(@RequestBody AccessRequestDto accessRequestDto) throws CustomException, MessagingException {
        return accessRequestService.addRequest(accessRequestDto);
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("getAll")
//    public List<AccessRequest> getAll(){
//        return accessRequestService.getAll();
//    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getAccessRequestListings")
    public List<AccessRequestListingDto> getAllListing(@RequestParam(required = false) String listingStatus) {
        return accessRequestService.getAllListing(listingStatus);
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("getJsonListings")
//    public List<Map<String, Object>> getAllDynamicListing(@RequestParam(required = false) String listingStatus)
//        throws CustomException {
//        return accessRequestService.getAllDynamicListing(listingStatus);
//    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getJsonListings")
    public List<Map<String, Map<String,Object>>> getAllDynamicListing(@RequestParam(required = false) String listingStatus)
            throws CustomException {
        return accessRequestService.getAllDynamicListing(listingStatus);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("status")
    public AccessRequestListingDto managerApproval(@RequestParam Long id, @RequestParam Status action, @RequestParam String remarks) throws Exception {
        return accessRequestService.managerApproval(id, action, remarks);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("complete")
    public AccessRequestListingDto completeRequest(@RequestParam Long id, @RequestParam Status approval, @RequestParam String remarks) throws Exception {
        return accessRequestService.completeRequest(id, approval, remarks);
    }
}
