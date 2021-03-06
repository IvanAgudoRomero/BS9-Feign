package com.BS9.BS9.Repositorios;

import com.BS9.BS9.POJOs.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
@Repository
public interface ProfesorRepositorio extends JpaRepository<Profesor, Integer> {
    public Optional<Profesor> findById(int id_profesor);
    public void deleteById(int id_profesor);
}
