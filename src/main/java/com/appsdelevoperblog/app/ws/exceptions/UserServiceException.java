package com.appsdelevoperblog.app.ws.exceptions;

public class UserServiceException  extends RuntimeException{

    private static final long serialVersionUID = -370131327740618578L;

    public UserServiceException(String message) {
        super(message);
    }
}
