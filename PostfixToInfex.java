/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.postfixtoinfex;

import java.util.Stack;

/**
 *
 * @author PC LAND
 */
public class PostfixToInfex {
    static boolean isOperand(char x)
{
    return (x >= '1' && x <= '9') 
          ;
}
 
// Get Infix for a given postfix
// expression
static String getInfix(String exp)
{
    Stack<String> s = new Stack<String>();
 
    for (int i = 0; i < exp.length(); i++)
    {
        // Push operands
        if (isOperand(exp.charAt(i)))
        {
        s.push(exp.charAt(i) + "");
        }
 
        // We assume that input is
        // a valid postfix and expect
        // an operator.
        else
        {
            String op1 = s.peek();
            s.pop();
            String op2 = s.peek();
            s.pop();
            s.push("(" + op2 + exp.charAt(i) +
                    op1 + ")");
        }
    }
 
    // There must be a single element
    // in stack now which is the required
    // infix.
    return s.peek();
}

    public static void main(String[] args) {
      String exp = "823^/23*+51*-";
    System.out.println( getInfix(exp));
    }
}
