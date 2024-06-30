package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260 {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<Integer> list1;
    static ArrayList<Integer> list2;

    static void dfs(int v, int l, int n) {
        if (l == n)
            return;
        for (int x : graph.get(v)) {
            if (!visited[x]) {
                visited[x] = true;
                list1.add(x);
                dfs(x, l + 1, n);
            }
        }
    }

    static void bfs(int v, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int x:graph.get(cur)){
                if(!visited[x]){
                    visited[x]=true;
                    list2.add(x);
                    q.offer(x);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        visited[v]= true;
        list1.add(v);
        list2.add(v);
        dfs(v, 0, n);
        for (int x : list1) {
            System.out.print(x + " ");
        }
        System.out.println();
        bfs(v,n);
        for (int x : list2) {
            System.out.print(x + " ");
        }
    }
}
