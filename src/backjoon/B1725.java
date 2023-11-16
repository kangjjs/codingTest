package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 2];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack =new Stack<>();
        stack.push(0);
        int ans = 0;

        for (int i = 1; i < n+2; i++) {
            while(!stack.isEmpty()){
                int top = stack.peek();
                if(arr[top]<=arr[i])
                    break;
                stack.pop();
                ans = Math.max(ans,arr[top]*(i-stack.peek()-1));
            }
            stack.push(i);
        }

        System.out.println(ans);
    }
}
