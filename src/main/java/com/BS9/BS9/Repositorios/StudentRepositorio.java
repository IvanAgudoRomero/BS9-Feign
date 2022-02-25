package com.BS9.BS9.Repositorios;

import com.BS9.BS9.POJOs.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositorio extends JpaRepository<Student, Integer> {
    //public Optional<Student> findById(int id_student);
    //@Query("delete from student where student.id_student=?1")
    //public void deleteById(int id_persona);
}
