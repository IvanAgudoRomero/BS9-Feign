package com.BS9.BS9.Controladores;

import com.BS9.BS9.DTOs.output.ProfesorOutputDTO;
import com.BS9.BS9.Excepciones.NotFoundException;
import com.BS9.BS9.Feign.IFeignServer;
import com.BS9.BS9.POJOs.Profesor;
import com.BS9.BS9.Servicios.ProfesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class ControladorProfesor {
    @Autowired
    ProfesorServicio profesorServicio;

    @GetMapping("profesor/buscarId/{id_profesor}")
    public Optional<Profesor> buscarId(@PathVariable int id_profesor, @RequestParam String outputType){
        if(outputType==""){
            outputType="simple";
        }
        if(outputType.equals("simple")){
            Optional<Profesor> profesor = profesorServicio.buscarId(id_profesor);
            return profesor;
        }else if(outputType.equals("full")){
            Optional<Profesor> profesor = profesorServicio.buscarId(id_profesor);
            return profesor;
        }else{
            throw new NotFoundException("No se encuentra una solicitud con ese parametro");
        }
    }

    @GetMapping("profesor/showAll")
    public ArrayList mostrarTodo(){
        ArrayList profesores = profesorServicio.mostrarTodo();
        return (ArrayList) profesores.stream()
                .map(i -> new ProfesorOutputDTO((Profesor) i))
                .collect(Collectors.toList());
    }

    @PostMapping("profesor/addProfesor")
    public void addProfesor(@RequestBody Profesor p) throws Exception{
        profesorServicio.addProfesor(p);
    }

    @DeleteMapping("profesor/deleteProfesor/{id_profesor}")
    public void deleteProfesor(@PathVariable int id_profesor){
        profesorServicio.deleteProfesor(id_profesor);
    }
}
/*
* FALTA PONER EL ATRIBUTO PARA QUE MUESTRE O NO LOS DATOS ASOCIADOS
* A UN DETERMINADO OBJETO COMO CON EL OBJETO ESTUDIANTE QUE MUESTRA
* LOS DE PERSONA
* */