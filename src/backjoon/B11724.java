package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11724 {

    static int n, m;
    static boolean[] visited;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int ans = 0;

        for (int i = 1; i <= 6; i++) {
            if (!visited[i]) {
                find(i);
                ans++;
            }
        }

        System.out.println(ans);
    }

    static void find(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
