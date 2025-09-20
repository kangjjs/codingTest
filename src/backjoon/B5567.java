package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});

        int ans = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int next : graph.get(cur[0])) {
                if (!visited[next]) {
                    if (cur[1] <= 1) {
                        visited[next] = true;
                        q.add(new int[]{next, cur[1] + 1});
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}