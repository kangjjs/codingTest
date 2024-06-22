package programmers;

public class NeighborComponent {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        String color = board[h][w];
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<4;i++){
            int nx = h+dx[i];
            int ny = w+dy[i];
            if(nx>=0&&nx<n&&ny>=0&&ny<m){
                if(color.equals(board[nx][ny]))
                    answer++;
            }
        }


        return answer;
    }
}
