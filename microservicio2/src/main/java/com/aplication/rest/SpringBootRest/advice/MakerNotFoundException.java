package com.aplication.rest.SpringBootRest.advice;

public class MakerNotFoundException extends RuntimeException {
    public MakerNotFoundException(Long id) {
        super("No se encontró el Maker con id: " + id);
    }
}
