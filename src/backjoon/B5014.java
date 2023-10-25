package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5014 {

    public static String solution(int f, int s, int g, int u, int d) {

        int[] answer = new int[f + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        answer[s]=1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == g) {
                return String.valueOf(answer[now]-1);
            }

            int up = now + u;
            int down = now - d;

            if (up <= f && answer[up] == 0) {
                q.offer(up);
                answer[up] = answer[now] + 1;
            }

            if (down >= 1 && answer[down] == 0) {
                q.offer(down);
                answer[down] = answer[now] + 1;
            }
        }

        return "use the stairs";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        System.out.print(solution(F, S, G, U, D));
    }
}
