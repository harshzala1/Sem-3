
import java.util.*;
public class EvaluatePostfix {
    
  
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            
            if (Character.isDigit(c)) {
                stack.push(c - '0'); 
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                
                stack.push(opration(operand1,operand2,c));
              
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
    public static int opration(int operand1, int operand2, char c){
        switch(c) {
            case '+':
                return (operand1 + operand2);
            case '-':
                 return (operand1 - operand2);
            case '*':
                 return (operand1 * operand2);
            case '/':
                return (operand1 / operand2);
        }
        return 0;
        
    
    }
}