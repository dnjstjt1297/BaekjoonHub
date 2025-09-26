import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(!st.isEmpty()){
                char a = st.pop();
                if(a != s.charAt(i)){
                    st.add(a);
                    st.add(s.charAt(i));
                }   
            }
            else st.add(s.charAt(i));
        }
        
        if(st.isEmpty()) return 1;
        else return 0;
    }
}