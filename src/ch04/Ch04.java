package ch04;

import java.util.Arrays;

class Ch04 {

    public int avg(int[] score,int s,int e){
        int sum = 0;
        for (int i = s; i <=e; i++) {
            sum+=score[i];
        }

        return (int) Math.floor((sum/(e-s+1)));
    }

    public int solution(int[] score, int k){
        int answer = 0;
        Arrays.sort(score);
        int n = score.length;
        for (int i = 0; i <= n-k; i++) {
            if(score[i+k-1]-score[i]<=10){
                return avg(score,i,i+k-1);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ch04 T = new Ch04();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}
