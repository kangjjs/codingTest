package section09;

import java.util.*;


class Lecture implements Comparable<Lecture>{

    public int m;
    public int d;

    public Lecture(int m,int d){
        this.m=m;
        this.d=d;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.d-this.d;
    }
}
public class S04 {

    static int max=Integer.MIN_VALUE;

    public int solution(ArrayList<Lecture> lectures,int n){
        Collections.sort(lectures);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int answer=0;
        int j=0;

        for(int i=max;i>=1;i--){
            for(;j<n;j++){
               if(lectures.get(j).d<i)
                   break;
               priorityQueue.offer(lectures.get(j).m);
            }

            if(!priorityQueue.isEmpty())
                answer+=priorityQueue.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        S04 T = new S04();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        ArrayList<Lecture> queue = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = kb.nextInt();
            int d = kb.nextInt();
            queue.add(new Lecture(m,d));
            max=Math.max(max,d);
        }

        System.out.println(T.solution(queue,n));
    }
}
