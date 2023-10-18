package section10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Top implements Comparable<Top> {

    public int a, h, w;

    public Top(int a, int h, int w) {
        this.a = a;
        this.h = h;
        this.w = w;
    }


    @Override
    public int compareTo(Top o) {
        return o.a - this.a;
    }
}

public class S04 {
    public int solution(int n, ArrayList<Top> arr) {

        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int[] dy = new int[n];
        dy[0] = arr.get(0).h;

        for (int i = 1; i < n; i++) {
            int max = arr.get(i).h;

            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(i).w < arr.get(j).w) {
                    if (max < arr.get(i).h + dy[j]) {
                        max = arr.get(i).h + dy[j];
                    }
                }
            }

            dy[i] = max;
        }

        for (int x : dy) {
            answer = Math.max(x, answer);
        }

        return answer;
    }


    public static void main(String[] args) {
        S04 T = new S04();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        ArrayList<Top> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            arrayList.add(new Top(a, b, c));
        }

        System.out.print(T.solution(n, arrayList));
    }
}
