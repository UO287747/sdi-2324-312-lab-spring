package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.repositories.ProfessorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorsService {

    @Autowired
    private ProfessorsRepository professorsRepository;

    public List<Professor> getProfessors() {
        List<Professor> teachers = new ArrayList<>();
        professorsRepository.findAll().forEach(teachers::add);
        return teachers;
    }
    public Professor getProfessor(Long id) {
        return professorsRepository.findById(id).get();
    }

    public void addProfessor(Professor professor) {
        professor.setDni(professor.getDni().toLowerCase());
        professorsRepository.save(professor);
    }

    public Professor getProfessorByDni(String dni) {
        return professorsRepository.findByDni(dni);
    }

    public void deleteProfessor(Long id) {
        professorsRepository.deleteById(id);
    }
}
