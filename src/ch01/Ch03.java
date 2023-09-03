package ch01;

class Ch03 {
    public int solution(int[][] board) {
        int answer = 0;
        int n=board.length;

        int[] px = {-1, 0, 1, 0};
        int[] py = {0, 1, 0, -1};

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int dogX=0,dogY=0,peX=0,peY=0,dp=0,dd=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    peX=i;
                    peY=j;
                }

                if(board[i][j]==3){
                    dogX=i;
                    dogY=j;
                }
            }
        }

        while(answer<10000){
            answer++;

            boolean bp=true,bd=true;

            int npeX=peX+px[dp];
            int npeY=peY+py[dp];

            int ndX=dogX+dx[dd];
            int ndY=dogY+dy[dd];

            if(npeX>=n||npeX<0||npeY>=n||npeY<0||board[npeX][npeY]==1){
                dp=(dp+1)%4;
                bp=false;
            }

            if(ndX>=n||ndX<0||ndY>=n||ndY<0||board[ndX][ndY]==1){
                dd=(dd+1)%4;
                bd=false;
            }

            if(bp){
                peX=npeX;
                peY=npeY;
            }

            if(bd){
                dogX=ndX;
                dogY=ndY;
            }

            if(peX==dogX&&peY==dogY)
                break;
        }

        if(answer>=10000){
            return 0;
        }else{
            return answer;
        }
    }

    public static void main(String[] args) {
        Ch03 T = new Ch03();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
