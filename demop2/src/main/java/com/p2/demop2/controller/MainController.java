package com.p2.demop2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.p2.demop2.Repository.AutorRepository;
import com.p2.demop2.Repository.EditorialRepository;
import com.p2.demop2.Repository.LibroRepository;
import com.p2.demop2.dto.LibroRequest;
import com.p2.demop2.entidad.Autor;
import com.p2.demop2.entidad.Libro;
import com.p2.demop2.entidad.Editorial;

@Controller
public class MainController {

	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private EditorialRepository editorialRepository;
	
	@Autowired
	private LibroRepository libroRepository;
	
	@QueryMapping
	public List<Libro> listadoLibros(){
		return libroRepository.findAll();
	}
	
    @QueryMapping
    public Libro listadoLibrosPorId(@Argument String id) {
        return libroRepository.findById(id).orElse(null);
    }
    
	@MutationMapping
	public void eliminarLibro(@Argument String id) {
		libroRepository.deleteById(id);
	}
	
    @MutationMapping
    public Libro actualizarLibros(@Argument String id,@Argument LibroRequest libroRequest) {
        Autor autor = autorRepository.findById(libroRequest.autor_id()).orElse(null);
        Editorial editorial = editorialRepository.findById(libroRequest.editorial_id()).orElse(null);
        Libro libroBds = new Libro();
        
        libroBds.setId(id);
        libroBds.setTitulo(libroRequest.titulo());
        libroBds.setDescripcion(libroRequest.descripcion());
        libroBds.setPaginas(libroRequest.paginas());
        libroBds.setEdicion(libroRequest.edicion());
        libroBds.setAutor(autor);
        libroBds.setEditorial(editorial);

        return libroRepository.save(libroBds);
    }
}
