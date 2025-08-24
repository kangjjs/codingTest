package programmers;

public class TicTac {
    public int solution(String[] board) {
        char[][] map = new char[3][3];
        int o=0,x=0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                map[i][j] = board[i].charAt(j);
                if(board[i].charAt(j)=='O')
                    o++;
                else if(board[i].charAt(j)=='X')
                    x++;
            }
        }

        if(x>o || o>x+1)
            return 0;

        boolean oWin = win(map,'O');
        boolean xWin = win(map,'X');

        if(oWin && xWin)
            return 0;
        if(oWin && o!=x+1)
            return 0;
        if(xWin && o!=x)
            return 0;
        return 1;
    }

    static boolean win(char[][] map, char ch){
        for(int i=0;i<3;i++){
            if(map[i][0]==ch && map[i][1]==ch && map[i][2]==ch)
                return true;
            if(map[0][i]==ch && map[1][i]==ch && map[2][i] ==ch)
                return true;
        }

        if(map[0][0]==ch && map[1][1]==ch && map[2][2]==ch)
            return true;
        if(map[0][2]==ch && map[1][1]==ch && map[2][0]==ch)
            return true;
        return false;
    }
}
