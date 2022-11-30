package org.example.exceptions;

public class EmptyArgumentException extends IllegalArgumentException{
    public EmptyArgumentException(String s) {
        super(s);
    }
}
