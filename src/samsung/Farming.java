package samsung;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Farming {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while (n-- > 0) {
            sb.append("#").append(cnt++).append(" ");
            int m = Integer.parseInt(br.readLine());
            int[][] map = new int[m][m];

            for (int i = 0; i < m; i++) {
                String str = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                }
            }

            int sum = 0;

            for (int i = 0; i < m; i++) {
                if (i == m / 2) {
                    for (int j = 0; j < m; j++) {
                        sum+=map[i][j];
                    }
                    break;
                }
                for (int j = (m / 2) - i; j <= (m / 2) + i; j++) {
                    sum += map[i][j];
                    sum += map[m - 1 - i][j];
                }
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
