package ch01;
import java.util.*;

public class Ch04 {
        public int[] solution(int c, int r, int k) {
            int[] answer = new int[2];

            if(k>c*r){
                return new int[] {0,0};
            }

            int[][] seat=new int[c][r];
            int [] dx={0,1,0,-1};
            int [] dy={1,0,-1,0};
            int count=1,x=0,y=0,d=0;

            while(count<k){
                int nx=x+dx[d];
                int ny=y+dy[d];
                if(nx<0||nx>=c||ny<0||ny>=r||seat[nx][ny]==1){
                    d=(d+1)%4;
                    continue;
                }
                seat[x][y]=1;
                count++;
                x=nx;
                y=ny;
            }

            answer[0]=x+1;
            answer[1]=y+1;

            return answer;
        }

    public static void main(String[] args){
        Ch04 T = new Ch04();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
