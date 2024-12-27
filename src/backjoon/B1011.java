package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            long distance = y - x;
            long maxMove = 0;
            long moveCount = 0;

            while (distance > 0) {
                moveCount++;
                maxMove += (moveCount + 1) / 2;
                if (maxMove >= distance) {
                    break;
                }
            }
            sb.append(moveCount).append("\n");
        }

        System.out.print(sb);
    }
}
