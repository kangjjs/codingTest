package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B18234 {

    static class Carrot implements Comparable<Carrot> {
        long w, p;

        Carrot(long w, long p) {
            this.w = w;
            this.p = p;
        }


        @Override
        public int compareTo(Carrot o) {
            return (int) (this.p - o.p);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());
        List<Carrot> carrotList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            long w = Long.parseLong(st.nextToken());
            long p = Long.parseLong(st.nextToken());

            carrotList.add(new Carrot(w, p));
        }

        Collections.sort(carrotList);
        long ans=0;

        for (int i = 0; i < N; i++) {
            long result = (i+T-N) * carrotList.get(i).p + carrotList.get(i).w;
            ans+=result;
            System.out.println(result);
        }

        System.out.println(ans);
    }
}
