package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting> {

    int st, et;

    public Meeting(int st, int et) {
        this.st = st;
        this.et = et;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.et==o.et)
            return this.st - o.st;
        else
            return this.et-o.et;
    }
}

public class B1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);
        int et = meetings.get(0).et;
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (meetings.get(i).st >= et) {
                et = meetings.get(i).et;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
