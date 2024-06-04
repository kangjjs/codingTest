package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SameSumQueue {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        for (int j : queue1) {
            q1.offer(j);
        }

        for (int x : queue2) {
            q2.offer(x);
        }

        int cnt = 0;
        while(sum1!=sum2){
            if(cnt>(queue1.length+queue2.length)*2)
                return -1;
            if(sum1>sum2){
                int x = q1.poll();
                q2.offer(x);
                sum1-= x;
                sum2+= x;
            }else if(sum1<sum2){
                int x = q2.poll();
                q1.offer(x);
                sum1+= x;
                sum2-= x;
            }else{
                return cnt;
            }
            cnt++;
        }

        return cnt;
    }
}
