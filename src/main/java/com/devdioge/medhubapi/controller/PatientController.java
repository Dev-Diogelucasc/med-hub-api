package com.devdioge.medhubapi.controller;

import com.devdioge.medhubapi.dto.patient.PatientListingDataDto;
import com.devdioge.medhubapi.dto.patient.PatientRegistrationDataDto;
import com.devdioge.medhubapi.dto.patient.PatientUpdateDataDto;
import com.devdioge.medhubapi.entity.PatientEntity;
import com.devdioge.medhubapi.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    public void create(@RequestBody @Valid PatientRegistrationDataDto patient) {
        patientRepository.save(new PatientEntity(patient));
    }

    @GetMapping
    public Page<PatientListingDataDto> listar(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return patientRepository.findAllByActiveTrue(pageable).map(PatientListingDataDto::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@PathVariable Long id, @RequestBody PatientUpdateDataDto dados) {
        var patient = patientRepository.getReferenceById(id);
        patient.updateInfo(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        var patient = patientRepository.getReferenceById(id);
        patient.excluir();
    }
}
