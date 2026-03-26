package com.devdioge.medhubapi.repository;

import com.devdioge.medhubapi.entity.PatientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    Page<PatientEntity> findAllByActiveTrue(Pageable pageable);
}
