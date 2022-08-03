package com.ssafy.colors.util;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ValidationChecker {

    public boolean idValidationCheck(String inputId) {
        return validationCheck(inputId, 6);
    }

    public boolean pwdValidationCheck(String inputPwd) {
        return validationCheck(inputPwd, 8);
    }

    public boolean validationCheck(String str, int length) {
        if(str.length() < length) {
            return false;
        } else {
            boolean containNumeric = str.matches(".*[0-9].*");
            boolean containAlphabet = str.matches(".*[a-zA-Z].*");
            return containNumeric && containAlphabet;
        }
    }
}
