package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B4195 {

    static int[] unf, count;

    public static int find(int v) {
        if (v == unf[v])
            return v;
        return unf[v] = find(unf[v]);
    }

    public static void Union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx > fy) {
            int tmp = fx;
            fx = fy;
            fy = tmp;
        }
        if (fx == fy)
            return;
        unf[fy] = fx;
        count[fx] += count[fy];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            HashMap<String, Integer> hm = new HashMap<>();
            int m = Integer.parseInt(br.readLine());
            int idx = 1;
            int[][] friend = new int[m][2];
            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String x = st.nextToken();
                String y = st.nextToken();
                if (!hm.containsKey(x)) {
                    hm.put(x, idx++);
                }
                if (!hm.containsKey(y)) {
                    hm.put(y, idx++);
                }

                friend[i] = new int[]{hm.get(x), hm.get(y)};
            }

            unf = new int[idx];
            count = new int[idx];
            Arrays.fill(count, 1);

            for (int i = 0; i < idx; i++) {
                unf[i] = i;
            }

            for (int[] x : friend) {
                Union(x[0], x[1]);
                System.out.println(count[find(x[0])]);
            }
        }
    }
}