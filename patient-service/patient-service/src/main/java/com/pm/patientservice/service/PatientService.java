package com.pm.patientservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    
    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients=patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOs=patients.stream()
                .map(patient -> PatientMapper.toDTO(patient))
                .toList();
        return patientResponseDTOs;
    }
    
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        Patient patient=patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(patient);
    }
}
