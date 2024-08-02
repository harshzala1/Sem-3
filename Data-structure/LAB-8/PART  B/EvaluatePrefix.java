// 48. Write a program for evaluation of prefix Expression using Stack.

import java.util.*;

public class EvaluatePrefix {
    
    // Function to evaluate prefix expression
    public static int evaluatePrefix(String prefix) {
        Stack<Integer> stack = new Stack<>();
        
        // Reverse the prefix expression
        String reversedPrefix = reverseString(prefix);
        
        // Iterate through each character in the reversed prefix expression
        for (int i = 0; i < reversedPrefix.length(); i++) {
            char c = reversedPrefix.charAt(i);
            
            // If character is operand, push it onto stack
            if (Character.isDigit(c)) {
                stack.push(c - '0'); // Convert char to int
            } else {
                // Character is operator, pop top two elements from stack and perform operation
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                
                switch(c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }
        
        // Result will be the only element left in the stack
        return stack.pop();
    }
    
    // Function to reverse a string
    private static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }
    
    // Main method to test the evaluatePrefix function
    public static void main(String[] args) {
        String prefixExpression = "-+*23*549";
        int result = evaluatePrefix(prefixExpression);
        
        System.out.println("Prefix Expression: " + prefixExpression);
        System.out.println("Result of Evaluation: " + result);
    }
}
