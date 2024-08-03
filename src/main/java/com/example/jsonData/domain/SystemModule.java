package com.example.jsonData.domain;

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

    @Column(name = "systemName", nullable = false)
    @Enumerated(EnumType.STRING)
    private Systems systemName;

    @Column(name = "systemDisplayName", nullable = false)
    private String systemDisplayName;

    @Column(name = "module", nullable = false)
    private String module;

    @Column(name = "isDeleted", nullable = false)
    private boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Systems getSystemName() {
        return systemName;
    }

    public void setSystemName(Systems systemName) {
        this.systemName = systemName;
    }

    public String getSystemDisplayName() {
        return systemDisplayName;
    }

    public void setSystemDisplayName(String systemDisplayName) {
        this.systemDisplayName = systemDisplayName;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
