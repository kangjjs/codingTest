package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B7682 {

    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("end"))
                break;
            board = new char[3][3];
            int xCnt = 0, oCnt = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char x = str.charAt(i * 3 + j);
                    board[i][j] = x;
                    if (x == 'X')
                        xCnt++;
                    if (x == 'O')
                        oCnt++;
                }
            }

            if (xCnt - oCnt == 1) {
                if(xCnt+oCnt==9&&!check('O')){
                    System.out.println("valid");
                }else if(!check('O')&&check('X')){
                    System.out.println("valid");
                }else
                    System.out.println("invalid");
            }else if(xCnt==oCnt){
                if(!check('X')&&check('O'))
                    System.out.println("valid");
                else
                    System.out.println("invalid");
            }else {
                System.out.println("invalid");
            }
        }
    }
    static boolean check(char c) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == c && board[i][1] == c && board[i][2] == c)
                return true;
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == c && board[1][i] == c && board[2][i] == c)
                return true;
        }

        if(board[0][0]==c&&board[1][1]==c&&board[2][2]==c)
            return true;
        return board[0][2] == c && board[1][1] == c && board[2][0] == c;
    }
}
