package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            hs.add(str);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split(",");
            for (String x : str) {
                hs.remove(x);
            }
            sb.append(hs.size()).append('\n');
        }

        System.out.println(sb);
    }
}
