package programmers;
import java.util.*;

public class MemoryScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String,Integer> hm = new HashMap<>();

        for(int i=0;i<name.length;i++){
            hm.put(name[i],yearning[i]);
        }
        int idx =0;

        for(String[] p : photo){
            int sum = 0;
            for(String x:p){
                if(hm.containsKey(x)){
                    sum+=hm.get(x);
                }
            }
            answer[idx++] = sum;
        }

        return answer;
    }
}
