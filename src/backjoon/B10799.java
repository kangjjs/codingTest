package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int ans = 0;
        int stick = 0;

        Stack<Character> s = new Stack<>();
        s.push(str.charAt(0));
        stick++;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                s.push(str.charAt(i));
                stick++;
            } else {
                s.pop();
                stick--;
                if (str.charAt(i - 1) == '(') {
                    ans += stick;
                } else {
                    ans += 1;
                }
            }
        }

        System.out.println(ans);
    }
}
