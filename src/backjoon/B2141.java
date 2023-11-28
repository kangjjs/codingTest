package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Town implements Comparable<Town> {
    public long p, v;

    public Town(long p, long v) {
        this.p = p;
        this.v = v;
    }

    @Override
    public int compareTo(Town o) {
        return (int) (this.p - o.p);
    }
}

public class B2141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Town> towns = new ArrayList<>();
        long sum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long p = Integer.parseInt(st.nextToken());
            long v = Integer.parseInt(st.nextToken());
            towns.add(new Town(p, v));
            sum += v;
        }

        Collections.sort(towns);
        long v = 0;

        for (Town town : towns) {
            v += town.v;
            if ((sum + 1) / 2 <= v) {
                System.out.println(town.p);
                break;
            }
        }
    }
}
