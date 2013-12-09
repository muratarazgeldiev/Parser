public class CheckNumber {
    public boolean isNum(String token){
        return check(token);
    }
    private boolean check(String token) {
        try {
            Double.parseDouble(token);
        } catch (NumberFormatException NotNumber){
            return false;
        }
        return true;
    }
}
