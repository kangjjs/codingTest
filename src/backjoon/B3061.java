package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3061 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (arr[i] == i)
                    continue;
                for (int j = i + 1; j <= n; j++) {
                    if (arr[j] == i) {
                        for (int k = j; k > i; k--) {
                            int tmp = arr[k];
                            arr[k] = arr[k - 1];
                            arr[k - 1] = tmp;
                            cnt++;
                        }
                        break;
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }
}
