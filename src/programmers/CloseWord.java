package programmers;

import java.util.HashMap;

public class CloseWord {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int x = hm.getOrDefault(s.charAt(i), -1);
            if(x==-1)
                answer[i]= -1;
            else{
                answer[i] = i - hm.get(s.charAt(i));
            }
            hm.put(s.charAt(i),i);
        }

        return answer;
    }
}
