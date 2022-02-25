package com.BS9.BS9.DTOs.output;

import com.BS9.BS9.POJOs.Persona;
import com.BS9.BS9.POJOs.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfesorOutputDTO {
    private Integer id_profesor;
    private Persona persona;
    private String coments;
    private String branch;
    private ProfesorOutputDTO profesor;

    public ProfesorOutputDTO(Profesor profesor){
        this.id_profesor = profesor.getId_profesor();
        this.persona = profesor.getPersona();
        this.coments = profesor.getComents();
        this.branch = profesor.getBranch();
    }
}
