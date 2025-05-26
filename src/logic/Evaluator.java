/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import static logic.EvalHelper.*;

import java.util.*;


/**
 *
 * @author iya
 */
public class Evaluator {
    
    public static void main(String[] args) {
        
    }
    public static String eval (Queue infixQueue){
        
        //Infix

        int infixSize = 0;
        
        Stack stackPostfix = new Stack<>();
        
        Double Postfix;
        infixSize = infixQueue.size();
        
        //Postfix evaluation
        for(int i = 0; i<infixSize; i++){
            
            String token = String.valueOf(infixQueue.remove());
            
            if(isDigit(token)){
                
                stackPostfix.push(token);
                
            }else if(isOperator(token)&& !token.equals("%")&& !token.equals("√")){
                
                String operand2 = String.valueOf(stackPostfix.pop());
                String operand1 = String.valueOf(stackPostfix.pop());
                Postfix = Double.parseDouble(applyOperator(operand1, operand2, token));
                stackPostfix.push(String.valueOf(Postfix));
                    
            }else if(token.equals("%")){
                String operand1 = String.valueOf(stackPostfix.pop());
                Postfix = Double.parseDouble(percentage(operand1));
                stackPostfix.push(String.valueOf(Postfix));
                
            }else if (token.equals("√")){
                
                String operand1 = String.valueOf(stackPostfix.pop());
                Postfix = Double.parseDouble(squareroot(operand1));
                stackPostfix.push(String.valueOf(Postfix));
            
            }
            
        }
        String Complete = String.valueOf(stackPostfix.pop());
        
        return Complete;
        
    }
}
/* March 31, 2025 | 8:28 PM - Fix the so that the evaluated digit is thrown back on that specific location.
                              Then continue with the Shunting parenthesis reader. Also add the multiply function of 
                              parenthesis in shunting*/