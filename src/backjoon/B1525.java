package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1525 {

    static final String GOAL = "123456780";
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                sb.append(st.nextToken());
            }
        }

        String start = sb.toString();
        System.out.print(bfs(start));
    }

    static int bfs(String start) {
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> dist = new HashMap<>();

        q.add(start);
        dist.put(start, 0);

        while (!q.isEmpty()) {
            String cur = q.poll();

            if (cur.equals(GOAL))
                return dist.get(cur);

            int idx = cur.indexOf('0');
            int x = idx / 3;
            int y = idx % 3;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3)
                    continue;
                int newIdx = nx * 3 + ny;

                String next = swap(cur, idx, newIdx);

                if (!dist.containsKey(next)) {
                    dist.put(next, dist.get(cur) + 1);
                    q.add(next);
                }
            }
        }

        return -1;
    }

    static String swap(String cur, int curIdx, int nextIdx) {
        char[] c = cur.toCharArray();
        char tmp = c[curIdx];
        c[curIdx] = c[nextIdx];
        c[nextIdx] = tmp;
        return new String(c);
    }
}
