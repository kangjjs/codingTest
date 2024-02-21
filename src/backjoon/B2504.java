package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st = new Stack<>();

        String s = br.readLine();
        int ans = 0;
        int sum = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
                sum *= 2;
                continue;
            }

            if (c == '[') {
                st.push(c);
                sum *= 3;
                continue;
            }

            if (c == ')') {
                if (st.isEmpty() || st.peek() != '(') {
                    ans = 0;
                    break;
                }
                if (s.charAt(i - 1) == '(')
                    ans += sum;
                st.pop();
                sum /= 2;
                continue;
            }
            if (c == ']') {
                if (st.isEmpty() || st.peek() != '[') {
                    ans = 0;
                    break;
                }

                if (s.charAt(i - 1) == '[')
                    ans += sum;
                st.pop();
                sum /= 3;
            }
        }


        System.out.println(!st.isEmpty() ? 0 : ans);
    }
}
