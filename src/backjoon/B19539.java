package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B19539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            sum += x;
            if (x % 2 == 1) {
                cnt++;
            }
        }

        if (sum % 3 == 0 && cnt <= sum/3){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
