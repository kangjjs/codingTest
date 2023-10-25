package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B9019 {

    public void solution(int a, int b) {
        String[] answer = new String[10000];
        boolean[] check = new boolean[10000];

        Queue<Integer> q = new LinkedList<>();

        check[a] = true;
        q.offer(a);
        Arrays.fill(answer, "");

        while (!q.isEmpty() && !check[b]) {
            int now = q.poll();

            int D = (now * 2) % 10000;
            int S = (now == 0) ? 9999 : now - 1;
            int L = (now % 1000) * 10 + now / 1000;
            int R = (now % 10) * 1000 + now / 10;

            if (!check[D]) {
                q.add(D);
                check[D] = true;
                answer[D] = answer[now] + "D";
            }

            if (!check[S]) {
                q.add(S);
                check[S] = true;
                answer[S] = answer[now] + "S";
            }

            if (!check[L]) {
                q.add(L);
                check[L] = true;
                answer[L] = answer[now] + "L";
            }

            if (!check[R]) {
                q.add(R);
                check[R] = true;
                answer[R] = answer[now] + "R";
            }

        }

        System.out.println(answer[b]);

    }

    public static void main(String[] args) throws IOException {
        B9019 T = new B9019();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < n; i++) {
            T.solution(a[i], b[i]);
        }
    }
}
