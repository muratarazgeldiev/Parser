import java.util.Stack;

public class Function  {
    public String ErrorMessage = "";
    public Stack<String> stackFun = new Stack<String>();
    CheckNumber checkNumber = new CheckNumber();
    public final String[] Function = {"sin", "cos", "min", "max", "sqrt"};
    public byte insertFuncPriority(String function){
        return FuncPriority(function);
    }
    public boolean checkIsFunc(String function){
        return isFunc(function);
    }
    public boolean logicFunc(String function, Stack<String> stack){
        return logicCalcFunc(function, stack);
    }
    private boolean logicCalcFunc(String token, Stack<String> stack){
        stackFun = stack;
        if(token.equals("sqrt")){
            if(!checkNumber.isNum(String.valueOf(stackFun.peek()))){
                ErrorMessage = token + "(" + stackFun.elementAt(stackFun.size() - 1);
                return false;
            }
            double a = Double.parseDouble(String.valueOf(stackFun.pop()));
            stackFun.add("" + Math.sqrt(a));
        }
        if(token.equals("sin")){
            if(!checkNumber.isNum(String.valueOf(stackFun.peek()))){
                ErrorMessage = token + "(";
                return false;
            }
            double a = Double.parseDouble(String.valueOf(stackFun.pop()));
            stackFun.add("" + Math.sin(Math.toRadians(a)));
            stackFun.push(stack.pop());
        }
        if(token.equals("cos")){
            if(!checkNumber.isNum(String.valueOf(stackFun.peek()))){
                ErrorMessage = token + "(";
                return false;
            }
            double a = Double.parseDouble(String.valueOf(stack.pop()));
            stackFun.add("" + Math.cos(Math.toRadians(a)));
        }
        if(token.equals("min")){
            if(!checkNumber.isNum(String.valueOf(stackFun.peek()))){
                ErrorMessage = "Неверно описана функция " + token +"(" + stackFun.peek() + ")";
                return false;
            }
            if(!stackFun.contains(";")){
                ErrorMessage = "Неверно записанное выражение для функции min(;" ;
                return false;
            }
            while (!stack.peek().equals(";")){
                double a = Double.parseDouble(stackFun.pop().toString());
                double b = Double.parseDouble(stackFun.pop().toString());
                if(a > b){
                    if(stackFun.peek().equals(";")){
                        stackFun.pop();
                        stackFun.push(String.valueOf(b));
                        break;
                    } else {
                        stackFun.push(String.valueOf(b));
                    }
                } else {
                    if(stackFun.peek().equals(";")){
                        stackFun.pop();
                        stackFun.push(String.valueOf(a));
                        break;
                    } else {
                        stackFun.push(String.valueOf(a));
                    }
                }

            }
        }
        if(token.equals("max")){
            if(!checkNumber.isNum(String.valueOf(stackFun.peek()))){
                ErrorMessage = "Неверно описана функция " + token +"(" + stackFun.peek() + ")";
                return false;
            }
            if(!stackFun.contains(";")){
                ErrorMessage = "Неверно записанное віражение для функции max(;";
                return false;
            }
            while (!stackFun.peek().equals(";")){
                double a = Double.parseDouble(stackFun.pop().toString());
                double b = Double.parseDouble(stackFun.pop().toString());
                if(a < b){
                    if(stackFun.peek().equals(";")){
                        stackFun.pop();
                        stackFun.push(String.valueOf(b));
                        break;
                    } else {
                        stackFun.push(String.valueOf(b));
                    }
                } else {
                    if(stackFun.peek().equals(";")){
                        stackFun.pop();
                        stackFun.push(String.valueOf(a));
                        break;
                    } else {
                        stackFun.push(String.valueOf(a));
                    }
                }

            }
        }

        return true;
    }
    private byte FuncPriority(String function){
        return 5;
    }
    private boolean isFunc(String function){
        boolean s = false;
        for(String item : Function){
            if(item.equals(function)){
                s = true;
                break;
            }
        }
        return s;
    }
}
