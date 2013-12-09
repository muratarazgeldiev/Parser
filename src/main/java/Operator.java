import java.util.Stack;

public class Operator  {
    public final String Operators = "+-*/^";
    public Stack<String> OperandStack = new Stack<String>();
    public boolean checkOper(String token){
        return CheckOperator(token);
    }
    public boolean insertToCalc(String token,Stack<String> stack){
        return ToCalc(token, stack);
    }
    private boolean ToCalc(String token, Stack<String> AnswerStack){
        OperandStack = AnswerStack;
        double a = Double.parseDouble(OperandStack.pop());
        double b = Double.parseDouble(OperandStack.pop());
        if(token.equals("+")){
            OperandStack.push(b + a + "");
            return true;
        }
        if(token.equals("-")){
            OperandStack.push(b - a + "");
            return true;
        }
        if(token.equals("*")){
            OperandStack.push(b * a + "");
            return true;
        }
        if(token.equals("/")){
            OperandStack.push((b / a) + "");
            return true;
        }
        if(token.equals("^")){
            OperandStack.push(Math.pow(b, a) + "");
            return true;
        }
        return false;
    }
    private boolean CheckOperator(String token){
        if(Operators.contains(token)){
            return true;
        } else {
            return false;
        }
    }

}
