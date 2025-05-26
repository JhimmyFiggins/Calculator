/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import static logic.EvalHelper.isDigitC;
import java.util.*;

/**
 *
 * @author iya
 */
public class Infix {
    
    public static Queue toInfix (String expression){
    
        Queue infix = new LinkedList();
        String complete = "";
        
        for(int i = 0; i<expression.length(); i++){
            
            char token = expression.charAt(i);
            boolean decide = isDigitC(String.valueOf(expression.charAt(i)));
            
            
            
            if(decide){
            
                complete = complete + token;
                
                if(i == expression.length()-1){
                
                    infix.offer(complete);
                    
                }
                
            }else if(!decide ){
                
                if(complete.isEmpty()){
                
                    complete = String.valueOf(token);
                    
                    if(complete.equals("-")){
                    
                        complete = complete + expression.charAt(i+1);
                        i++;
                    }else if(complete.equals("(") ||complete.equals(")") ){
                    
                        infix.offer(complete);
                        complete="";
                        
                    }else{
                        
                        infix.offer(complete);
                        complete="";
                    
                    }
                }else if (String.valueOf(token).equals("%")){
                    
                    infix.offer(complete);
                    complete = String.valueOf(token);
                    infix.offer(complete);
                    complete="";
                
                }else{
                    
                    infix.offer(complete);
                    complete = String.valueOf(token);
                    infix.offer(complete);
                    complete="";
                }
                
                
                
                
                
                
                
            }
            
            
        } 
        
        return infix;
    }
    
    
    
}
