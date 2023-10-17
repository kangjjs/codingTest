package section09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {

    public int time;
    public char state;

    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time o) {
        if (this.time == o.time)
            return this.state - o.state;
        else
            return this.time - o.time;
    }
}

class S03 {

    public int solution(int n, ArrayList<Time> arrayList) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arrayList);
        int cnt = 0;

        for (Time t : arrayList) {
            if (t.state == 's')
                cnt++;
            else
                cnt--;
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        ArrayList<Time> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int st = kb.nextInt();
            int et = kb.nextInt();
            arrayList.add(new Time(st, 's'));
            arrayList.add(new Time(et, 'e'));
        }

        System.out.print(T.solution(n, arrayList));
    }
}