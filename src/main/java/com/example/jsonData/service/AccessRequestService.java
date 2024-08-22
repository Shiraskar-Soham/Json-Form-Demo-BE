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
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.util.StringUtils;

import static com.example.jsonData.enums.Status.*;

@Service
public class AccessRequestService {

    @Autowired
    private AccessRequestRepo accessRequestRepo;

    @Autowired
    private AccessRequestListingDTOConverter accessRequestListingDTOConverter;

    @Autowired
    private AccessRequestDtoConvertor accessRequestDtoConvertor;

    @Autowired
    private EmailService emailService;

    public Long addRequest(AccessRequestDto accessRequestDto) throws CustomException, MessagingException {
        if (ObjectUtils.isEmpty(accessRequestDto)) {
            throw new CustomException("Access Request Not valid");
        }
        Map<Systems, List<String>> systemsListMap = accessRequestDto.getModules();
        if (ObjectUtils.isEmpty(systemsListMap)) {
            throw new CustomException("Modules can not be empty");
        }
        systemsListMap.entrySet().removeIf(entry -> entry.getValue() == null || entry.getValue().isEmpty());
        boolean allListsEmpty = systemsListMap.values().stream().allMatch(List::isEmpty);
        if (allListsEmpty) {
            throw new CustomException("All module lists cannot be empty");
        }
        AccessRequest accessRequest = accessRequestDtoConvertor.convert(accessRequestDto);
        accessRequest.setApproveStatus(PENDING);
        accessRequest.setDateCreated(System.currentTimeMillis());
        accessRequestRepo.save(accessRequest);
        String htmlContent = "<html>" +
                "<head>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; line-height: 1.6; }" +
                ".container { max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 5px; background-color: #f9f9f9; }" +
                ".header { font-size: 18px; font-weight: bold; margin-bottom: 20px; }" +
                ".content { margin-bottom: 20px; }" +
                ".footer { font-size: 12px; color: #777; margin-top: 30px; }" +
                ".btn { display: inline-block; padding: 10px 20px; color: white; background-color: greenyellow; text-decoration: none; border-radius: 5px; margin-top: 20px; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<div class='header'>" +
                "Access Request Approval Required: ${userName} - ${systemModuleName}" +
                "</div>" +
                "<div class='content'>" +
                "<p>Dear Sir/Mam,</p>" +
                "<p>${userName} has requested access to the following system/module(s):</p>" +
                "<ul>" +
                "<li><strong>Company:</strong> ${companyName}</li>" +
                "<li><strong>System:</strong> ${systemName}</li>" +
                "<li><strong>Module(s):</strong> ${selectedModules}</li>" +
                "<li><strong>Remarks:</strong> ${userRemarks}</li>" +
                "</ul>" +
                "<p>We kindly ask for your approval of this request.</p>" +
                "<a href='${approvalLink}' class='btn'>Click here to approve or reject</a>" +
                "</div>" +
                "<div class='footer'>" +
                "<p>Note: Please review the details and approve or reject.</p>" +
                "</div>" +
                "<p>Thanks.</p>" +
                "</div>" +
                "</body>" +
                "</html>";
        htmlContent = htmlContent.replace("${userName}",accessRequest.getEmployeeName());
        htmlContent = htmlContent.replace("${systemModuleName}",accessRequestDto.getModules().keySet().toString());
        htmlContent = htmlContent.replace("${companyName}", accessRequest.getCompanyName().name());
        htmlContent = htmlContent.replace("${systemName}", accessRequestDto.getModules().keySet().toString());
        htmlContent = htmlContent.replace("${selectedModules}",accessRequestDto.getModules().values().toString());
        htmlContent = htmlContent.replace("${userRemarks}",accessRequest.getRequestRemarks());
        htmlContent = htmlContent.replace("${approvalLink}","http://localhost:3000/");
        emailService.sendRichEmail(accessRequest.getEmailId(), "Access Request Approval Required: " + accessRequest.getEmployeeName() + "-" +accessRequest.getPermissionRequired().keySet().toString(), htmlContent);
        return accessRequest.getId();
    }

