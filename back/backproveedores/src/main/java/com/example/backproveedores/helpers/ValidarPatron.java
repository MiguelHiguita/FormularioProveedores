package com.example.backproveedores.helpers;

import org.springframework.stereotype.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidarPatron {

    public ValidarPatron() {
    }

    public boolean validarPatron(String cadenaEvaluar, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cadenaEvaluar);

        if (matcher.matches()){
            return true;
        }else {
            return false;
        }
    }
}
