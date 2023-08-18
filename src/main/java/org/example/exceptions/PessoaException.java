package org.example.exceptions;

public class PessoaException extends Exception {
    public PessoaException (String str)
    {
        // calling the constructor of parent Exception
        super(str);
    }
}
