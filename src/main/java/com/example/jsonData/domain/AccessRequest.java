package com.example.jsonData.domain;


import com.example.jsonData.convertor.MapToJsonConvertor;
import com.example.jsonData.enums.Company;
import com.example.jsonData.enums.Status;
import com.example.jsonData.enums.Systems;
import jakarta.persistence.*;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "accessRequest")
@Table(name = "accessRequest")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessRequest {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emailId", nullable = false)
    private String emailId;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name= "subDepartment", nullable = false)
    private String subDepartment;

    @Column(name= "approvingManager", nullable = false)
    private String approvingManager;

    @Column(name= "companyName", nullable = false)
    @Enumerated(EnumType.STRING)
    private Company companyName;
    
    @Column(name= "permissionRequired", nullable = false, columnDefinition = "json")
    @Convert(converter = MapToJsonConvertor.class)
    private Map<Systems, List<String>> permissionRequired;

    @Column(name= "dateCreated", nullable = false)
    private Long dateCreated;

    @Column(name="status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="isDeleted", nullable = false)
    private boolean isDeleted;

    @Column(name="remarks", nullable = true)
    private String remarks;

    public static interface IdStep {
        EmailIdStep withId(Long id);
    }

    public static interface EmailIdStep {
        DepartmentStep withEmailId(String emailId);
    }

    public static interface DepartmentStep {
        SubDepartmentStep withDepartment(String department);
    }

    public static interface SubDepartmentStep {
        ApprovingManagerStep withSubDepartment(String subDepartment);
    }

    public static interface ApprovingManagerStep {
        CompanyNameStep withApprovingManager(String approvingManager);
    }

    public static interface CompanyNameStep {
        PermissionRequiredStep withCompanyName(Company companyName);
    }

    public static interface PermissionRequiredStep {
        DateCreatedStep withPermissionRequired(Map<Systems, List<String>> permissionRequired);
    }

    public static interface DateCreatedStep {
        StatusStep withDateCreated(Long dateCreated);
    }

    public static interface StatusStep {
        IsDeletedStep withStatus(Status status);
    }

    public static interface IsDeletedStep {
        RemarksStep withIsDeleted(boolean isDeleted);
    }

    public static interface RemarksStep {
        BuildStep withRemarks(String remarks);
    }

    public static interface BuildStep {
        AccessRequest build();
    }

    public static class Builder
        implements IdStep, EmailIdStep, DepartmentStep, SubDepartmentStep, ApprovingManagerStep,
        CompanyNameStep, PermissionRequiredStep, DateCreatedStep, StatusStep, IsDeletedStep,
        RemarksStep, BuildStep {
        private Long id;

        private String emailId;

        private String department;

        private String subDepartment;

        private String approvingManager;

        private Company companyName;

        private Map<Systems, List<String>> permissionRequired;

        private Long dateCreated;

        private Status status;

        private boolean isDeleted;

        private String remarks;

        private Builder() {
        }

        public static IdStep accessRequest() {
            return new Builder();
        }

        @Override
        public EmailIdStep withId(Long id) {
            this.id = id;
            return this;
        }

        @Override
        public DepartmentStep withEmailId(String emailId) {
            this.emailId = emailId;
            return this;
        }

        @Override
        public SubDepartmentStep withDepartment(String department) {
            this.department = department;
            return this;
        }

        @Override
        public ApprovingManagerStep withSubDepartment(String subDepartment) {
            this.subDepartment = subDepartment;
            return this;
        }

        @Override
        public CompanyNameStep withApprovingManager(String approvingManager) {
            this.approvingManager = approvingManager;
            return this;
        }

        @Override
        public PermissionRequiredStep withCompanyName(Company companyName) {
            this.companyName = companyName;
            return this;
        }

        @Override
        public DateCreatedStep withPermissionRequired(
            Map<Systems, List<String>> permissionRequired) {
            this.permissionRequired = permissionRequired;
            return this;
        }

        @Override
        public StatusStep withDateCreated(Long dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        @Override
        public IsDeletedStep withStatus(Status status) {
            this.status = status;
            return this;
        }

        @Override
        public RemarksStep withIsDeleted(boolean isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        @Override
        public BuildStep withRemarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        @Override
        public AccessRequest build() {
            return new AccessRequest(
                this.id,
                this.emailId,
                this.department,
                this.subDepartment,
                this.approvingManager,
                this.companyName,
                this.permissionRequired,
                this.dateCreated,
                this.status,
                this.isDeleted,
                this.remarks
            );
        }
    }
}
