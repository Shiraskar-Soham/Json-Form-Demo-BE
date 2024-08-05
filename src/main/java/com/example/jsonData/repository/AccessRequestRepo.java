package com.example.jsonData.repository;

import com.example.jsonData.domain.AccessRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessRequestRepo extends JpaRepository<AccessRequest, String> {

    @Query(value = "SELECT * FROM access_request", nativeQuery = true)
    List<AccessRequest> getAll();
}
