package ch06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Ch03 {
    int answer, n;
    int[] ch;

    public void dfs(int L, int s, int[][] cans) {
        if (L == n / 2) {
            int sw=0,sb=0;

            for (int i = 0; i < n; i++) {
                if(ch[i]==1)
                    sw+=cans[i][0];
                else
                    sb+=cans[i][1];
            }

            answer = Math.min(answer,Math.abs(sw-sb));
        } else {
            for (int i = s; i < n; i++) {
                ch[i] = 1;
                dfs(L + 1, i + 1, cans);
                ch[i] = 0;
            }
        }
    }

    public int solution(int[][] cans) {
        answer = Integer.MAX_VALUE;
        n = cans.length;
        ch = new int[n];
        dfs(0, 0, cans);

        return answer;
    }

    public static void main(String[] args) {
        Ch03 T = new Ch03();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33}, {25, 32}, {37, 59}, {33, 47}}));
    }
}

