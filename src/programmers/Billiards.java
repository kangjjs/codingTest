package programmers;
import java.util.*;

public class Billiards {
    static int sx,sy,ex,ey;

    static int up(int[] ball){
        if(sx==ball[0]&&sy<ball[1])
            return Integer.MAX_VALUE;
        int x = ball[0];
        int y = ey+(ey-ball[1]);

        return (int)Math.pow((x-sx),2)+(int)Math.pow((y-sy),2);
    }

    static int down(int[] ball){
        if(sx==ball[0]&&ball[1]<sy)
            return Integer.MAX_VALUE;
        int x = ball[0];
        int y = -ball[1];

        return (int)Math.pow((x-sx),2)+(int)Math.pow((y-sy),2);
    }

    static int left(int[] ball){
        if(sy==ball[1]&&ball[0]<sx)
            return Integer.MAX_VALUE;
        int x = -ball[0];
        int y = ball[1];

        return (int)Math.pow((x-sx),2)+(int)Math.pow((y-sy),2);
    }

    static int right(int[] ball){
        if(sy==ball[1]&&sx<ball[0])
            return Integer.MAX_VALUE;
        int x = ex+(ex-ball[0]);
        int y = ball[1];

        return (int)Math.pow((x-sx),2)+(int)Math.pow((y-sy),2);
    }

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        ArrayList<Integer> answer = new ArrayList<>();
        sx = startX;
        sy = startY;
        ex = m;
        ey = n;

        for(int[] ball:balls){
            int min = Integer.MAX_VALUE;
            min = Math.min(min,up(ball));
            min = Math.min(min,down(ball));
            min = Math.min(min,right(ball));
            min = Math.min(min,left(ball));
            answer.add(min);
        }

        int[] ans = new int[answer.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = answer.get(i);
        }

        return ans;
    }
}
