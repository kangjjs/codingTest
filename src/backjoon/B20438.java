package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B20438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<Integer> sleep = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sleep.add(Integer.parseInt(st.nextToken()));
        }

        boolean[] isPresent = new boolean[n + 3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (sleep.contains(x))
                continue;
            for (int j = x; j <= n + 2; j += x) {
                if (sleep.contains(j))
                    continue;
                isPresent[j] = true;
            }
        }

        int[] absent = new int[n + 3];
        for (int i = 3; i <= n + 2; i++) {
            if (!isPresent[i])
                absent[i] = 1;
        }

        int[] prefix = new int[n + 3];
        for (int i = 3; i <= n + 2; i++) {
            prefix[i] = prefix[i - 1] + absent[i];
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(prefix[e]-prefix[s-1]);
        }
    }
}
