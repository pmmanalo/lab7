import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

/**
 * Lab07: Reverse Polish Notation
 * @author [Paulo Manalo]
 * @date [4/10/22]
 */

public class RPN {

   public static int evalRPN(List<String> tokens) {
       Stack<Integer> rpn = new Stack<>(); //initialize stack
       String num = "[0-9]+";
       Pattern patt = Pattern.compile(num);
       for (String input : tokens) {
           Matcher match = patt.matcher(input);

           //if statements to check for arithmetic
            if (input == "-") {
               if (rpn.size() < 2) {

                   System.out.println("stack size should be 2");
               }
               int a = rpn.pop();
               int b = rpn.pop();
               rpn.push((b - a));
           }
            else if (input == "+") {
               if (rpn.size() < 2) {
                   System.out.println("stack size should be 2");
               }
               int a = rpn.pop();
               int b = rpn.pop();
               rpn.push((a + b));
           }
            else if (input == "/") {
               if (rpn.size() < 2) {

                   System.out.println("stack size should be 2");
               }
               int a = rpn.pop();
               int b = rpn.pop();
               if (a == 0) {
                   throw new NumberFormatException();
               }
               rpn.push((b / a));
           } 
            else if (input == "*") {
               if (rpn.size() < 2) {

                   System.out.println("stack size should be 2");
               }
               int a = rpn.pop();
               int b = rpn.pop();
               rpn.push((a * b));
           }  
            else if (match.matches()) {
               rpn.push(Integer.valueOf(input));
           }

       }
       return rpn.peek();
   }

   public static void main(String[] args) {
	   List<String> tokens = new LinkedList<String>(Arrays.asList("10","6","9","3","+","-11","*","/","17","+","5","+"));
	      System.out.println("Given the array of tokens: " + tokens);
	      System.out.println("Expected output: " + 22);
	      System.out.println("Actual output: " + evalRPN(tokens));
	      
	      tokens = new LinkedList<String>(Arrays.asList("4","13","5","/","+"));
	      System.out.println("Given the array of tokens: " + tokens);
	      System.out.println("Expected output: " + 6);
	      System.out.println("Actual output: " + evalRPN(tokens));
	      
	      tokens = new LinkedList<String>(Arrays.asList("2","1","+","3","*"));
	      System.out.println("Given the array of tokens: " + tokens);
	      System.out.println("Expected output: " + 9);
	      System.out.println("Actual output: " + evalRPN(tokens));
   }

}