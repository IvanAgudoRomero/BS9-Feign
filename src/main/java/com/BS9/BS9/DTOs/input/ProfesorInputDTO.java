package com.BS9.BS9.DTOs.input;

import com.BS9.BS9.POJOs.Profesor;
import com.BS9.BS9.Repositorios.PersonaRepositorio;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class ProfesorInputDTO {
    @Autowired
    PersonaRepositorio personaRepositorio;

    private Integer id_profesor;
    private Integer id_persona;
    private String coments;
    private String branch;

    public Profesor profesor(){
        Profesor profesor = new Profesor();
        profesor.setId_profesor(this.getId_profesor());
        profesor.setPersona(personaRepositorio.findById(this.getId_persona()).get());
        profesor.setComents(this.getComents());
        profesor.setBranch(this.getBranch());
        return profesor;
    }
}