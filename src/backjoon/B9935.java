package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            stack.push(str.charAt(i));

            if (stack.size() >= bomb.length()) {
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) == bomb.charAt(j)) {
                        count++;
                    }

                    if (count == bomb.length()) {
                        for (int k = 0; k < bomb.length(); k++) {
                            stack.pop();
                        }
                    }
                }
            }
        }

        StringBuilder sb =new StringBuilder();
        if (!stack.isEmpty()) {
            for (Character c : stack) {
                sb.append(c);
            }
        } else {
            System.out.print("FRULA");
        }

        System.out.println(sb);

    }
}