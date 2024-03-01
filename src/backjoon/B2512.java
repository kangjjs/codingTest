package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int left = 0,right = -1;
        int[] budget = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(budget);
        right = budget[N-1];

        int total = Integer.parseInt(br.readLine());

        while(left<=right){
            int mid = (left+right)/2;
            long b = 0;

            for (int i = 0; i <N; i++) {
                b += Math.min(budget[i], mid);
            }

            if(b<=total)
                left = mid+1;
            else
                right = mid-1;
        }

        System.out.println(right);
    }
}
