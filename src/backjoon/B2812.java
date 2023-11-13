package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Character> dq = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();

        String str = br.readLine();

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.getFirst() < str.charAt(i) && k > 0) {
                dq.removeFirst();
                k--;
            }

            dq.push(str.charAt(i));
            System.out.println(dq.getFirst());
        }

        while (dq.size() > k) {
            ans.append(dq.removeLast());
        }

        System.out.println(ans);
    }
}
