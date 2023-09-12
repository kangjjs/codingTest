package ch02;

import java.util.*;
class Ch02_1 {
    public int[] solution(String s){
        int[] answer = new int[5];

        HashMap<Character,Integer> hm = new HashMap<>();

        for(char x:s.toCharArray()){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }

        String tmp="abcde";
        int max=Integer.MIN_VALUE;

        for(char x:tmp.toCharArray()){
            if(hm.getOrDefault(x,0)>max)
                max=hm.getOrDefault(x,0);
        }

        for(int i=0;i<5;i++){
            answer[i]=max-hm.getOrDefault(tmp.charAt(i),0);
        }

        return answer;
    }

    public static void main(String[] args){
        Ch02_1 T = new Ch02_1();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
