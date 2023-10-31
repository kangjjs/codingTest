package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B13913 {

    static int n, m, answer = 0;
    static int[] check;
    static int[] visited;

    public void solution() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(n);
        check[n] = 1;

        while (!queue.isEmpty()) {
            int nowTime = queue.poll();

            for (int i = 0; i < 3; i++) {
                int nextTime = 0;
                switch (i) {
                    case 0:
                        nextTime = nowTime + 1;
                        break;
                    case 1:
                        nextTime = nowTime - 1;
                        break;
                    case 2:
                        nextTime = nowTime * 2;
                        break;
                }

                if (nextTime == m) {
                    answer = check[nowTime];
                    visited[nextTime] = nowTime;
                    return;
                }

                if (nextTime >= 0 && nextTime <= 100000 && (check[nextTime] == 0 || check[nextTime] == check[nowTime] + 1)) {
                    check[nextTime] = check[nowTime] + 1;
                    queue.offer(nextTime);
                    visited[nextTime] = nowTime;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        B13913 T = new B13913();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new int[100001];
        visited = new int[100001];

        if (n >= m) {
            System.out.println(n - m);
            for (int i = n; i >= m; i--) {
                System.out.print(i + " ");
            }

            return;
        }

        T.solution();
        System.out.println(answer);

        Stack<Integer> stack = new Stack<>();
        int x = m;
        while (x != n) {
            stack.push(x);
            x = visited[x];
        }
        stack.push(x);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
