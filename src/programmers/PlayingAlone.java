package programmers;

import java.util.*;

public class PlayingAlone {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] visited = new boolean[cards.length];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<cards.length;i++){
            Queue<Integer> q = new LinkedList<>();
            int size = 0;
            if(!visited[cards[i]-1]){
                visited[cards[i]-1] = true;
                q.offer(cards[i]-1);
                size++;
                while(!q.isEmpty()){
                    int cur = q.poll();
                    if(!visited[cards[cur]-1]){
                        visited[cards[cur]-1] = true;
                        q.offer(cards[cur]-1);
                        size++;
                    }
                }
                list.add(size);
            }
        }

        list.sort(Comparator.reverseOrder());
        if(list.size()==1)
            return 0;
        else{
            return list.get(0)*list.get(1);
        }
    }
}
