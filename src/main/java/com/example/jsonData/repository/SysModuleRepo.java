package com.example.jsonData.repository;

import com.example.jsonData.domain.SystemModule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SysModuleRepo extends JpaRepository<SystemModule, String> {

    @Query(value = "Select system_name, system_display_name from system_module WHERE is_deleted = false and company_name = ?1 GROUP BY system_name, system_display_name", nativeQuery = true)
    List<Object[]> getAllSystemNames(String company_name);

    @Query(value = "SELECT module FROM system_module WHERE company_name=?1 and system_name = ?2 and is_deleted = false", nativeQuery = true)
    List<String> getModules(String company_name, String system_name);

    @Query(value = "Select company_name, company_display_name from system_module WHERE is_deleted = false GROUP BY company_name, company_display_name", nativeQuery = true)
    List<Object[]> getAllCompany();
}
