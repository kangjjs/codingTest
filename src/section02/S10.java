package section02;

import java.util.*;
class S10 {

    public int solution(int [][] arr){
        int [] dx= {1,0,-1,0};
        int [] dy={0,1,0,-1};

        int n=arr.length;
        int answer=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                boolean flag=true;

                for(int k=0;k<4;k++){
                    int nx=i+dx[k];
                    int ny=j+dy[k];

                    if(nx>=0&&nx<n&&ny>=0&&ny<n&&arr[nx][ny]>=arr[i][j]){
                        flag=false;
                        break;
                    }
                }

                if(flag)
                    answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        S10 T = new S10();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        int [][] arr =new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=kb.nextInt();
            }
        }

        System.out.print(T.solution(arr));

    }
}
