package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class PilarAndFloor {
    static ArrayList<Point> buildings;

    static class Point implements Comparable<Point> {

        int x, y, s;

        public Point(int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {
            Point point = (Point) o;
            return point.x == this.x && point.y == this.y && point.s == this.s;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x && this.y == o.y)
                return this.s - o.s;
            if (this.x == o.x)
                return this.y - o.y;
            return this.x - o.x;
        }
    }

    static void remove(int x, int y, int s) {
        buildings.remove(new Point(x, y, s));
        boolean flag = true;

        for (Point p : buildings) {
            if (p.s == 0) {
                if (!canPilar(p.x, p.y))
                    flag = false;
            } else {
                if (!canFloor(p.x, p.y))
                    flag = false;
            }
        }

        if (!flag) {
            buildings.add(new Point(x, y, s));
        }
    }

    static boolean canPilar(int x, int y) {
        return y == 0 || buildings.contains(new Point(x, y - 1, 0)) ||
                buildings.contains(new Point(x - 1, y, 1)) ||
                buildings.contains(new Point(x, y, 1));
    }

    static boolean canFloor(int x, int y) {
        return buildings.contains(new Point(x, y - 1, 0)) ||
                buildings.contains(new Point(x + 1, y - 1, 0)) ||
                (buildings.contains(new Point(x - 1, y, 1))) &&
                        buildings.contains(new Point(x + 1, y, 1));
    }

    public int[][] solution(int n, int[][] build_frame) {

        buildings = new ArrayList<>();
        for (int[] x : build_frame) {
            if (x[3] == 1) {
                if (x[2] == 0) {
                    if (canPilar(x[0], x[1]))
                        buildings.add(new Point(x[0], x[1], x[2]));
                } else if (x[2] == 1) {
                    if (canFloor(x[0], x[1]))
                        buildings.add(new Point(x[0], x[1], x[2]));
                }
            } else {
                remove(x[0], x[1], x[2]);
            }
        }

        Collections.sort(buildings);

        int[][] answer = new int[buildings.size()][3];
        for (int i = 0; i < buildings.size(); i++) {
            answer[i][0] = buildings.get(i).x;
            answer[i][1] = buildings.get(i).y;
            answer[i][2] = buildings.get(i).s;
        }

        return answer;
    }

    public static void main(String[] args) {
        PilarAndFloor s = new PilarAndFloor();
        int[][] num = {{0, 0, 0, 1},
                {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};
        s.solution(5, num);
    }
}
