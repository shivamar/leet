public class ExcelSheetLetters {
    public String convertToTitle(int n) {
        n -= 1;
        //integer is positive
        int div = n / 26;
        int res = n % 26;
        
        char c = (char)(65+res);
        
        String ans = (div > 0) ? convertToTitle(div)+String.valueOf(c) : String.valueOf(c);
        
        return ans;
    }
}
