/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author iya
 */




import static logic.Infix.toInfix;
import static logic.Postfix.ShuntingAlgo;
import static logic.EvalHelper.remainderC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Main implements ActionListener{
    
    JFrame frame;
    JTextField computation;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[13];
    JButton addButton, subButton, multiButton, divButton;
    JButton leftbButton, rightbButton;
    JButton clrButton, delButton;
    JButton perButton, rsButton, sqrButton;
    JButton decButton, equButton;
    
    
    JPanel numpad; 
 
    Queue queue = new LinkedList();
    //Font fontier = new Font("Ink Free", Font.Bold,30);
    //Have tackled the idea about these codeblocks
    double num1=0, num2=0, result=0;
    char operator;
    
        
        
    
    Main(){
        
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        
        //For display
        computation = new JTextField();
        computation.setBounds(50, 25, 300, 50);
        //textfield.setFont(myfont);
        computation.setEditable(false);
        
        //For system to base on
        computation = new JTextField();
        computation.setBounds(50, 25, 300, 50);
        //textfield.setFont(myfont);
        computation.setEditable(false);
        computation.setVisible(true);
        
        
        //Renaming the button with symbols
        addButton = new JButton("+");
        subButton = new JButton("-");
        multiButton = new JButton("x");
        divButton = new JButton("/");
        
        clrButton = new JButton("CE");
        delButton = new JButton("Del");
        
        leftbButton = new JButton("(");
        rightbButton = new JButton(")");
        rsButton = new JButton("^");
        sqrButton = new JButton("sqr");
        perButton = new JButton("%");
        
        
        decButton = new JButton(".");
        equButton = new JButton("=");
        
        //Assigning of buttons to array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiButton;
        functionButtons[3] = divButton;
        
        functionButtons[4] = clrButton;
        functionButtons[5] = delButton;
        
        functionButtons[6] = leftbButton;
        functionButtons[7] = rightbButton;
        
        
        functionButtons[8] = rsButton;
        functionButtons[9] = sqrButton;
        functionButtons[10] = perButton;
        
        functionButtons[11] = decButton;
        functionButtons[12] = equButton;
        
        // No idea how this works
        for (int i =0; i<=12; i++){
            functionButtons[i].addActionListener(this);
            //functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);
        }
        for (int i =0; i<=9; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            /*functionButtons[i].setFont(myfont);
            numberButtons[i].setOpaque(false);
            numberButtons[i].setContentAreaFilled(false);
            numberButtons[i].setBorderPainted(false);*/
            numberButtons[i].setFocusable(false);
        }
        
    
        numpad = new JPanel();
        numpad.setBounds(50, 100, 300, 300);
        numpad.setLayout(new GridLayout(6, 4, 7, 7));
       //s numpad.setBackground(Color.PINK);
        
        
        numpad.add(perButton);
        numpad.add(rsButton);
        numpad.add(clrButton);
        numpad.add(delButton);
        
        numpad.add(sqrButton);
        numpad.add(leftbButton);
        numpad.add(rightbButton);
        numpad.add(divButton);
        
        numpad.add(numberButtons[7]);
        numpad.add(numberButtons[8]);
        numpad.add(numberButtons[9]);
        numpad.add(multiButton);
        numpad.add(numberButtons[4]);
        numpad.add(numberButtons[5]);
        numpad.add(numberButtons[6]);
        numpad.add(subButton);
        numpad.add(numberButtons[1]);
        numpad.add(numberButtons[2]);
        numpad.add(numberButtons[3]);
        numpad.add(addButton);

        numpad.add(numberButtons[0]);
        numpad.add(decButton);
        numpad.add(equButton);
    
        
        frame.add(numpad);
        frame.add(computation);
        frame.add(computation);
        frame.setVisible(true);
        
        
    }
    
    public static void main(String[] args){
        
        Main calc = new Main();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        for(int i=0; i<=9; i++){
            if(e.getSource() == numberButtons[i]){
                computation.setText(computation.getText()+(String.valueOf(i)));
                
            }
        }
            // other function buttons 
        
        if (e.getSource() == decButton){
          
            computation.setText(computation.getText()+".");
        }
        if (e.getSource() == addButton){
            String Textfield = computation.getText();
            int TextfieldL = Textfield.length();
            String token = String.valueOf(Textfield.charAt(TextfieldL-1));
            if(token.equals("-")){
                computation.setText("");
                    for(int j=0; j<TextfieldL-1; j++){
                        computation.setText(computation.getText()+Textfield.charAt(j));
                    }computation.setText(computation.getText()+"+");
            }else{
                computation.setText(computation.getText()+"+");
            }
            
        }
        if (e.getSource() == subButton){
            String Textfield = computation.getText();
            int TextfieldL = Textfield.length();
            String token = String.valueOf(Textfield.charAt(TextfieldL-1));
            if(token.equals("+")){
                computation.setText("");
                    for(int j=0; j<TextfieldL-1; j++){
                        computation.setText(computation.getText()+Textfield.charAt(j));
                    }computation.setText(computation.getText()+"-");
            }else{
                computation.setText(computation.getText()+"-");
            }
        }
        if (e.getSource() == multiButton){
            computation.setText(computation.getText()+"*");
            
        }
        if (e.getSource() == divButton){
            computation.setText(computation.getText()+"/");
            
        }
        if (e.getSource() == rsButton){
           
            computation.setText(computation.getText()+"^");
            
        }
        if (e.getSource() == sqrButton){
        
            computation.setText(computation.getText()+"√");
        }
        if (e.getSource() == leftbButton){
            
            computation.setText(computation.getText()+"(");
            
        }
        if (e.getSource() == rightbButton){
            
            computation.setText(computation.getText()+")");
            
        }
        if (e.getSource() == perButton){
            
            computation.setText(computation.getText()+"%");
            
        }
        if(e.getSource() == equButton){
           
            String temp = computation.getText();
            Queue infix = new LinkedList(toInfix(temp));
            
            double total = Double.parseDouble(ShuntingAlgo(infix));
            String totalS = String.valueOf(total);
            int    totalInt = (int) total;
            if(remainderC(totalS)){
            
                computation.setText(String.valueOf(total));
                
            }else if(!remainderC(totalS)){
            
                computation.setText(String.valueOf(totalInt));
            
            }
        }
            
        
        if(e.getSource() == clrButton){
            
            computation.setText("");
        }
        //uncomplete function
        
        if(e.getSource() == delButton){
            String computing = computation.getText();
            computation.setText("");
            
            for(int i=0; i<computing.length()-1; i++){
                computation.setText(computation.getText()+computing.charAt(i));
               
            }          
        }
        
        
        
    }
}

// February 27, 2025 - Left on numpad 
// Thinking of putting other function buttons together with numbers

// March 4, 2025 - Find a font to use and find ways to compute the values more than 2
// April 27, 2025 - Found what's missing in the program. Fix negative numbers and add percentage function.
// April 29, 2025 - Coded negative function. Add percentage function next time.
// April 30, 2025 - Finished all the function of the function buttons and founded that PEMDAS works differently.
// May 14, 2025 - Input "(-)" when clicking "-" beside operators except parenthesis. Then make a function for "(-)".
// May 15, 2025 - Don't need to fix the (-). I found that subtracting numbers with decimal gives different type of shi.
//                apply BigDecimal on double value.
// May 17, 2025 - Made some changes in eval using BigDecimal for more accurate answer. Added remainder Check in EvalHelper.
//                Arrange the proper system of the calculator for finishing product.
// May 26, 2025 - Pushing this project into github for experimentation.