package com.example.jsonData.repository;

import com.example.jsonData.domain.SystemModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysModuleRepo extends JpaRepository<SystemModule, String> {

    @Query(value = "Select system_name, system_display_name from system_module WHERE is_deleted = false GROUP BY system_name, system_display_name", nativeQuery = true)
    List<Object[]> getAllSystemNames();

    @Query(value = "SELECT module FROM system_module WHERE system_name = ?1 and is_deleted = false", nativeQuery = true)
    List<String> getModules(String system_name);

    @Query(value = "Select * FROM system_module WHERE system_name = ?1 and module = ?2", nativeQuery = true)
    SystemModule findModule(String systemName, String module);
}
