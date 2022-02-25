package com.BS9.BS9.Feign;

import com.BS9.BS9.DTOs.output.ProfesorOutputDTO;
import com.BS9.BS9.POJOs.Profesor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "simpleFeign", url = "http://localhost:8081/profesor/buscarId", fallbackFactory = FeignFallbackFactory.class)
public interface IFeignServer {
    @GetMapping("{id}?outputType=full")
    ResponseEntity<ProfesorOutputDTO> callServer(@PathVariable("id") int idProfesor);

    @GetMapping("profesor/1/{id}")
    ResponseEntity<ProfesorOutputDTO> callServer1(@PathVariable("id") Optional<Profesor> profesor);
}
