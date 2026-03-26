package com.devdioge.medhubapi.dto.doctor;

import com.devdioge.medhubapi.dto.address.AddressRegistrationDataDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorRegistrationDataDto(
                                        @NotBlank
                                        String name,
                                        @NotBlank
                                        @Email
                                        String email,
                                        @NotBlank
                                        @Pattern(regexp = "\\d{4,6}")
                                        String crm,
                                        @NotBlank
                                        String phone,
                                        @NotNull
                                        Speciality speciality,
                                        @NotNull
                                        Boolean active,
                                        @NotNull
                                        @Valid
                                        AddressRegistrationDataDto address) {
}
