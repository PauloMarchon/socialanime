package com.socialanime.core.exception;

public class EmailAlreadyRegisteredException extends Exception{

    public EmailAlreadyRegisteredException(){
        super("the email provided has already been used");
    }
}
