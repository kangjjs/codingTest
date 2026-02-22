package programmers;

import java.util.*;

class ConflictDetective {

    static class Point{
        int x,y;

        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static Map<String, Integer> cnt;

    public int solution(int[][] points, int[][] routes) {
        Point[] P = new Point[points.length + 1];
        for (int i = 0; i < points.length; i++) {
            P[i + 1] = new Point(points[i][0], points[i][1]);
        }

        cnt = new HashMap<>();

        for(int[] route:routes){
            Point start = P[route[0]];
            int sx = start.x;
            int sy = start.y;
            int t = 0;
            add(sx,sy,t);

            for(int i=1;i<route.length;i++){
                Point target = P[route[i]];
                int tx = target.x;
                int ty = target.y;

                while(tx!=sx){
                    sx += (tx>sx) ? 1 : -1;
                    t++;
                    add(sx,sy,t);
                }

                while(sy!=ty){
                    sy += (ty>sy) ? 1 : -1;
                    t++;
                    add(sx,sy,t);
                }
            }
        }

        int answer = 0;
        for(int count : cnt.values()){
            if(count>=2)
                answer++;
        }

        return answer;
    }

    static void add(int t,int x,int y){
        String key = t+","+x+","+y;
        cnt.put(key,cnt.getOrDefault(key,0)+1);
    }
}