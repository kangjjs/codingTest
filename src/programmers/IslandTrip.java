package programmers;

import java.util.*;

class IslandTrip {
    static int n,m;
    static List<Integer> list;
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static void bfs(int i,int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j]=true;
        int cnt = Integer.parseInt(String.valueOf(map[i][j]));


        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int k=0;k<4;k++){
                int nx = cur[0]+dx[k];
                int ny = cur[1]+dy[k];

                if(nx>=0&&nx<n&&ny>=0&&ny<m&&map[nx][ny]!='X'&&!visited[nx][ny]){
                    visited[nx][ny]=true;
                    cnt +=Integer.parseInt(String.valueOf(map[nx][ny]));
                    q.offer(new int[]{nx,ny});
                }
            }
        }

        list.add(cnt);
    }

    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        visited= new boolean[n][m];
        list = new ArrayList<>();
        for(int i=0;i<maps.length;i++){
            for(int j = 0; j<maps[i].length();j++){
                map[i][j] = maps[i].charAt(j);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]!='X'&&!visited[i][j]){
                    bfs(i,j);
                }
            }
        }

        if(list.isEmpty())
            return new int[] {-1};

        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}