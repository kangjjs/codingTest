package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int score1 = 0, score2 = 0;
        int winTime1 = 0, winTime2 = 0;
        int prevTime = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int team = Integer.parseInt(input[0]);
            int currentTime = convertTime(input[1]);

            if (score1 > score2) {
                winTime1 += currentTime - prevTime;
            } else if (score2 > score1) {
                winTime2 += currentTime - prevTime;
            }

            // 득점 반영
            if (team == 1) score1++;
            else score2++;

            prevTime = currentTime;
        }

        int endTime = 48 * 60;
        if (score1 > score2) {
            winTime1 += endTime - prevTime;
        } else if (score2 > score1) {
            winTime2 += endTime - prevTime;
        }

        System.out.println(convert(winTime1));
        System.out.println(convert(winTime2));
    }

    static int convertTime(String str) {
        int m = Integer.parseInt(str.split(":")[0]);
        int s = Integer.parseInt(str.split(":")[1]);

        return 60 * m + s;
    }

    static String convert(int time) {
        int m = time / 60;
        int s = time % 60;

        return String.format("%02d:%02d", m, s);
    }
}
