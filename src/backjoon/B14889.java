package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14889 {

    public static int n,ans=Integer.MAX_VALUE;
    public static int[][] team;
    public static int [] teamA;
    public static int [] teamB;
    public static boolean [] check;

    public void chooseTeam(){
        for(int i=0,j=0;i<n;i++){
            if(!check[i]) {
                teamB[j] = i;
                j++;
            }

            if(j==n/2+1)
                break;
        }
    }

    public int findAns(int [] teamA,int [] teamB){
        int sumA=0,sumB=0;

        for(int x: teamA){
            for(int y: teamA){
                if(x!=y)
                    sumA+=team[x][y];
            }
        }

        for(int x: teamB){
            for(int y: teamB){
                if(x!=y)
                    sumB+=team[x][y];
            }
        }

        return Math.abs(sumA-sumB);
    }

    public void solution(int l,int s) {
        if (l == n / 2) {
            chooseTeam();
            ans=Math.min(ans,findAns(teamA,teamB));
        }else{
            for(int i=s;i<n;i++){
                teamA[l]=i;
                check[i]=true;
                solution(l+1,i+1);
                check[i]=false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        B14889 T =new B14889();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        team = new int[n][n];
        teamA = new int[n/2];
        teamB = new int[n/2];
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        T.solution(0,0);
        System.out.println(ans);
    }
}
