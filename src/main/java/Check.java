import java.util.Stack;
import java.util.StringTokenizer;

public class Check {
    Stack<String> checkStack = new Stack<String>();
    Function function = new Function();
    Operator operator = new Operator();
    CheckNumber checkNumber = new CheckNumber();
    String ErrorMessage = "";
    public boolean insertCheck(String args){
        if(isCheckExp(args)){
            if(isBrackets(args)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    private boolean isCheckExp(String exp){
        exp = exp.replace(" ", "");
        if(exp.isEmpty() || (exp.equals("()"))){
            ErrorMessage = "Вы ничего не ввели!";
            return false;
        }
        exp = "(" + exp + ")";
        exp = exp.replace("(-","(0-").replace("(+", "(0+");
        StringTokenizer tokenizer = new StringTokenizer(exp, operator.Operators + "()" + ";" ,true);
        while(tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            if(!isTrueToken(token)){
                return false;
            }
            if(checkStack.size() < 2){
                checkStack.push(token);
            } else {
                if(operator.Operators.contains(token) && operator.Operators.contains(checkStack.lastElement())){
                    ErrorMessage = "Неверное записанное выражение " + checkStack.lastElement() + token;
                    return false;
                } else {
                    if(operator.Operators.contains(token) && checkStack.lastElement().equals("(")){
                        ErrorMessage = "Неверное записанное выражение " + checkStack.lastElement() + token;
                        return false;
                    } else {
                        if(function.checkIsFunc(token) && checkStack.lastElement().equals(")")){
                            ErrorMessage = "Неверное записанное выражение " + checkStack.lastElement() + token;
                            return false;
                        } else {
                            if(function.checkIsFunc(token) && function.checkIsFunc(checkStack.lastElement())){
                                ErrorMessage = "Неверное записанное выражение " + checkStack.lastElement() + token;
                                return false;
                            } else {
                                if(token.equals(")") && checkStack.lastElement().equals(";")){
                                    ErrorMessage = "Неверное записанное выражение " + checkStack.lastElement() + token;
                                    return false;
                                } else {
                                    if(token.equals(")") && checkStack.lastElement().equals("(")){
                                        ErrorMessage = "Неверное записанное выражение " + checkStack.lastElement() + token;
                                        return false;
                                    } else {
                                        if(function.checkIsFunc(token) && operator.checkOper(checkStack.lastElement())){
                                            ErrorMessage = "Неверное записанное выражение " + checkStack.lastElement() + token;
                                            return false;
                                        } else {
                                            checkStack.push(token);
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        return true;
    }
    private boolean isBrackets(String exp){
        int brackets = 0;
        for( int i = 0; i < exp.length(); i++){
            if(exp.charAt(i) == '('){
                brackets++;
            }
            if(exp.charAt(i) == ')'){
                brackets--;
            }

        }
        if (brackets == 0){
            return true;
        } else {

            if(brackets > 0) {
                ErrorMessage = "Недостаточно закрывающих скобок!";
                return false;
            } else {
                ErrorMessage = "Недостаточно открывающих скобок!";
                return false;
            }
        }

    }
    private boolean isTrueToken(String token){
        if(!function.checkIsFunc(token)){
            if(!operator.Operators.contains(token)){
                if(!checkNumber.isNum(token)){
                    if(!token.equals("(")){
                        if(!token.equals(")")){
                            if(!token.equals(";")){
                                ErrorMessage = "Неизвестный токен " + token;
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
