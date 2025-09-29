package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B10282 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            List<List<int[]>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph.get(b).add(new int[]{a, s});
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.add(new int[]{c, 0});
            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[c] = 0;

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();

                int now = cur[0];
                int time = cur[1];

                if(time > dist[now])
                    continue;

                for(int[] next : graph.get(now)){
                    int nextNode = next[0];
                    int cost = time + next[1];

                    if(cost < dist[nextNode]){
                        dist[nextNode] = cost;
                        pq.add(new int[]{nextNode,cost});
                    }
                }
            }

            int cnt = 0;
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    cnt++;
                    ans = Math.max(ans, dist[i]);
                }
            }

            sb.append(cnt).append(" ").append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
