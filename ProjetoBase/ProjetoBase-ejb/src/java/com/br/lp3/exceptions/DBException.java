package com.br.lp3.exceptions;

/**
 *
 * @author 1147106
 */
public class DBException extends RuntimeException{
    
    public DBException(DBExceptionEnum msg){
        super(msg.toString());
    }
    
}
