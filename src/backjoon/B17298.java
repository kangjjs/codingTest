package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] req = new int[N];
        int[] ans = new int[N];
        for(int i = 0; i<N;i++){
            req[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<N;i++){
            while(!s.isEmpty() && req[s.peek()] < req[i]){
                ans[s.pop()] = req[i];
            }
            s.push(i);
        }

        while(!s.isEmpty()){
            ans[s.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(ans[i]).append(' ');
        }

        System.out.println(sb);
    }
}
