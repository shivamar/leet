public class ValidPalindrome {
    /*
     Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome. 

For the purpose of this problem, we define empty string as valid palindrome. 
    */
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        s = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        int start=0,end=s.length()-1;
        while(end>=start)
        {
            if(s.charAt(end)!=s.charAt(start)) return false;
            end--;
            start++;
        }
        return true;
    }
}