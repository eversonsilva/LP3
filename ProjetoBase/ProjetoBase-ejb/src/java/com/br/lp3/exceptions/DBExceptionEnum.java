package com.br.lp3.exceptions;

/**
 *
 * @author 1147106
 */
public enum DBExceptionEnum {
    PERSIST_ERROR{
        @Override
        public String toString(){
            return "Erro na persistência!";
        } 
    }, 
    
    REMOVE_ERROR{
        @Override
        public String toString(){
            return "Erro na remoção!";
        } 
    }, 
    
    FIND_ERROR{
        @Override
        public String toString(){
            return "Erro na busca!";
        } 
    }
}
