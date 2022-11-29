package org.example.exceptions;

public class NonExistentElementException extends IllegalArgumentException{
    public NonExistentElementException(String s) {
        super(s);
    }
}
