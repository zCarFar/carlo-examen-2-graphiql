package com.p2.demop2.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Libro {

	@Id
	private String id;
	private String titulo;
	private String descripcion;
	private int paginas;
	private String edicion;
	
	@ManyToOne
    @JoinColumn(name="id_autor")
    private Autor autor;
	
	@ManyToOne
    @JoinColumn(name="id_editorial")
    private Editorial editorial;
}
