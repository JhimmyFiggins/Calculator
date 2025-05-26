package logic;

import static java.lang.Math.pow;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author iya
 */
public class EvalHelper {
    
    
    public static boolean isOperator(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/") || t.equals("^") || t.equals("%") || t.equals("√");
    }

    public static boolean isDigit(String t) {
        return !isOperator(t) && !t.equals("(") && !t.equals(")");
    }
    
    public static boolean isDigitC(String t){
        return !t.equals ("+") && !t.equals ("-") && !t.equals ("*") && !t.equals ("/") && !t.equals ("^") && !t.equals ("(") && 
                !t.equals (")") && !t.equals("%") && !t.equals("√");
    }
    public static boolean isDigitP (String t){
        return !t.equals("+") && !t.equals("-") && !t.equals("*") && !t.equals("/") && !t.equals("^");
    }
    
    
    public static int getPrecedence(String operator){
        //checking the precedence of the top of stack
        
        switch(operator){
            
            case "-":
            case "+":
                return 1;
            case "/":
            case "*":
            case "%":
                return 2;
            case "^":
                return 3;
            case "√":
                return 4;
            case "(":
                return 0; 
            default:
                return 0;
        }
        
        
    }
    
    public static String applyOperator(String operand1, String operand2, String operator){
      
        BigDecimal result;
        BigDecimal exponent;
        BigDecimal op1 = new BigDecimal(operand1);
        BigDecimal op2 = new BigDecimal(operand2);
        
        switch(operator){
            
            case "-": result = op1.subtract(op2);
                return String.valueOf(result);
            case "+": result = op1.add(op2);
                return String.valueOf(result);
            case "/": result = op1.divide((op2),10, RoundingMode.HALF_UP);
                return String.valueOf(result);
            case "*": result = op1.multiply(op2);
                return String.valueOf(result);
            case "^": 
                double op1D = Double.parseDouble(operand1);
                double op2D = Double.parseDouble(operand2);
                result = BigDecimal.valueOf(pow(op1D, op2D));
                return String.valueOf(result);
            
            default:
                return null;
        }
    
    }
    public static String percentage(String digit){
        
        BigDecimal  op1 = new BigDecimal (digit);
        BigDecimal  dividend = new BigDecimal ("100");
        String  result = String.valueOf(op1.divide(dividend));
        
    return result;
    }
    
    public static String squareroot(String digit){
        BigDecimal op1 = new BigDecimal(digit);
        MathContext mc = new MathContext(10);
        BigDecimal result = op1.sqrt(mc);
        return String.valueOf(result);
    
    }
    
    public static boolean remainderC (String a){
    
        double digit = Double.parseDouble(a);
        double remainder = digit % 1;
        
    
    return remainder != 0;
    }
    
    
}


