package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][s];
        char[][] result = new char[r][s];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int dist = r;
        for (int j = 0; j < s; j++) {
            int bottom = -1;
            for (int i = 0; i < r; i++) {
                if (map[i][j] == 'X')
                    bottom = i;
                else if (map[i][j] == '#' && bottom != -1) {
                    dist = Math.min(dist, i - bottom - 1);
                    break;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            Arrays.fill(result[i], '.');
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                if (map[i][j] == 'X')
                    result[i + dist][j] = 'X';
                else if (map[i][j] == '#')
                    result[i][j] = '#';
            }
        }

        for (int i = 0; i < r; i++) {
            System.out.println(new String(result[i]));
        }
    }
}