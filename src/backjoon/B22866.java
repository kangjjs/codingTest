package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B22866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        int[] visibleCnt = new int[n];
        int[] nearestVisible = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }
            visibleCnt[i] += stack.size();
            if (!stack.isEmpty())
                nearestVisible[i] = stack.peek() + 1;  // pop이 아닌 peek 사용
            stack.push(i);
        }

        stack.clear();
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }
            visibleCnt[i] += stack.size();
            if (!stack.isEmpty() && (nearestVisible[i] == 0 || Math.abs(stack.peek() - i) < Math.abs(nearestVisible[i] - 1 - i))) {
                nearestVisible[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(visibleCnt[i]).append(" ");
            if (visibleCnt[i] > 0) {
                sb.append(nearestVisible[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}