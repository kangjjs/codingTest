package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18243 {

    static int N, K;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        if (check()) {
            System.out.println("Small World!");
        } else {
            System.out.println("Big World!");
        }
    }

    static boolean check() {
        for (int i = 1; i <= N; i++) {
            if (!bfs(i))
                return false;
        }

        return true;
    }

    static boolean bfs(int i) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, 0});
        boolean[] visited = new boolean[N + 1];
        visited[i] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[1] >= 7)
                return false;
            for (int next : graph.get(cur[0])) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, cur[1] + 1});
                }
            }
        }

        for (int j = 1; j <= N; j++) {
            if(!visited[j])
                return false;
        }

        return true;
    }
}
