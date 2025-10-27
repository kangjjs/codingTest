package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B19942 {

    static int mp, mf, ms, mv, N, ans;
    static int[] p, f, s, v, c;
    static ArrayList<Integer> list, ansList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());
        p = new int[N];
        f = new int[N];
        s = new int[N];
        v = new int[N];
        c = new int[N];
        ans = Integer.MAX_VALUE;
        list = new ArrayList<>();
        ansList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            f[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0, 0, 0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        if (ansList.isEmpty())
            return;
        Collections.sort(ansList);
        for (int x : ansList) {
            System.out.print(x + " ");
        }
    }

    static void dfs(int l, int cp, int cf, int cs, int cv, int cc) {
        if (l == N) {
            if (cp >= mp && cf >= mf && cs >= ms && cv >= mv) {
                if (cc < ans) {
                    ans = cc;
                    ansList = new ArrayList<>(list);
                } else if (cc == ans) {
                    if(compare(list,ansList)){
                        ansList = new ArrayList<>(list);
                    }
                }
            }

            return;
        }

        list.add(l + 1);
        dfs(l + 1, cp + p[l], cf + f[l], cs + s[l], cv + v[l], cc + c[l]);
        list.remove(Integer.valueOf(l + 1));
        dfs(l + 1, cp, cf, cs, cv, cc);
    }

    static boolean compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}
