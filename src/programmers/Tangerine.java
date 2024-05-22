package programmers;

import java.util.*;

class Tangerine {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int x:tangerine){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int x:hm.keySet()){
            list.add(hm.get(x));
        }

        list.sort(Collections.reverseOrder());
        for(int x:list){
            k-=x;
            answer++;
            if(k<=0)
                break;
        }

        return answer;
    }
}