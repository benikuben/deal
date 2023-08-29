package ru.neoflex.deal.exceptions;

public class ApplicationStatusException extends RuntimeException {
    public ApplicationStatusException() {
        super("Application cannot be processed due to its status");
    }
}
