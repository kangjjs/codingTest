package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxRoad {
    static int n,m,ans;
    static int[][] map;
    static boolean[] visited;

    static void dfs(int l,int v){
        visited[v] = true;
        for (int i = 0; i <=n; i++) {
            if(map[v][i]==1&&!visited[i]){
                dfs(l+1,i);
                visited[i]=false;
            }
        }
        ans = Math.max(ans,l);
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append("#").append(cnt++).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            ans = 0;
            map = new int[n+1][n+1];
            visited = new boolean[n+1] ;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y]=1;
                map[y][x]=1;
            }

            for (int i = 1; i <= n; i++) {
                dfs(1,i);
                visited[i]=false;
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
