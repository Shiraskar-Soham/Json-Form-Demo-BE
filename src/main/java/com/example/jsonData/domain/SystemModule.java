package com.example.jsonData.domain;

import com.example.jsonData.enums.Company;
import com.example.jsonData.enums.Systems;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "systemModule")
@Table(name = "systemModule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemModule {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "companyName", nullable = false)
    @Enumerated(EnumType.STRING)
    private Company companyName;

    @Column(name = "companyDisplayName", nullable = false)
    private String companyDisplayName;

    @Column(name = "systemName", nullable = false)
    @Enumerated(EnumType.STRING)
    private Systems systemName;

    @Column(name = "systemDisplayName", nullable = false)
    private String systemDisplayName;

    @Column(name = "module", nullable = false)
    private String module;

    @Column(name = "isDeleted", nullable = false)
    private boolean isDeleted;

    public static interface IdStep {
        CompanyNameStep withId(Long id);
    }

    public static interface CompanyNameStep {
        CompanyDisplayNameStep withCompanyName(Company companyName);
    }

    public static interface CompanyDisplayNameStep {
        SystemNameStep withCompanyDisplayName(String companyDisplayName);
    }

    public static interface SystemNameStep {
        SystemDisplayNameStep withSystemName(Systems systemName);
    }

    public static interface SystemDisplayNameStep {
        ModuleStep withSystemDisplayName(String systemDisplayName);
    }

    public static interface ModuleStep {
        IsDeletedStep withModule(String module);
    }

    public static interface IsDeletedStep {
        BuildStep withIsDeleted(boolean isDeleted);
    }

    public static interface BuildStep {
        SystemModule build();
    }


    public static class Builder implements IdStep, CompanyNameStep, CompanyDisplayNameStep, SystemNameStep, SystemDisplayNameStep, ModuleStep, IsDeletedStep, BuildStep {
        private Long id;
        private Company companyName;
        private String companyDisplayName;
        private Systems systemName;
        private String systemDisplayName;
        private String module;
        private boolean isDeleted;

        private Builder() {
        }

        public static IdStep systemModule() {
            return new Builder();
        }

        @Override
        public CompanyNameStep withId(Long id) {
            this.id = id;
            return this;
        }

        @Override
        public CompanyDisplayNameStep withCompanyName(Company companyName) {
            this.companyName = companyName;
            return this;
        }

        @Override
        public SystemNameStep withCompanyDisplayName(String companyDisplayName) {
            this.companyDisplayName = companyDisplayName;
            return this;
        }

        @Override
        public SystemDisplayNameStep withSystemName(Systems systemName) {
            this.systemName = systemName;
            return this;
        }

        @Override
        public ModuleStep withSystemDisplayName(String systemDisplayName) {
            this.systemDisplayName = systemDisplayName;
            return this;
        }

        @Override
        public IsDeletedStep withModule(String module) {
            this.module = module;
            return this;
        }

        @Override
        public BuildStep withIsDeleted(boolean isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        @Override
        public SystemModule build() {
            return new SystemModule(
                    this.id,
                    this.companyName,
                    this.companyDisplayName,
                    this.systemName,
                    this.systemDisplayName,
                    this.module,
                    this.isDeleted
            );
        }
    }
}
