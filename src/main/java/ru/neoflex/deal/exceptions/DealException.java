package ru.neoflex.deal.exceptions;

public class DealException extends RuntimeException {
    public DealException() {
        super("Unexpected error");
    }
}