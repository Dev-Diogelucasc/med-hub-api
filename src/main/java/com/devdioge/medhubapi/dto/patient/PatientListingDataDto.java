package com.devdioge.medhubapi.dto.patient;

import com.devdioge.medhubapi.entity.PatientEntity;

public record PatientListingDataDto(Long id,
                                    String name,
                                    String email,
                                    String phone,
                                    String legalDocument,
                                    Boolean active) {
    public PatientListingDataDto(PatientEntity patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone(), patient.getLegalDocument(), patient.getActive());
    }
}
