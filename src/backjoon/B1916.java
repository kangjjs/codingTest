package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916 {

    static class Node implements Comparable<Node> {

        public int v, d;

        public Node(int v, int d) {
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph.get(s).add(new int[]{e, d});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        final int INF = 1_000_000_000;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.v;

            if (visited[v])
                continue;
            if (v == end)
                break;
            visited[v] = true;

            for (int[] next : graph.get(v)) {
                if (!visited[next[0]] && dist[next[0]] > dist[v] + next[1]) {
                    dist[next[0]] = dist[v] + next[1];
                    pq.add(new Node(next[0], dist[next[0]]));
                }
            }
        }

        System.out.println(dist[end]);
    }
}
