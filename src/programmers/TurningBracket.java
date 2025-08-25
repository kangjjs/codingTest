package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class TurningBracket {
    public int solution(String s) {
        int l = s.length();
        if(l%2==1)
            return 0;
        int answer = 0;
        for (int shift = 0; shift < l; shift++) {
            if (isValidRotation(s, shift)) answer++;
        }

        return answer;
    }

    private boolean isValidRotation(String s, int shift) {
        int n = s.length();
        Deque<Character> st = new ArrayDeque<>();
        for (int k = 0; k < n; k++) {
            char c = s.charAt((shift + k) % n);
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;
                char top = st.pop();
                if (!match(top, c)) return false;
            }
        }
        return st.isEmpty();
    }

    private boolean match(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
