package com.sideralti.app.exceptions;

public class MesaNotFoundException extends RuntimeException {
    public MesaNotFoundException(Long id) {
        super("Mesa not found with id: " + id);
    }
}