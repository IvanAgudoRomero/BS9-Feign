package com.BS9.BS9.DTOs.input;

import com.BS9.BS9.POJOs.Alumnos_Estudios;
import com.BS9.BS9.POJOs.Profesor;
import com.BS9.BS9.POJOs.Student;
import lombok.Data;

import java.util.Date;

@Data
public class Alumnos_EstudiosInputDTO {
    Integer id_study;
    Profesor profesor;
    Student student;
    String asignatura;
    String comment;
    Date initial_date;
    Date finish_date;

    public Alumnos_Estudios alumnos_estudios(){
        Alumnos_Estudios alumnos_estudios = new Alumnos_Estudios();
        alumnos_estudios.setId_study(this.getId_study());
        alumnos_estudios.setProfesor(this.getProfesor());
        alumnos_estudios.setStudent(this.getStudent());
        alumnos_estudios.setAsignatura(this.getAsignatura());
        alumnos_estudios.setComment(this.getComment());
        alumnos_estudios.setInitial_date(this.getInitial_date());
        alumnos_estudios.setFinish_date(this.getFinish_date());
        return alumnos_estudios;
    }
}
