package ch01;

import java.util.*;
class Ch01 {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];

        for(int i = 0; i < n; i++){
            answer[i] = (char)(i + 65);
        }

        for(int [] l:ladder){
            for(int x: l){
                char tmp=answer[x];
                answer[x]=answer[x-1];
                answer[x-1]=tmp;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ch01 T = new Ch01();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}