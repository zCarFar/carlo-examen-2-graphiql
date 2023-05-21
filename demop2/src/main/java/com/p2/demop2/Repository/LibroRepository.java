package com.p2.demop2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p2.demop2.entidad.Libro;

public interface LibroRepository extends JpaRepository<Libro, String> {

}
