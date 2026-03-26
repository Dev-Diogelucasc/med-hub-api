package com.devdioge.medhubapi.dto.patient;

import com.devdioge.medhubapi.dto.address.AddressRegistrationDataDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PatientRegistrationDataDto(@NotBlank
                                         String name,
                                         @NotBlank
                                         @Email
                                         String email,
                                         @NotBlank
                                         String phone,
                                         @NotBlank
                                         String legalDocument,
                                         @NotNull
                                         Boolean active,
                                         @NotNull
                                         @Valid
                                         AddressRegistrationDataDto address) {
}
