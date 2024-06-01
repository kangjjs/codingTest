package programmers;

import java.util.*;

public class RicoChat {
    static int n,m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int bfs(int x,int y,char[][] map){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] =true;
        int ans =0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                if(map[cur[0]][cur[1]]=='G')
                    return ans;
                for(int j=0;j<4;j++){
                    int nx = cur[0] +dx[j];
                    int ny = cur[1] +dy[j];
                    if(nx<0||nx>=n||ny<0||ny>=m)
                        continue;
                    while(nx>=0&&nx<n&&ny>=0&&ny<m&&map[nx][ny]!='D'){
                        nx+=dx[j];
                        ny+=dy[j];
                    }

                    nx-=dx[j];
                    ny-=dy[j];

                    if(!visited[nx][ny]){
                        visited[nx][ny]=true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            ans++;
        }

        return -1;
    }

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];
        int x=0,y=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                map[i][j]=board[i].charAt(j);
                if(board[i].charAt(j)=='R'){
                    x=i;
                    y=j;
                }
            }
        }
        return bfs(x,y,map);
    }
}
