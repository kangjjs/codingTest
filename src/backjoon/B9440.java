package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B9440 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            if (n == 0)
                break;

            int[] arr = new int[n];
            int zero = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == 0)
                    zero++;
            }

            Arrays.sort(arr);

            int idx = 0;
            while (arr[idx] == 0) {
                idx++;
            }
            int a, b;
            a = arr[idx++];
            b = arr[idx++];
            boolean turn = true;
            while (zero > 0) {
                if (turn)
                    a *= 10;
                else
                    b *= 10;
                turn = !turn;
                zero--;
            }

            for (int i = idx; i < n; i++) {
                if (turn) {
                    a *= 10;
                    a += arr[i];
                } else {
                    b *= 10;
                    b += arr[i];
                }

                turn = !turn;
            }

            sb.append(a + b).append('\n');
        }

        System.out.print(sb);
    }
}
