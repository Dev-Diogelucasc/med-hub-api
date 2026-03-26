package com.devdioge.medhubapi.controller;

import com.devdioge.medhubapi.dto.doctor.DoctorListingDataDto;
import com.devdioge.medhubapi.dto.doctor.DoctorRegistrationDataDto;
import com.devdioge.medhubapi.dto.doctor.DoctorUpdateDataDto;
import com.devdioge.medhubapi.entity.DoctorEntity;
import com.devdioge.medhubapi.repository.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DoctorRegistrationDataDto doctor) {
        doctorRepository.save(new DoctorEntity(doctor));
    }

    @GetMapping
    public Page<DoctorListingDataDto> listar(@PageableDefault(size = 10) Pageable pageable) {
        return doctorRepository.findAllByActiveTrue(pageable).map(DoctorListingDataDto::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@PathVariable Long id, @RequestBody @Valid DoctorUpdateDataDto dados) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.updateInfo(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.excluir();
    }

}
