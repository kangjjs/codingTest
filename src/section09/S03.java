package section09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time>{
    public int t;
    public char s;

    public Time(int t,char s){
        this.t=t;
        this.s=s;
    }


    @Override
    public int compareTo(Time o) {
        if(this.t==o.t)
            return this.s-o.s;
        else
            return this.t-o.t;
    }
}
public class S03 {

    public int solution(ArrayList<Time> times){
        Collections.sort(times);
        int answer=Integer.MIN_VALUE;
        int count=0;
        for(Time t:times){
            if(t.s=='s')
                count++;
            else
                count--;
            answer=Math.max(answer,count);
        }

        return answer;
    }

    public static void main(String[] args) {
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        ArrayList<Time> times = new ArrayList<>();

        for(int i=0;i<n;i++){
            int at=kb.nextInt();
            int lt=kb.nextInt();
            times.add(new Time(at,'s'));
            times.add(new Time(lt,'l'));
        }

        System.out.print(T.solution(times));
    }
}
