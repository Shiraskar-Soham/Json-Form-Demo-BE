package com.example.jsonData.repository;

import com.example.jsonData.domain.AccessRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRequestRepo extends JpaRepository<AccessRequest, String> {

}
