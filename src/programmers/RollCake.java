package programmers;

import java.util.HashMap;
import java.util.Map;

public class RollCake {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();

        for(int x:topping){
            map1.put(x,map1.getOrDefault(x,0)+1);
        }

        for(int x:topping){
            map2.put(x,map2.getOrDefault(x,0)+1);

            if(map1.get(x)-1==0){
                map1.remove(x);
            }else{
                map1.put(x,map1.get(x)-1);
            }

            if(map1.size()==map2.size())
                answer++;
        }

        return answer;
    }
}
