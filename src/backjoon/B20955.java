package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20955 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int cycle = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(find(u)==find(v))
                cycle++;
            else
                union(u, v);
        }
        boolean[] visited = new boolean[n+1];
        int cnt = 0;
        for(int i=1;i<=n;i++){
            int root = find(i);
            if(!visited[root]){
                visited[root] = true;
                cnt++;
            }
        }

        System.out.println(cycle+cnt-1);
    }

    static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y)
            parent[y] = x;
    }
}
