package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1389 {

    static int n, m, ans, cnt;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;
        cnt = Integer.MAX_VALUE;
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

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        System.out.println(ans);
    }

    static void bfs(int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, 0});
        boolean[] visited = new boolean[n + 1];
        visited[x] = true;
        int c = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int next : graph.get(cur[0])) {
                if (!visited[next]) {
                    c += cur[1];
                    visited[next] = true;
                    q.add(new int[]{next, cur[1] + 1});
                }
            }
        }

        if(c<cnt){
            cnt = c;
            ans = x;
        }else if(cnt==c){
            ans = Math.min(ans,x);
        }
    }
}
