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
    private String id;

    @Column(name = "systemName", nullable = false)
    @Enumerated(EnumType.STRING)
    private Systems systemName;

    @Column(name = "systemDisplayName", nullable = false)
    private String systemDisplayName;

    @Column(name = "module", nullable = false)
    private String module;

    @Column(name = "isDeleted", nullable = false)
    private boolean isDeleted;

}
