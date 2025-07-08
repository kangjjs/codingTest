package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B6549 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            if (n == 0)
                break;
            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Stack<Integer> stack = new Stack<>();
            long max = 0;

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                    long height = arr[stack.pop()];
                    long width;
                    if (stack.isEmpty())
                        width = i;
                    else
                        width = i - stack.peek() - 1;
                    long area = height * width;
                    max = Math.max(area, max);
                }

                stack.push(i);
            }

            while (!stack.isEmpty()) {
                long height = arr[stack.pop()];
                long width = stack.isEmpty() ? n : n - stack.peek() - 1;
                long area = height * width;
                max = Math.max(area, max);
            }

            sb.append(max).append('\n');
        }

        System.out.print(sb);
    }
}
