package logic;





import static logic.EvalHelper.*;
import static logic.Evaluator.eval;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;


// Make a method like this and add some code to get the string from the calculator, for easy input.
public class Postfix {
    public static void main(String[] args) { 
        
    }
    public static String ShuntingAlgo (Queue infixQueue){

        
        int infixSize;
        
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        
        
        Stack<String> precedenceRef =(Stack<String>) stack.clone();
        Stack<String> previousParen = new Stack<>();
        Stack<String> previousToken = new Stack<>();
        
        
        
        int precedenceStack, precedenceToken, temp = 10 ,stackSize = 0;
        
        infixSize = infixQueue.size();
        
        
        for (int i = 0; i<infixSize; i++){
            
            String token = String.valueOf(infixQueue.remove());
            boolean decide = isOperator(token);
            
            
            if(!decide && !token.equals("(") && !token.equals(")")){
                
                queue.offer(token);
                previousToken.push(token);
                
            }else if(decide && !token.equals("(") && !token.equals(")")){
                
                if(stack.isEmpty()){
                    stack.push(token);
                    previousToken.push(token);
                
                }else{

                    precedenceToken = getPrecedence(token);
                    precedenceStack = getPrecedence(stack.peek());
                    
                    if(precedenceToken > precedenceStack){
                        stack.push(token);
                        previousToken.push(token);
                    }else if(precedenceToken == precedenceStack){
                        
                        queue.offer(stack.pop());
                        stack.push(token);
                        
                        previousToken.push(token);
                    }else if(precedenceToken < precedenceStack){
                  
                        
                        precedenceRef =(Stack<String>) stack.clone();
                        stackSize = stack.size();
                       
                        
                        for(int k = 0; k<stackSize; k++){
                                   precedenceToken = getPrecedence(token);
                                   precedenceStack = getPrecedence(precedenceRef.peek());
                                   
                                   if(precedenceToken <= precedenceStack){
                                       
                                       temp = k;
                                       precedenceRef.pop();                   
                                       
                                   }else if(precedenceToken >= precedenceStack){
                                       
                                   }
                        }
              
                        for (int j = 0; j<=temp; j++){
                            
                            queue.offer(stack.pop());
                        }
                            stack.push(token);
                            previousToken.push(token);
                    }
                    
                }
                
            }else if(token.equals("(")){
                
                stack.push(token);
                if(!previousToken.isEmpty())
                previousParen.push(previousToken.pop());
                
                previousToken.push(token);
                
        
            }else if (token.equals(")")){
                
                
                stackSize = stack.size();
                for(int j = 0; j<stackSize; j++){
                
                    String tokenP = stack.pop();
                    
                    if (tokenP.equals("(")){
                        
                        j = stackSize;
                        
                    }else if(!tokenP.equals("(")){
                    
                        queue.offer(tokenP);
                    }
                
                }
                
                    if(!previousParen.isEmpty()){
                        
                        if(isDigitP(previousParen.peek()) /*|| previousParen.peek().equals(")")*/){
                        
                        queue.offer("*");
                        }
                        
                        if(!infixQueue.isEmpty()){
                    
                            if(isDigitP(String.valueOf(infixQueue.element()))){

                                queue.offer(String.valueOf(infixQueue.remove()));
                                queue.offer("*");
                                i++;
                            }
                        }
                    }else if(!infixQueue.isEmpty()){
                    
                        if(isDigitP(String.valueOf(infixQueue.element()))){

                            queue.offer(String.valueOf(infixQueue.remove()));
                            queue.offer("*");
                            i++;
                        }
                    
                        if(!previousParen.isEmpty()){
                            if(isDigitP(previousParen.peek()) || token.equals(")")){

                            queue.offer("*");

                            }
                        }
                    }
                
                previousToken.push(token);
            }   
            
        }
        //Postfix
       
        stackSize = stack.size();
        
        for(int i = 0; i<stackSize; i++){
            
            queue.offer(stack.pop());
            
        }
        
      
        
        
        
     return eval(queue);    
    }
    
    
    
    
}
//March 20, 2025 | 3:28 - made a postfix using limited logic only. Add exponent and parenthesis next time(tomorrow)
//March 21, 2025 | 6:53 - Apply parenthesis in this code and make a postfix evaluator for *chefkiss
//April 2, 2025 | 2:05 - Fixed and cleaned the code. Finish the parenthesis by using pop() until you reach closest "("
//April 7, 2025 | 2:29 - Finally fixed and completed the parenthesis function. Apply shunting algo 
//                       to your calculator tomorrow or later. Congratulations and Thank you <3.
//April 18, 2025 |3:23 - Fixed some errors in shunting and EvalHelper. Fully implement the algorithm to calculator, then
//                       input parenthesis in gui in the calculator. Also add the ^ function.