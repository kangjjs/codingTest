package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt=0,rt = n-1;
        int[] ans = new int[2];
        int min = Integer.MAX_VALUE;

        while(lt<rt){
            int sum = Math.abs(arr[lt]+arr[rt]);

            if(sum<min){
                min = sum;
                ans[0] = arr[lt];
                ans[1] = arr[rt];
            }

            if(arr[lt] + arr[rt]>=0){
                rt--;
            }else{
                lt++;
            }
        }

        System.out.println(ans[0]+" "+ans[1]);
    }
}