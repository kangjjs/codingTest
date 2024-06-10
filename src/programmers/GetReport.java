package programmers;

import java.util.*;

public class GetReport {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String,Set<String>> map = new HashMap<>();
        for(String r:report){
            String x = r.split(" ")[0];
            String y = r.split(" ")[1];

            if(!map.containsKey(y)){
                map.put(y,new HashSet<>());
            }
            map.get(y).add(x);
        }
        Map<String,Integer> hm = new HashMap<>();
        for(String id:id_list){
            if(map.containsKey(id)&&map.get(id).size()>=k){
                for(String x:map.get(id)){
                    hm.put(x,hm.getOrDefault(x,0)+1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for(int i=0;i<answer.length;i++){
            answer[i] = hm.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}
