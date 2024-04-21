package programmers;

import java.util.*;

class GetMaxAndMin {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a,b) -> b - a);
        PriorityQueue<Integer> minQ = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        for(String x:operations){
            String op = x.split(" ")[0];
            int v = Integer.parseInt(x.split(" ")[1]);

            if(op.equals("I")){
                maxQ.offer(v);
                minQ.offer(v);
            }else if(op.equals("D")){
                if(maxQ.isEmpty())
                    continue;
                if(v==1){
                    int max = maxQ.poll();
                    minQ.remove(max);
                }else if(v==-1){
                    int min = minQ.poll();
                    maxQ.remove(min);
                }
            }
        }

        return maxQ.isEmpty() ? new int[] {0,0} : new int[] {maxQ.poll(),minQ.poll()};
    }
}