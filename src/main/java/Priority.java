public class Priority {
    public byte GetPriority(String token){
        return priority(token);
    }
    private byte priority(String token){
        if (token.equals("(")) {
            return 0;
        } else if (token.equals(")")) {
            return 1;
        } else if (token.equals("+") || token.equals("-") ) {
            return 2;
        }  else if (token.equals("*") || token.equals("/")) {
            return 3;
        } else if (token.equals("^")) {
            return 4;
        } else if(token.equals("min") || token.equals("max")){
            return 5;
        } else return 6;
    }
}
