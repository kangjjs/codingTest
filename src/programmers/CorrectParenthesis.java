package programmers;

import java.util.Stack;

public class CorrectParenthesis {
    boolean solution(String s) {
        Stack<Character> st =new Stack<>();

        for(char c : s.toCharArray()){
            if(c=='('){
                st.push(c);
            }else{
                if(st.isEmpty())
                    return false;
                else
                    st.pop();
            }
        }

        return st.isEmpty();
    }
}
