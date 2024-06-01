package programmers;
import java.util.*;

public class EscapeMaze {
    static int n,m,lx,ly;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};

    static int findLever(int x,int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited= new boolean[n][m];
        visited[x][y]=true;
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                if(map[cur[0]][cur[1]]=='L'){
                    lx = cur[0];
                    ly = cur[1];
                    return cnt;
                }
                for(int j=0;j<4;j++){
                    int nx = cur[0]+dx[j];
                    int ny = cur[1]+dy[j];
                    if(nx>=0&&nx<n&&ny>=0&&ny<m&&map[nx][ny]!='X'&&!visited[nx][ny]){
                        visited[nx][ny]=true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            cnt++;
        }

        return -1;
    }

    static int findExit(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{lx,ly});
        visited= new boolean[n][m];
        visited[lx][ly]=true;
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                if(map[cur[0]][cur[1]]=='E'){
                    return cnt;
                }
                for(int j=0;j<4;j++){
                    int nx = cur[0]+dx[j];
                    int ny = cur[1]+dy[j];
                    if(nx>=0&&nx<n&&ny>=0&&ny<m&&map[nx][ny]!='X'&&!visited[nx][ny]){
                        visited[nx][ny]=true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            cnt++;
        }

        return -1;
    }

    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();
        lx=0;
        ly=0;
        map = new char[n][m];
        int x=0,y=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = maps[i].charAt(j);
                if(maps[i].charAt(j)=='S'){
                    x=i;
                    y=j;
                }
            }
        }

        int lCnt = findLever(x,y);
        if(lCnt==-1)
            return -1;
        int eCnt = findExit();
        if(eCnt==-1)
            return -1;
        return lCnt+eCnt;
    }
}