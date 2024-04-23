package programmers;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Boat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Deque<Integer> dq = new LinkedList<>();
        Arrays.sort(people);
        for(int x : people){
            dq.offer(x);
        }

        while(!dq.isEmpty()){
            int cur = dq.pollLast();

            if(!dq.isEmpty()&& dq.peek()+cur<=limit){
                dq.poll();
            }

            answer++;
        }

        return answer;
    }
}
