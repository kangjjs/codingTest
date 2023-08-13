package section09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture>{
    public int t;
    public int d;

    public Lecture(int t,int d){
        this.t=t;
        this.d=d;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.d-this.d;
    }
}

public class S04 {

    public int solution(ArrayList<Lecture> lectures,int n,int max){
        Collections.sort(lectures);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int j=0,answer=0;

        for(int i=max;i>=1;i--){
            for(;j<n;j++){
                if(lectures.get(j).d<i)
                    break;
                priorityQueue.offer(lectures.get(j).t);
            }
            if(!priorityQueue.isEmpty())
                answer+=priorityQueue.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        S04 T = new S04();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int max=Integer.MIN_VALUE;
        ArrayList<Lecture> lectures = new ArrayList<>();

        for(int i=0;i<n;i++){
            int t=kb.nextInt();
            int d=kb.nextInt();
            lectures.add(new Lecture(t,d));
            if(max<d)
                max=d;
        }

        System.out.print(T.solution(lectures,n,max));
    }
}
