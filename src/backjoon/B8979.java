package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B8979 {

    static class Rank implements Comparable<Rank> {
        int c, g, s, b, r;

        public Rank(int c, int g, int s, int b) {
            this.c = c;
            this.g = g;
            this.s = s;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Rank rank = (Rank) o;
            return c == rank.c && g == rank.g && s == rank.s && b == rank.b && r == rank.r;
        }

        @Override
        public int compareTo(Rank o) {
            if (this.g == o.g && this.s == o.s)
                return o.b - this.b;
            if (this.g == o.g)
                return o.s - this.s;
            return o.g - this.g;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Rank> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Rank(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);
        list.get(0).r = 1;
        int x = 0;

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).c==k)
                x = i;
            if (list.get(i).g == list.get(i - 1).g && list.get(i).s == list.get(i - 1).s && list.get(i).b == list.get(i - 1).b) {
                list.get(i).r = list.get(i - 1).r;
            } else {
                list.get(i).r = i + 1;
            }
        }

        System.out.println(list.get(x).r);
    }
}
