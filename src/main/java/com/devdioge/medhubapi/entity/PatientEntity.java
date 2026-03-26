package com.devdioge.medhubapi.entity;

import com.devdioge.medhubapi.dto.patient.PatientRegistrationDataDto;
import com.devdioge.medhubapi.dto.patient.PatientUpdateDataDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false, unique = true)
    private String legalDocument;
    @Column(nullable = false)
    private Boolean active;

    @Embedded
    private Address address;


    public PatientEntity(PatientRegistrationDataDto patient) {
        this.name = patient.name();
        this.email = patient.email();
        this.phone = patient.phone();
        this.legalDocument = patient.legalDocument();
        this.active = patient.active();
        this.address = new Address(patient.address());
    }

    public void excluir() {
        this.active = false;
    }

    public void updateInfo(PatientUpdateDataDto dados) {
        if (this.name != null) {
            this.name = dados.name();
        }
        if (this.phone != null) {
            this.phone = dados.phone();
        }
    }
}
