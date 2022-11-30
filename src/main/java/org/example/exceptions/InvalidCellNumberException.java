package org.example.exceptions;

public class InvalidCellNumberException extends IndexOutOfBoundsException{
    public InvalidCellNumberException(String s) {
        super(s);
    }
}
