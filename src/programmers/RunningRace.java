package programmers;

import java.util.*;

public class RunningRace {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String,Integer> hm1 = new HashMap<>();
        HashMap<Integer,String> hm2 = new HashMap<>();

        for(int i=0;i<players.length;i++){
            hm1.put(players[i],i+1);
            hm2.put(i+1,players[i]);
        }

        for(String x:callings){
            int z = hm1.get(x);
            String y = hm2.get(z-1);
            hm2.put(z,y);
            hm2.put(z-1,x);
            hm1.put(x,z-1);
            hm1.put(y,z);
        }
        String[] answer = new String[players.length];
        for(int i=0;i<players.length;i++){
            answer[i] = hm2.get(i+1);
        }

        return answer;
    }
}
