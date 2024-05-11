package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long sum = 0;
            long[] arr = new long[m];
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                arr[i] = x;
            }

            long max = 0;

            for (int i = m-1; i >=0 ; i--) {
                if(arr[i]>max){
                    max = arr[i];
                }else{
                    sum += (max - arr[i]);
                }
            }

            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}
