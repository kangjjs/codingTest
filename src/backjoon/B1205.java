package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int np = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        if (n == 0) {
            System.out.println("1");
            return;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n == p && np <= arr[n - 1]) {
            System.out.println("-1");
        } else {
            int rank = 1;
            for (int i = 0; i < n; i++) {
                if(np<arr[i])
                    rank++;
                else
                    break;
            }

            System.out.println(rank);
        }
    }
}
