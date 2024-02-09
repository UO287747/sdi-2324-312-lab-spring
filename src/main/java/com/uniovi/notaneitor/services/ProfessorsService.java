package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Professor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProfessorsService {

    private Professor[] defaultProfessors = {
            new Professor(1L, "77643987X", "Toni", "Cuquerella", "Profesor Titular"),
            new Professor(2L, "84637184F", "Pedro", "De la rosa", "Profesor Suplente"),
            new Professor(3L, "87957210G", "Melisa", "Jimenez", "Profesora Ayudante")
    };
    private List<Professor> professorList = Arrays.stream(defaultProfessors).toList();

    public List<Professor> getProfessors() {
        return professorList;
    }

    public void addProfessor(Professor professor) {

        for (Professor p: professorList){
            if (p.getId().equals(professor.getId())) {

                professorList.remove(p);
            }
        }
        professorList.add(professor);
    }

    public Professor getProfessor(Long id) {

        for (Professor p: professorList){
            if (p.getId().equals(id)) { return p; }
        }
        return null;
    }

    public void deleteProfessor(Long id) {

        professorList.removeIf(professor -> professor.getId().equals(id));
    }
}
