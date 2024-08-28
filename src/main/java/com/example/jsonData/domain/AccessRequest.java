package com.example.jsonData.domain;

import com.example.jsonData.convertor.MapToJsonConvertor;
import com.example.jsonData.enums.Company;
import com.example.jsonData.enums.Status;
import com.example.jsonData.enums.Systems;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Entity(name = "accessRequest")
@Table(name = "accessRequest")
@Where(clause = "is_deleted=0")
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

    @Column(name = "subDepartment", nullable = false)
    private String subDepartment;

    @Column(name = "approvingManager", nullable = false)
    private String approvingManager;

    @Column(name = "companyNameRequest", nullable = false)
    @Enumerated(EnumType.STRING)
    private Company companyName;

    @Column(name = "permissionRequired", nullable = false, columnDefinition = "json")
    @Convert(converter = MapToJsonConvertor.class)
    private Map<Systems, List<String>> permissionRequired;

    @Column(name = "dateCreated", nullable = false)
    private Long dateCreated;

    @Column(name = "approveStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status approveStatus;

    @Column(name = "isDeleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "requestRemarks", nullable = false)
    private String requestRemarks;

    @Column(name = "employeeName", nullable = false)
    private String employeeName;

    @Column(name = "managerName", nullable = false)
    private String managerName;

    @Column(name = "controlTowerStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status controlTowerStatus;

    @Column(name = "dateApproved", nullable = true)
    private Long dateApproved;

    @Column(name = "dateCompleted", nullable = true)
    private Long dateCompleted;

    @Column(name = "employeeCompany", nullable = false)
    @Enumerated(EnumType.STRING)
    private Company employeeCompany;

    @Column(name = "approveRemarks", nullable = true)
    private String approveRemarks;

    @Column(name = "reviewRemarks", nullable = true)
    private String reviewRemarks;

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
        ApproveStatusStep withDateCreated(Long dateCreated);
    }

    public static interface ApproveStatusStep {
        IsDeletedStep withApproveStatus(Status approveStatus);
    }

    public static interface IsDeletedStep {
        RequestRemarksStep withIsDeleted(boolean isDeleted);
    }

    public static interface RequestRemarksStep {
        EmployeeNameStep withRequestRemarks(String requestRemarks);
    }

    public static interface EmployeeNameStep {
        ManagerNameStep withEmployeeName(String employeeName);
    }

    public static interface ManagerNameStep {
        ControlTowerStatusStep withManagerName(String managerName);
    }

    public static interface ControlTowerStatusStep {
        DateApprovedStep withControlTowerStatus(Status controlTowerStatus);
    }

    public static interface DateApprovedStep {
        DateCompletedStep withDateApproved(Long dateApproved);
    }

    public static interface DateCompletedStep {
        EmployeeCompanyStep withDateCompleted(Long dateCompleted);
    }

    public static interface EmployeeCompanyStep {
        ApproveRemarksStep withEmployeeCompany(Company employeeCompany);
    }

    public static interface ApproveRemarksStep {
        ReviewRemarksStep withApproveRemarks(String approveRemarks);
    }

    public static interface ReviewRemarksStep {
        BuildStep withReviewRemarks(String reviewRemarks);
    }

    public static interface BuildStep {
        AccessRequest build();
    }

    public static class Builder
        implements IdStep, EmailIdStep, DepartmentStep, SubDepartmentStep, ApprovingManagerStep,
        CompanyNameStep, PermissionRequiredStep, DateCreatedStep, ApproveStatusStep, IsDeletedStep,
        RequestRemarksStep, EmployeeNameStep, ManagerNameStep, ControlTowerStatusStep,
        DateApprovedStep, DateCompletedStep, EmployeeCompanyStep, ApproveRemarksStep,
        ReviewRemarksStep, BuildStep {
        private Long id;

        private String emailId;

        private String department;

        private String subDepartment;

        private String approvingManager;

        private Company companyName;

        private Map<Systems, List<String>> permissionRequired;

        private Long dateCreated;

        private Status approveStatus;

        private boolean isDeleted;

        private String requestRemarks;

        private String employeeName;

        private String managerName;

        private Status controlTowerStatus;

        private Long dateApproved;

        private Long dateCompleted;

        private Company employeeCompany;

        private String approveRemarks;

        private String reviewRemarks;

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
        public ApproveStatusStep withDateCreated(Long dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        @Override
        public IsDeletedStep withApproveStatus(Status approveStatus) {
            this.approveStatus = approveStatus;
            return this;
        }

        @Override
        public RequestRemarksStep withIsDeleted(boolean isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        @Override
        public EmployeeNameStep withRequestRemarks(String requestRemarks) {
            this.requestRemarks = requestRemarks;
            return this;
        }

        @Override
        public ManagerNameStep withEmployeeName(String employeeName) {
            this.employeeName = employeeName;
            return this;
        }

        @Override
        public ControlTowerStatusStep withManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        @Override
        public DateApprovedStep withControlTowerStatus(Status controlTowerStatus) {
            this.controlTowerStatus = controlTowerStatus;
            return this;
        }

        @Override
        public DateCompletedStep withDateApproved(Long dateApproved) {
            this.dateApproved = dateApproved;
            return this;
        }

        @Override
        public EmployeeCompanyStep withDateCompleted(Long dateCompleted) {
            this.dateCompleted = dateCompleted;
            return this;
        }

        @Override
        public ApproveRemarksStep withEmployeeCompany(Company employeeCompany) {
            this.employeeCompany = employeeCompany;
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
                this.approveStatus,
                this.isDeleted,
                this.requestRemarks,
                this.employeeName,
                this.managerName,
                this.controlTowerStatus,
                this.dateApproved,
                this.dateCompleted,
                this.employeeCompany,
                this.approveRemarks,
                this.reviewRemarks
            );
        }
    }
}