    public List<AccessRequest> getAll() {
        return accessRequestRepo.findAll();
    }

    public List<AccessRequestListingDto> getAllListing(String listingStatus) {
        List<AccessRequest> e = new ArrayList<>();
        if (StringUtils.isEmpty(listingStatus)) {
            e = accessRequestRepo.findAll();
        } else if (listingStatus.equals("COMPLETED")) {
            e = accessRequestRepo.findByControlTowerStatusNot(PENDING);
        } else {
            e = accessRequestRepo.findByApproveStatus(Status.valueOf(listingStatus));
        }
        List<AccessRequestListingDto> convertedList = new ArrayList<>();
        for (AccessRequest accessRequest : e) {
            AccessRequestListingDto dto = accessRequestListingDTOConverter.convert(accessRequest);
            convertedList.add(dto);
        }
        return convertedList;
    }

    public AccessRequestListingDto managerApproval(Long id, Status action, String remarks) throws Exception {
        if (ObjectUtils.isEmpty(id)) {
            throw new Exception("id cannot be empty");
        }
        AccessRequest accessRequest = accessRequestRepo.findByAccessRequestId(id);
        if (ObjectUtils.isEmpty(accessRequest)) {
            throw new Exception("No access request found");
        }
        if (accessRequest.getApproveStatus() != PENDING) {
            throw new Exception("This request is already approved/rejected");
        }
        accessRequest.setApproveStatus(action);
        accessRequest.setApproveRemarks(remarks);
        accessRequest.setDateApproved(System.currentTimeMillis());
        accessRequestRepo.save(accessRequest);
        String htmlContent = "<html>" +
                "<head>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; line-height: 1.6; }" +
                ".container { max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 5px; background-color: #f9f9f9; }" +
                ".header { font-size: 18px; font-weight: bold; margin-bottom: 20px; }" +
                ".content { margin-bottom: 20px; }" +
                ".footer { font-size: 12px; color: #777; margin-top: 30px; }" +
                ".btn { display: inline-block; padding: 10px 20px; color: white; background-color: greenyellow; text-decoration: none; border-radius: 5px; margin-top: 20px; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<div class='header'>" +
                "Access Request Approval Required: ${userName} - ${systemModuleName}" +
                "</div>" +
                "<div class='content'>" +
                "<p>Dear ${userName} and System Review Team,</p>" +
                "We would like to inform you that your request for access to the following system/module(s) has been ${managerApprovalStatus} by ${approverName}</p>" +
                "<p></p>" +
                "<a href='${approvalLink}' class='btn'>Click on the link</a>" +
                "</div>" +
                "<div class='footer'>" +
                "<p>Note: Please review the details.</p>" +
                "</div>" +
                "<p>Thanks.</p>" +
                "</div>" +
                "</body>" +
                "</html>";
        htmlContent = htmlContent.replace("${userName}",accessRequest.getEmployeeName());
        htmlContent = htmlContent.replace("${systemModuleName}",accessRequest.getPermissionRequired().keySet().toString());
        htmlContent = htmlContent.replace("${approverName}",accessRequest.getApprovingManager());
        htmlContent = htmlContent.replace("${managerApprovalStatus}", accessRequest.getApproveStatus().toString());
        htmlContent = htmlContent.replace("${approvalLink}","http://localhost:3000/");

        emailService.sendRichEmail(accessRequest.getEmailId(), "Access Request Approval Required: " + accessRequest.getEmployeeName() + "-" +accessRequest.getPermissionRequired().keySet().toString(), htmlContent);

        return accessRequestListingDTOConverter.convert(accessRequest);
    }

