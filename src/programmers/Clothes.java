package programmers;

import java.util.*;

class Clothes {
    public int solution(String[][] clothes) {
        HashMap<String,Integer> hm = new HashMap<>();
        for(String[] x : clothes){
            hm.put(x[1],hm.getOrDefault(x[1],0)+1);
        }

        int answer = 1;
        for(String x : hm.keySet()){
            answer *= (hm.get(x)+1);
        }

        return answer-1;
    }
}