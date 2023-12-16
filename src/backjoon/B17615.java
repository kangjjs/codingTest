package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int blueCnt = 0, redCnt = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'B')
                blueCnt++;
            else
                redCnt++;
        }

        int answer = Integer.MAX_VALUE;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R')
                cnt++;
            else
                break;
        }

        answer = Math.min(answer, redCnt - cnt);
        cnt = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == 'R')
                cnt++;
            else
                break;
        }

        answer = Math.min(answer, redCnt - cnt);
        cnt = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'B')
                cnt++;
            else
                break;
        }

        answer = Math.min(answer, blueCnt - cnt);
        cnt = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == 'B')
                cnt++;
            else
                break;
        }

        answer = Math.min(answer, blueCnt - cnt);

        System.out.println(answer);
    }
}
