
import java.util.Stack;

public class Calculation {
    public Stack<String> AnswerStack = new Stack<String>();
    public String Answer = "";
    public String ErrorMessage = "";
    CheckNumber checkNumber = new CheckNumber();
    Function function = new Function();
    Operator operators = new Operator();

    public boolean calc(Stack stack){
        return calculations(stack);
    }
    private boolean calculations(Stack stack){
        while (!stack.empty()){
            String token = String.valueOf(stack.pop());
            if(checkNumber.isNum(token)){
                AnswerStack.push(token);
                continue;
            }
            if(operators.checkOper(token)){
                if(AnswerStack.size() >= 2){
                    if(operators.insertToCalc(token, AnswerStack)){
                        AnswerStack = operators.OperandStack;
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    ErrorMessage = "Неверное записанное выражение!! Недостаточно операндов " + AnswerStack.pop() + token + AnswerStack.pop();
                    return false;
                }
            }
            if(function.checkIsFunc(token)){
                if(function.logicFunc(token , AnswerStack)){
                AnswerStack = function.stackFun;
                continue;
                } else {
                    ErrorMessage = function.ErrorMessage;
                    return false;
                }
            }
            if(token.equals(";")){
                AnswerStack.push(token);
                continue;
            }
        }
        Answer = AnswerStack.pop();
        return true;
    }
}
