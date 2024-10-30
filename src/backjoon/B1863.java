package backjoon;

import java.io.BufferedReader;
import java.util.Stack;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int h : height) {
            if (h == 0) {
                answer += stack.size();
                stack.clear();
            } else if (!stack.isEmpty()) {
                int peek = stack.peek();
                if (peek < h) {
                    stack.push(h);
                } else {
                    while (!stack.isEmpty() && stack.peek() > h) {
                        stack.pop();
                        answer++;
                    }
                    if (!stack.isEmpty() && stack.peek() < h)
                        stack.push(h);
                    if (stack.isEmpty())
                        stack.push(h);
                }
            } else {
                stack.push(h);
            }
        }

        if (!stack.isEmpty())
            answer += stack.size();
        System.out.println(answer);
    }
}