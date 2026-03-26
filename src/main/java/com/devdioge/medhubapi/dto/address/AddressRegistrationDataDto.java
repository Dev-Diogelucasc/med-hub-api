package com.devdioge.medhubapi.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressRegistrationDataDto(
                                        @NotBlank
                                        String street,
                                        @NotBlank
                                        String neighborhood,
                                        @NotBlank
                                        @Pattern(regexp = "\\d{8}")
                                        String zipCode,
                                        @NotBlank
                                        String city,
                                        @NotBlank
                                        String state,
                                        @NotBlank
                                        String number,
                                        String additionalInformation) {
}
