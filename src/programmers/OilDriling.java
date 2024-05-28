package programmers;

import java.util.*;

class OilDriling {

    static int w,h;
    static int[] answer;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static void bfs(int[][]land,int n,int m){
        Queue<int[]> q = new LinkedList<>();
        int cnt = 1;
        visited[n][m]=true;
        q.offer(new int[]{n,m});
        Set<Integer> s = new HashSet<>();

        while(!q.isEmpty()){
            int[] cur = q.poll();
            s.add(cur[1]);
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx>=0&&nx<h&&ny>=0&&ny<w&&land[nx][ny]==1){
                    if(!visited[nx][ny]){
                        visited[nx][ny]=true;
                        q.offer(new int[]{nx,ny});
                        cnt++;
                    }
                }
            }
        }

        for(int x:s){
            answer[x]+=cnt;
        }
    }

    public int solution(int[][] land) {
        w = land[0].length;
        h = land.length;
        answer = new int[w];
        visited= new boolean[h][w];
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(land[i][j]==1&&!visited[i][j]){
                    bfs(land,i,j);
                }
            }
        }
        Arrays.sort(answer);

        return answer[w-1];
    }
}