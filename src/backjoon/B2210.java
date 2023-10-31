package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class B2210 {
    static char[][] board;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    static StringBuilder sb =new StringBuilder();
    static HashSet<String> answer;

    public void solution(int l, int x, int y) {
        if (l == 6) {
            answer.add(sb.toString());
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0&&nx<5&&ny>=0&&ny<5){
                    sb.append(board[nx][ny]);
                    solution(l+1,nx,ny);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        B2210 T = new B2210();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[5][5];
        answer= new HashSet<>();

        for (int i = 0; i < 5; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = str[j].charAt(0);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                T.solution(0,i,j);
            }
        }

        System.out.println(answer.size());
    }
}
