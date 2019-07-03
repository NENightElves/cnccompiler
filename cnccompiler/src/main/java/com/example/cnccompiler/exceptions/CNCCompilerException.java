package com.example.cnccompiler.exceptions;

public class CNCCompilerException extends RuntimeException {

    public CNCCompilerException() {
        super();
    }
    
    public CNCCompilerException(String msg) {
        super(msg);
    }

}