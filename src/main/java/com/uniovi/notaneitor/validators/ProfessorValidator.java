package com.uniovi.notaneitor.validators;

import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.services.ProfessorsService;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

@Component
public class ProfessorValidator implements Validator {

    private final ProfessorsService professorsService;

    public ProfessorValidator(ProfessorsService professorsService) {
        this.professorsService = professorsService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Professor.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Professor professor = (Professor) target;

        if (professor.getDni().length() != 9) {
            errors.rejectValue("dni", "Error.professor.DNI.length");}
        if (!Character.isLetter(professor.getDni().charAt(professor.getDni().length()-1))) {
            errors.rejectValue("dni", "Error.professor.DNI.letter");}
        if (professorsService.getProfessorByDni(professor.getDni().toUpperCase()) != null) {
            errors.rejectValue("dni", "Error.professor.DNI.duplicate");}
        // Corrección de error: La aplicación hacía distinción entre letras mayúsculas y minúsculas en el DNI, por lo
        // lo que podía haber DNIs repetidos como "12345678a" y "12345678A".
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Error.empty");
        if (professor.getName().charAt(0) == ' ' || professor.getName().charAt(professor.getName().length()-1) == ' ') {
            errors.rejectValue("name", "Error.professor.name.whitespaces");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "Error.empty");
        if (professor.getSurname().charAt(0) == ' ' || professor.getSurname().charAt(professor.getSurname().length()-1) == ' ') {
            errors.rejectValue("surname", "Error.professor.surname.whitespaces");
        }
    }
}

