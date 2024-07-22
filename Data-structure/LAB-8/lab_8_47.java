
import java.util.*;
public class EvaluatePostfix {
    
    // Function to evaluate postfix expression
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            
            if (Character.isDigit(c)) {
                stack.push(c - '0'); 
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                
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
        
        return stack.pop();
    }
    public static void main(String[] args) {
        String postfixExpression = "23*54*+9-";
        int result = evaluatePostfix(postfixExpression);
        
        System.out.println("Postfix Expression: " + postfixExpression);
        System.out.println("Result of Evaluation: " + result);
    }
}