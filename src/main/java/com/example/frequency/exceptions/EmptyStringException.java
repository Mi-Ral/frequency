package com.example.frequency.exceptions;

public class EmptyStringException extends RuntimeException {
    public EmptyStringException() {
        super("Input string cannot be empty.");
    }
}