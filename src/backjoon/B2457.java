package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2457 {

    static class Flower implements Comparable<Flower> {
        int sd, ed;

        Flower(int sd, int ed) {
            this.sd = sd;
            this.ed = ed;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.sd < o.sd)
                return -1;
            else if (this.sd == o.sd) {
                if (this.ed > o.ed)
                    return -1;
                else if (this.ed == o.ed) {
                    return 0;
                }

                return 1;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Flower> flowerList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            int start = startMonth * 100 + startDay;
            int end = endMonth * 100 + endDay;
            flowerList.add(new Flower(start, end));
        }

        Collections.sort(flowerList);
        int endDay = 1201;
        int startDay = 301;
        int max = 0;
        int index = 0;
        int ans=0;

        while (startDay < endDay) {
            boolean flag = false;

            for (int i = index; i < N; i++) {
                if (flowerList.get(i).sd > startDay)
                    break;
                if (max < flowerList.get(i).ed) {
                    flag = true;
                    max = flowerList.get(i).ed;
                    index = i + 1;
                }
            }

            if(flag){
                startDay=max;
                ans++;
            }else{
                break;
            }
        }

        if(max<endDay)
            System.out.println(0);
        else
            System.out.println(ans);
    }
}
