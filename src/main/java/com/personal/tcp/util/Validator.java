package com.personal.tcp.util;

public class Validator {

    public static boolean validateMessage(String message){
        boolean isValid = false;
        System.out.println("Validator.validateMessage() - Validating message recieved: " + message);



        System.out.println("Validator.validateMessage() - Validation result: " + isValid);
        return isValid;
    }

}
