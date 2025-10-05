package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1711 {

    static int n;
    static long[][] point;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        point = new long[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            point[i][0] = Long.parseLong(st.nextToken());
            point[i][1] = Long.parseLong(st.nextToken());
        }

        ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isRightTriangle(point[i], point[j], point[k])) {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static boolean isRightTriangle(long[] a, long[] b, long[] c) {
        long ab = dist2(a, b);
        long bc = dist2(b, c);
        long ca = dist2(c, a);

        return (ab + bc == ca) || (bc + ca == ab) || (ca + ab == bc);
    }

    static long dist2(long[] p1, long[] p2) {
        long dx = p1[0] - p2[0];
        long dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }
}
