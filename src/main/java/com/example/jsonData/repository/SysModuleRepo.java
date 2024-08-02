package com.example.jsonData.repository;

import com.example.jsonData.domain.SystemModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysModuleRepo extends JpaRepository<SystemModule, String> {

}
