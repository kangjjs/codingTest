package ch02;

import java.util.HashMap;

class Ch01 {
    public int solution(String s){
        HashMap<Character,Integer> answer =new HashMap<>();

        for(char x:s.toCharArray()){
            answer.put(x,answer.getOrDefault(x,0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(answer.get(s.charAt(i))==1)
                return i+1;
        }

        return -1;
    }

    public static void main(String[] args){
        Ch01 T = new Ch01();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