    public AccessRequestListingDto completeRequest(Long id, Status approval, String remarks) throws Exception {
        if (ObjectUtils.isEmpty(id)) {
            throw new Exception("id cannot be empty");
        }
        AccessRequest accessRequest = accessRequestRepo.findByAccessRequestId(id);
        if (ObjectUtils.isEmpty(accessRequest)) {
            throw new Exception("No access request found");
        }
        if (accessRequest.getControlTowerStatus() != PENDING) {
            throw new Exception("This request is already approved/rejected");
        }
        accessRequest.setControlTowerStatus(approval);
        accessRequest.setReviewRemarks(remarks);
        accessRequest.setDateCompleted(System.currentTimeMillis());
        accessRequestRepo.save(accessRequest);
        String htmlContent = "<html>" +
                "<head>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; line-height: 1.6; }" +
                ".container { max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 5px; background-color: #f9f9f9; }" +
                ".header { font-size: 18px; font-weight: bold; margin-bottom: 20px; }" +
                ".content { margin-bottom: 20px; }" +
                ".footer { font-size: 12px; color: #777; margin-top: 30px; }" +
                ".btn { display: inline-block; padding: 10px 20px; color: white; background-color: greenyellow; text-decoration: none; border-radius: 5px; margin-top: 20px; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<div class='header'>" +
                "Access Request Approval Required: ${userName} - ${systemModuleName}" +
                "</div>" +
                "<div class='content'>" +
                "<p>Dear ${userName} and System Review Team,</p>" +
                "Your Requested has been ${managerApprovalStatus} and thus marked as completed by ${approverName}</p>" +
                "<p></p>" +
                "<a href='${approvalLink}' class='btn'>Click on the link</a>" +
                "</div>" +
                "<div class='footer'>" +
                "<p>Note: Please review the details.</p>" +
                "</div>" +
                "<p>Thanks.</p>" +
                "</div>" +
                "</body>" +
                "</html>";
        htmlContent = htmlContent.replace("${userName}",accessRequest.getEmployeeName());
        htmlContent = htmlContent.replace("${systemModuleName}",accessRequest.getPermissionRequired().keySet().toString());
        htmlContent = htmlContent.replace("${approverName}",accessRequest.getApprovingManager());
        htmlContent = htmlContent.replace("${managerApprovalStatus}", accessRequest.getApproveStatus().toString());
        htmlContent = htmlContent.replace("${approvalLink}","http://localhost:3000/");

        emailService.sendRichEmail(accessRequest.getEmailId(), "Access Request Approval Required: " + accessRequest.getEmployeeName() + "-" +accessRequest.getPermissionRequired().keySet().toString(), htmlContent);

        return accessRequestListingDTOConverter.convert(accessRequest);
    }

    public List<Map<String, Object>> getAllDynamicListing() {
        List<AccessRequestListingDto> list = getAllListing(null);
        List<Map<String, Object>> result = new ArrayList<>();
        for (AccessRequestListingDto accessRequest : list) {
            Map<String, Object> json = convertToJson(accessRequest);
            result.add(json);
        }
        return result;
    }

    public Map<String, Object> convertToJson(AccessRequestListingDto dto) {
        Map<String, Object> jsonData = new HashMap<>();

        // Header section
        Map<String, String> header = new HashMap<>();
        header.put("Employee Name", dto.getEmployeeName());
        header.put("Sub Department", dto.getSubDepartment());
        header.put("Company Name", dto.getEmployeeCompany().name());
        jsonData.put("header", header);

        // Label Chips section
        Map<String, String> labelChips = new HashMap<>();
        labelChips.put("Date Created", formatDate(dto.getDateCreated()));
        labelChips.put("Email Id", dto.getEmailId());
        labelChips.put("Manager Status", dto.getApprovalStatus().toString());
        labelChips.put("Control Tower Status", dto.getControlTowerStatus().toString());
        jsonData.put("labelChips", labelChips);

        // Body section
        jsonData.put("body", dto.getModules());

        // Footer section
        Map<String, String> footer = new HashMap<>();
        footer.put("Remarks", dto.getRequestRemarks());
        footer.put("Date Approved", formatDate(dto.getDateApproved()));
        footer.put("Approving Remarks", dto.getApproveRemarks());
        jsonData.put("footer", footer);

        return jsonData;
    }
    private String formatDate(Long timestamp) {
        if (timestamp == null) return "";
        Date date = new Date(timestamp);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }
}
