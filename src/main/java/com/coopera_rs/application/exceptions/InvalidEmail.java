package com.coopera_rs.application.exceptions;

public class InvalidEmail extends RuntimeException {
    public InvalidEmail() {super("Email não encontrado ou inválido.");}
}
