package com.devdioge.medhubapi.entity;

import com.devdioge.medhubapi.dto.doctor.DoctorRegistrationDataDto;
import com.devdioge.medhubapi.dto.doctor.DoctorUpdateDataDto;
import com.devdioge.medhubapi.dto.doctor.Speciality;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true, length = 6)
    private String crm;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @Embedded
    private Address address;

    @Column(nullable = false)
    private boolean active;

    public DoctorEntity(DoctorRegistrationDataDto doctor) {
        this.name = doctor.name();
        this.email = doctor.email();
        this.crm = doctor.crm();
        this.phone = doctor.phone();
        this.speciality = doctor.speciality();
        this.active = doctor.active();
        this.address = new Address(doctor.address());
    }

    public void updateInfo(DoctorUpdateDataDto doctor) {
        if (doctor.name() != null) {
            this.name = doctor.name();
        }
        if (doctor.phone() != null) {
            this.phone = doctor.phone();
        }
        if (doctor.address() != null) {
            this.address.updateInfo(doctor.address());
        }
    }

    public void excluir() {
        this.active = false;
    }
}
