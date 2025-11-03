package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B27971 {

    static int n, m, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        boolean[] banned = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            for (int j = l; j <= r; j++) {
                banned[j] = true;
            }
        }

        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        dist[0] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == n)
                break;
            int nextA = cur + a;
            if (nextA <= n && dist[nextA] == -1 && !banned[nextA]) {
                dist[nextA] = dist[cur] + 1;
                q.add(nextA);
            }

            int nextB = cur + b;
            if(nextB <= n && dist[nextB]==-1 && !banned[nextB]){
                dist[nextB] = dist[cur]+1;
                q.add(nextB);
            }
        }

        System.out.println(dist[n]);
    }
}