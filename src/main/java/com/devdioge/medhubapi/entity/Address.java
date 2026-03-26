package com.devdioge.medhubapi.entity;

import com.devdioge.medhubapi.dto.address.AddressRegistrationDataDto;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String neighborhood;
    @Column(nullable = false, length = 9)
    private String zipCode;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false, length = 2)
    private String state;
    @Column(nullable = false)
    private String number;
    private String additionalInformation;

    public Address(AddressRegistrationDataDto address) {
        this.street = address.street();
        this.neighborhood = address.neighborhood();
        this.zipCode = address.zipCode();
        this.city = address.city();
        this.state = address.state();
        this.number = address.number();
        this.additionalInformation = address.additionalInformation();
    }

    public void updateInfo(AddressRegistrationDataDto address) {
        if (address.street() != null) {
            this.street = address.street();
        }
        if (address.neighborhood() != null) {
            this.neighborhood = address.neighborhood();
        }
        if (address.zipCode() != null) {
            this.zipCode = address.zipCode();
        }
        if (address.city() != null) {
            this.city = address.city();
        }
        if (address.state() != null) {
            this.state = address.state();
        }
        if (address.additionalInformation() != null) {
            this.additionalInformation = address.additionalInformation();
        }
    }
}
