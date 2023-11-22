package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B20300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        Long[] arr =new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        long m;
        if(n%2==1){
            m = arr[0];
            for (int i = 1; i < n/2; i++) {
                long sum = arr[i]+arr[n-i];
                m=Math.max(sum,m);
            }
        }else{
            m= Integer.MAX_VALUE;
            for (int i = 0; i < n / 2; i++) {
                long sum  = arr[i]+arr[n-1-i];
                m=Math.max(sum,m);
            }
        }

        System.out.println(m);
    }
}
