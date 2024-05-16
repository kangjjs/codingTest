package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class HamburgerDiet {
    static int ans, n, l;
    static ArrayList<Hamburger> list;
    static boolean[] check;

    static class Hamburger implements Comparable<Hamburger> {
        public int s, k;

        public Hamburger(int s, int k) {
            this.s = s;
            this.k = k;
        }


        @Override
        public int compareTo(Hamburger o) {
            if (this.k == o.k)
                return o.s - this.s;
            return this.k - o.k;
        }
    }

    static void dfs(int i, int s, int k) {
        if (k > l) {
            return;
        }
        if (i == n) {
            ans = Math.max(s, ans);
            return;
        }

        dfs(i + 1, s + list.get(i).s, k + list.get(i).k);
        dfs(i + 1, s, k);
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append("#").append(cnt++).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            check = new boolean[n];
            ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                list.add(new Hamburger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(list);
            dfs(0, 0, 0);

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
