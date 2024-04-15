package com.example;

import java.util.Stack;

public class Expresion {

    public static Boolean expresion(String frase){
        Stack<Integer> stack = new Stack<>();
        if (frase == null){
            return false;
        }
        char[] stringToChar = frase.toCharArray();
        for (char c : stringToChar) {
            if(c == '{'){
                stack.push(1);
            }
            if(c == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.isEmpty()){         
            return true;
        } else {
            return false;
        }
    }
    
}
