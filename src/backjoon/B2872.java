package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr =new int[N+1];

        for (int i = 0; i < N; i++) {
            arr[i+1] = Integer.parseInt(br.readLine());
        }
        int seq = N;
        for (int i = N;i>=1;i--){
            if(arr[i]==seq)
                seq--;
        }

        System.out.println(seq);
    }
}
