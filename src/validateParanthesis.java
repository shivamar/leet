import java.util.Stack;

public class validateParanthesis {

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i < s.length();i++)
        {
            switch(s.charAt(i))
            {
                case ')':
                    if(!st.isEmpty() && st.peek() != '(')
                        return false;
                    else if(st.isEmpty())
                        st.push(s.charAt(i));
                    else st.pop();
                    break;
                case '}':
                    if(!st.isEmpty() && st.peek() != '{')
                        return false;
                    else if(st.isEmpty())
                        st.push(s.charAt(i));
                    else st.pop();
                    break;
                case ']':
                    if(!st.isEmpty() && st.peek() != '[')
                        return false;
                    else if(st.isEmpty())
                        st.push(s.charAt(i));
                    else st.pop();
                    break;
                default:
                    st.push(s.charAt(i));
                    break;
            }
        }
        
        if(st.isEmpty()) return true;
        else return false;
    }
}
