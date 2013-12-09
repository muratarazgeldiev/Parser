public class Result {
    public String result(String exp){
        Check check = new Check();
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        Calculation calculation = new Calculation();
        if(check.insertCheck(exp)){
            infixToPostfix.insertParse(check.checkStack);
            if(calculation.calc(infixToPostfix.outStack)){
                return calculation.Answer;
            } else {
                return calculation.ErrorMessage;
            }
        } else {
            return check.ErrorMessage;
        }
    }
}
