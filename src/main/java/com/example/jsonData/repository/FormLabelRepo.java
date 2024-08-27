package com.example.jsonData.repository;

import com.example.jsonData.domain.FormLabel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FormLabelRepo extends JpaRepository<FormLabel, Long> {

    @Query(value = "SELECT f.field_key, f.label FROM form_label f", nativeQuery = true)
    List<Object[]> findAllLabels();

}
