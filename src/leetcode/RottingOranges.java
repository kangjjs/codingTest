package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0)
            return 0;

        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean hasRottenThisRound = false;
            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                for(int j=0;j<4;j++){
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];
                    if(nx>=0&&nx<m&&ny>=0&&ny<n&&grid[nx][ny]==1){
                        q.add(new int[]{nx,ny});
                        grid[nx][ny] = 2;
                        hasRottenThisRound = true;
                        fresh--;
                    }
                }
            }
            if(hasRottenThisRound)
                ans++;
        }

        return fresh==0 ? ans : -1;
    }
}