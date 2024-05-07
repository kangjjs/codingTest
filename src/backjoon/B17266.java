package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17266 {

    static int N, M;
    static int[] light;

    static boolean binarySearch(int t) {
        int prev = 0;
        for (int i = 0; i < M; i++) {
            if (light[i] - t <= prev)
                prev = light[i] + t;
            else
                return false;
        }

        return N - prev <= 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        light = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 1;
        int rt = N;
        int ans = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (binarySearch(mid)) {
                ans = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
