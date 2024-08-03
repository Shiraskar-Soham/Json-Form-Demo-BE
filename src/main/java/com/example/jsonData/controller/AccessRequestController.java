package com.example.jsonData.controller;

import com.example.jsonData.dto.AccessRequestDto;
import com.example.jsonData.service.AccessRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/request")

public class AccessRequestController {

    @Autowired
    private AccessRequestService accessRequestService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("submit")
    public Long addRequest(@RequestBody AccessRequestDto accessRequestDto) throws Exception {
        return accessRequestService.addRequest(accessRequestDto);
    }

}
