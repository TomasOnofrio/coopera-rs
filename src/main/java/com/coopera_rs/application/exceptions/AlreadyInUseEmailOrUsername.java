package com.coopera_rs.application.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class AlreadyInUseEmailOrUsername extends RuntimeException {

    private final List<String> errors;

    public AlreadyInUseEmailOrUsername ( List<String> errors ) {
        super("Erro de Validação");
        this.errors = errors;
    }


}
