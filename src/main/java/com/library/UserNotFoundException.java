package com.library;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String message){
        super(message);
    }
}
