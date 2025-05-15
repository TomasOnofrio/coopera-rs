package com.coopera_rs.application.exceptions;

public class InvalidPassword extends RuntimeException {
    public InvalidPassword () {
        super("Senha inválida");
    }
}
