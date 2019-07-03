package com.example.cnccompiler.exceptions;

/**
 * ConfCannotToString
 */
public class ConfCannotToString extends RuntimeException {

    public ConfCannotToString()
    {
        super();
    }

    public ConfCannotToString(String msg)
    {
        super(msg);
    }
}