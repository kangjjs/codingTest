package programmers;

import java.util.*;

class RoomNum {

    static class Point{
        public int x,y;

        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        public int hashCode(){
            return Objects.hash(x,y);
        }

        public boolean equals(Object o){
            return this.x ==((Point)o).x && this.y == ((Point)o).y;
        }
    }

    static ArrayList<Point> getEdge(Point p){
        ArrayList<Point> edge =new ArrayList<>();
        edge.add(p);
        return edge;
    }

    public int solution(int[] arrows) {
        int answer = 0;

        Point cur = new Point(0,0);
        int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };

        HashMap<Point,ArrayList<Point>> visited = new HashMap<>();

        for(int i : arrows){
            for(int j=0 ; j <= 1;j++){
                Point next = new Point(cur.x+dx[i],cur.y+dy[i]);
                if(!visited.containsKey(next)){
                    visited.put(next,getEdge(cur));

                    if(visited.get(cur)==null){
                        visited.put(cur,getEdge(next));
                    }else{
                        visited.get(cur).add(next);
                    }
                }else if(visited.containsKey(next) && !(visited.get(next).contains(cur))){
                    visited.get(next).add(cur);
                    visited.get(cur).add(next);
                    answer++;
                }

                cur = next;
            }
        }

        return answer;
    }
}