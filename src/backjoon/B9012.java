package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int cnt = 0; cnt < n; cnt++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty() && flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}