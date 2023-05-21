package com.p2.demop2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p2.demop2.entidad.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
