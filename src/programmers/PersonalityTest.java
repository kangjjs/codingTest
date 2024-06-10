package programmers;
import java.util.*;

public class PersonalityTest {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character,Integer> hm = new HashMap<>();
        String[] s = new String[]{"RT","CF","JM","AN"};
        for(String x:s){
            char y = x.charAt(0);
            char z = x.charAt(1);

            hm.put(y,0);
            hm.put(z,0);
        }
        for(int i=0;i<survey.length;i++){
            char x = survey[i].charAt(0);
            char y = survey[i].charAt(1);

            if(choices[i]<4){
                hm.put(x,hm.getOrDefault(x,0)+(4-choices[i]));
            }else if(choices[i]>4){
                hm.put(y,hm.getOrDefault(y,0)+(choices[i]-4));
            }
        }

        for(String x:s){
            char y = x.charAt(0);
            char z = x.charAt(1);

            if(hm.get(y)>=hm.get(z))
                answer+=y;
            else if(hm.get(y)<hm.get(z)){
                answer+=z;
            }
        }

        return answer;
    }
}
