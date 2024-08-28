package com.example.jsonData.dto;

import com.example.jsonData.enums.Company;
import com.example.jsonData.enums.Status;
import com.example.jsonData.enums.Systems;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessRequestListingDto {
    private Long id;

    private String employeeName;

    private String subDepartment;

    private Company companyName;

    private String emailId;

    private String approvingManagerName;

    private Status approvalStatus;

    private Status controlTowerStatus;

    private Long dateCreated;

    private Long dateApproved;

    private Long dateCompleted;

    private Map<Systems, List<String>> modules;

    private Company employeeCompany;

    private String requestRemarks;

    private String approveRemarks;

    private String reviewRemarks;

    public static interface IdStep {
        EmployeeNameStep withId(Long id);
    }

    public static interface EmployeeNameStep {
        SubDepartmentStep withEmployeeName(String employeeName);
    }

    public static interface SubDepartmentStep {
        CompanyNameStep withSubDepartment(String subDepartment);
    }

    public static interface CompanyNameStep {
        EmailIdStep withCompanyName(Company companyName);
    }

    public static interface EmailIdStep {
        ApprovingManagerNameStep withEmailId(String emailId);
    }

    public static interface ApprovingManagerNameStep {
        ApprovalStatusStep withApprovingManagerName(String approvingManagerName);
    }

    public static interface ApprovalStatusStep {
        ControlTowerStatusStep withApprovalStatus(Status approvalStatus);
    }

    public static interface ControlTowerStatusStep {
        DateCreatedStep withControlTowerStatus(Status controlTowerStatus);
    }

    public static interface DateCreatedStep {
        DateApprovedStep withDateCreated(Long dateCreated);
    }

    public static interface DateApprovedStep {
        DateCompletedStep withDateApproved(Long dateApproved);
    }

    public static interface DateCompletedStep {
        ModulesStep withDateCompleted(Long dateCompleted);
    }

    public static interface ModulesStep {
        EmployeeCompanyStep withModules(Map<Systems, List<String>> modules);
    }

    public static interface EmployeeCompanyStep {
        RequestRemarksStep withEmployeeCompany(Company employeeCompany);
    }

    public static interface RequestRemarksStep {
        ApproveRemarksStep withRequestRemarks(String requestRemarks);
    }

    public static interface ApproveRemarksStep {
        ReviewRemarksStep withApproveRemarks(String approveRemarks);
    }

    public static interface ReviewRemarksStep {
        BuildStep withReviewRemarks(String reviewRemarks);
    }

    public static interface BuildStep {
        AccessRequestListingDto build();
    }

    public static class Builder
        implements IdStep, EmployeeNameStep, SubDepartmentStep, CompanyNameStep, EmailIdStep,
        ApprovingManagerNameStep, ApprovalStatusStep, ControlTowerStatusStep, DateCreatedStep,
        DateApprovedStep, DateCompletedStep, ModulesStep, EmployeeCompanyStep, RequestRemarksStep,
        ApproveRemarksStep, ReviewRemarksStep, BuildStep {
        private Long id;

        private String employeeName;

        private String subDepartment;

        private Company companyName;

        private String emailId;

        private String approvingManagerName;

        private Status approvalStatus;

        private Status controlTowerStatus;

        private Long dateCreated;

        private Long dateApproved;

        private Long dateCompleted;

        private Map<Systems, List<String>> modules;

        private Company employeeCompany;

        private String requestRemarks;

        private String approveRemarks;

        private String reviewRemarks;

        private Builder() {
        }

        public static IdStep accessRequestListingDto() {
            return new Builder();
        }

        @Override
        public EmployeeNameStep withId(Long id) {
            this.id = id;
            return this;
        }

        @Override
        public SubDepartmentStep withEmployeeName(String employeeName) {
            this.employeeName = employeeName;
            return this;
        }

        @Override
        public CompanyNameStep withSubDepartment(String subDepartment) {
            this.subDepartment = subDepartment;
            return this;
        }

        @Override
        public EmailIdStep withCompanyName(Company companyName) {
            this.companyName = companyName;
            return this;
        }

        @Override
        public ApprovingManagerNameStep withEmailId(String emailId) {
            this.emailId = emailId;
            return this;
        }

        @Override
        public ApprovalStatusStep withApprovingManagerName(String approvingManagerName) {
            this.approvingManagerName = approvingManagerName;
            return this;
        }

        @Override
        public ControlTowerStatusStep withApprovalStatus(Status approvalStatus) {
            this.approvalStatus = approvalStatus;
            return this;
        }

        @Override
        public DateCreatedStep withControlTowerStatus(Status controlTowerStatus) {
            this.controlTowerStatus = controlTowerStatus;
            return this;
        }

        @Override
        public DateApprovedStep withDateCreated(Long dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        @Override
        public DateCompletedStep withDateApproved(Long dateApproved) {
            this.dateApproved = dateApproved;
            return this;
        }

        @Override
        public ModulesStep withDateCompleted(Long dateCompleted) {
            this.dateCompleted = dateCompleted;
            return this;
        }

        @Override
        public EmployeeCompanyStep withModules(Map<Systems, List<String>> modules) {
            this.modules = modules;
            return this;
        }

        @Override
        public RequestRemarksStep withEmployeeCompany(Company employeeCompany) {
            this.employeeCompany = employeeCompany;
            return this;
        }

        @Override
        public ApproveRemarksStep withRequestRemarks(String requestRemarks) {
            this.requestRemarks = requestRemarks;
            return this;
        }

        @Override
        public ReviewRemarksStep withApproveRemarks(String approveRemarks) {
            this.approveRemarks = approveRemarks;
            return this;
        }

        @Override
        public BuildStep withReviewRemarks(String reviewRemarks) {
            this.reviewRemarks = reviewRemarks;
            return this;
        }

        @Override
        public AccessRequestListingDto build() {
            return new AccessRequestListingDto(
                this.id,
                this.employeeName,
                this.subDepartment,
                this.companyName,
                this.emailId,
                this.approvingManagerName,
                this.approvalStatus,
                this.controlTowerStatus,
                this.dateCreated,
                this.dateApproved,
                this.dateCompleted,
                this.modules,
                this.employeeCompany,
                this.requestRemarks,
                this.approveRemarks,
                this.reviewRemarks
            );
        }
    }
}
