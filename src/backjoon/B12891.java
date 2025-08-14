package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String dna = br.readLine();

        int[] need = new int[4];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            need[i] = Integer.parseInt(st.nextToken());
        }

        int[] cur = new int[4];

        for (int i = 0; i < p; i++) {
            cur[idx(dna.charAt(i))]++;
        }

        int ans = 0;
        if (check(cur, need))
            ans++;

        for (int lt = 0, rt = p; rt < s; lt++, rt++) {
            cur[idx(dna.charAt(lt))]--;
            cur[idx(dna.charAt(rt))]++;
            if(check(cur,need))
                ans++;
        }

        System.out.println(ans);
    }

    static int idx(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        return 3;
    }

    static boolean check(int[] cur, int[] need) {
        for (int i = 0; i < 4; i++) if (cur[i] < need[i]) return false;
        return true;
    }
}
