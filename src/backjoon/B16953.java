package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16953 {

    static long n, m;
    static Queue<Long> q;

    static int bfs() {
        int cnt = 0;
        while (!q.isEmpty()) {
            for (int i = 0, size = q.size(); i < size; i++) {
                long x = q.poll();
                if (x == m) {
                    return cnt + 1;
                }

                long next1 = x * 2;
                long next2 = x * 10 + 1;

                if (next1 <= m)
                    q.offer(next1);
                if (next2 <= m)
                    q.offer(next2);
            }
            cnt++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        q = new LinkedList<>();
        q.offer(n);

        System.out.println(bfs());
    }
}
