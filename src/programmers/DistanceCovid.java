package programmers;
import java.util.*;

public class DistanceCovid {
    static boolean check(int x,int y,String[] place){
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        boolean[][] visited = new boolean[5][5];
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0||nx>=5||ny<0||ny>=5||place[nx].charAt(ny)=='X'||visited[nx][ny])
                    continue;
                int dis = Math.abs(x-nx)+Math.abs(y-ny);
                if(dis<=2&&place[nx].charAt(ny)=='P')
                    return false;
                if(dis<=2&&place[nx].charAt(ny)=='O'){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }

        return true;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0;i<places.length;i++){
            boolean flag = true;
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    if(places[i][j].charAt(k)=='P'){
                        if(!check(j,k,places[i])){
                            flag = false;
                            break;
                        }
                    }
                }

                if(!flag)
                    break;
            }

            if(flag)
                answer[i]=1;
            else
                answer[i]=0;
        }

        return answer;
    }
}
