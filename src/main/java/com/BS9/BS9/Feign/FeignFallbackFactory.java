package com.BS9.BS9.Feign;

import com.BS9.BS9.DTOs.output.ProfesorOutputDTO;
import com.BS9.BS9.POJOs.Profesor;
import com.BS9.BS9.Repositorios.ProfesorRepositorio;
import com.BS9.BS9.Servicios.ProfesorServicio;
import feign.FeignException;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FeignFallbackFactory implements FallbackFactory<IFeignServer> {

    @Override
    public IFeignServer create(Throwable cause) {
        return new FeingFallback(cause);
    }

    class FeingFallback implements IFeignServer{
        int code;
        String msg;
        ProfesorServicio ps = new ProfesorServicio();

        @Override
        public ResponseEntity<ProfesorOutputDTO> callServer(int idProfesor) {
            return ResponseEntity.status(code).body(new ProfesorOutputDTO(ps.buscarId(idProfesor).get()));
        }

        @Override
        public ResponseEntity<ProfesorOutputDTO> callServer1(Optional<Profesor> profesor) {
            return  ResponseEntity.status(code).body(new ProfesorOutputDTO(profesor.get()));
        }

        FeingFallback(Throwable cause){
            if(cause instanceof FeignException){
                FeignException feignException = (FeignException) cause;
                code = feignException.status();
            }
            msg= cause.getLocalizedMessage();
        }
    }
}
