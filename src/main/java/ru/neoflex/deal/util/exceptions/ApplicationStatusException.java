package ru.neoflex.deal.util.exceptions;

public class ApplicationStatusException extends RuntimeException {
    public ApplicationStatusException() {
        super("Application cannot be processed due to its status");
    }
}
