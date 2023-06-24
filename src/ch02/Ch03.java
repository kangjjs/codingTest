package ch02;

import java.util.*;
class Ch03 {
    public int solution(String s){
        int answer = 0;

        HashMap<Character,Integer> hm =new HashMap<>();

        for(char x:s.toCharArray()){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(char c:hm.keySet()){
            while(arrayList.contains(hm.get(c))) {
                answer++;
                hm.put(c,hm.get(c)-1);
            }

            if(hm.get(c)==0)
                continue;
            arrayList.add(hm.get(c));
        }

        return answer;
    }

    public static void main(String[] args){
        Ch03 T = new Ch03();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
