package section08;

import java.util.ArrayList;
import java.util.Scanner;

public class S15 {

    static int n, m, len,answer = Integer.MAX_VALUE;
    static ArrayList<Point> pz, hm;
    static int[] arr;

    public void solution(int l,int s) {
        if (l == m) {
            int sum = 0;

            for (Point h : hm) {
                int dis = Integer.MAX_VALUE;
                for (int i : arr) {
                    dis = Math.min(dis, (Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y)));
                }
                sum += dis;
            }

            answer = Math.min(sum, answer);
        } else {
            for (int i = s; i < len; i++) {
                arr[l] = i;
                solution(l + 1,s+1);
            }
        }
    }

    public static void main(String[] args) {
        S15 T = new S15();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[m];
        pz = new ArrayList<>();
        hm = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = kb.nextInt();

                if (tmp == 1) {
                    hm.add(new Point(i, j));
                } else if (tmp == 2) {
                    pz.add(new Point(i, j));
                }
            }
        }

        len=pz.size();

        T.solution(0,0);
        System.out.print(answer);
    }
}
