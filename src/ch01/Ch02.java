package ch01;

import java.util.*;
class Ch02 {
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];

        int [] dx = {0,1,0,-1};
        int [] dy= {1,0,-1,0};

        int count=0;
        int d=0,x=0,y=0;
        while(count<k){
            count++;
            int px=x+dx[d];
            int py=y+dy[d];

            if(px<0||px>=board.length||py<0||py>= board.length||board[px][py]==1){
                d=(d+1)%4;
                continue;
            }
            x=px;
            y=py;
        }

        answer[0]=x;
        answer[1]=y;

        return answer;
    }

    public static void main(String[] args){
        Ch02 T = new Ch02();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
