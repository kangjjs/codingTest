package section08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    public int x;
    public int y;

    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}

public class S11 {

    static int [][] board,answer;

    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};


    public void solution(int x,int y){
        Queue<Point> queue =new LinkedList<>();

        queue.offer(new Point(x,y));
        board[x][y]=1;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0;i<4;i++){
                int nx=p.x+dx[i];
                int ny=p.y+dy[i];

                if(nx>=1&&nx<=7&&ny>=1&&ny<=7&&board[nx][ny]==0){
                    board[nx][ny]=1;
                    queue.offer(new Point(nx,ny));
                    answer[nx][ny]=answer[p.x][p.y]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        S11 T = new S11();
        Scanner kb = new Scanner(System.in);

        board = new int[8][8];
        answer =new int [8][8];

        for(int i=1;i<=7;i++){
            for(int j=1;j<=7;j++){
                board[i][j]=kb.nextInt();
            }
        }

        T.solution(1,1);

        if(answer[7][7]==0){
            System.out.print(-1);
        }

        System.out.print(answer[7][7]);
    }
}
