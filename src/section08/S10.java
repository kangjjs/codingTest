package section08;

import java.util.Scanner;

public class S10 {

    static int answer=0;
    static int [][] board=new int[8][8];

    int []dx={1,0,-1,0};
    int []dy={0,1,0,-1};

    public void solution(int x,int y){
        if(x==7&&y==7) {
            answer++;
        }else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    solution(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        S10 T = new S10();
        Scanner kb = new Scanner(System.in);

        for(int i=1;i<=7;i++){
            for(int j=1;j<=7;j++){
                board[i][j]=kb.nextInt();
            }
        }

        board[1][1]=1;

        T.solution(1,1);
        System.out.print(answer);
    }
}
