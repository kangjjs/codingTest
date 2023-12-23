package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2109 {

    static class Lecture implements Comparable<Lecture>{
        int pay,day;

        public Lecture(int pay,int day){
            this.pay=pay;
            this.day=day;
        }


        @Override
        public int compareTo(Lecture o) {
            if(this.day==o.day)
                return o.pay-this.pay;
            return this.day-o.day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> lectureList =new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            lectureList.add(new Lecture(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Queue<Integer> q = new PriorityQueue<>();

        while(!lectureList.isEmpty()){
            Lecture lc =lectureList.poll();
            q.offer(lc.pay);
            if(q.size()>lc.day)
                q.poll();
        }

        int ans=0;
        while (!q.isEmpty())
            ans+=q.poll();

        System.out.println(ans);
    }
}
