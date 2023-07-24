package section08;

import java.util.Scanner;

public class S10 {

    static int [][] arr = new int[7][7];
    static int answer=0;
    int [] dx={1,0,-1,0};
    int [] dy={0,1,0,-1};

    public void solution(int x,int y){
        if(x==6&&y==6){
            answer++;

        }else{
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx>=0&&nx<7&&ny>=0&&ny<7&&arr[nx][ny]==0){
                    arr[nx][ny]=1;
                    solution(nx,ny);
                    arr[nx][ny]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        S10 T = new S10();
        Scanner kb = new Scanner(System.in);

        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                arr[i][j]=kb.nextInt();
            }
        }
        arr[0][0]=1;
        T.solution(0,0);
        System.out.print(answer);
    }
}