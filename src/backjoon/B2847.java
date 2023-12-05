package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int base = arr[N - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            if(arr[i]>base-1){
                cnt+=arr[i]-base+1;
                base--;
            }else
                base = arr[i];
        }

        System.out.println(cnt);
    }
}
