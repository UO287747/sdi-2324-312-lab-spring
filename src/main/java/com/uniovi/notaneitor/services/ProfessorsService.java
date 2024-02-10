package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Professor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProfessorsService {

    private List<Professor> professorList = new ArrayList<>();

    public List<Professor> getProfessors() {
        return professorList;
    }

    @PostConstruct
    private void init(){
        professorList.add(new Professor(1L, "77643987X", "Toni", "Cuquerella", "Profesor Titular"));
        professorList.add(new Professor(2L, "84637184F", "Pedro", "De la rosa", "Profesor Suplente"));
        professorList.add(new Professor(3L, "87957210G", "Melisa", "Jimenez", "Profesora Ayudante"));

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

        professorList.removeIf(professor -> professor.getId() == (id));
    }
}
