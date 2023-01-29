package ru.hukola.servicer.exception;

/**
 * @author Babin Nikolay
 */
public class NotFoundException extends Exception{
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
