package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if (stack.peek()[0] < x) {
                    stack.pop();
                } else {
                    System.out.print(stack.peek()[1] + " ");
                    break;
                }
            }

            if (stack.isEmpty())
                System.out.print("0 ");
            stack.push(new int[]{n, i + 1});
        }

    }
}
