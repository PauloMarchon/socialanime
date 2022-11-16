package com.socialanime.core.exception;

public class UsernameAlreadyUsedException extends Exception{

    public UsernameAlreadyUsedException(String username){
        super("The username "+ username + " is already in use, please try another");
    }
}
