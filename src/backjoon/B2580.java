package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2580 {

    static boolean flag1;
    static int[][] board;

    static boolean check(int k,int x,int y){
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == k) {
                return false;
            }

            if (board[i][y] == k) {
                return false;
            }
        }

        int dx = (x / 3) * 3;
        int dy = (y / 3) * 3;

        for (int i = dx; i < dx + 3; i++) {
            for (int j = dy; j < dy + 3; j++) {
                if (board[dx][dy] == k) {
                    return false;
                }
            }
        }

        return true;
    }

    static void solution(int x,int y) {
        if(y==9){
            solution(x+1,0);
            return;
        }

        if(x==9){
            StringBuilder sb =new StringBuilder();

            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(board[i][j]).append(" ");
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        if(board[x][y]==0){
            for(int i=1;i<=9;i++){
                if(check(i,x,y)){
                    board[x][y]=i;
                    solution(x,y+1);
                }
            }

            board[x][y]=0;
            return;
        }

        solution(x,y+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0,0);

        for (int[] x : board) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
