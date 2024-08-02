import java.util.*;

public class InfixToPrefix {
    
    // Function to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    // Function to determine precedence of operators
    private static int precedence(char operator) {
        switch(operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
    
    // Function to reverse a string
    private static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }
    
    // Function to convert infix expression to prefix expression
    public static String infixToPrefix(String infix) {
        // Step 1: Reverse the infix expression
        String reversedInfix = reverseString(infix);
        
        // Step 2: Modify the reversed infix expression
        StringBuilder modifiedInfix = new StringBuilder();
        for (int i = 0; i < reversedInfix.length(); i++) {
            char c = reversedInfix.charAt(i);
            
            if (c == '(') {
                modifiedInfix.append(')');
            } else if (c == ')') {
                modifiedInfix.append('(');
            } else {
                modifiedInfix.append(c);
            }
        }
        
        // Step 3: Convert modified infix expression to postfix expression
        String postfix = infixToPostfix(modifiedInfix.toString());
        
        // Step 4: Reverse the postfix expression to get prefix expression
        String prefix = reverseString(postfix);
        
        return prefix;
    }
    
    // Function to convert infix expression to postfix expression
    private static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            
            // If character is operand, add it to postfix
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }
            // If character is '(', push it to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If character is ')', pop and add to postfix until '(' is encountered
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Pop '(' from stack (and discard it)
            }
            // If character is operator
            else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        
        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        
        return postfix.toString();
    }
    
    // Main method to test the infixToPrefix function
    public static void main(String[] args) {
        String infixExpression = "((A + B) * C - D) / E";
        String prefixExpression = infixToPrefix(infixExpression);
        
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Prefix Expression: " + prefixExpression);
    }
}
