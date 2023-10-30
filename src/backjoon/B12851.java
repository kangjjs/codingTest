package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B12851 {

    static int n, m, cnt = 0, time = Integer.MAX_VALUE;
    static int[] arr;

    public void solution() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        arr[n] = 1;

        while (!q.isEmpty()) {
            int t = q.poll();

            if (time < arr[t]) {
                return;
            }

            for (int i = 0; i < 3; i++) {

                int nextTime = 0;

                switch (i) {
                    case 0:
                        nextTime = t + 1;
                        break;
                    case 1:
                        nextTime = t - 1;
                        break;
                    case 2:
                        nextTime = t * 2;
                }

                if (nextTime == m) {
                    time = arr[t];
                    cnt++;
                }

                if (nextTime >= 0 && nextTime <= 100000 && (arr[nextTime] == 0 || arr[nextTime] == arr[t] + 1)) {
                    q.offer(nextTime);
                    arr[nextTime] = arr[t] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        B12851 T = new B12851();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[100001];

        if (n >= m) {
            System.out.println(n - m);
            System.out.println(1);
            return;
        }

        T.solution();

        System.out.println(time);
        System.out.println(cnt);
    }
}
