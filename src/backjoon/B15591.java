package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B15591 {

    static int bfs(ArrayList<ArrayList<int[]>> graph, int n, int start, int k) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int[] next : graph.get(cur)) {
                if (!visited[next[0]] && next[1] >= k) {
                    visited[next[0]] = true;
                    queue.add(next[0]);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list.get(x).add(new int[]{y, z});
            list.get(y).add(new int[]{x, z});
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(bfs(list, n, v, k)).append('\n');
        }
        System.out.print(sb);
    }
}
