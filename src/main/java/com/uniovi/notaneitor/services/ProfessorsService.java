package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Professor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProfessorsService {

    private Professor[] defaultProfessors = {
            new Professor("364356X", "Toni", "Cuquerella", "Profesor Titular"),
            new Professor("364356X", "Toni", "Cuquerella", "Profesor Titular"),
            new Professor("364356X", "Toni", "Cuquerella", "Profesor Titular")
    };
    private List<Professor> professorList = Arrays.stream(defaultProfessors).toList();

    public List<Professor> getProfessors() {
        return professorList;
    }

    public void addProfessor(Professor professor) {
        professorList.add(professor);
    }

    public Professor getProfessor(Long id) {

        for (Professor p: professorList){
            if (p.getId().equals(id)) { return p; }
        }
        return null;
    }

    public void deleteProfessor(Long id) {

        for (Professor p: professorList){
            if (p.getId().equals(id)) {

                professorList.remove(p);
                return;
            }
        }
    }
}
