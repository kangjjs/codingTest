package section08;

import java.util.*;

class S15 {

    static int n, m, len, ans = Integer.MAX_VALUE;
    static int[][] board;
    static int[] c;
    static ArrayList<Point> hm, pz;

    public void solution(int l, int s) {
        if (l == m) {
            int sum=0;
            for(Point h : hm){
                int dis = Integer.MAX_VALUE;
                for(int i:c){
                    dis=Math.min(dis,Math.abs(h.x-pz.get(i).x)+Math.abs(h.y-pz.get(i).y));
                }
                sum += dis;
            }
            ans = Math.min(sum,ans);
        } else {
            for(int i=s;i<len;i++){
                c[l]=i;
                solution(l+1,i+1);
            }
        }
    }

    public static void main(String[] args) {
        S15 T = new S15();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();
        hm = new ArrayList<>();
        pz = new ArrayList<>();
        board = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = kb.nextInt();
                if (board[i][j] == 1)
                    hm.add(new Point(i, j));
                if (board[i][j] == 2)
                    pz.add(new Point(i, j));
            }
        }

        len = pz.size();
        c = new int[m];

        T.solution(0,0);
        System.out.print(ans);
    }
}
