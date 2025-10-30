package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B18352 {

    static int N, M, K, X;
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        answer = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
        }

        bfs();

        if(answer.isEmpty()) {
            System.out.println("-1");
            return;
        }

        Collections.sort(answer);
        for(int x:answer){
            System.out.println(x);
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{X, 0});
        boolean[] visited = new boolean[N + 1];
        visited[X] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[1] == K) {
                answer.add(cur[0]);
                continue;
            }

            for (int next : graph.get(cur[0])) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, cur[1] + 1});
                }
            }
        }
    }
}
