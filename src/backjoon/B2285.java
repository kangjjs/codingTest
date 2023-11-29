package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2285 {

    public static class Town implements Comparable<Town> {
        public long pos, pop;

        public Town(long pos, long pop) {
            this.pos = pos;
            this.pop = pop;
        }


        @Override
        public int compareTo(Town o) {
            return (int) (this.pos - o.pos);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        ArrayList<Town> towns = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long pos = Long.parseLong(st.nextToken());
            long pop = Long.parseLong(st.nextToken());
            towns.add(new Town(pos, pop));
            sum += pop;
        }

        Collections.sort(towns);

        long pop = 0;
        for (Town t : towns) {
            pop+=t.pop;
            if(pop>=(sum+1)/2){
                System.out.println(t.pos);
                break;
            }
        }
    }
}
