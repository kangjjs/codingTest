package ch01;

import java.util.Arrays;

class Ch07 {
    public int solution(int[] keypad, String password) {
        int answer = 0;
        int[][] key = new int[3][3];
        int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
        int[][] dist = new int[10][10];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                key[i][j] = keypad[i*3+j];
            }
        }

        for (int i = 0; i < 10; i++) {
            Arrays.fill(dist[i],2);
        }

        for (int i = 0; i < 10; i++) {
            dist[i][i]=0;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int from = key[i][j];
                for (int k = 0; k < 8; k++) {
                    if(i+dx[k]>=0 && i+dx[k]<3 && j+dy[k]>=0 && j+dy[k]<3){
                        int to = key[i+dx[k]][j+dy[k]];
                        dist[from][to]=1;
                    }
                }
            }
        }

        for (int i = 0; i < password.length()-1; i++) {
            int from = (int)password.charAt(i)-48;
            int to = (int)password.charAt(i+1)-48;
            answer += dist[from][to];
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch07 T = new Ch07();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
