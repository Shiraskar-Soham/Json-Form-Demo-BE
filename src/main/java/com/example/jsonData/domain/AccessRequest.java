package com.example.jsonData.domain;


import com.example.jsonData.enums.Status;
import com.example.jsonData.enums.Systems;
import jakarta.persistence.*;
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

    @Column(name= "systemName", nullable = false)
    @Enumerated(EnumType.STRING)
    private Systems systemName;

    @Column(name= "modules", nullable = false)
    private List<String> modules;

    @Column(name= "dateCreated", nullable = false)
    private Long dateCreated;

    @Column(name="status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="isDeleted", nullable = false)
    private boolean isDeleted;

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
        SystemNameStep withApprovingManager(String approvingManager);
    }

    public static interface SystemNameStep {
        ModulesStep withSystemName(Systems systemName);
    }

    public static interface ModulesStep {
        DateCreatedStep withModules(List<String> modules);
    }

    public static interface DateCreatedStep {
        StatusStep withDateCreated(Long dateCreated);
    }

    public static interface StatusStep {
        IsDeletedStep withStatus(Status status);
    }

    public static interface IsDeletedStep {
        BuildStep withIsDeleted(boolean isDeleted);
    }

    public static interface BuildStep {
        AccessRequest build();
    }


    public static class Builder implements IdStep, EmailIdStep, DepartmentStep, SubDepartmentStep, ApprovingManagerStep, SystemNameStep, ModulesStep, DateCreatedStep, StatusStep, IsDeletedStep, BuildStep {
        private Long id;
        private String emailId;
        private String department;
        private String subDepartment;
        private String approvingManager;
        private Systems systemName;
        private List<String> modules;
        private Long dateCreated;
        private Status status;
        private boolean isDeleted;

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
        public SystemNameStep withApprovingManager(String approvingManager) {
            this.approvingManager = approvingManager;
            return this;
        }

        @Override
        public ModulesStep withSystemName(Systems systemName) {
            this.systemName = systemName;
            return this;
        }

        @Override
        public DateCreatedStep withModules(List<String> modules) {
            this.modules = modules;
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
        public BuildStep withIsDeleted(boolean isDeleted) {
            this.isDeleted = isDeleted;
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
                    this.systemName,
                    this.modules,
                    this.dateCreated,
                    this.status,
                    this.isDeleted
            );
        }
    }
}
