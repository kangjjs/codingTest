package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1182 {

    static int n, s;
    static int[] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;

        dfs(0, 0);

        if(s==0)
            cnt--;
        System.out.println(cnt);
    }

    static void dfs(int l, int sum) {
        if (l == n) {
            if (sum == s)
                cnt++;
            return;
        }

        dfs(l + 1, sum + arr[l]);
        dfs(l + 1, sum);
    }
}
