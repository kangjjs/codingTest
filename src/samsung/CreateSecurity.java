package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CreateSecurity {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append("#").append(num).append(" ");
            Queue<Integer> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 8; i++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }

            int cnt = 0;

            while (true) {
                int x = q.poll() - ++cnt;
                if (x <= 0) {
                    q.offer(0);
                    break;
                }

                if (cnt == 5) {
                    cnt = 0;
                }
                q.offer(x);
            }

            for (int x : q) {
                sb.append(x).append(" ");
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}
