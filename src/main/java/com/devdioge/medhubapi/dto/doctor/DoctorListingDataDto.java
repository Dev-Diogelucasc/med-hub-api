package com.devdioge.medhubapi.dto.doctor;

import com.devdioge.medhubapi.entity.DoctorEntity;

public record DoctorListingDataDto(Long id,
                                   String name,
                                   String email,
                                   String crm,
                                   String phone,
                                   Speciality speciality,
                                   Boolean active) {

    public DoctorListingDataDto(DoctorEntity doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhone(), doctor.getSpeciality(), doctor.isActive());
    }
}
