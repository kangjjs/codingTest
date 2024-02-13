package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int ans = 0;
        int left=0;
        int right=arr[N-1]-arr[0];

        while(left<=right){
            int cnt =1;
            int bf = arr[0];

            int mid = (right+left)/2;

            for (int i = 1; i < N ; i++) {
                if(arr[i]-bf >=mid){
                    cnt++;
                    bf = arr[i];
                }
            }

            if(cnt>=C){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        System.out.println(ans);
    }
}