package com.p2.demop2.dto;

public record LibroRequest(
        Integer id,
        String titulo,
        String descripcion,
        Integer paginas,
        String edicion,
        Long autor_id,
        Long editorial_id
		) {

}
