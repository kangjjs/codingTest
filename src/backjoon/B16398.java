package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B16398 {

    static int[] parents;

    static int find(int x) {
        if (parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return false;
        parents[y] = x;
        return true;
    }

    static class Edge implements Comparable<Edge> {

        int a, b;
        long cost;

        Edge(int a, int b, long cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        parents = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                long cost = Long.parseLong(st.nextToken());
                if (i < j) {
                    edges.add(new Edge(i, j, cost));
                }
            }
        }

        Collections.sort(edges);

        long ans = 0;
        int cnt = 0;

        for (Edge e : edges) {
            if (union(e.a, e.b)) {
                ans += e.cost;
                cnt++;
                if (cnt == n - 1)
                    break;
            }
        }

        System.out.println(ans);
    }
}
