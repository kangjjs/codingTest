package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14495 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] arr = new long[117];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i <= 116; i++) {
            arr[i] = arr[i - 1] + arr[i - 3];
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(arr[n]);
    }
}
