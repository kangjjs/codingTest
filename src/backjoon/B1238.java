package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1238 {

    static int n, m, x;
    static ArrayList<ArrayList<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, c});
        }

        int[] distToX = dijkstra(x);
        int maxRoundTrip = 0;

        for (int i = 1; i <= n; i++) {
            if (i != x) {
                int[] distFromI = dijkstra(i);
                maxRoundTrip = Math.max(maxRoundTrip, distFromI[x] + distToX[i]);
            }
        }

        System.out.println(maxRoundTrip);
    }

    static int[] dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[1] > dist[cur[0]])
                continue;
            for (int[] next : graph.get(cur[0])) {
                int v = next[0];
                int cost = next[1];

                if (dist[v] > dist[cur[0]] + cost) {
                    dist[v] = dist[cur[0]] + cost;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        return dist;
    }
}
