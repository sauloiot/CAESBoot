package com.ghost.caesboot.services.exception;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1l;

    public ObjectNotFoundException(String msg){
        super(msg);
    }

}
