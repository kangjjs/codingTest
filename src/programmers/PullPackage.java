package programmers;

public class PullPackage {
    public int solution(int n, int w, int num) {
        int k = n /w;
        int[][] board = new int[k+1][w];

        int x = 1,r=0,c=0;
        int fx =0,fy =0;

        while(x<=n){
            board[r][c] = x;
            if(num==x){
                fx= r;
                fy= c;
            }

            if(r%2==0){
                if(c==w-1){
                    r++;
                }else{
                    c++;
                }
            }else{
                if(c==0)
                    r++;
                else
                    c--;
            }
            x++;
        }

        int answer = 0;

        for(int i=fx;i<=k;i++){
            if(board[i][fy]!=0)
                answer++;
        }

        return answer;
    }
}
