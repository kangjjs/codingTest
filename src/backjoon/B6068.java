package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B6068 {

    static class Farm implements Comparable<Farm> {
        int s, t;

        public Farm(int s, int t) {
            this.s = s;
            this.t = t;
        }

        @Override
        public int compareTo(Farm o) {
            if (this.t == o.t)
                return this.s - o.s;
            return this.t - o.t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Farm> farms = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            farms.add(new Farm(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(farms);
        int x = farms.get(0).t - farms.get(0).s;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i <= x; i++) {
            int time = i;
            boolean flag = false;
            for(Farm f : farms){
                time+=f.s;
                if(time>f.t){
                    flag=true;
                    break;
                }
            }

            if(flag)
                continue;
            ans=Math.max(ans,i);
        }

        if(ans==Integer.MIN_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
}
