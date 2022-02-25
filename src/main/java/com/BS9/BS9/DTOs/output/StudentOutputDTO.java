package com.BS9.BS9.DTOs.output;

import com.BS9.BS9.POJOs.Persona;
import com.BS9.BS9.POJOs.Profesor;
import com.BS9.BS9.POJOs.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class StudentOutputDTO {
    /*
    @Autowired
    PersonaRepositorio personaRepositorio;

    @Autowired
    ProfesorRepositorio profesorRepositorio;
*/
    //private Optional<Persona> persona;
    private Persona persona;
    private Integer num_hours_week;
    private String coments;
    private Optional<Profesor> profesor;
    private String branch;
    private List estudios;
    private StudentOutputDTO student;

    public StudentOutputDTO(Student student){
        //this.persona = Optional.ofNullable(student.getPersona());
        this.persona = student.getPersona();
        this.num_hours_week = student.getNum_hours_week();
        this.coments = student.getComents();
        this.profesor = Optional.ofNullable(student.getProfesor());
        this.branch = student.getBranch();
    }
}
