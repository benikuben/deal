package ru.neoflex.deal.util.exceptions;

public class InvalidSesCodeException extends RuntimeException {
    public InvalidSesCodeException() {
        super("Invalid ses code was sent");
    }
}
