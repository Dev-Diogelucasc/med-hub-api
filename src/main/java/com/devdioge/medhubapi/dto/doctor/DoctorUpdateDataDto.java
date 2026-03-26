package com.devdioge.medhubapi.dto.doctor;

import com.devdioge.medhubapi.dto.address.AddressRegistrationDataDto;

public record DoctorUpdateDataDto(String name, String phone, AddressRegistrationDataDto address) {

}
