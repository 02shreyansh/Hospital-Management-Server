package com.pm.patientservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientRequestDTO {
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100,message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Size(max = 100, message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotBlank(message = "Date of Birth cannot be blank")
    private String dateOfBirth;

    @NotBlank(message = "Registration date cannot be blank")
    private String registrationDate;
}
