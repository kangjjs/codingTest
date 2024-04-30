package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1654 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long lt = 1;
        long rt = arr[arr.length-1];
        long mid;
        long ans = 0;
        while(lt<=rt){
            mid = (lt+rt) / 2;
            int cnt = 0;
            for(long x: arr){
                cnt += x/mid;
            }

            if(cnt>=K){
                ans = Math.max(ans,mid);
                lt = mid+1;
            }else{
                rt = mid-1;
            }
        }

        System.out.println(ans);
    }
}
