package com.example.jsonData.repository;

import com.example.jsonData.domain.AccessRequest;
import com.example.jsonData.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public interface AccessRequestRepo extends JpaRepository<AccessRequest, Long> {

    @Query(value = "SELECT * FROM access_request where id=?1", nativeQuery = true)
    AccessRequest findByAccessRequestId(Long id);

    List<AccessRequest> findByApproveStatus(Status listingStatus);

    List<AccessRequest> findByControlTowerStatusNot(Status status);
}
