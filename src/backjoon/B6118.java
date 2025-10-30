package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B6118 {

    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
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

        bfs();
        int ans = 0;
        int dis = 0;
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i] > dis) {
                ans = i;
                dis = arr[i];
                cnt = 0;
                cnt++;
            } else if (arr[i] == dis) {
                cnt++;
            }
        }

        System.out.println(ans + " " + dis + " " + cnt);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int next : graph.get(cur[0])) {
                if (arr[next] == 0) {
                    arr[next] = cur[1] + 1;
                    q.add(new int[]{next, arr[next]});
                }
            }
        }
    }
}
