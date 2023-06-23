package ch02;

import java.util.*;
class Ch02 {
    public int[] solution(String s){
        int[] answer = new int[5];

        HashMap<Character,Integer> hashMap =new HashMap<>();

        for(char c:s.toCharArray()){
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }

        int max=-1;
        String tmp ="abcde";

        for(char c: hashMap.keySet()){
            max=Math.max(hashMap.get(c),max);
        }

        for(int i=0;i<answer.length;i++){
            answer[i]=max-hashMap.getOrDefault(tmp.charAt(i),0);
        }

        return answer;
    }

    public static void main(String[] args){
        Ch02 T = new Ch02();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}

