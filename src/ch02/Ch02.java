package ch02;

import java.util.*;
class Ch02 {
    public int[] solution(String s){
        int[] answer = new int[5];

        int [] str =new int[5];
        int max=0;

        for(char x:s.toCharArray()){
            str[x-97]++;
        }

        for(int x:str){
            max=Math.max(x,max);
        }

        for(int i=0;i<5;i++){
            answer[i]=max-str[i];
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

