package programmers;

public class PathLength {
    static int[][] map;
    static boolean[][][] visited;

    public int solution(String dirs) {
        int answer = 0;
        map = new int[11][11];
        visited = new boolean[11][11][4];

        int[] dx ={1,-1,0,0};
        int[] dy ={0,0,-1,1};
        int[] op = {1,0,3,2};

        int x = 5;
        int y = 5;

        for(char c: dirs.toCharArray()){
            int d = dir(c);

            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx<0 || nx >=11 || ny<0 || ny>=11)
                continue;

            if(!visited[x][y][d]){
                visited[x][y][d] = true;
                visited[nx][ny][op[d]] = true;
                answer++;
            }

            x = nx;
            y = ny;
        }

        return answer;
    }

    static int dir(char c){
        if(c=='U')
            return 0;
        else if(c=='D')
            return 1;
        else if(c=='L')
            return 2;
        return 3;
    }
}
