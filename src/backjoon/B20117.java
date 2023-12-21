package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B20117 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr =new int[N];

        StringTokenizer st =new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        Arrays.sort(arr);

        if (N % 2 == 0) {
            for (int i = N - 1; i >= N / 2; i--) {
                sum += arr[i] * 2;
            }
        } else {
            for (int i = N - 1; i > N / 2; i--) {
                sum += arr[i] * 2;
            }
            sum+=arr[N/2];
        }

        System.out.println(sum);
    }
}
