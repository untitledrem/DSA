import java.util.*;
public class EquationSolver 
{
    public static void main (String args[])
    {
        Scanner sc = new Scanner (System.in);

        System.out.println("Please enter your equation, with all elements separated by a space: ");

        String equation = sc.nextLine();
        double ans = solve(equation);

        System.out.println("The answer is: " + ans);
        sc.close();
    }
   
    // Method to combine supporting methods and provide answer
    public static double solve(String equation)
    {
        return evalPostfix(parseInfixtoPostfix(equation));

    }
    
    // Parse String equation from user to a Stack 
    private static DSAStack parseInfixtoPostfix (String equation)
    {
        String[] array = parseString(equation);
        DSAStack postFix = new DSAStack(array.length);
        DSAStack opStack = new DSAStack(array.length);
        int i = 0;
        String term;

        while (i < array.length) 
        {
            term = array[i];

            if (term.equals("("))
            {
                opStack.push(term);
            }

            else if (term.equals(")")) 
            {
                while (!opStack.top().equals("(")) 
                {
                    postFix.push(opStack.pop());
                }
                opStack.pop();
            }

            else if (isOperator(term)) 
            {
                while (!opStack.isEmpty() && (String) opStack.top() != "(" && (precedence((String) opStack.top()) >= precedence(term))) 
                {
                    postFix.push(opStack.pop());
                }
                opStack.push(term);
            }

            else
            {
                postFix.push(term);
            }

            i++;
        }

        while (!opStack.isEmpty()) 
        {
            postFix.push(opStack.pop());
        }

        return postFix;
    }

    // Helper method to provide precedence value to different operator types
    private static int precedence (String term)
    {
        if (term.equals("+") || term.equals("-"))
        {
            return 1;
        }
        
        if (term.equals("*") || term.equals("/"))
        {
            return 2;
        }
        
        if (term.equals("^"))
        {
            return 3;
        }
        
        else
        {
            return 0;
        }
    }

    // Parse initial equation into a String[] of individual values 
    private static String[] parseString(String equation)
    {
        String[] array = equation.split(" ");
        return array;
    }

    // Helper method for checking for operators
    private static boolean isOperator(String term)
    {
        if (term.equals("+") || term.equals("-") || term.equals("*") || term.equals("/") || term.equals("^"))
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    // Create new stack to evaluate the PostFix formed after parsing and provide final answer
    private static double evalPostfix(DSAStack postFixStack)
    {
        DSAStack evaluateStack = new DSAStack(postFixStack.getCount());
        String term;

        for (int i = 0; i < postFixStack.count; i++)
        {   
            term = (String) postFixStack.stack[i];
            if (!isOperator(term))
            {
                evaluateStack.push(postFixStack.stack[i]);
            }

            if (isOperator(term))
            {
                double op2 = new Double(evaluateStack.pop().toString());
                double op1 = new Double (evaluateStack.pop().toString());
                double answer = executeOperation(term, op1, op2);
                evaluateStack.push(answer);
            }
        }

        return (Double) evaluateStack.pop();

    }
    
    // Execute operators on items on the stack
    private static double executeOperation(String operator, double op1, double op2)
    {
        switch (operator) 
        {
            case "+":
                return op1 + op2;
            
            case "-":
                return op1 - op2;
            
            case "*":
                return op1 * op2;
            
            case "/":
                return op1 / op2;
            
            case "^":
                return Math.pow(op1, op2);
        }

        return 0;
    }
}


    