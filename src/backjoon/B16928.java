package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] distance = new int[101];
        Arrays.fill(distance, -1);

        for (int i = 0; i < n + k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            hm.put(x, y);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        distance[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100) continue;
                if (hm.containsKey(next)) next = hm.get(next);
                if (distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    q.add(next);
                }
            }
        }
        System.out.println(distance[100]);
    }
}
