package ch01;

import java.util.*;

class Ch02 {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int[] solution(int[][] board, int k) {
        int[] answer = new int[2];
        int count = 0;

        int i = 1, x = 0, y = 0;

        while (count < k) {
            count++;

            int nx = x + dx[i];
            int ny = y + dy[i];


            if(nx>=board.length||nx<0||ny>=board.length||ny<0||board[nx][ny]==1){
                i=(i+1)%4;
                continue;
            }

            x=nx;
            y=ny;
        }

        answer[0]=x;
        answer[1]=y;

        return answer;
    }

    public static void main(String[] args) {
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
