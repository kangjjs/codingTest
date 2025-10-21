package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2469 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        char[] goal = br.readLine().toCharArray();
        String[] ladder = new String[n];
        int questionLine = -1;

        for (int i = 0; i < n; i++) {
            ladder[i] = br.readLine();
            if (ladder[i].charAt(0) == '?')
                questionLine = i;
        }

        char[] top = new char[k];
        for (int i = 0; i < k; i++)
            top[i] = (char) ('A' + i);

        for (int i = 0; i < questionLine; i++) {
            for (int j = 0; j < k - 1; j++) {
                if (ladder[i].charAt(j) == '-') {
                    char tmp = top[j];
                    top[j] = top[j + 1];
                    top[j + 1] = tmp;
                }
            }
        }

        char[] bottom = goal.clone();
        for (int i = n - 1; i > questionLine; i--) {
            for (int j = 0; j < k - 1; j++) {
                if (ladder[i].charAt(j) == '-') {
                    char tmp = bottom[j];
                    bottom[j] = bottom[j + 1];
                    bottom[j + 1] = tmp;
                }
            }
        }

        char[] result = new char[k - 1];

        for (int i = 0; i < k - 1; i++) {
            if (top[i] == bottom[i])
                result[i] = '*';
            else if (top[i] == bottom[i + 1] && top[i + 1] == bottom[i]) {
                result[i] = '-';
                char tmp = top[i];
                top[i] = top[i + 1];
                top[i + 1] = tmp;
            } else {
                Arrays.fill(result, 'x');
                break;
            }
        }

        System.out.print(new String(result));
    }
}
