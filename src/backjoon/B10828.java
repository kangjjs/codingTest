package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        sb.append("-1");
                        sb.append("\n");
                    } else {
                        sb.append(stack.lastElement());
                        sb.append("\n");
                    }
                    break;
                case "size":
                    sb.append(stack.size());
                    sb.append("\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                    sb.append("\n");
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        sb.append("-1");
                        sb.append("\n");
                    } else {
                        sb.append(stack.pop());
                        sb.append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
