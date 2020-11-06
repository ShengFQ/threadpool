package com.shengfq.exception.test;

import com.shengfq.exception.EnrichableException;
import com.shengfq.exception.ExceptionHandler;

public class ExceptionTest {
	
    protected ExceptionHandler exceptionHandler = new ExceptionHandler(){
        public void handle(String errorContext, String errorCode,
                           String errorText, Throwable t){

            if(! (t instanceof EnrichableException)){
                throw new EnrichableException(
                    errorContext, errorCode, errorText, t);
            } else {
                ((EnrichableException) t).addInfo(
                    errorContext, errorCode, errorText);
            }
        }

        public void raise(String errorContext, String errorCode,
                          String errorText){
            throw new EnrichableException(
                errorContext, errorCode, errorText);
        }
    };

    public static void main(String[] args){
        ExceptionTest test = new ExceptionTest();
        try{
            test.level1();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void level1(){
        try{
            level2();
        } catch (EnrichableException e){
            this.exceptionHandler.handle(
                "L1", "E1", "Error in level 1, calling level 2", e);
            throw e;
        }
    }

    public void level2(){
        try{
            level3();
        } catch (EnrichableException e){
            this.exceptionHandler.handle(
                "L2", "E2", "Error in level 2, calling level 3", e);
            throw e;
        }
    }

    public void level3(){
        try{
            level4();
        } catch(Exception e){
            this.exceptionHandler.handle(
                "L3", "E3", "Error at level 3", e);
        }
    }

    public void level4(){
        throw new IllegalArgumentException("incorrect argument passed");
    }

}