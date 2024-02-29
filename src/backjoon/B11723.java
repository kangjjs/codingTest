package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    if (queue.contains(j))
                        continue;
                    queue.offer(j);
                }
                continue;
            }
            if (str.equals("empty")) {
                queue.clear();
                continue;
            }
            int x = Integer.parseInt(st.nextToken());

            if (str.equals("add")) {
                if (queue.contains(x))
                    continue;
                queue.offer(x);
            } else if (str.equals("check")) {
                if (queue.contains(x))
                    sb.append("1").append("\n");
                else
                    sb.append("0").append("\n");
            } else if (str.equals("remove")) {
                queue.remove(x);
            } else if (str.equals("toggle")) {
                if (queue.contains(x))
                    queue.remove(x);
                else
                    queue.offer(x);
            }
        }

        System.out.println(sb);
    }
}
