import java.util.Collections;
import java.util.Stack;

public class InfixToPostfix {
    Stack<String> stackOperator = new Stack<String>();
    Stack<String> outStack = new Stack<String>();
    CheckNumber number =  new CheckNumber();
    Function function = new Function();
    Operator operators = new Operator();
    Priority priority = new Priority();
    public void insertParse(Stack<String> stack){
        Collections.reverse(stack);
        Parse(stack);
    }
    private void Parse(Stack<String> stack){
        while (!stack.empty()){
            String token = stack.pop();
            if(number.isNum(token)){
                outStack.add(token);
                continue;
            }
            if(function.checkIsFunc(token)){
                if(token.equals("max") || token.equals("min")){
                    outStack.add(";");
                }
                stackOperator.add(token);
                continue;
            }
            if(token.equals(";")){
                while (!stackOperator.empty()
                        &&
                        !stackOperator.lastElement().equals("(")){
                    outStack.add(stackOperator.pop());
                }
                continue;
            }
            if(operators.Operators.contains(token)){
                while (!stackOperator.empty() &&
                        operators.Operators.contains(stackOperator.lastElement())
                        &&(priority.GetPriority(token) <= priority.GetPriority(stackOperator.lastElement()))
                        ){
                    outStack.add(stackOperator.pop());
                }
                stackOperator.add(token);
                continue;
            }
            if(token.equals("(")){
                stackOperator.add(token);
                continue;
            }
            if(token.equals(")")){
                while (!stackOperator.empty()){
                    if(stackOperator.peek().equals("(")){
                        stackOperator.pop();
                        break;
                    } else {
                        outStack.add(stackOperator.pop());
                    }
                }

                if(!stackOperator.empty()){
                    if(function.checkIsFunc(stackOperator.peek())){
                        outStack.add(stackOperator.pop());
                    }
                }
            }
            if(!stackOperator.empty()){
                while (stackOperator.empty()){
                    outStack.add(stackOperator.pop());
                }
            }
        }
        Collections.reverse(outStack);
    }
}
